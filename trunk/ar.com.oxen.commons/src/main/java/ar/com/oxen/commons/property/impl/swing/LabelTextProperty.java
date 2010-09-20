package ar.com.oxen.commons.property.impl.swing;

import javax.swing.JLabel;

import ar.com.oxen.commons.property.api.Property;

public class LabelTextProperty implements Property<String> {
	private JLabel label;

	public LabelTextProperty(JLabel label) {
		this.label = label;
	}

	@Override
	public String get() {
		return this.label.getText();
	}

	@Override
	public void set(String newValue) {
		this.label.setText(newValue);
	}
}
