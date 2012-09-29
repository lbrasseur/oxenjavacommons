package ar.com.oxen.commons.license.api;

import java.io.Serializable;

public interface License<I extends Serializable> extends Serializable {
	I getInfo();

	byte[] getAuthorization();
}
