package ar.com.oxen.commons.eventbus.api;

/**
 * A callback for handling incoming events.
 * 
 * @param <T>
 *            The event type
 */
public interface EventHandler<T> {
	/**
	 * Callback method.
	 * 
	 * @param event
	 *            The event which originated the event
	 */
	void onEvent(T event);
}
