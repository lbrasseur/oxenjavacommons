package ar.com.oxen.commons.property.impl.vaadin;

import com.vaadin.ui.Label;

import ar.com.oxen.commons.property.api.Property;

public class LabelCaptionProperty implements Property<String> {
	private Label label;

	public LabelCaptionProperty(Label label) {
		super();
		this.label = label;
	}

	@Override
	public String get() {
		return this.label.getCaption();
	}

	@Override
	public void set(String value) {
		this.label.setCaption(value);
	}
}
