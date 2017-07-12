package sz.automat.stock.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import sz.automat.core.base.BaseService;
import sz.automat.stock.model.StoSupplier;

/**
 *
 * 供应商 服务实现类
 * Created by Administrator on 2017/7/7.
 */
@Service
@CacheConfig(cacheNames = "stoSupplier")
public class StoSupplierService extends BaseService<StoSupplier> {
}
