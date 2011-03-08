package ar.com.oxen.commons.exception.api;

import java.io.IOException;

public class IOExceptionWrapper extends ExceptionWrapper {
	/**
	 * Serialization ID.
	 */
	private static final long serialVersionUID = -3678428447763629879L;

	public IOExceptionWrapper(IOException rootCause) {
		super(rootCause);
	}

	@Override
	public IOException getCause() {
		return (IOException) super.getCause();
	}
}
