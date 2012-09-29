package ar.com.oxen.commons.converter.impl;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;

import ar.com.oxen.commons.converter.api.ConversionException;
import ar.com.oxen.commons.converter.api.Converter;

public class SignatureConverter implements Converter<byte[], byte[]> {
	private String algorithm;
	private PrivateKey privateKey;

	public SignatureConverter(String algorithm, PrivateKey privateKey) {
		super();
		this.algorithm = algorithm;
		this.privateKey = privateKey;
	}

	@Override
	public byte[] convert(byte[] source) {
		try {
			Signature signature = Signature.getInstance(this.algorithm);
			signature.initSign(this.privateKey);
			signature.initSign(privateKey);
			signature.update(source);
			return signature.sign();
		} catch (SignatureException e) {
			throw new ConversionException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new ConversionException(e);
		} catch (InvalidKeyException e) {
			throw new ConversionException(e);
		}
	}

}
