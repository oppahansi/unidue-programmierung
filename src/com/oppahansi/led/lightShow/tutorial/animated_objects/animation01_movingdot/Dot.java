/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 */

/*
 * Eigenstaendige Klasse um ein animiertes Objekt, in diesem Fall einen roten Punkt, darzustellen. Das Aussehen des
 * Punktes ist hier definiert und nicht im Hauptprogramm.
 * 
 * AUFGABE 2a:
 *   Aendert die Klasse Dot so, dass der animierte Punkt nicht rot, sondern blau ist.
 *   
 * AUFGABE 2b:
 *   Aendert die Klasse Dot so, dass nicht ein einfacher Punkt, sondern ein 2x2 Quadrat ueber das Board wandert.
 */

package com.oppahansi.led.lightShow.tutorial.animated_objects.animation01_movingdot;

import ledControl.BoardController;

public class Dot {
	
	// Attribute um die Position des Punktes zu speichern.
	private int xPosition, yPosition;
	// Eigene Referenz auf den Boardcontroller, um dem Objekt zu ermoeglichen sich selbst zu zeichnen. 
	private BoardController controller;
	
	// Im Konstruktor wird alles vorbereitet um ein Objekt der Klasse Dot zu verwenden. Den BoardController als
	// Parameter im Konstruktor zu verlangen stellt sicher, dass jedes erzeugte Objekt einen Verweis auf den Controller
	// hat, um in der Methode draw() darauf zugreifen zu koennen.
	// Ausserdem werden die initialen Koordinaten eines Dot-Objekts auf (0, 0) gesetzt.
	public Dot(BoardController controller){
		this.controller = controller;
		this.xPosition	= 0;
		this.yPosition	= 0;
	}
	
	// Getter und Setter nach bekanntem Schema
	public int getXPosition() {
		return xPosition;
	}
	
	public void setXPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	
	public int getYPosition() {
		return yPosition;
	}
	
	public void setYPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	
	// Die Zeichnungsmethode wird verwendet um das Objekt auf dem Board zu zeichnen. Damit wir auf dem Board zeichnen 
	// koennen, haben Objekte der Klasse einen eigenen Verweis auf den BoardController (Attribut controller, Zeile 21).
	// Der Punkt wird abhaengig von der Position (Attribute xPosition, yPosition, Zeile 19) gezeichnet. Aendert sich die
	// Position des Punktes, zeichnet diese Methode den Punkt dementsprechend an der neuen Position.
	public void draw(){
		controller.setColor(xPosition, yPosition, 127, 0, 0);
	}

}
