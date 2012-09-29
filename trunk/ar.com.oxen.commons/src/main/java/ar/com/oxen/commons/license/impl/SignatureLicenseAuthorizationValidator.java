package ar.com.oxen.commons.license.impl;

import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

import javax.inject.Provider;

import ar.com.oxen.commons.converter.api.Converter;
import ar.com.oxen.commons.license.api.LicenceException;
import ar.com.oxen.commons.license.api.License;
import ar.com.oxen.commons.license.api.LicenseAuthorizationValidator;

public class SignatureLicenseAuthorizationValidator<I extends Serializable>
		implements LicenseAuthorizationValidator<I> {
	private Provider<Signature> signatureProvider;
	private PublicKey publicKey;
	private Converter<I, byte[]> converter;

	public SignatureLicenseAuthorizationValidator(
			Provider<Signature> signatureProvider, PublicKey publicKey,
			Converter<I, byte[]> converter) {
		super();
		this.signatureProvider = signatureProvider;
		this.publicKey = publicKey;
		this.converter = converter;
	}

	@Override
	public boolean validate(License<I> license) {
		try {
			Signature signature = this.signatureProvider.get();
			signature.initVerify(this.publicKey);
			signature.update(this.converter.convert(license.getInfo()));
			return signature.verify(license.getAuthorization());
		} catch (SignatureException e) {
			throw new LicenceException(e);
		} catch (InvalidKeyException e) {
			throw new LicenceException(e);
		}
	}
}
