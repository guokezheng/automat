package sz.automat.service;

import sz.automat.core.base.BaseService;
import sz.automat.model.SysUnit;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

/**
 * @author
 *
 */
@Service
@CacheConfig(cacheNames = "sysUnit")
public class SysUnitService extends BaseService<SysUnit> {

}
