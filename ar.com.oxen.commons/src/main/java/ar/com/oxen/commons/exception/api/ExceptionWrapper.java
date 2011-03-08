package ar.com.oxen.commons.exception.api;

public class ExceptionWrapper extends BaseException {
	/**
	 * Serialization ID.
	 */
	private static final long serialVersionUID = -4322516426306607781L;

	public ExceptionWrapper(Throwable rootCause) {
		super(rootCause);
	}

}
