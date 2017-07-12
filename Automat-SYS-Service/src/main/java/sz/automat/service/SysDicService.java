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
import sz.automat.model.SysDic;

/**
 * @author
 * @version 2016年5月20日 下午3:19:19
 */
@Service
@CacheConfig(cacheNames = "sysDic")
public class SysDicService extends BaseService<SysDic> {

	@Cacheable(value = Constants.CACHE_NAMESPACE + "sysDics")
	public Map<String, Map<String, String>> getAllDic() {
		Map<String, Object> params = InstanceUtil.newHashMap();
		params.put("orderBy", "type_,sort_no");
		List<SysDic> list = queryList(params);
		Map<String, Map<String, String>> resultMap = InstanceUtil.newHashMap();
		for (SysDic sysDic : list) {
			if (sysDic != null) {
				String key = sysDic.getType();
				if (resultMap.get(key) == null) {
					Map<String, String> dicMap = InstanceUtil.newHashMap();
					resultMap.put(key, dicMap);
				}
				if (StringUtils.isNotBlank(sysDic.getParentCode())) {
					resultMap.get(key).put(sysDic.getParentCode() + sysDic.getCode(), sysDic.getCodeText());
				} else {
					resultMap.get(key).put(sysDic.getCode(), sysDic.getCodeText());
				}
			}
		}
		return resultMap;
	}

	@Cacheable(value = Constants.CACHE_NAMESPACE + "sysDics")
	public Map<String, String> queryDicByTypeMap(Map<String, Object> params) {
		return queryDicByType((String) params.get("type"));
	}

	@Cacheable(value = Constants.CACHE_NAMESPACE + "sysDics")
	public Map<String, String> queryDicByType(String key) {
		Map<String, String> resultMap = applicationContext.getBean(SysDicService.class).getAllDic().get(key);
		if (resultMap == null) {
			return InstanceUtil.newHashMap();
		}
		return resultMap;
	}
}
