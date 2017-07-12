package sz.automat.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import sz.automat.core.Constants;
import sz.automat.core.base.BaseService;
import sz.automat.core.util.InstanceUtil;
import sz.automat.model.SysParam;

/**
 * @author
 * @version 2016年5月31日 上午11:01:33
 */
@Service
@CacheConfig(cacheNames = "sysParam")
public class SysParamService extends BaseService<SysParam> {
	@Cacheable(value = Constants.CACHE_NAMESPACE + "sysParams")
	public Map<String, String> getAllParams() {
		Map<String, Object> params = InstanceUtil.newHashMap();
		params.put("orderBy", "type_,sort_no");
		List<SysParam> list = queryList(params);
		Map<String, String> resultMap = InstanceUtil.newHashMap();
		for (SysParam sysParam : list) {
			if (sysParam != null) {
				resultMap.put(sysParam.getParamKey(), sysParam.getParamValue());
			}
		}
		return resultMap;
	}

	@Cacheable(value = Constants.CACHE_NAMESPACE + "sysParamName")
	public String getName(String key) {
		if (StringUtils.isBlank(key)) {
			return "";
		}
		Map<String, Object> params = InstanceUtil.newHashMap();
		params.put("orderBy", "type_,sort_no");
		List<SysParam> list = queryList(params);
		for (SysParam sysParam : list) {
			if (sysParam != null) {
				if (key.equals(sysParam.getParamKey())) {
					return sysParam.getRemark();
				}
			}
		}
		return "";
	}

	public String getValue(String key) {
		String value = applicationContext.getBean(SysParamService.class).getAllParams().get(key);
		if (StringUtils.isBlank(value)) {
			return "";
		}
		return value;
	}
}
