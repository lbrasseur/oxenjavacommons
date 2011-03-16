package ar.com.oxen.commons.eventbus.api;

public interface EventHandler<T> {
	void onEvent(T event);
}
