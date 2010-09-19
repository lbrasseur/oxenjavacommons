package ar.com.oxen.commons.property.impl.swing;

import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ar.com.oxen.commons.property.api.ObservableProperty;
import ar.com.oxen.commons.property.impl.SimpleObservable;

public class CheckBoxSelectedProperty extends SimpleObservable implements
		ObservableProperty<Boolean> {
	private JCheckBox checkBox;

	public CheckBoxSelectedProperty(JCheckBox checkBox) {
		super();
		this.checkBox = checkBox;

		this.checkBox.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				CheckBoxSelectedProperty.this.notifyObservers();
			}
		});
	}

	@Override
	public Boolean get() {
		return checkBox.isSelected();
	}

	@Override
	public void set(Boolean newValue) {
		checkBox.setSelected(newValue);
	}
}
