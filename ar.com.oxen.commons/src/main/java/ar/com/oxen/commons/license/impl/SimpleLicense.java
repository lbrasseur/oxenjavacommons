package ar.com.oxen.commons.license.impl;

import java.io.Serializable;
import java.util.Arrays;

import ar.com.oxen.commons.license.api.License;

public class SimpleLicense<I extends Serializable> implements License<I> {
	private static final long serialVersionUID = 2905278555167754416L;
	private I info;
	private byte[] authorization;

	public SimpleLicense(I info, byte[] authorization) {
		super();
		this.info = info;
		this.authorization = authorization;
	}

	@Override
	public I getInfo() {
		return this.info;
	}

	@Override
	public byte[] getAuthorization() {
		return this.authorization;
	}

	@Override
	public String toString() {
		return "SimpleLicense [info=" + info + ", authorization="
				+ Arrays.toString(authorization) + "]";
	}
}
