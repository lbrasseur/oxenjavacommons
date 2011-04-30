package ar.com.oxen.commons.bean.api;

import java.lang.annotation.Annotation;

/**
 * Class used to describe a property. Replaces java.beans.PropertyDescriptor
 * since it is not available in Android.
 * 
 * @author lbrasseur
 * 
 */
public class PropertyDescriptor {
	private String name;
	private Class<?> type;
	private Annotation[] annotations;

	public PropertyDescriptor(String name, Class<?> type,
			Annotation[] annotations) {
		super();
		this.name = name;
		this.type = type;
		this.annotations = annotations;
	}

	public String getName() {
		return name;
	}

	public Class<?> getType() {
		return type;
	}

	public Annotation[] getAnnotations() {
		return annotations;
	}

	@SuppressWarnings("unchecked")
	public <T> T getAnnotation(Class<T> annotationClass) {
		if (this.annotations != null) {
			for (Annotation annotation : this.annotations) {
				if (annotationClass.isAssignableFrom(annotation.getClass())) {
					return (T) annotation;
				}
			}
		}
		return null;
	}
}
