package ar.com.oxen.commons.license.api;

import java.security.PublicKey;

/**
 * Component that provides a public key.
 */
public interface PublicKeyProvider {
	/**
	 * @return The public key
	 */
	PublicKey getPublicKey();
}
