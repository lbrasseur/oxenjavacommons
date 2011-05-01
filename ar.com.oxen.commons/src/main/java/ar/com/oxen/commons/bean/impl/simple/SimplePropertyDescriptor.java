package ar.com.oxen.commons.bean.impl.simple;

import java.lang.annotation.Annotation;

import ar.com.oxen.commons.bean.api.PropertyDescriptor;

public class SimplePropertyDescriptor implements PropertyDescriptor {
	private String name;
	private Class<?> type;
	private Annotation[] annotations;

	public SimplePropertyDescriptor(String name, Class<?> type,
			Annotation[] annotations) {
		super();
		this.name = name;
		this.type = type;
		this.annotations = annotations;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Class<?> getType() {
		return type;
	}

	@Override
	public Annotation[] getAnnotations() {
		return annotations;
	}

	@Override
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
