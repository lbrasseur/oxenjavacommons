package ar.com.oxen.commons.license.impl;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import ar.com.oxen.commons.license.api.KeyStoreProvider;
import ar.com.oxen.commons.license.api.LicenceException;

/**
 * KeyStore provider that reads KeyStore from an InputStream.
 */
public class InputStreamKeyStoreProvider implements KeyStoreProvider {
	private InputStream keyStoreInputStream;

	public InputStreamKeyStoreProvider(InputStream keyStoreInputStream) {
		super();
		this.keyStoreInputStream = keyStoreInputStream;
	}

	@Override
	public KeyStore getKeyStore() {
		try {
			KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
			ks.load(this.keyStoreInputStream, null);
			return ks;
		} catch (KeyStoreException e) {
			throw new LicenceException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new LicenceException(e);
		} catch (CertificateException e) {
			throw new LicenceException(e);
		} catch (IOException e) {
			throw new LicenceException(e);
		}
	}
}
