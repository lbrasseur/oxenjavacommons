# Introduction #
This API provides a way for accessing and binding properties.

# Details #
It extends the idea found on this blogs:
  * http://www.matthicks.com/2009/07/death-of-beans.html
  * http://www.sgine.org/2010/08/properties-discussion.html
  * http://www.sgine.org/2010/09/beans-should-be-deprecated-future-of.html

but adds observables and the ability and binding properties and/or events.

This is the main [package](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/property/api/). Here you can find the [Property](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/property/api/Property.java) interface. It abstracts the access to a individual data item.

Another important interfaces are [Observable](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/property/api/Observable.java) and [Observer](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/property/api/Observer.java). They implement the observer pattern, used here to handle events (I preferred creating new interfaces over JDK´s default [Observer-Observable](http://download-llnw.oracle.com/javase/6/docs/api/java/util/Observable.html) implementation because this one required concrete inheritance).
Finally, the interface [ObservableProperty](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/property/api/ObservableProperty.java) just combines Property and Observable.

Common implementations can be found on this [package](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/property/impl). The [Binder](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/property/impl/Binder.java) class is important here: it allows binding properties and observables, so when one is changed/notified, the other one is automatically updated.


Beside the API and generic implementations, we have some specific adapters over existing technologies:
  * [ar.com.oxen.commons.property.impl.bean](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/property/impl/bean) : Adapter over [JavaBeans](http://www.oracle.com/technetwork/java/javase/tech/index-jsp-138795.html), typically useful for accessing model data.
  * [ar.com.oxen.commons.property.impl.swing](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/property/impl/swing) : Adapters for accessing [Swing](http://download-llnw.oracle.com/javase/6/docs/technotes/guides/swing/) widgets
  * [ar.com.oxen.commons.property.impl.vaadin](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.commons/src/main/java/ar/com/oxen/commons/property/impl/vaadin) : Adapters for accessing [Vaadin](http://vaadin.com/home) widgets.

(I didn´t include SWT just to avoid native libraries dependencies, but it can be built easily.)

Using this infrastructure, the sample projects contains some examples:
  * [ar.com.oxen.sample.mvp](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.sample/src/main/java/ar/com/oxen/sample/mvp) : A technology-independent MVP pattern implementation sample.
  * [ar.com.oxen.sample.mvp.swing](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.sample/src/main/java/ar/com/oxen/sample/mvp/swing) : The MVP sample with binding to [Swing](http://download-llnw.oracle.com/javase/6/docs/technotes/guides/swing/) components.
  * [ar.com.oxen.sample.mvp.vaadin](http://code.google.com/p/oxenjavacommons/source/browse/trunk/ar.com.oxen.sample/src/main/java/ar/com/oxen/sample/mvp/vaadin) : The MVP sample with binding to [Vaadin](http://vaadin.com/home) components.

This is just a proof of concept, but is a simple example of how to build a generic MVP with binding from UI to Presentation Model and to Model. We also build an [Android](http://code.google.com/p/oxenandroidcommons/wiki/Property) implementation that runs the same example without modification.

Future Work:
  * Creating a Decorator over Property that provides validation.
  * Creating a Decorator over Property that provides data conversion.
  * How could it made less verbose? Specially the presentation model declaration.