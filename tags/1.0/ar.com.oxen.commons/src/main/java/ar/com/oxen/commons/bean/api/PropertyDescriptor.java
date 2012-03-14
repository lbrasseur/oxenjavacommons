package ar.com.oxen.commons.bean.api;

import java.lang.annotation.Annotation;

/**
 * Interface used to describe a property. Replaces java.beans.PropertyDescriptor
 * since it is not available in Android. Also, it adds some functionality such
 * as annotation processing.
 * 
 * @author lbrasseur
 */
public interface PropertyDescriptor {

	String getName();

	Class<?> getType();

	Annotation[] getAnnotations();

	<T> T getAnnotation(Class<T> annotationClass);

}