package ar.com.oxen.commons.license.impl;

import java.io.Serializable;

import javax.inject.Inject;

import ar.com.oxen.commons.license.api.License;
import ar.com.oxen.commons.license.api.LicenseAuthorizationValidator;
import ar.com.oxen.commons.license.api.LicenseInfoValidator;
import ar.com.oxen.commons.license.api.LicenseValidator;

public class DefaultLicenseValidator<I extends Serializable> implements
		LicenseValidator<I> {
	private LicenseAuthorizationValidator<I> licenseAuthorizationValidator;
	private LicenseInfoValidator<I> licenseInfoValidator;

	@Inject
	public DefaultLicenseValidator(
			LicenseAuthorizationValidator<I> licenseAuthorizationValidator,
			LicenseInfoValidator<I> licenseInfoValidator) {
		super();
		this.licenseAuthorizationValidator = licenseAuthorizationValidator;
		this.licenseInfoValidator = licenseInfoValidator;
	}

	@Override
	public boolean validate(License<I> license) {
		return this.licenseAuthorizationValidator.validate(license)
				&& this.licenseInfoValidator.validate(license.getInfo());
	}
}
