package ar.com.oxen.commons.license.impl;

import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;

import javax.inject.Inject;
import javax.inject.Provider;

import ar.com.oxen.commons.converter.api.ConversionException;
import ar.com.oxen.commons.converter.api.Converter;
import ar.com.oxen.commons.license.api.LicenceException;
import ar.com.oxen.commons.license.api.License;
import ar.com.oxen.commons.license.api.LicenseAuthorizer;

public class SignatureLicenseAuthorizer<I extends Serializable> implements
		LicenseAuthorizer<I> {
	private Provider<Signature> signatureProvider;
	private PrivateKey privateKey;
	private Converter<I, byte[]> converter;

	@Inject
	public SignatureLicenseAuthorizer(Provider<Signature> signatureProvider,
			PrivateKey privateKey, Converter<I, byte[]> converter) {
		super();
		this.signatureProvider = signatureProvider;
		this.privateKey = privateKey;
		this.converter = converter;
	}

	@Override
	public License<I> authorize(I licenseInfo) {
		try {
			Signature signature = this.signatureProvider.get();
			signature.initSign(this.privateKey);
			signature.update(this.converter.convert(licenseInfo));
			return new SimpleLicense<I>(licenseInfo, signature.sign());
		} catch (SignatureException e) {
			throw new LicenceException(e);
		} catch (InvalidKeyException e) {
			throw new ConversionException(e);
		}
	}

}
