package ar.com.oxen.commons.property.impl;

import ar.com.oxen.commons.property.api.Property;

abstract class AbstractProperty<T> implements Property<T> {
	private T value;

	public AbstractProperty() {
		super();
	}

	public AbstractProperty(T value) {
		this();
		this.value = value;
	}

	public T get() {
		return value;
	}

	void internalSet(T value) {
		this.value = value;
	}
}
