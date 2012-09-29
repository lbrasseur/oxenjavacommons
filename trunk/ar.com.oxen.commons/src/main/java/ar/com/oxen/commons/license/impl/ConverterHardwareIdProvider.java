package ar.com.oxen.commons.license.impl;

import ar.com.oxen.commons.converter.api.Converter;
import ar.com.oxen.commons.license.api.HardwareIdProvider;

public class ConverterHardwareIdProvider implements HardwareIdProvider {
	private HardwareIdProvider hardwareIdProvider;
	private Converter<byte[], byte[]> converter;

	public ConverterHardwareIdProvider(HardwareIdProvider hardwareIdProvider,
			Converter<byte[], byte[]> converter) {
		super();
		this.hardwareIdProvider = hardwareIdProvider;
		this.converter = converter;
	}

	@Override
	public byte[] getHardwareId() {
		return this.converter.convert(this.hardwareIdProvider.getHardwareId());
	}
}
