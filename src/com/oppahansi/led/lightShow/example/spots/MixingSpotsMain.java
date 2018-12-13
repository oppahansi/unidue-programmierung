/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 */

/*
 * version 1.02
 */

package com.oppahansi.led.lightShow.example.spots;

import ledControl.BoardController;

public class MixingSpotsMain {
	
	static BoardController controller;
	static Spot[] spots;
	static int[][][] colors;
	
	// Ausdehnung der Spots festlegen
	private final static double EXPANSION = 5.;

	public static void main(String[] args) {
		controller = BoardController.getBoardController();
		spots	= new Spot[3];
		// Das Array colors verwaltet unsere Farben und wird vom Controller
		// angefordert.
		colors	= controller.getColors();
		
		// Die Spots sind die Scheinwerferlichter, die sich ueber das Board
		// bewegen.
		for (int i = 0; i < 3; i++){
			spots[i] = new Spot(controller.getWidth(), controller.getHeight());
		}
		
		// Farben der Spots festlegen
		spots[0].setColor(127,  0,  0);
		spots[1].setColor(0,  127,  0);
		spots[2].setColor(0,  0,  127);
		
		// Geschwindigkeit und Richtung der Spots festlegen
		spots[0].setSpeed(0.02, -1, 2);
		spots[1].setSpeed(0.033, 2, -1);
		spots[2].setSpeed(0.01, 1, 5);
		
		// Startposition der Spots festlegen
		for (int i = 0; i < 3; i++){
			spots[i].xPos = 5;
			spots[i].yPos = 5;
		}
		
		// Hier findet der eigentliche Programmablauf in einer Endlosschleife
		// statt.
		while (true){
			for (int i = 0; i < 3; i++){
				// Berechnung der aktuellen LED-Farbwerte
				// Berechnung der neuen Scheinwerferpositionen
				spots[i].move();
			}
			calculateLEDs();
		}
	}

	public static void calculateLEDs(){
		// alle LEDs aus
		controller.resetColors();
		
		// Neuberechnung fuer saemtliche LEDs
		for (int x = 0; x < controller.getWidth(); x++){
			for (int y = 0; y < controller.getHeight(); y++){
				// und saemtliche Spots
				for (int spot = 0; spot < 3; spot++){
					// Distanz der LED zum Spot berechnen
					double dist		= spots[spot].getDistance(x, y);
					// ist der Spot nah genug an der LED um die LED zum Leuchten zu bringen?
					double factor	= (dist > EXPANSION) ? 0 : (1 - dist/EXPANSION);
					// quadratischer statt linearer Abfall der Helligkeit vom Zentrum
					// um einen schoeneren Helligkeitsabfall zu erreichen
					double brightness = factor * factor;
					// add statt set um die Farbe der anderen Spots nicht zu loeschen
					controller.addColor(x, y, (int)(brightness * spots[spot].color[0]),
											  (int)(brightness * spots[spot].color[1]),
											  (int)(brightness * spots[spot].color[2]));
				}
			}
		}
		
		// Update des Bildes
		controller.updateBoard();
	}
	
}
