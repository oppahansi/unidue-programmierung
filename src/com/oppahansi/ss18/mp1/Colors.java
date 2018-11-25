/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 */

package com.oppahansi.ss18.mp1;

/**
 * A utility class that provides a space-efficient RGB encoding and decoding
 * of individual color components. 
 * 
 * @author Marcus
 */
public class Colors {

	/**
	 * Computes an integer that represents the specified RGB value.
	 * 
	 * @param r The red component from 0-255.
	 * @param g The green component from 0-255.
	 * @param b The blue component from 0-255.
	 * @return An integer representing the combined RGB value.
	 */
	public static int toRGB(int r, int g, int b) {
		return (0xff << 24) | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
	}
	
	/**
	 * Returns the red component of the specified RGB value.
	 * 
	 * @param rgb The rgb value.
	 * @return The red component (from 0-255).
	 */
	public static int getR(int rgb) {
		return (rgb >> 16) & 0xff; 
	}

	/**
	 * Returns the green component of the specified RGB value.
	 * 
	 * @param rgb The rgb value.
	 * @return The green component (from 0-255).
	 */
	public static int getG(int rgb) {
		return (rgb >> 8) & 0xff;
	}
	
	/**
	 * Returns the blue component of the specified RGB value.
	 * 
	 * @param rgb The rgb value.
	 * @return The blue component (from 0-255).
	 */
	public static int getB(int rgb) {
		return rgb & 0xff;
	}

	
	/**
	 * Adds a padding to the byte value. 
	 * 
	 * @param b The integer representing a byte value.
	 * @return The padded string.
	 */
	private static String padByte(int b) {
		String prefix;
		if (b >= 100) {
			prefix = "";
		} else if (b >= 10) {
			prefix = "0";
		} else {
			prefix = "00"; 
		}
		return prefix + Integer.toString(b);
	}
	
	/**
	 * Converts a color to a human readable string.
	 * 
	 * @param color The color.
	 * @return The string.
	 */
	public static String toString(int color) {
		return "R(" + padByte(getR(color)) + ") G(" + padByte(getG(color)) + ") B(" + padByte(getB(color)) + ")"; 
	}

	
}
