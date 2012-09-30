package ar.com.oxen.commons.license.api;

import java.security.PrivateKey;

/**
 * Component that provides a private key.
 */
public interface PrivateKeyProvider {
	/**
	 * @return The private key 
	 */
	PrivateKey getPrivateKey();
}
