package ar.com.oxen.commons.property.impl.swing;

import java.awt.Component;

import ar.com.oxen.commons.property.api.Property;

public class ComponentEnabledProperty implements Property<Boolean> {
	private Component component;

	public ComponentEnabledProperty(Component component) {
		super();
		this.component = component;
	}

	@Override
	public Boolean get() {
		return this.component.isEnabled();
	}

	@Override
	public void set(Boolean value) {
		this.component.setEnabled(value);
	}
}
