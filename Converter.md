# Introduction #
This section documents the use of the [Converter](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/converter/api/Converter.java) interface.

# Motivation #
When developing the license module, we realized that, according to different customer's requests, the way in which data is modified in order to store and validate licences may vary. We didn't want a hardcoded model.

So, we built a model based on a [Converter](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/converter/api/Converter.java) interface, pretty much like
[Spring Converter](http://static.springsource.org/spring/docs/3.0.0.RC2/reference/html/ch05s05.html).

Adding a mechanism for chaining converters would make object conversion more customizable, using a composition model.

# Details #
As we said before, the [Converter](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/converter/api/Converter.java) interface is the main component here.

We also provide some [converter implementations](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/converter/impl/). However, creating an implementation for each requirement would require an exponential number of classes. Because of this, we created the [CompoundConverter](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/converter/impl/CompoundConverter.java), which chaines two converters.

# Converter Builder #
Creating many converters and connecting them using [CompoundConverter](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/converter/impl/CompoundConverter.java)s woudl be very verbose. In order to solve this problem, we created the [ConverterBuilder](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/converter/api/ConverterBuilder.java) class.
It uses method chaining in order to allow a concise, type-safe converter creation.

## Examples ##
```
Converter<Date, String> convertidor = ConverterBuilder
		.create(new SerializableToBytesConverter<Date>())
		.add(new BytesToBase64Converter())
		.build();
```

```
Converter<String, Date> revertidor = ConverterBuilder
		.create(new Base64ToBytesConverter())
		.add(new BytesToSerializableConverter<Date>())
		.build();
```

```
Converter<Date, String> hash = ConverterBuilder
		.create(new SerializableToBytesConverter<Date>())
		.add(new DigestConverter("SHA-512"))
		.add(new BytesToBase64Converter())
		.build();
```

```
Converter<String, String> convertidor = ConverterBuilder
		.create(new SerializableToBytesConverter<String>())
		.add(new SaltConverter())
		.add(new BytesToBase64Converter())
		.build();
```

```
Converter<String, String> revertidor = ConverterBuilder
		.create(new Base64ToBytesConverter())
		.add(new UnsaltConverter())
		.add(new BytesToSerializableConverter<String>())
		.build();
```