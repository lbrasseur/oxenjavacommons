# Introduction #
Documentation for Wrapper component.


# Details #
The [BeanWrapper](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/bean/api/BeanWrapper.java) and [ClassWrapper](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/bean/api/ClassWrapper.java) components allows wrapping of classes and objects in order to manipulate them in a dynamic way.

The implementation is hidden behind a [WrapperFactory](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/bean/api/WrapperFactory.java).

A [simple implementation](http://code.google.com/p/oxenjavacommons/source/browse/#svn%2Ftrunk%2Far.com.oxen.commons%2Fsrc%2Fmain%2Fjava%2Far%2Fcom%2Foxen%2Fcommons%2Fbean%2Fimpl%2Fsimple) is provided. `Spring BeanWrapper` and `Commons BeanUtils` implementations could be easily built, but they wouldn't run on Android

# Ideas #
  * Provide a more sophisticated implementation with chained property access (using the dot operator in property names).
  * Provide `CommonsBeantils` and `Spring` implementations