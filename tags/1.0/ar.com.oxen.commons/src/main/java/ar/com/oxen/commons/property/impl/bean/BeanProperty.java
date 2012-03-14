package ar.com.oxen.commons.property.impl.bean;

import ar.com.oxen.commons.bean.api.BeanWrapper;
import ar.com.oxen.commons.property.api.Property;

public class BeanProperty<T> implements Property<T> {
	private BeanWrapper<?> beanWrapper;
	private String propertyName;

	public BeanProperty(BeanWrapper<?> beanWrapper, String propertyName) {
		super();
		this.beanWrapper = beanWrapper;
		this.propertyName = propertyName;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get() {
		return (T) beanWrapper.getProperty(propertyName);
	}

	@Override
	public void set(T value) {
		beanWrapper.setProperty(propertyName, value);
	}
}
