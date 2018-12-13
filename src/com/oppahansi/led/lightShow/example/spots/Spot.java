/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 */

package com.oppahansi.led.lightShow.example.spots;

public class Spot {
	
	// Boarddimensionen
	// benoetigt um zu errechnen, wann der Spot vom Boardrand abprallt
	final double X_MAX, Y_MAX;

	// Position und Geschwindigkeit sind als double, nicht als int, angelegt,
	// um Schritte < 1 und damit fluessigere Bewegungen zu ermoeglichen
	
	// Position
	double xPos, yPos;
	// Geschwindigkeit in x- und y-Richtung
	double dx, dy;
	// Farbe des Spots
	int[] color;
	
	// Initialisierung des Spots mit Boarddimension und Farbe
	public Spot (double xMax, double yMax){
		X_MAX = xMax;
		Y_MAX = yMax;
		color = new int[3];
	}

	// Geschwindigkeit des Spots setzen.
	// speed gibt die Geschwindigkeit an, dx und dy einen unnormierten
	// Richtungsvektor. Der Richtungsvektor wird normiert und danach an
	// speed angepasst.
	public void setSpeed(double speed, double dx, double dy){
		this.dx = Math.sqrt(dx*dx+dy*dy) * dx * speed;
		this.dy = Math.sqrt(dx*dx+dy*dy) * dy * speed;
	}
	
	public void setColor(int r, int g, int b){
		color[0] = r;
		color[1] = g;
		color[2] = b;
	}
	
	// gibt die Distanz des Spots zur uebergebenen Position zurueck
	public double getDistance (double x, double y){
		return Math.sqrt((x - xPos) * (x - xPos) + (y - yPos) * (y - yPos));
	}
	
	// bewegt den Spot gemaess der durch dx und dy gegebenen Geschwindigkeit.
	// Wird der Rand erreicht, prallt der Spot ab. Einfallswinkel = Ausfallswinkel
	public void move(){
		xPos += dx;
		yPos += dy;
		if (xPos >= X_MAX || xPos < 0){
			dx = -dx;
		}
		if (yPos >= Y_MAX || yPos < 0){
			dy = -dy;
		}
	}
	
}
