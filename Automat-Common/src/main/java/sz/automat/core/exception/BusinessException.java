package sz.automat.core.exception;

import sz.automat.core.support.HttpCode;

/**
 * @author
 * @version 2016年5月20日 下午3:19:19
 */
@SuppressWarnings("serial")
public class BusinessException extends BaseException {
	public BusinessException() {
	}

	public BusinessException(Throwable ex) {
		super(ex);
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable ex) {
		super(message, ex);
	}

	protected HttpCode getHttpCode() {
		return HttpCode.CONFLICT;
	}
}