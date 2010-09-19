package ar.com.oxen.commons.property.api;

/**
 * Simple observable interface.
 * 
 * @author Lautaro
 * 
 */
public interface Observable {
	void addObserver(Observer observer);

	void notifyObservers();
}
