package ar.com.oxen.commons.license.api;

import java.security.Signature;

public interface SignatureProvider {
	Signature getSignature();
}
