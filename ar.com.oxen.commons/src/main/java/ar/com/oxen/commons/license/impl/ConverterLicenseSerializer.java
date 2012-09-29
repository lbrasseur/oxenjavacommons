package ar.com.oxen.commons.license.impl;

import java.io.Serializable;

import ar.com.oxen.commons.converter.api.Converter;
import ar.com.oxen.commons.license.api.License;
import ar.com.oxen.commons.license.api.LicenseSerializer;

public class ConverterLicenseSerializer<I extends Serializable> implements
		LicenseSerializer<I> {
	private Converter<I, String> infoToStringConverter;
	private Converter<License<I>, String> licenseToStringConverter;
	private Converter<String, I> stringToInfoConverter;
	private Converter<String, License<I>> stringToLicenseConverter;

	public ConverterLicenseSerializer(
			Converter<I, String> infoToStringConverter,
			Converter<License<I>, String> licenseToStringConverter,
			Converter<String, I> stringToInfoConverter,
			Converter<String, License<I>> stringToLicenseConverter) {
		super();
		this.infoToStringConverter = infoToStringConverter;
		this.licenseToStringConverter = licenseToStringConverter;
		this.stringToInfoConverter = stringToInfoConverter;
		this.stringToLicenseConverter = stringToLicenseConverter;
	}

	@Override
	public String serializeLicenceInfo(I licenseInfo) {
		return this.infoToStringConverter.convert(licenseInfo);
	}

	@Override
	public String serializeLicence(License<I> license) {
		return this.licenseToStringConverter.convert(license);
	}

	@Override
	public I deserializeLicenceInfo(String data) {
		return this.stringToInfoConverter.convert(data);
	}

	@Override
	public License<I> deserializeLicence(String data) {
		return this.stringToLicenseConverter.convert(data);
	}
}
