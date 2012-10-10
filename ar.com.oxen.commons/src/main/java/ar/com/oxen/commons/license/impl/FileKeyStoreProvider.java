package ar.com.oxen.commons.license.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import ar.com.oxen.commons.license.api.LicenceException;

/**
 * KeyStore provider that reads KeyStore from a File.
 */
public class FileKeyStoreProvider extends InputStreamKeyStoreProvider {

	public FileKeyStoreProvider(File keyStoreFile) {
		super(buildfInputStream(keyStoreFile));
	}

	private static InputStream buildfInputStream(File keyStoreFile) {
		try {
			return new FileInputStream(keyStoreFile);
		} catch (FileNotFoundException e) {
			throw new LicenceException(e);
		}
	}
}
