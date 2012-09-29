package ar.com.oxen.commons.license.api;

import java.io.Serializable;

public interface LicenseAuthorizer<I extends Serializable> {
	License<I> authorize(I licenseInfo);
}
