package ar.com.oxen.commons.bean.api;

import ar.com.oxen.commons.exception.api.BaseException;

/**
 * Wrapper related exception.
 * 
 * @author lautaro.brasseur
 */
public class WrapperException extends BaseException {
	/**
	 * Serializable ID.
	 */
	private static final long serialVersionUID = -6896304250166536544L;

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            The root cause.
	 */
	public WrapperException(final Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 *            Error message
	 * @param cause
	 *            The cause
	 */
	public WrapperException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
