package ar.com.oxen.commons.property.impl.vaadin;

import ar.com.oxen.commons.property.api.ObservableProperty;
import ar.com.oxen.commons.property.impl.SimpleObservable;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.AbstractField;

public class AbstractFieldValueProperty<T> extends SimpleObservable implements
		ObservableProperty<T> {
	private AbstractField field;

	public AbstractFieldValueProperty(AbstractField textField) {
		super();
		this.field = textField;

		this.field.addListener(new ValueChangeListener() {
			private static final long serialVersionUID = -29569553074206723L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				AbstractFieldValueProperty.this.notifyObservers();
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get() {
		return (T) field.getValue();
	}

	@Override
	public void set(T value) {
		field.setValue(value);
	}
}
