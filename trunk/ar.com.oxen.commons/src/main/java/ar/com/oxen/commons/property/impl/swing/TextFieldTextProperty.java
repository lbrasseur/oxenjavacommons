package ar.com.oxen.commons.property.impl.swing;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

import ar.com.oxen.commons.property.api.ObservableProperty;
import ar.com.oxen.commons.property.impl.SimpleObservable;

public class TextFieldTextProperty extends SimpleObservable implements
		ObservableProperty<String> {
	private JTextField textField;

	public TextFieldTextProperty(JTextField textField) {
		super();
		this.textField = textField;

		this.textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				TextFieldTextProperty.this.notifyObservers();
			}
		});
	}

	@Override
	public String get() {
		return textField.getText();
	}

	@Override
	public void set(String newValue) {
		textField.setText(newValue);
	}
}
