package ar.com.oxen.commons.license.api;

import java.io.Serializable;

/**
 * Component that validates the license license info. Implementations of this
 * interface will be domain-specific.
 * 
 * @param <I>
 *            The license info type
 */
public interface LicenseInfoValidator<I extends Serializable> {
	boolean validate(I licenseInfo);
}
