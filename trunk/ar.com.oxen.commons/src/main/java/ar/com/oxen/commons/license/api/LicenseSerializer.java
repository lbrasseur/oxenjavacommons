package ar.com.oxen.commons.license.api;

import java.io.Serializable;

public interface LicenseSerializer<I extends Serializable> {
	String serializeLicenceInfo(I licenseInfo);

	String serializeLicence(License<I> license);

	I deserializeLicenceInfo(String data);

	License<I> deserializeLicence(String data);
}
