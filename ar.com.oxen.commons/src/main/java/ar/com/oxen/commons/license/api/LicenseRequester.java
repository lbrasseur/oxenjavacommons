package ar.com.oxen.commons.license.api;

public interface LicenseRequester<I> {
	License requestLicense(I info);
}
