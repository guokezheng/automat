package sz.automat.core;

import sz.automat.core.base.BaseProviderImpl;
import sz.automat.provider.ISysProvider;

import com.alibaba.dubbo.config.annotation.Service;

@Service(interfaceClass = ISysProvider.class)
public class SysProviderImpl extends BaseProviderImpl implements ISysProvider {
	
}