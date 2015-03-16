# Introduction #
This section explains how the licensing module is designed.

# Licensing process #
## Requesting a license ##
In order to request a license, you must create a license info. Since license info is domain-specific, it bust be implemented by a custom class.

All the classes accessing such info have a type parameter for such object. This way, the user can store the user licence information in any class. There is only one restriction: the license info must be serializable.

There is a default implementation, [DefaultLicenseInfo](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/impl/DefaultLicenseInfo.java), which validates hardware and expiration date.

Once the license information is created, it must be serialized using a [LicenseSerializer](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/api/LicenseSerializer.java) in order to send it for approval.

The module doesn't define how the license must be sent. However, since it is serialized to String, it could be sent over web services, mail, etc.

## Authorizing a license ##
On the authorizer side, a String with the license info will be received. A [LicenseSerializer](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/api/LicenseSerializer.java) compatible with the one used for creating the request must be used in order to reconstruct the license info from the received String.

Once the license info is created, it can be displayed, mailed, etc. in order to be approved by an user. When the user decides to approve the request, it must use the [LicenseAuthorizer](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/api/LicenseAuthorizer.java) component. It constructs an authorized [License](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/api/License.java) from license info. The [License](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/api/License.java) object contains all the license information, so the authorizer can modify it before sending it back to the requester.

Once the license is authorized, it must be serialized back to String, again with [LicenseSerializer](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/api/LicenseSerializer.java). This way, all the data can be sent to the requester.

## Validating a license ##
When the original license requester recibes the String with license data, it must use the [LicenseSerializer](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/api/LicenseSerializer.java) in order to construct the [License](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/api/License.java) object.

Once constructed, it can be validated using a [LicenseValidator](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/api/LicenseValidator.java). Mostly, this validation will involve two steps: validating the authorization and validating the license info. Since the license info validation process is domain-specific, we divide these two steps into 2 interfaces:

  * [LicenseAuthorizationValidator](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/api/LicenseAuthorizationValidator.java), which validates the authorization field. Since this process is implementation specific, we can provide common implementations such as a [Signature](http://docs.oracle.com/javase/7/docs/api/java/security/Signature.html) based one.
  * [LicenseInfoValidator](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/api/LicenseInfoValidator.java), which validates the license info. We just provide an implementation for the default license info: [DefaultLicenseInfoValidator](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/impl/DefaultLicenseInfoValidator.java).

The default license validation implementation ([DefaultLicenseValidator](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/impl/DefaultLicenseValidator.java)) receives these two components and just performs an "and" over the two validations.

# Provider API #
There is also some provider interfaces that help in creating modular implementations. Such interfaces are:

  * [HardwareIdProvider](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/api/HardwareIdProvider.java)
  * [KeyStoreProvider](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/api/KeyStoreProvider.java)
  * [PrivateKeyProvider](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/api/PrivateKeyProvider.java)
  * [PublicKeyProvider](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/api/PublicKeyProvider.java)
  * [SignatureProvider](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/api/SignatureProvider.java)

One might ask why the module don't just use [JSR330](http://www.jcp.org/en/jsr/detail?id=330) providers. The answer is that, since all of them return standar Java classes, injecting them using a container would require a mechanism in order to identify them. For example, a custom annotation. Creating specific interfaces seemed a more elegant solution.

# Included implementations #
The module provide many [implementations](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/license/impl/). Describing them here would mean duplicating documentation (and there is a brief explanation on javadoc) , so we aren't going to do that.

However, as a general rule, the implementation name describes the approach used in order to implement the interface semantics. Many of them just have a "Default" prefix, which means that they implements the functionality in a way that would be commonly used, but they aren't specific to one implementation.

Also, when custom creation is needed, a [JSR330](http://www.jcp.org/en/jsr/detail?id=330) provider. This enforces integration with containers such as [Gucie](http://code.google.com/p/google-guice/). However, the providers and objects could be created and injected manually.

# Example with Guice #
```
Guice.createInjector(new TestModule()).getInstance(Test.class);

public class TestModule extends AbstractModule {

	@Override
	protected void configure() {
		/* Hardware identification configuration - SHA-512 over MAC address in this case */
		bind(HardwareIdProvider.class).toInstance(
				new ConverterHardwareIdProvider(
						new MacAddressHardwareIdProvider(),
						new DigestConverter("SHA-512")));
		
		/* Digital signature configuration */
		bind(SignatureProvider.class).toInstance(
				new DefaultSignatureProvider("DSA"));
		
		/* Public an private key configuration */
		KeyStoreProvider ksp = new DefaultKeyStoreProvider("keyStorePassword");
		bind(PublicKeyProvider.class).toInstance(
				new KeyStorePublicKeyProvider("myKey", ksp));
		bind(PrivateKeyProvider.class).toInstance(
				new KeyStorePrivateKeyProvider("myKey", "myPassword", ksp));
		
		/* Serialization configuration */
		bind(new TypeLiteral<LicenseSerializer<DefaultLicenseInfo>>() {})
			.toProvider(new TypeLiteral<DefaultLicenseSerializerProvider<DefaultLicenseInfo>>() {});

		/* Authorization configuration */
		bind(new TypeLiteral<LicenseAuthorizer<DefaultLicenseInfo>>() {})
			.toProvider(new TypeLiteral<DefaultLicenseAuthorizerProvider<DefaultLicenseInfo>>() {});

		/* Validation configuration */
		bind(new TypeLiteral<LicenseValidator<DefaultLicenseInfo>>() {})
			.to(new TypeLiteral<DefaultLicenseValidator<DefaultLicenseInfo>>() {});
		bind(new TypeLiteral<LicenseAuthorizationValidator<DefaultLicenseInfo>>() {})
			.toProvider(new TypeLiteral<DefaultLicenseAuthorizationValidatorProvider<DefaultLicenseInfo>>() {});
		bind(new TypeLiteral<LicenseInfoValidator<DefaultLicenseInfo>>() {})
			.to(DefaultLicenseInfoValidator.class);
	}

}

public class Test {
	@Inject
	public Test(LicenseSerializer<DefaultLicenseInfo> serializer,
			LicenseAuthorizer<DefaultLicenseInfo> authorizer,
			LicenseValidator<DefaultLicenseInfo> validator,
			HardwareIdProvider hardwareIdProvider) {

		DefaultLicenseInfo licenseInfo = new DefaultLicenseInfo("IBM",
				new Date(System.currentTimeMillis() + 2000),
				hardwareIdProvider.getHardwareId());

		String serializedInfo = serializer
				.serializeLicenceInfo(licenseInfo);
		System.out.println("Serialized info: " + serializedInfo);
		System.out.println("De-serialized info: "
				+ serializer.deserializeLicenceInfo(serializedInfo));

		License<DefaultLicenseInfo> license = authorizer
				.authorize(licenseInfo);
		System.out.println("Is license valid?: "
				+ validator.validate(license));

		String serializedLicense = serializer.serializeLicence(license);
		System.out.println("Serialized license: " + serializedLicense);
		System.out.println("De-serialized license: "
				+ serializer.deserializeLicence(serializedLicense));
		System.out.println("Is De-serialized license valid?: "
				+ validator.validate(serializer
						.deserializeLicence(serializedLicense)));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		System.out.println("Is license valid after 2 seconds?: "
				+ validator.validate(serializer
						.deserializeLicence(serializedLicense)));
	}
}
```

# Bytecode obfuscation #
As you may know, Java can be easily decompiled. This is a huge problem in software licensing.

In order to mitigate this problem, a code obfuscator can be used. [ProGuard](http://proguard.sourceforge.net/) is a popular and free implementation.

When using an obfuscator, be sure of including the license classes into the obfuscation process.  If they aren't included, they could be easily replaced by a attacker.

Obfuscation using a container should be easier using class injection configuration than using XML (for example, [Spring](http://www.springsource.org/) with XML). In general, avoid using dynamic class loading (ie, reading the name from a Stirng, a file, etc.) since obfuscators usually change the class names.