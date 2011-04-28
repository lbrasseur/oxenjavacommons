package ar.com.oxen.commons.eventbus.api;

public interface EventBus {
	void fireEvent(Object event);

	void fireEvent(Object event, String topic);

	<T> void addHandler(Class<T> eventClass, EventHandler<T> handler);

	<T> void addHandler(Class<T> eventClass, EventHandler<T> handler,
			String topic);

	void removeHandler(EventHandler<?> handler);

	void subscribeAnnotatedObject(Object subscriber);
}
