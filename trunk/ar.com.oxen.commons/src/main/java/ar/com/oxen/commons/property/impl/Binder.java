package ar.com.oxen.commons.property.impl;

import ar.com.oxen.commons.property.api.Observable;
import ar.com.oxen.commons.property.api.ObservableProperty;
import ar.com.oxen.commons.property.api.Observer;
import ar.com.oxen.commons.property.api.Property;

public class Binder {
	public <T, S extends T> Binder bindProperty(
			final ObservableProperty<S> source, final Property<T> target) {
		source.addObserver(new Observer() {
			private boolean updated = false;

			@Override
			public void update() {
				if (!this.updated) {
					this.updated = true;
					target.set(source.get());
					this.updated = false;
				}
			}
		});
		return this;
	}

	public <T, S extends T> Binder bindProperty(final Property<T> target,
			final ObservableProperty<S> source) {
		return this.bindProperty(target, source);
	}

	public <T> Binder bindProperty(final ObservableProperty<T> source,
			final ObservableProperty<T> target) {
		this.bindProperty(source, (Property<T>) target);
		this.bindProperty(target, (Property<T>) source);
		return this;
	}

	public Binder bindObservable(final Observable source,
			final Observable target) {
		source.addObserver(new Observer() {
			private boolean updated = false;

			@Override
			public void update() {
				if (!this.updated) {
					this.updated = true;
					target.notifyObservers();
					this.updated = false;
				}
			}
		});
		return this;
	}
}
