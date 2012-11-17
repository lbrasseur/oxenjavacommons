package ar.com.oxen.commons.property.impl;


public class SimpleProperty<T> extends AbstractProperty<T> {
	public SimpleProperty() {
		super();
	}

	public SimpleProperty(T value) {
		super(value);
	}

	@Override
	public void set(T value) {
		this.internalSet(value);
	}
}
