package ar.com.oxen.sample.mvp.swing;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ar.com.oxen.commons.property.impl.Binder;
import ar.com.oxen.commons.property.impl.swing.ButonClickObservable;
import ar.com.oxen.commons.property.impl.swing.CheckBoxSelectedProperty;
import ar.com.oxen.commons.property.impl.swing.ComponentEnabledProperty;
import ar.com.oxen.commons.property.impl.swing.DialogProperty;
import ar.com.oxen.commons.property.impl.swing.LabelTextProperty;
import ar.com.oxen.commons.property.impl.swing.TextFieldTextProperty;
import ar.com.oxen.sample.mvp.Person;
import ar.com.oxen.sample.mvp.PresentationModel;
import ar.com.oxen.sample.mvp.ViewPresenter;

public class SampleAplicacion {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Swing Sample");

		frame.setLayout(null);

		JLabel nameCap = new JLabel("Name:");
		nameCap.setBounds(10, 10, 60, 20);
		frame.add(nameCap);
		JTextField name = new JTextField();
		name.setBounds(75, 10, 150, 20);
		frame.add(name);

		JLabel emailCap = new JLabel("Email:");
		emailCap.setBounds(10, 40, 60, 20);
		frame.add(emailCap);
		JTextField email = new JTextField();
		email.setBounds(75, 40, 150, 20);
		frame.add(email);

		JLabel termsCap = new JLabel("Accept terms and conditions");
		termsCap.setBounds(35, 70, 200, 20);
		frame.add(termsCap);
		JCheckBox terms = new JCheckBox();
		terms.setBounds(10, 70, 20, 20);
		frame.add(terms);

		JLabel errorMessage = new JLabel();
		errorMessage.setBounds(10, 100, 250, 20);
		frame.add(errorMessage);

		JButton signup = new JButton("Signup");
		signup.setBounds(10, 130, 100, 20);
		frame.add(signup);

		frame.setSize(400, 400);
		frame.setVisible(true);

		Person model = new Person();
		PresentationModel pModel = new PresentationModel();

		new Binder()
			.bindProperty(pModel.name, new TextFieldTextProperty(name))
			.bindProperty(pModel.email, new TextFieldTextProperty(email))
			.bindProperty(pModel.acceptTerms, new CheckBoxSelectedProperty(terms))
			.bindProperty(pModel.signupAllowed, new ComponentEnabledProperty(signup))
			.bindProperty(pModel.errorMessage, new LabelTextProperty(errorMessage))
			.bindProperty(pModel.notification, new DialogProperty())
			.bindObservable(new ButonClickObservable(signup), pModel.signupClicked);
		
		new ViewPresenter(pModel, model);
	}
}
