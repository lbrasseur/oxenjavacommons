# Introduction #
This section contains documentation for the Event Bus component .

# Motivation #
As you may know, there are many event bus implementations on the Java platform.
At the moment of developing this component, we didn't find a implementation which fulfilled our requirements:

  * Both, annotation and handler subscription models.
  * Automatic subscriptor removal when such subscriptor is no longer reachable (weak subscription).

So, we created an interface and built a [simple implementation](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/eventbus/impl/simple/SimpleEventBus.java). In a (near) future, we would be able to change it for another one.

# Details #
The main interface is [EventBus](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/eventbus/api/EventBus.java).

As said before, there is two ways for adding event listeners:
  * Creating [EventHandler](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/eventbus/api/EventHandler.java) subclasses and passing them to the envent bus.
  * Annotating class methods with [EventHandlerMethod](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/eventbus/api/EventHandlerMethod.java) and suscriben the annotated class. In this way, the annotated class doesn't require implementing a specific interface. The first argument in the method defines the type of the event to be listen.