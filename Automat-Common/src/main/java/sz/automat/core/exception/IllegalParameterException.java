/**
 * 
 */
package sz.automat.core.exception;

import sz.automat.core.support.HttpCode;

/**
 * 
 * @author
 * @version 2016年6月7日 下午8:46:11
 */
@SuppressWarnings("serial")
public class IllegalParameterException extends BaseException {
	public IllegalParameterException() {
	}

	public IllegalParameterException(Throwable ex) {
		super(ex);
	}

	public IllegalParameterException(String message) {
		super(message);
	}

	public IllegalParameterException(String message, Throwable ex) {
		super(message, ex);
	}

	protected HttpCode getHttpCode() {
		return HttpCode.BAD_REQUEST;
	}
}
