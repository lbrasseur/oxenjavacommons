package ar.com.oxen.commons.property.impl.vaadin;

import ar.com.oxen.commons.property.impl.SimpleObservable;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class ButonClickObservable extends SimpleObservable {
	public ButonClickObservable(Button button) {
		super();
		button.addListener(new Button.ClickListener() {
			private static final long serialVersionUID = 6148087064343577097L;

			@Override
			public void buttonClick(ClickEvent event) {
				ButonClickObservable.this.notifyObservers();
			}
		});
	}
}
