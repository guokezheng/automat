package sz.automat.service;

import sz.automat.model.SysMsgConfig;
import sz.automat.core.base.BaseService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author
 * @since 2017-03-12
 */
@Service
@CacheConfig(cacheNames = "sysMsgConfig")
public class SysMsgConfigService extends BaseService<SysMsgConfig> {
	
}