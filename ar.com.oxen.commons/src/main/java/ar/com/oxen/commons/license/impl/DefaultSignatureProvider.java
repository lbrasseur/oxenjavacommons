package ar.com.oxen.commons.license.impl;

import java.security.NoSuchAlgorithmException;
import java.security.Signature;

import javax.inject.Provider;

import ar.com.oxen.commons.license.api.LicenceException;

public class DefaultSignatureProvider implements Provider<Signature> {
	private String algorithm;

	public DefaultSignatureProvider(String algorithm) {
		super();
		this.algorithm = algorithm;
	}

	@Override
	public Signature get() {
		try {
			return Signature.getInstance(this.algorithm);
		} catch (NoSuchAlgorithmException e) {
			throw new LicenceException(e);
		}
	}
}
