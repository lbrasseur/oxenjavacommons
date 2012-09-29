package ar.com.oxen.commons.license.api;

public interface License {
	byte[] getInfo();

	byte[] getRequesterId();

	byte[] getAuthorization();
}
