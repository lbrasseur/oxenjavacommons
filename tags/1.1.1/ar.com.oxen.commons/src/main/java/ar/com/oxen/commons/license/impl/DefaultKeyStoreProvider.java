package ar.com.oxen.commons.license.impl;

import java.io.File;

/**
 * Loads the default Java key store.
 */
public class DefaultKeyStoreProvider extends FileKeyStoreProvider {
	public DefaultKeyStoreProvider(String keyStorePassword) {
		super(new File(System.getProperty("user.home"), ".keystore"),
				keyStorePassword);
	}
}
