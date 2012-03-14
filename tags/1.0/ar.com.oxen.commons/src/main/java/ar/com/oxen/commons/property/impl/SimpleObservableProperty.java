package ar.com.oxen.commons.property.impl;

import ar.com.oxen.commons.property.api.Observable;
import ar.com.oxen.commons.property.api.ObservableProperty;
import ar.com.oxen.commons.property.api.Observer;

public class SimpleObservableProperty<T> extends AbstractProperty<T> implements
		ObservableProperty<T> {
	private Observable observable = new SimpleObservable();

	public SimpleObservableProperty() {
		super();
	}

	public SimpleObservableProperty(T value) {
		super(value);
	}
	@Override
	public void set(T value) {
		this.internalSet(value);
		this.notifyObservers();
	}

	@Override
	public void addObserver(Observer observer) {
		this.observable.addObserver(observer);
	}

	@Override
	public void notifyObservers() {
		this.observable.notifyObservers();
	}
}
