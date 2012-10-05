package ar.com.oxen.commons.eventbus.impl.simple;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ar.com.oxen.commons.eventbus.api.EventBus;
import ar.com.oxen.commons.eventbus.api.EventHandler;
import ar.com.oxen.commons.eventbus.api.EventHandlerMethod;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * Simple event bus implementation.<br>
 * Includes automatic de-subscription of garbage-collected object (using weak
 * references).
 */
public class SimpleEventBus implements EventBus {
	private Multimap<Class<?>, AbstractInfo> handlers = HashMultimap.create();
	private Map<Reference<?>, AbstractInfo> referenceToHandler = new HashMap<Reference<?>, AbstractInfo>();

	private ReferenceQueue<Object> referenceQueue = new ReferenceQueue<Object>();

	public SimpleEventBus() {
		super();
		this.startKillerThread();
	}

	public synchronized void fireEvent(Object event) {
		this.fireEvent(event, null);
	}

	@SuppressWarnings("unchecked")
	public synchronized void fireEvent(Object event, String topic) {
		for (AbstractInfo handlerInfo : new ArrayList<AbstractInfo>(this.handlers
				.get(event.getClass()))) {
			EventHandler<Object> eventHandler = (EventHandler<Object>) handlerInfo
					.getEventHandler();
			if (eventHandler != null
					&& (topic == null || handlerInfo.getTopic() == null || topic
							.equals(handlerInfo.getTopic()))) {
				eventHandler.onEvent(event);
			}
		}
	}

	public <T> void addHandler(Class<T> eventClass, EventHandler<T> handler) {
		this.addHandler(eventClass, handler, null);
	}

	public <T> void addHandler(Class<T> eventClass, EventHandler<T> handler,
			String topic) {
		this.addHandlerInfo(new HandlerInfo(handler, eventClass, topic));
	}

	@Override
	public synchronized void removeHandler(EventHandler<?> handler) {
		for (Map.Entry<Class<?>, AbstractInfo> entry : this.handlers.entries()) {
			if (handler.equals(entry.getValue().getEventHandler())) {
				this.handlers.remove(entry.getKey(), entry.getValue());
				this.referenceToHandler.remove(entry.getValue().getReference());
			}
		}
	}

	@Override
	public void subscribeAnnotatedObject(final Object subscriber) {
		for (final Method method : subscriber.getClass().getMethods()) {
			EventHandlerMethod annotation = method
					.getAnnotation(EventHandlerMethod.class);
			if (annotation != null) {
				Class<?> paramTypes[] = method.getParameterTypes();
				if (paramTypes.length != 1) {
					throw new IllegalArgumentException("Param count must be 1");
				}
				this.addHandlerInfo(new SubscriberInfo(
						new EventHandler<Object>() {

							@Override
							public void onEvent(Object event) {
								try {
									boolean origAcc = method.isAccessible();
									method.setAccessible(true);
									method.invoke(subscriber, event);
									method.setAccessible(origAcc);
								} catch (IllegalAccessException e) {
									throw new IllegalArgumentException(e);
								} catch (InvocationTargetException e) {
									throw new IllegalArgumentException(e);
								}
							}
						}, paramTypes[0], subscriber, annotation.topic()));
			}
		}
	}

	private void startKillerThread() {
		Thread killerThread = new Thread(new Runnable() {

			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				while (true) {
					try {
						removeReference((Reference<Object>) referenceQueue
								.remove());
					} catch (InterruptedException e) {
						throw new IllegalStateException(e);
					}

				}
			}
		});
		killerThread.setDaemon(false);
		killerThread.start();
	}

	private synchronized <T> void removeReference(Reference<Object> reference) {
		AbstractInfo info = this.referenceToHandler.remove(reference);
		this.handlers.remove(info.getEventClass(), info);
	}

	private synchronized <T> void addHandlerInfo(AbstractInfo info) {
		this.handlers.put(info.getEventClass(), info);
		this.referenceToHandler.put(info.getReference(), info);
	}

	private abstract class AbstractInfo {
		private Reference<?> reference;
		private Class<?> eventClass;
		private String topic;

		public AbstractInfo(Object reffered, Class<?> eventClass, String topic) {
			super();
			this.reference = new WeakReference<Object>(reffered, referenceQueue);
			this.eventClass = eventClass;
			this.topic = "".equals(topic) ? null : topic;
		}

		public Reference<?> getReference() {
			return this.reference;
		}

		public Class<?> getEventClass() {
			return this.eventClass;
		}

		public String getTopic() {
			return topic;
		}

		public abstract EventHandler<?> getEventHandler();
	}

	private class HandlerInfo extends AbstractInfo {
		public HandlerInfo(EventHandler<?> handler, Class<?> eventClass,
				String topic) {
			super(handler, eventClass, topic);
		}

		public EventHandler<?> getEventHandler() {
			return (EventHandler<?>) this.getReference().get();
		}
	}

	private class SubscriberInfo extends AbstractInfo {
		private EventHandler<?> handler;

		public SubscriberInfo(EventHandler<?> handler, Class<?> eventClass,
				Object referred, String topic) {
			super(referred, eventClass, topic);
			this.handler = handler;
		}

		public EventHandler<?> getEventHandler() {
			return this.handler;
		}
	}
}
