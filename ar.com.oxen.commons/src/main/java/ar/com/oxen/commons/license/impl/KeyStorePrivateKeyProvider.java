package ar.com.oxen.commons.license.impl;

import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;

import ar.com.oxen.commons.license.api.KeyStoreProvider;
import ar.com.oxen.commons.license.api.LicenceException;
import ar.com.oxen.commons.license.api.PrivateKeyProvider;

public class KeyStorePrivateKeyProvider implements PrivateKeyProvider {
	private String alias;
	private String password;
	private KeyStoreProvider keyStoreProvider;

	public KeyStorePrivateKeyProvider(String alias, String password,
			KeyStoreProvider keyStoreProvider) {
		super();
		this.alias = alias;
		this.password = password;
		this.keyStoreProvider = keyStoreProvider;
	}

	@Override
	public PrivateKey getPrivateKey() {
		try {
			return  (PrivateKey) this.keyStoreProvider.getKeyStore().getKey(
					alias, password.toCharArray());
		} catch (UnrecoverableKeyException e) {
			throw new LicenceException(e);
		} catch (KeyStoreException e) {
			throw new LicenceException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new LicenceException(e);
		}
	}

}
