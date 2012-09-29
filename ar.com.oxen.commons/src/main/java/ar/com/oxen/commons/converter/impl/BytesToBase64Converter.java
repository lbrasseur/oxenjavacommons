package ar.com.oxen.commons.converter.impl;

import org.apache.commons.codec.binary.Base64;

import ar.com.oxen.commons.converter.api.Converter;

public class BytesToBase64Converter implements Converter<byte[], String> {
	@Override
	public String convert(byte[] source) {
		return Base64.encodeBase64String(source);
	}
}
