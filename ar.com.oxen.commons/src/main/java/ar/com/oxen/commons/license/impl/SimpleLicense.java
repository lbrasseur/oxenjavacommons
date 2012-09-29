package ar.com.oxen.commons.license.impl;

import ar.com.oxen.commons.license.api.License;

public class SimpleLicense implements License {
	private byte[] info;
	private byte[] requesterId;
	private byte[] authorization;

	public SimpleLicense(byte[] info, byte[] requesterId, byte[] authorization) {
		super();
		this.info = info;
		this.requesterId = requesterId;
		this.authorization = authorization;
	}

	@Override
	public byte[] getInfo() {
		return this.info;
	}

	@Override
	public byte[] getRequesterId() {
		return this.requesterId;
	}

	@Override
	public byte[] getAuthorization() {
		return this.authorization;
	}
}
