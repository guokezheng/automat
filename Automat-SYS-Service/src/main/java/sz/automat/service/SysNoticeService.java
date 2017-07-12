package sz.automat.service;

import sz.automat.core.base.BaseService;
import sz.automat.model.SysNotice;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author
 *
 */
@Service
@CacheConfig(cacheNames = "sysNotice")
public class SysNoticeService extends BaseService<SysNotice> {

}
