package sz.automat.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sz.automat.core.base.BaseService;
import sz.automat.core.util.CacheUtil;
import sz.automat.core.util.InstanceUtil;
import sz.automat.core.util.PropertiesUtil;
import sz.automat.mapper.SysSessionMapper;
import sz.automat.model.SysSession;

/**
 * @author
 * @version 2016年5月20日 下午3:19:19
 */
@Service
@CacheConfig(cacheNames = "sysSession")
public class SysSessionService extends BaseService<SysSession> {

	@CachePut
	@Transactional
	public SysSession update(SysSession record) {
		if (record != null && record.getId() == null) {
			record.setUpdateTime(new Date());
			Long id = ((SysSessionMapper) mapper).queryBySessionId(record.getSessionId());
			if (id != null) {
				mapper.updateById(record);
			} else {
				record.setCreateTime(new Date());
				mapper.insert(record);
			}
		} else {
			mapper.updateById(record);
		}
		return record;
	}

	// 系统触发,由系统自动管理缓存
	public void deleteBySessionId(final SysSession sysSession) {
		if (sysSession != null) {
			((SysSessionMapper) mapper).deleteBySessionId(sysSession.getSessionId());
		}
	}

	public List<String> querySessionIdByAccount(SysSession sysSession) {
		if (sysSession != null) {
			return ((SysSessionMapper) mapper).querySessionIdByAccount(sysSession.getAccount());
		}
		return null;
	}

	//
	public void cleanExpiredSessions() {
		String key = "spring:session:" + PropertiesUtil.getString("session.redis.namespace") + ":sessions:expires:";
		Map<String, Object> columnMap = InstanceUtil.newHashMap();
		List<SysSession> sessions = queryList(columnMap);
		for (SysSession sysSession : sessions) {
			if (sysSession != null) {
				logger.info("检查SESSION : {}", sysSession.getSessionId());
				if (!CacheUtil.getCache().exists(key + sysSession.getSessionId())) {
					logger.info("移除SESSION : {}", sysSession.getSessionId());
					delete(sysSession.getId());
				}
			}
		}
	}
}