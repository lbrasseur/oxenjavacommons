package ar.com.oxen.commons.license.impl;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * A common-use license info, which includes a company name, hardware
 * identification and an expiration date.<br>
 * However, in most cases, this implementation will be discarded in favor of a
 * domain-specific implementation.
 */
public class DefaultLicenseInfo implements Serializable {
	private static final long serialVersionUID = -5962868381565454809L;
	private String customerName;
	private Date expirationDate;
	private byte[] hardwareId;

	public DefaultLicenseInfo(String customerName, Date expirationDate,
			byte[] hardwareId) {
		super();
		this.customerName = customerName;
		this.expirationDate = expirationDate;
		this.hardwareId = hardwareId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public byte[] getHardwareId() {
		return hardwareId;
	}

	@Override
	public String toString() {
		return "DefaultLicenseInfo [customerName=" + customerName
				+ ", expirationDate=" + expirationDate + ", hardwareId="
				+ Arrays.toString(hardwareId) + "]";
	}
}
