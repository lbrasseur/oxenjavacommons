package ar.com.oxen.commons.property.api;

/**
 * Interface for properies that are at the same time observable.
 * 
 * @author Lautaro
 * 
 * @param <T>
 *            The type of the property to be hold.
 */
public interface ObservableProperty<T> extends Observable, Property<T> {

}
