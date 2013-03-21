package ar.com.oxen.commons.eventbus.api;

/**
 * A generic interface or accessing an EventBus.<br>
 * Events are dispatched according to its type (class).
 */
public interface EventBus {
	/**
	 * Fires an event.
	 * 
	 * @param event The object with event data
	 */
	void fireEvent(Object event);

	/**
	 * Fires an event with an specific topic. The topic used in order to filter
	 * events of the same type.
	 * 
	 * @param event
	 *            The object with event data
	 * @param topic
	 *            The topic
	 */
	void fireEvent(Object event, String topic);

	/**
	 * Registers an event handler.
	 * 
	 * @param eventClass
	 *            The event type for which the events will be listened.
	 * @param handler
	 *            The event handler
	 */
	<T> void addHandler(Class<T> eventClass, EventHandler<T> handler);

	/**
	 * Registers an event handler for a given topic.
	 * 
	 * @param eventClass
	 *            The event type for which the events will be listened.
	 * @param handler
	 *            The event handler
	 * @param topic
	 *            The topic
	 */
	<T> void addHandler(Class<T> eventClass, EventHandler<T> handler,
			String topic);

	/**
	 * Unregisters a handler.
	 * 
	 * @param handler
	 *            The handler
	 */
	void removeHandler(EventHandler<?> handler);

	/**
	 * Registers the subscriber object for receiving events on methods annotated
	 * with {@link EventHandlerMethod}
	 * 
	 * @param subscriber
	 *            The annotated object
	 */
	void subscribeAnnotatedObject(Object subscriber);
	
	/**
	 * Unregisters the subscriber object for receiving events on methods
	 * annotated with {@link EventHandlerMethod}
	 * 
	 * @param subscriber
	 *            The annotated object
	 */
	void unsubscribeAnnotatedObject(Object subscriber);
}
