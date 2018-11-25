/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Solved/Edited by Tornike K. Possible solution - there are other ways to solve these tasks.
 */

package com.oppahansi.ss18.mp1_A1;

/**
 * Image Manipulation
 * 
 * @author Marcus
 */
public class Aufgabe2 {

	/**
	 * Converts a RGB color to a gray scale.
	 * 
	 * @param rgb The RGB value to convert.
	 * @return The gray scale value.
	 */
	public static int convertColorToGrayscale(int rgb) {
		// TODO: implement me!
		
		return (Colors.getR(rgb)+Colors.getG(rgb)+Colors.getB(rgb))/3;
		
	}
	
	/**
	 * Converts the pixels of an image from RGB to a gray scale.
	 * 
	 * @param pixels The input pixels.
	 * @return The modified pixels.
	 */
	public static int[][] convertPictureToGrayscale(int[][] pixels) {
		// TODO: implement me!
		for(int i = 0; i < pixels.length; i ++){
			for (int j = 0; j < pixels[0].length; j++){
				pixels[i][j]=Colors.toRGB(convertColorToGrayscale(pixels[i][j]),convertColorToGrayscale(pixels[i][j]),convertColorToGrayscale(pixels[i][j]));
			}			
		}
		return pixels;
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
		// TODO: implement me!
		
		for(int i = 0; i < pixels.length; i ++){
			for (int j = 0; j < pixels[0].length; j++){
				if ( i < pixels.length/3){
					pixels[i][j]= Colors.toRGB(Colors.getR(pixels[i][j]), 0, 0);
				}
				else if (i < 2*pixels.length/3){
					pixels[i][j]= Colors.toRGB(0,Colors.getG(pixels[i][j]), 0);
				}
				else
					pixels[i][j]= Colors.toRGB(0, 0, Colors.getB(pixels[i][j]));
			}			
		}
		return pixels;
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
		// TODO: implement me!
		for(int i = 0; i < pixels.length; i ++){
			for (int j = 0; j < pixels[0].length; j++){
				if((i<borderWidth || i >= pixels.length - borderWidth)||(j < borderWidth || j >= pixels[0].length -borderWidth)){
					pixels[i][j] = borderColor;
				}
			}			
		}
		return pixels;
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
		// TODO: implement me!
		int p1[][] = new int [pixels.length + 2*borderWidth][pixels[0].length + 2*borderWidth];
		for(int i = 0; i < pixels.length; i ++){
			for (int j = 0; j < pixels[0].length; j++){
				p1[i+borderWidth][j+borderWidth] = pixels[i][j];
			}			
		}
		return drawBorderOnPicture(p1, borderWidth, borderColor);
	}
	
	/**
	 * Rotates a picture by 90 degrees by swapping out the
	 * x and y axis.
	 * 
	 * @param pixels The pixels.
	 * @return The rotated picture.
	 */
	public static int[][] rotatePicture(int[][] pixels) {
		// TODO: implement me!
		int p1[][] = new int [pixels[0].length][pixels.length];
		for (int i = 0; i < p1.length; i ++){
			for(int j = 0; j < p1[0].length; j ++){
				p1[i][j] = pixels[p1[0].length-1-j][i];
			}
		}
		return p1;
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
		// TODO: implement me!
		int x = length / n;
		double y = 1.0*length / n;
		if (y > x){
			return x+1;
		}
		return x;
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
		// TODO: implement me!
		int p1 [][] = new int [computeShrinkedSize(pixels.length, n)][computeShrinkedSize(pixels[0].length, n)];
		for(int i = 0; i< p1.length; i ++){
			for (int j = 0; j < p1[0].length; j ++){
				p1[i][j]=pixels[i*n][j*n];
			}
		}
		return p1;
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
		// TODO: implement me!
		int r = 0;
		int g = 0; 
		int b = 0;
		int t = 0;
		for (int i = startX; i < startX+n && i <pixels.length; i ++){
			for (int j = startY; j < startY+n && j < pixels[0].length; j++){
				r += Colors.getR(pixels[i][j]);
				g += Colors.getG(pixels[i][j]);
				b += Colors.getB(pixels[i][j]);	
				t++;
			}
		}
		
		return Colors.toRGB(r/t, g/t, b/t);
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
		// TODO: implement me!
		int p1 [][] = new int [computeShrinkedSize(pixels.length, n)][computeShrinkedSize(pixels[0].length, n)];
		for (int i = 0; i < p1.length; i ++){
			for (int j = 0; j < p1[0].length; j++){
				p1[i][j] = computeAverageColor(pixels, i*n, j*n, n);
			}
		}
		return p1;
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
		long timestamp = System.currentTimeMillis();
		Images.writeImage(name + "-gray-" + timestamp + extension, convertPictureToGrayscale(Images.readImage(input)));
		Images.writeImage(name + "-warhol-" + timestamp + extension, andyWarhol(Images.readImage(input)));
		Images.writeImage(name + "-draw-" + timestamp + extension, drawBorderOnPicture(Images.readImage(input), 100, Colors.toRGB(255, 0, 0)));
		Images.writeImage(name + "-extend-" + timestamp + extension, extendPictureWithBorder(Images.readImage(input), 100, Colors.toRGB(0, 255, 0)));
		Images.writeImage(name + "-rotate-" + timestamp + extension, rotatePicture(Images.readImage(input)));
		Images.writeImage(name + "-shrink-" + timestamp + extension, shrinkPicture(Images.readImage(input), 3));
		Images.writeImage(name + "-smooth-" + timestamp + extension, shrinkPictureSmooth(Images.readImage(input), 3));
	}
	
	
	
	
	
}
