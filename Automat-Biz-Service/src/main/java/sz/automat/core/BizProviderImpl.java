package sz.automat.core;

import sz.automat.core.base.BaseProviderImpl;
import sz.automat.provider.IBizProvider;

import com.alibaba.dubbo.config.annotation.Service;

@Service(interfaceClass = IBizProvider.class)
public class BizProviderImpl extends BaseProviderImpl implements IBizProvider {

}