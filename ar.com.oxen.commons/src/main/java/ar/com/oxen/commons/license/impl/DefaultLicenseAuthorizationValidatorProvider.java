package ar.com.oxen.commons.license.impl;

import java.io.Serializable;
import java.security.PublicKey;
import java.security.Signature;

import javax.inject.Inject;
import javax.inject.Provider;

import ar.com.oxen.commons.converter.impl.SerializableToBytesConverter;
import ar.com.oxen.commons.license.api.LicenseAuthorizationValidator;

public class DefaultLicenseAuthorizationValidatorProvider<I extends Serializable>
		implements Provider<LicenseAuthorizationValidator<I>> {
	private Provider<Signature> signatureProvider;
	private PublicKey publicKey;

	@Inject
	public DefaultLicenseAuthorizationValidatorProvider(
			Provider<Signature> signatureProvider, PublicKey publicKey) {
		super();
		this.signatureProvider = signatureProvider;
		this.publicKey = publicKey;
	}

	@Override
	public LicenseAuthorizationValidator<I> get() {
		return new SignatureLicenseAuthorizationValidator<I>(
				this.signatureProvider, this.publicKey,
				new SerializableToBytesConverter<I>());
	}
}
