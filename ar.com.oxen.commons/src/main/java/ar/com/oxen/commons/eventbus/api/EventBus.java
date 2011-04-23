package ar.com.oxen.commons.eventbus.api;

public interface EventBus {
	void fireEvent(Object event);

	<T> void addHandler(Class<T> eventClass, EventHandler<T> handler);

	void removeHandler(EventHandler<?> handler);
}
