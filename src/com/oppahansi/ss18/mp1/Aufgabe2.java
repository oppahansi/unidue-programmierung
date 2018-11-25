/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */

package com.oppahansi.ss18.mp1;

/**
 * Image Manipulation
 * 
 * @author Marcus
 */
public class Aufgabe2 {

    private static int[][] imageOriginalImageCopy;

	/**
	 * Converts a RGB color to a gray scale.
	 * 
	 * @param rgb The RGB value to convert.
	 * @return The gray scale value.
	 */
	public static int convertColorToGrayscale(int rgb) {
	    int grayValue = (Colors.getR(rgb) + Colors.getG(rgb) + Colors.getB(rgb)) / 3;
		return Colors.toRGB(grayValue, grayValue, grayValue);
	}
	
	/**
	 * Converts the pixels of an image from RGB to a gray scale.
	 * 
	 * @param pixels The input pixels.
	 * @return The modified pixels.
	 */
	public static int[][] convertPictureToGrayscale(int[][] pixels) {
		int[][] grayScaleImage = new int[pixels.length][pixels[0].length];

        for (int x = 0; x < pixels.length; x++) {
            for (int y = 0; y < pixels[x].length; y++) {
                grayScaleImage[x][y] = convertColorToGrayscale(pixels[x][y]);
            }
        }

        return grayScaleImage;
	}
	
	/**
	 * Converts a picture by dividing it in three equal parts along the X axis. 
	 * In the first (left) part, only the red component is drawn. In the second 
	 * (middle) part, only the green component is drawn. In the third (right) part,
	 * only the blue component is drawn.
	 * 
	 * @param pixels The input pixels.
	 * @return The output pixels.
	 */
	public static int[][] andyWarhol(int[][] pixels) {
		int[][] andyWarholImage = new int[pixels.length][pixels[0].length];

        for (int x = 0; x < pixels.length; x++) {
            for (int y = 0; y < pixels[x].length; y++) {
                if (x < pixels.length / 3) {
                    andyWarholImage[x][y] = Colors.toRGB(Colors.getR(pixels[x][y]), 0, 0);
                } else if (x >= pixels.length / 3 && x < pixels.length * 2 / 3) {
                    andyWarholImage[x][y] = Colors.toRGB(0, Colors.getG(pixels[x][y]), 0);
                } else {
                    andyWarholImage[x][y] = Colors.toRGB(0, 0, Colors.getB(pixels[x][y]));
                }
            }
        }

		return andyWarholImage;
	}
	
	/**
	 * Draws a border of the specified borderWidth with the specified borderColor
	 * onto the picture.
	 * 
	 * @param pixels The pixels of the picture.
	 * @param borderWidth The border width in number of pixels (>= 0).
	 * @param borderColor The border color.
	 * @return The picture with a border of the specified width and color.
	 */
	public static  int[][] drawBorderOnPicture(int[][] pixels, int borderWidth, int borderColor) {
		imageOriginalImageCopy = pixels;

	    int[][] borderImage = new int[pixels.length][pixels[0].length];

        for (int x = 0; x < pixels.length; x++) {
            for (int y = 0; y < pixels[x].length; y++) {
                if ((x < borderWidth || x >= pixels.length - borderWidth) || (y < borderWidth || y >= pixels[x].length - borderWidth))  {
                    borderImage[x][y] = borderColor;
                }
                else {
                    borderImage[x][y] = pixels[x][y];
                }
            }
        }

		return borderImage;
	}
	
	/**
	 * Extends a picture with a border with the specified borderWidth and borderColor.
	 * 
	 * @param pixels The pixels of the picture.
	 * @param borderWidth The width of the border in pixels (>= 0).
	 * @param borderColor The border color.
	 * @return The extended picture with a border with the specified number of pixels in the specified color.
	 */
	public static  int[][] extendPictureWithBorder(int[][] pixels, int borderWidth, int borderColor) {
		int[][] extendedPicture = new int[pixels.length + borderWidth*2][pixels[0].length + borderWidth*2];

        for (int x = 0; x < extendedPicture.length; x++) {
            for (int y = 0; y < extendedPicture[x].length; y++) {
                if ((x < borderWidth || x >= extendedPicture.length - borderWidth) ||
                        (y < borderWidth || y >= extendedPicture[x].length - borderWidth))  {
                    extendedPicture[x][y] = borderColor;
                }
                else {
                    extendedPicture[x][y] = imageOriginalImageCopy[x - borderWidth][y - borderWidth];
                }
            }
        }

		return extendedPicture;
	}
	
	/**
	 * Rotates a picture by 90 degrees by swapping out the
	 * x and y axis.
	 * 
	 * @param pixels The pixels.
	 * @return The rotated picture.
	 */
	public static int[][] rotatePicture(int[][] pixels) {

        int[][] rotatedImage = new int[pixels[0].length][pixels.length];

        for (int x = 0; x < pixels.length; x++) {
            for (int y = 0; y < pixels[x].length; y++) {
                rotatedImage[y][x] = pixels[pixels.length - 1 - x][y];
            }
        }

		return rotatedImage;
	}
	
	/**
	 * Computes the size of an axis when shrinking it by only drawing
	 * every n-th pixel.
	 * 
	 * @param length The length of the axis (>0)
	 * @param n The interval of the pixels (>0).
	 * @return The number of pixels on the axis.
	 */
	public static int computeShrinkedSize(int length, int n) {
		return length % n == 0 ? length/n : length/n + 1;
	}
	
	/**
	 * Shrinks a picture while keeping the aspect ratio
	 * by drawing only every n-th pixel in each dimension.
	 * 
	 * @param pixels The pixels of the image.
	 * @param n The n to define how much to shrink the picture.
	 * @return The shrunken picture.
	 */
	public static int[][] shrinkPicture(int[][] pixels, int n) {
		int[][] shrinkedPicture = new int[computeShrinkedSize(pixels.length, n)][computeShrinkedSize(pixels[0].length, n)];

		for (int x = 0; x < shrinkedPicture.length; x++) {
            for (int y = 0; y < shrinkedPicture[x].length; y++) {
                    shrinkedPicture[x][y] = pixels[x * n][y * n];
            }
        }

		return shrinkedPicture;
	}
	
	/**
	 * Computes the average color of a group of pixels in another array starting at
	 * startX and startY going to min(startX + n, pixels.length), 
	 * min(startY + n, pixels[0].length).
	 * 
	 * @param pixels The pixels
	 * @param startX The x coordinate of the start.
	 * @param startY The y coordinate of the start.
	 * @param n The number of pixels in each dimension.
	 * @return The (component-wise) average color value representing the group of pixels.
	 */
	public static int computeAverageColor(int[][] pixels, int startX, int startY, int n) {
        int redSum = 0;
        int greenSum = 0;
        int blueSum = 0;
        int pixelsCounter = 0;

	    for (int x = startX; x < startX + n && x < pixels.length; x++) {
	        for (int y = startY; y < startY + n && y < pixels[x].length; y++) {
	            redSum += Colors.getR(pixels[x][y]);
	            greenSum += Colors.getG(pixels[x][y]);
	            blueSum += Colors.getB(pixels[x][y]);
                pixelsCounter++;
            }
        }

		return Colors.toRGB(redSum / pixelsCounter, greenSum / pixelsCounter, blueSum / pixelsCounter);
	}
	
	/**
	 * Smoothly shrinks a picture while keeping the aspect ratio
	 * by drawing only every n-th pixel in each dimension but
	 * using the average of all "shrunken" pixels.  
	 * 
	 * @param pixels The input pixels.
	 * @param n The n to define how much to shrink the picture.
	 * @return The smoothly shrunken picture.
	 */
	public static int[][] shrinkPictureSmooth(int[][] pixels, int n) {
        int[][] shrinkedSmoothPicture = new int[computeShrinkedSize(pixels.length, n)][computeShrinkedSize(pixels[0].length, n)];

        for (int x = 0; x < shrinkedSmoothPicture.length; x++) {
            for (int y = 0; y < shrinkedSmoothPicture[x].length; y++) {
                shrinkedSmoothPicture[x][y] = computeAverageColor(pixels, x * n, y * n, n);
            }
        }

        return shrinkedSmoothPicture;
	}
	
	
	/**
	 * Reads a picture, runs all conversion methods and saves
	 * the output to a new file with the following format:
	 * 
	 * name-'conversion'-'timestamp'
	 * 
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		String name = "notre-dame";
		String extension = ".png";
		String input = name + extension;
		// long timestamp = System.currentTimeMillis();
		Images.writeImage(name + "-gray-" + /*timestamp + */extension, convertPictureToGrayscale(Images.readImage(input)));
		Images.writeImage(name + "-warhol-" + /*timestamp + */extension, andyWarhol(Images.readImage(input)));
		Images.writeImage(name + "-draw-" + /*timestamp + */extension, drawBorderOnPicture(Images.readImage(input), 100, Colors.toRGB(255, 0, 0)));
		Images.writeImage(name + "-extend-" + /*timestamp + */extension, extendPictureWithBorder(Images.readImage(input), 100, Colors.toRGB(0, 255, 0)));
		Images.writeImage(name + "-rotate-" + /*timestamp + */extension, rotatePicture(Images.readImage(input)));
		Images.writeImage(name + "-shrink-" + /*timestamp + */extension, shrinkPicture(Images.readImage(input), 3));
		Images.writeImage(name + "-smooth-" + /*timestamp + */extension, shrinkPictureSmooth(Images.readImage(input), 3));
	}
	
	
	
	
	
}
