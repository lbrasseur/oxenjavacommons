package ar.com.oxen.sample.mvp.vaadin;

import ar.com.oxen.commons.property.impl.Binder;
import ar.com.oxen.commons.property.impl.vaadin.ButonClickObservable;
import ar.com.oxen.commons.property.impl.vaadin.AbstractFieldValueProperty;
import ar.com.oxen.commons.property.impl.vaadin.ComponentEnabledProperty;
import ar.com.oxen.commons.property.impl.vaadin.LabelCaptionProperty;
import ar.com.oxen.commons.property.impl.vaadin.NotificationProperty;
import ar.com.oxen.sample.mvp.Person;
import ar.com.oxen.sample.mvp.PresentationModel;
import ar.com.oxen.sample.mvp.ViewPresenter;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

public class SampleApplication extends Application {
	private static final long serialVersionUID = -603477344276163392L;

	@Override
	public void init() {
		TextField name = new TextField("Name");
		name.setImmediate(true);
		TextField email = new TextField("Email");
		email.setImmediate(true);
		CheckBox acceptTerms = new CheckBox("Accept terms and conditions");
		acceptTerms.setImmediate(true);
		
		Label errorMessage = new Label();
		
		Button signup = new Button("Signup");

		Person model = new Person();
		PresentationModel pModel = new PresentationModel();
		
		Window window = new Window();

		new Binder()
				.bindProperty(pModel.name, new AbstractFieldValueProperty<String>(name))
				.bindProperty(pModel.email, new AbstractFieldValueProperty<String>(email))
				.bindProperty(pModel.acceptTerms, new AbstractFieldValueProperty<Boolean>(acceptTerms))
				.bindProperty(pModel.signupAllowed, new ComponentEnabledProperty(signup))
				.bindProperty(pModel.errorMessage, new LabelCaptionProperty(errorMessage))
				.bindProperty(pModel.notification, new NotificationProperty(window))
				.bindObservable(new ButonClickObservable(signup), pModel.signupClicked);

		new ViewPresenter(pModel, model);

		window.addComponent(name);
		window.addComponent(email);
		window.addComponent(acceptTerms);
		window.addComponent(errorMessage);
		window.addComponent(signup);
		this.setMainWindow(window);
	}
}
