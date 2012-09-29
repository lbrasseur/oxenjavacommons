package ar.com.oxen.commons.license.impl;

import java.io.Serializable;
import java.security.PrivateKey;
import java.security.Signature;

import javax.inject.Inject;
import javax.inject.Provider;

import ar.com.oxen.commons.converter.impl.SerializableToBytesConverter;
import ar.com.oxen.commons.license.api.LicenseAuthorizer;

public class DefaultLicenseAuthorizerProvider<I extends Serializable>
		implements Provider<LicenseAuthorizer<I>> {
	private Provider<Signature> signatureProvider;
	private PrivateKey privateKey;

	@Inject
	public DefaultLicenseAuthorizerProvider(
			Provider<Signature> signatureProvider, PrivateKey privateKey) {
		super();
		this.signatureProvider = signatureProvider;
		this.privateKey = privateKey;
	}

	@Override
	public LicenseAuthorizer<I> get() {
		return new SignatureLicenseAuthorizer<I>(this.signatureProvider,
				this.privateKey, new SerializableToBytesConverter<I>());
	}

}
