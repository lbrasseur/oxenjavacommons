package ar.com.oxen.commons.license.api;

import java.io.Serializable;

public interface LicenseInfoValidator<I extends Serializable> {
	boolean validate(I licenseInfo);
}
