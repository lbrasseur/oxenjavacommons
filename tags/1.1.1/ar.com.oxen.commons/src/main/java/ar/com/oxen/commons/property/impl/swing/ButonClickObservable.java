package ar.com.oxen.commons.property.impl.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ar.com.oxen.commons.property.impl.SimpleObservable;

public class ButonClickObservable extends SimpleObservable {

	public ButonClickObservable(JButton button) {
		super();
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ButonClickObservable.this.notifyObservers();
			}
		});
	}
}
