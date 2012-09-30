package ar.com.oxen.commons.license.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import ar.com.oxen.commons.license.api.KeyStoreProvider;
import ar.com.oxen.commons.license.api.LicenceException;

/**
 * Loads the default Java key store.
 */
public class DefaultKeyStoreProvider implements KeyStoreProvider {
	@Override
	public KeyStore getKeyStore() {
		try {
			KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
			ks.load(new FileInputStream(new File(System
					.getProperty("user.home"), ".keystore")), null);
			return ks;
		} catch (KeyStoreException e) {
			throw new LicenceException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new LicenceException(e);
		} catch (CertificateException e) {
			throw new LicenceException(e);
		} catch (FileNotFoundException e) {
			throw new LicenceException(e);
		} catch (IOException e) {
			throw new LicenceException(e);
		}
	}
}
