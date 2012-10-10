package ar.com.oxen.commons.license.impl;

import java.io.InputStream;

/**
 * KeyStore provider that reads KeyStore from the class loader.
 */
public class ClassLoaderKeyStoreProvider extends AbstractKeyStoreProvider {
	private String keyStorePath;

	public ClassLoaderKeyStoreProvider(String keyStorePath,
			String keyStorePassword) {
		super(keyStorePassword);
		this.keyStorePath = keyStorePath;
	}

	@Override
	protected InputStream openKeyStoreInputStream() {
		return ClassLoaderKeyStoreProvider.class
				.getResourceAsStream(this.keyStorePath);
	}
}
