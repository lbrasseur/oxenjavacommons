package ar.com.oxen.commons.license.api;

import java.io.Serializable;

public interface LicenseValidator<I extends Serializable> {
	boolean validate(License<I> license);
}
