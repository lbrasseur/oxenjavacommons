package ar.com.oxen.commons.license.impl;

import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.Signature;
import java.security.SignatureException;

import ar.com.oxen.commons.converter.api.Converter;
import ar.com.oxen.commons.license.api.LicenceException;
import ar.com.oxen.commons.license.api.License;
import ar.com.oxen.commons.license.api.LicenseAuthorizationValidator;
import ar.com.oxen.commons.license.api.PublicKeyProvider;
import ar.com.oxen.commons.license.api.SignatureProvider;

public class SignatureLicenseAuthorizationValidator<I extends Serializable>
		implements LicenseAuthorizationValidator<I> {
	private SignatureProvider signatureProvider;
	private PublicKeyProvider publicKeyProvider;
	private Converter<I, byte[]> converter;

	public SignatureLicenseAuthorizationValidator(
			SignatureProvider signatureProvider,
			PublicKeyProvider publicKeyProvider, Converter<I, byte[]> converter) {
		super();
		this.signatureProvider = signatureProvider;
		this.publicKeyProvider = publicKeyProvider;
		this.converter = converter;
	}

	@Override
	public boolean validate(License<I> license) {
		try {
			Signature signature = this.signatureProvider.getSignature();
			signature.initVerify(this.publicKeyProvider.getPublicKey());
			signature.update(this.converter.convert(license.getInfo()));
			return signature.verify(license.getAuthorization());
		} catch (SignatureException e) {
			throw new LicenceException(e);
		} catch (InvalidKeyException e) {
			throw new LicenceException(e);
		}
	}
}
