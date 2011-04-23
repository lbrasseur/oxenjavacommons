package ar.com.oxen.commons.eventbus.impl.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import ar.com.oxen.commons.eventbus.api.EventBus;
import ar.com.oxen.commons.eventbus.api.EventHandler;

public class SimpleEventBus implements EventBus {
	private Map<EventHandler<?>, Class<?>> handlers = new HashMap<EventHandler<?>, Class<?>>();

	@SuppressWarnings("unchecked")
	public synchronized void fireEvent(Object event) {
		for (Entry<EventHandler<?>, Class<?>> entry : handlers.entrySet()) {
			if (entry.getValue().equals(event.getClass())) {
				EventHandler<Object> eventHandler = (EventHandler<Object>) entry
						.getKey();
				eventHandler.onEvent(event);
			}
		}
	}

	public synchronized <T> void addHandler(Class<T> eventClass,
			EventHandler<T> handler) {
		this.handlers.put(handler, eventClass);
	}

	@Override
	public synchronized void removeHandler(EventHandler<?> handler) {
		this.handlers.remove(handler);
	}

}
