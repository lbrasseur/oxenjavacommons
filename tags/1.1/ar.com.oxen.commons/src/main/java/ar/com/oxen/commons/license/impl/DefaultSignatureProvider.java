package ar.com.oxen.commons.license.impl;

import java.security.NoSuchAlgorithmException;
import java.security.Signature;

import ar.com.oxen.commons.license.api.LicenceException;
import ar.com.oxen.commons.license.api.SignatureProvider;

/**
 * Signature provider which uses standard Java security classes.
 */
public class DefaultSignatureProvider implements SignatureProvider {
	private String algorithm;

	public DefaultSignatureProvider(String algorithm) {
		super();
		this.algorithm = algorithm;
	}

	@Override
	public Signature getSignature() {
		try {
			return Signature.getInstance(this.algorithm);
		} catch (NoSuchAlgorithmException e) {
			throw new LicenceException(e);
		}
	}
}
