/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Modified by Oppa Hansi
 */

package com.oppahansi.ss18.mp1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * A helper class to load and save images from and to a file.
 * 
 * @author Marcus
 */
public class Images {

	/**
	 * Reads an image from a file and returns the image's ARGB
	 * values as a two-dimensional array[x][y] or throws a
	 * runtime exception, if the image cannot be loaded.
	 * 
	 * @param filename The name of the image to load.
	 * @return The image's ARGB-values as a 2-dimensional array. 
	 */
	public static int[][] readImage(String filename) {
		try {
			File file = new File("res/img/" + filename);
			BufferedImage image = ImageIO.read(file);
			int w = image.getWidth();
			int h = image.getHeight();
			int[][] pixels = new int[w][h];
			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h; j++) {
					pixels[i][j] = image.getRGB(i, j);
				}
			}
			return pixels;
		} catch (Exception e) {
			throw new RuntimeException("Das Bild konnte nicht geladen werden.", e);
		}
	}
	
	/**
	 * Writes a jpg image to a file or throws a runtime exception, if the
	 * operation fails. The operation will fail:
	 * - If the file exists alreay.
	 * - If the pixels array has a width or height of 0.
	 * - If any other IO error occurs.
	 * 
	 * @param filename The name of the file to write.
	 * @param pixels The ARGB values of the pixels.
	 */
	public static void writeImage(String filename, int[][] pixels) {
		try {
			File file = new File("out/" + filename);
			//if (file.exists()) throw new IOException("Die Datei existiert bereits.");
			if (pixels.length == 0 || pixels[0].length == 0) throw new IOException("Dein Bild hat keine Pixel."); 
			BufferedImage image = new BufferedImage(pixels.length, pixels[0].length, BufferedImage.TYPE_INT_ARGB);
			for (int i = 0, w = pixels.length; i < w; i ++) {
				for (int j = 0, h = pixels[0].length; j < h; j++) {
					image.setRGB(i, j, pixels[i][j]);
				}
			}
			ImageIO.write(image, "PNG", file);
		} catch (Exception e) {
			throw new RuntimeException("Das Bild konnte nicht gespeichert werden.", e);
		}
	}

}
