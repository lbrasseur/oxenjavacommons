package ar.com.oxen.commons.property.impl.vaadin;

import ar.com.oxen.commons.property.api.Property;

import com.vaadin.ui.Window;

public class NotificationProperty implements Property<String> {
	private Window window;

	public NotificationProperty(Window window) {
		super();
		this.window = window;
	}

	@Override
	public String get() {
		return null;
	}

	@Override
	public void set(String newValue) {
		if (newValue != null) {
			window.showNotification(newValue.toString());
		}
	}
}
