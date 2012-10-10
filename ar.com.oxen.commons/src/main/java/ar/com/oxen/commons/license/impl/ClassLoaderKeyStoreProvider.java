package ar.com.oxen.commons.license.impl;

/**
 * KeyStore provider that reads KeyStore from the class loader.
 */
public class ClassLoaderKeyStoreProvider extends InputStreamKeyStoreProvider {
	public ClassLoaderKeyStoreProvider(String path) {
		super(ClassLoaderKeyStoreProvider.class.getResourceAsStream(path));
	}
}
