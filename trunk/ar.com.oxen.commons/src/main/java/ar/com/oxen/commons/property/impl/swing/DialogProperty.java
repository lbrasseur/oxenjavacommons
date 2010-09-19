package ar.com.oxen.commons.property.impl.swing;

import javax.swing.JOptionPane;

import ar.com.oxen.commons.property.api.Property;

public class DialogProperty implements Property<String> {

	@Override
	public String get() {
		return null;
	}

	@Override
	public void set(String newValue) {
		if (newValue != null) {
			JOptionPane.showMessageDialog(null, newValue.toString());
		}
	}
}
