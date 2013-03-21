package ar.com.oxen.commons.property.impl;

import java.util.LinkedList;
import java.util.List;

import ar.com.oxen.commons.property.api.Observable;
import ar.com.oxen.commons.property.api.Observer;

public class SimpleObservable implements
		Observable {
	private List<Observer> observers = new LinkedList<Observer>();

	@Override
	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
}
