package ar.com.oxen.commons.converter.impl;

import org.apache.commons.codec.binary.Base64;

import ar.com.oxen.commons.converter.api.Converter;

public class Base64ToBytesConverter implements Converter<String, byte[]> {
	@Override
	public byte[] convert(String source) {
		return Base64.decodeBase64(source);
	}
}
