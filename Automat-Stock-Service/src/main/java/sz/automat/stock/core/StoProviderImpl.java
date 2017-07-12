package sz.automat.stock.core;

import com.alibaba.dubbo.config.annotation.Service;
import sz.automat.core.base.BaseProviderImpl;
import sz.automat.stock.provider.IStockProvider;

@Service(interfaceClass = IStockProvider.class)
public class StoProviderImpl extends BaseProviderImpl implements IStockProvider {
	
}