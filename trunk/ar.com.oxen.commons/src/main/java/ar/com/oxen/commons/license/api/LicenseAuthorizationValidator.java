package ar.com.oxen.commons.license.api;

import java.io.Serializable;

public interface LicenseAuthorizationValidator<I extends Serializable> {
	boolean validate(License<I> license);
}
