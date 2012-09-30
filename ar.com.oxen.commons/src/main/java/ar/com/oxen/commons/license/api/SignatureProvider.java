package ar.com.oxen.commons.license.api;

import java.security.Signature;

/**
 * Component that provides a signature.
 */
public interface SignatureProvider {
	/**
	 * @return The signature
	 */
	Signature getSignature();
}
