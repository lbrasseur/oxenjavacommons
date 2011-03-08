package ar.com.oxen.commons.exception.api;

public class BaseException extends RuntimeException {
	/**
	 * Serialization ID.
	 */
	private static final long serialVersionUID = 3467822394390887949L;

	public BaseException() {
		super();
	}

	public BaseException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BaseException(String arg0) {
		super(arg0);
	}

	public BaseException(Throwable arg0) {
		super(arg0);
	}
}
