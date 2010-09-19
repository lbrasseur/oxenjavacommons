package ar.com.oxen.commons.property.api;

/**
 * Inteface for accesing a property. Idea taken from the following pages.
 * {@link http://www.matthicks.com/2009/07/death-of-beans.html}
 * {@link http//www.sgine.org/2010/08/properties-discussion.html}
 * {@link http//www.sgine.org/2010/09/beans-should-be-deprecated-future-of.html}
 * 
 * @author Lautaro
 * @param <T> The type of the value to be hold.
 */
public interface Property<T> {
	public T get();

	public void set(T value);
}
