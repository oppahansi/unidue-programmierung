/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 */

package com.oppahansi.led.lightShow.tutorial.animated_objects.animation02_nightsky.advanced;

import java.util.Random;

import ledControl.BoardController;

public class BlinkingStar implements AnimatedObject{

	private final int BLINK_CHANCE = 100;
	private final Random rng;
	
	// play around with these constants to alter the appearance of the animation
	private final int INNER_SPEED_SLOW	= 3;
	private final int INNER_BASE_SLOW	= 50;
	private final int INNER_SPEED_FAST	= 6;
	private final int INNER_BASE_FAST	= 50;
	
	private final int OUTER_SPEED_FAST	= 20;
	private final int OUTER_BASE_FAST	= 15;
	

	private BoardController controller;
	private int xpos, ypos;

	// for animation status
	private int[]	innerColor;
	private int[]	outerColor;
	private int		progress;
	private boolean blinking;

	public BlinkingStar(BoardController controller, int x, int y){
		this.controller	= controller;
		this.xpos		= x;
		this.ypos		= y;

		innerColor	= new int[]{50, 50, 50};
		outerColor	= new int[]{0, 0, 0};
		blinking	= false;
		progress	= 0;
		rng			= new Random();
	}

	public void draw(){
		controller.setColor(xpos, ypos, innerColor);
		controller.maxColor(xpos - 1, ypos, outerColor);
		controller.maxColor(xpos + 1, ypos, outerColor);
		controller.maxColor(xpos, ypos - 1, outerColor);
		controller.maxColor(xpos, ypos + 1, outerColor);
	}

	public void update(){
		// The animation is controlled by the progress counter and is only active, if blinking is set.
		// If star is in the process of blinking,
		// it will get brighter till it peaks at progress == 10,
		// getting darker afterwards till resuming normal state at 20
		if (blinking){
			// one step forward in the animation
			progress++;
			// center of star will slowly grow brighter
			if (progress < 8){
				innerColor = new int[]{INNER_BASE_SLOW + INNER_SPEED_SLOW * progress,
										INNER_BASE_SLOW + INNER_SPEED_SLOW * progress,
										INNER_BASE_SLOW + INNER_SPEED_SLOW * progress};
				// center brightens faster, outer pixels also brighten
			} else if (progress >= 8 && progress < 10){
				innerColor = new int[]{INNER_BASE_FAST + INNER_SPEED_FAST * progress,
										INNER_BASE_FAST + INNER_SPEED_FAST * progress,
										INNER_BASE_FAST + INNER_SPEED_FAST * progress};
				outerColor = new int[]{OUTER_BASE_FAST + OUTER_SPEED_FAST * (progress - 8),
										OUTER_BASE_FAST + OUTER_SPEED_FAST * (progress - 8),
										OUTER_BASE_FAST + OUTER_SPEED_FAST * (progress - 8)};
				// peak brightness
			} else if (progress == 10){
				innerColor = new int[]{127, 127, 127};
				outerColor = new int[]{65, 65, 65};
				// star darkens, so do the outer pixels
			} else if (progress >= 11 && progress < 13){
				innerColor = new int[]{INNER_BASE_FAST + INNER_SPEED_FAST * (20 - progress),
										INNER_BASE_FAST + INNER_SPEED_FAST * (20 - progress),
										INNER_BASE_FAST + INNER_SPEED_FAST * (20 - progress)};
				outerColor = new int[]{OUTER_BASE_FAST + OUTER_SPEED_FAST * (12 - progress),
										OUTER_BASE_FAST + OUTER_SPEED_FAST * (12 - progress),
										OUTER_BASE_FAST + OUTER_SPEED_FAST * (12 - progress)};
				// center darkens slower, outer pixels are completely dark
			} else if (progress >= 13 && progress < 20){
				innerColor = new int[]{INNER_BASE_SLOW + INNER_SPEED_SLOW * (20 - progress),
										INNER_BASE_SLOW + INNER_SPEED_SLOW * (20 - progress),
										INNER_BASE_SLOW + INNER_SPEED_SLOW * (20 - progress)};
				outerColor = new int[]{0, 0, 0};
				// star returns to standard brightness, animation cycle is reset
			} else if (progress == 20){
				innerColor	= new int[]{50, 50, 50};
				blinking = false;
			}
			// If the star is not in the process of blinking, there is a random Chance the star starts to blink
		} else {
			if (rng.nextInt(BLINK_CHANCE) == 0){
				blinking = true;
				progress = 0;
			}
		}
	}
}
