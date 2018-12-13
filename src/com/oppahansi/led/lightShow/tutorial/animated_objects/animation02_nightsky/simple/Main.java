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
 * There are basically to important methods here:
 * - initialize()
 *   This method prepares all objects needed for the animation. Those are mainly stars and cloud, but also the
 *   BoardController and a random number generator (Random rng) to spread the stars randomly across the board.
 * - animationLoop()
 *   This method does the heavy lifting of the program and is responsible for the smooth animation. It relies on the
 *   used objects each having a method to draw them and a method to let their inner status progress which is ultimately
 *   responsible for the animations of the objects.
 * Later examples improve upon this concept.
 * 
 * For programs to work in this manner it is necessary to identify the objects that will be visible on the screen and
 * create classes for each identified group of objects. The cleaner the separation of those objects, the easier the
 * implementation of the main program and the classes for the objects will be.
 *   
 * The used objects are MovingClouds, which are just that, clouds that move over the board, and BlinkingStars, which
 * are also just that, stars that blink from time to time.
 */

package com.oppahansi.led.lightShow.tutorial.animated_objects.animation02_nightsky.simple;

import java.util.Random;

import ledControl.BoardController;

public class Main {
	
	private static BlinkingStar star0, star1, star2, star3, star4, star5, star6, star7, star8, star9;
	private static MovingCloud cloud0, cloud1, cloud2, cloud3, cloud4;
	private static BoardController controller;

	public static void main(String[] args) {
		// the main method just calls the two important methods
		initialize();
		animationLoop();
	}
	
	/*
	 * All drawable objects need to be given the BoardController for their instantiation. This enables the objects to
	 * draw themselves on the board completely independent of everything else. This makes the organization of the main
	 * program somewhat easier, because drawing of a single object will only require a single method call.
	 * EXERCISE: Try to place some or all stars at fixed position of your choice, or even paint a picture with them.
	 */
	private static void initialize(){
		controller = BoardController.getBoardController();
		Random rng = new Random();
		star0 = new BlinkingStar(controller, rng.nextInt(controller.getWidth()), rng.nextInt(controller.getHeight()));
		star1 = new BlinkingStar(controller, rng.nextInt(controller.getWidth()), rng.nextInt(controller.getHeight()));
		star2 = new BlinkingStar(controller, rng.nextInt(controller.getWidth()), rng.nextInt(controller.getHeight()));
		star3 = new BlinkingStar(controller, rng.nextInt(controller.getWidth()), rng.nextInt(controller.getHeight()));
		star4 = new BlinkingStar(controller, rng.nextInt(controller.getWidth()), rng.nextInt(controller.getHeight()));
		star5 = new BlinkingStar(controller, rng.nextInt(controller.getWidth()), rng.nextInt(controller.getHeight()));
		star6 = new BlinkingStar(controller, rng.nextInt(controller.getWidth()), rng.nextInt(controller.getHeight()));
		star7 = new BlinkingStar(controller, rng.nextInt(controller.getWidth()), rng.nextInt(controller.getHeight()));
		star8 = new BlinkingStar(controller, rng.nextInt(controller.getWidth()), rng.nextInt(controller.getHeight()));
		star9 = new BlinkingStar(controller, rng.nextInt(controller.getWidth()), rng.nextInt(controller.getHeight()));
		cloud0 = new MovingCloud(controller);
		cloud1 = new MovingCloud(controller);
		cloud2 = new MovingCloud(controller);
		cloud3 = new MovingCloud(controller);
		cloud4 = new MovingCloud(controller);
	}
	
	/*
	 * This method realizes an endless animation. It contains an endless loop in which the same steps are iterated again
	 * and again. One of the important ideas to grasp here is, that to create the next picture in your animation, you
	 * don't adjust the last picture, but completely erase the board and draw the next picture from scratch. This
	 * requires all objects to be drawn again on an empty board, knowing where and how they need to be drawn.
	 * You can easily identify the steps here:
	 * 1. Clear the board. The method call controller.resetColors() does just that.
	 * 2. Tell all objects to draw themselves on the board. If the Objects are properly implemented, this is easily done
	 *    as can be seen below. Bear in mind, that the objects only draw themselves, but do NOT call the update method
	 *    of the controller! Calling the update method in the draw methods of the objects will result not in a smooth
	 *    animation, but in a stuttering display.
	 * EXERCISE: Place the controller.updateLedStripe() call inside the objects draw method, observe the result
	 *           and try to understand it.
	 * 3. After all objects are drawn, the now complete picture is ready to be made visible. This is the right time to
	 *    call the method controller.updateLedStripe().
	 * 4. Now, that all the drawing is done, we can prepare the next step of the animation. All objects need to prepare
	 *    their inner state for the next picture. To do this, all objects receive a method call to update themselves.
	 *    Again, if the objects are properly implemented, this is easily done. In this example, the clouds move forward
	 *    and the stars blink.
	 */
	private static void animationLoop(){
		while (true){
			// clear screen
			controller.resetColors();
			// draw all objects
			// stars first
			// cloud0's draw method call is misplaced here. You might notice in the animation, that there is one strange
			// cloud that appears to be behind the stars. That's cloud0, because it is drawn in the wrong place.
			// EXERCISE: reposition the draw method call in a way, that the cloud is drawn in front of all stars.
			cloud0.draw();
			star0.draw();
			star1.draw();
			star2.draw();
			star3.draw();
			star4.draw();
			star5.draw();
			star6.draw();
			star7.draw();
			star8.draw();
			star9.draw();
			// then clouds, because clouds might conceal the stars
			cloud1.draw();
			cloud2.draw();
			cloud3.draw();
			cloud4.draw();
			
			// update screen when drawing is finished
			// when written in this way, this is the only place in the whole program (not only this class!),
			// where an update should occur!
			controller.updateBoard();
			
			// progress of all objects. In this case the ordering is irrelevant. If the inner state of your own objects
			// depends on other objects, the ordering will be important.
			star0.update();
			star1.update();
			star2.update();
			star3.update();
			star4.update();
			star5.update();
			star6.update();
			star7.update();
			star8.update();
			star9.update();
			cloud0.update();
			cloud1.update();
			cloud2.update();
			cloud3.update();
			cloud4.update();
		}
	}

}
