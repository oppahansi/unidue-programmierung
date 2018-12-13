/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 */

package com.oppahansi.led.lightShow.tutorial.animated_objects.animation02_nightsky.advanced;

/*
 * Star and MovingCloud implement this interface. This has the nice effect, that both kinds of objects can be put into
 * lists of AnimatedObject and the methods defined here can then be called on every object in those list, regardless of
 * being a Star or a MovingCloud.
 */

public interface AnimatedObject {
	
	void draw();
	
	void update();

}
