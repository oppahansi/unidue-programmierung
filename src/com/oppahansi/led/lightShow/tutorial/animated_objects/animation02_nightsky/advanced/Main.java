/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 */

/*
 * This program demonstrates an easy way to handle multiple drawable animated objects on the board, while keeping the
 * animation of all objects smooth and the code of the main program easy to understand.
 * 
 * Like all tutorial and example programs, this program shows possible solutions for common problems. This is only
 * one of many possible ways to realize animations. Feel free to adapt and/or modify it in any way you like.
 * 
 * Within the comments some lines are marked as EXERCISE. Following these exercises will improve your insight on how the
 * code works.
 * 
 * This is the second approach to animating objects on the board. It is based on the program in the package
 * light_show.tutorial.animated_objects.simple
 * The goal of this approach is to improve the organization of our code to make it
 *  - more readable
 *  - easier to understand
 * 	- easier to change
 * 
 * To achieve this several changes were made:
 *  - further moving clearly separatable code blocks to methods
 *  - defining an interface for animated objects
 *  - managing the animated objects in lists
 *  - the use of constants
 */

package com.oppahansi.led.lightShow.tutorial.animated_objects.animation02_nightsky.advanced;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import ledControl.BoardController;
import ledControl.LedConfiguration;

public class Main {
	
	/*
	 * With these constants we control how many stars and clouds are in the animation. Instead of explicitly writing the
	 * number of stars or clouds where necessary we use the constants.
	 * e.g.			for (int i = 0; i < COUNT_CLOUDS; i++)
	 * instead of	for (int i = 0; i < 5; i++)
	 * When written this way, we can change their number by changing just one line of code without the need to control
	 * every bit of code for the occurrence of that specific number. Constants can be used for anything occurring in our
	 * code, even if there is only one occurrence. The advantage is, that class behavior can be easily modified at
	 * one central place in the code. Of course you should keep your constants in one place.
	 * 
	 * EXERCISE: change the numbers of COUNT_CLOUDS and COUNT_STARS to see the effect and check if the program still
	 * 			 executes smoothly.
	 */
	private final static int COUNT_CLOUDS	= 5;
	private final static int COUNT_STARS	= 10;
	
	/*
	 * The animated objects are not anymore represented by a variable for each object, but they are put into a list at
	 * creation. This simplifies the drawing and updating of projects.
	 * Before the same method call had to be invoked on every single variable resulting in many lines of code that
	 * essentially did the same thing. Now we just iterate over the list of objects and write the method call only one
	 * time, as can be seen in the methods drawAnimatedObjects() and updateAnimatedObjects().
	 */
	private static List<AnimatedObject> animatedObjects;
	private static BoardController controller;

	public static void main(String[] args) {
		// the main method just calls the two important methods
		initialize();
		animationLoop();
	}
	
	private static void initialize(){
		controller		= BoardController.getBoardController(LedConfiguration.LED_20x20_EMULATOR);
		animatedObjects	= new LinkedList<>();
		Random rng = new Random();
		
		// The initialized objects are all put into the list of animatedObjects at creation time.
		// Notice, that the order of insertion defines the order of drawing and updating in this program.
		// Depending on the animation it might be advisable to separate the animated objects into multiple lists to gain
		// more control over the order of drawing and updating.
		
		// EXERCISE: Switch the position of both loops and observe the animation. What is the difference? Why is this
		//           caused by switching the loops?
		for (int i = 0; i < COUNT_STARS; i++){
			animatedObjects.add(new BlinkingStar(controller, rng.nextInt(controller.getWidth()), rng.nextInt(controller.getHeight())));
		}
		for (int i = 0; i < COUNT_CLOUDS; i++){
			animatedObjects.add(new MovingCloud(controller));
		}
	}
	
	/*
	 * This method realizes an endless animation. It contains an endless loop in which the same steps are iterated again
	 * and again. One of the important ideas to grasp here is, that to create the next picture in your animation, you
	 * don't adjust the last picture, but completely erase the board and draw the next picture from scratch. This
	 * requires all objects to be drawn again on an empty board, knowing where and how they need to be drawn. Different
	 * to the previous version some of the steps are implemented in their own methods, making the animation loop even
	 * more easy to read.
	 * 
	 * You can easily identify the steps here:
	 * 1. Clear the board. The method call controller.resetColors() does just that.
	 * 2. Tell all objects to draw themselves on the board. This is done in the method drawAnimatedObjects();
	 * 3. After all objects are drawn, the now complete picture is ready to be made visible. This is the right time to
	 *    call the method controller.updateLedStripe().
	 * 4. Now, that all the drawing is done, we can prepare the next step of the animation. This is done in the method
	 *    updateAnimatedObjects
	 *    
	 * EXERCISE: Change the execution order of the four steps. Is there a difference in the animation? If so, why?
	 */
	private static void animationLoop(){
		while (true){
			// clear screen
			controller.resetColors();
			
			// draw all objects
			// now the necessary code is in the method below, making the animation loop much easier to read and less
			// prone to errors
			drawAnimatedObjects();
			
			// update screen when drawing is finished
			// when written in this way, this is the only place in the whole program (not only this class!),
			// where an update should occur!
			controller.updateBoard();
			
			// similar to drawAnimatedObjects
			// better code organization results in better readability and more robust code
			updateAnimatedObjects();
		}
	}
	
	private static void drawAnimatedObjects(){
		/*
		 * The drawing of all objects is now reduced to this simple loop. Since the animated objects all implement the
		 * new Interface AnimatedObject and the list contains only objects implementing that interface, we can just call
		 * the method draw() on every object.
		 */
		for(AnimatedObject ao: animatedObjects){
			ao.draw();
		}
	}
	
	private static void updateAnimatedObjects(){
		/*
		 * Similar to drawAnimatedObjects() the update of objects is now much easier.
		 */
		for(AnimatedObject ao: animatedObjects){
			ao.update();
		}
	}

}
