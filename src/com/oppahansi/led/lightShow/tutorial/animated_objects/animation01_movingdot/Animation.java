/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 */

/*
 * Dieses Programm demonstriert, wie man Klassen verwendet um Animationen systematisch aufzubauen. In dieser Animation
 * wandert ein roter Punkt von links nach rechts und beginnt nach Vollendung einer Zeile in der naechsttieferen Zeile.
 * Sobald das Board vollstaendig durchlaufen ist, startet der Punkt wieder in der linken oberen Bildschirmecke.
 * Der Punkt selber ist in einer eigenen Klasse implementiert um die Trennung von den animierten Objekten (hier nur der
 * rote Punkt) und der Animationssteuerung zu demonstrieren.
 * In einer Endlosschleife wird das Bild immer wieder geloescht und neu aufgebaut, sowie die Animation gesteuert. In
 * diesem Beispiel besteht die Animation nur aus der kontinuierlichen Bewegung des Punktes.
 * Beide Klassen bieten AUFGABEN um das Verstaendnis des Codes zu vertiefen.
 * 
 * AUFGABE 1a:
 *   Aendert die Klasse Animation so, dass der Punkt von rechts nach links und von unten nach oben wandert.
 * 
 * AUFGABE 1b:
 *   Aendert die Klasse Animation so, dass zwei oder mehr Punkte in deutlichem Abstand ueber den Bildschirm wandern.
 *   
 * AUFGABE 1c:
 *   Aendert die Klassen Animation UND Dot so, dass mehrere verschiedenfarbige Punkte ueber das Board wandern. Weitere
 *   Attribute fuer die Klasse Dot koennten hilfreich sein.
 *   
 * AUFGABE 1d:
 *   siehe Zeile 64
 */

package com.oppahansi.led.lightShow.tutorial.animated_objects.animation01_movingdot;

import ledControl.BoardController;

public class Animation {

	public static void main(String[] args) {
		// Initialisierung des Programms. Wir benoetigen den BoardController und ein Dot-Objekt.
		BoardController controller = BoardController.getBoardController();
		Dot dot = new Dot(controller);
		
		// Endlosschleife fuer die Animation.
		while (true){
			// Board loeschen
			controller.resetColors();
			
			// Animation steuern. In diesem Fall neue Position des Punktes berechnen
			// Punkt um ein Feld nach rechts bewegen
			dot.setXPosition(dot.getXPosition() + 1);
			// pruefen ob der Punkt noch auf dem Board ist, andernfalls...
			if (dot.getXPosition() >= controller.getWidth()){
				// ...den Punkt wieder auf dem linken Bildschirmrand platzieren...
				dot.setXPosition(0);
				// ... und eine Zeile tiefer gehen.
				dot.setYPosition(dot.getYPosition() + 1);
				// Sicherstellen, dass die Zeile ueberhaupt noch auf dem Board ist...
				if (dot.getYPosition() >= controller.getHeight()){
					// um andernfalls wieder in der ersten Zeile zu beginnen.
					dot.setYPosition(0);
				}
			}
			
			// Punkt an der neuen Position zeichnen
			dot.draw();
			
			// fertig gemaltes Bild anzeigen
			// Der Aufruf controller.updateLedStripe() findet sich nur im Hauptprogramm, nicht in der Zeichnungsmethode
			// der Klasse Dot.
			
			// AUFGABE 1d:
			//   Warum befindet sich dieser Aufruf nur hier, nicht aber in der Zeichnungsmethode der zu zeichnenden
			//   Klasse? Fuehrt den Aufruf zusaetzlich oder ausschliesslich in der Zeichnungsmethode von Dot durch.
			//   Welchen Unterschied erwartet ihr? Fuehrt diese Aenderung insbesondere durch nachdem ihr AUFGABE 1b
			//   geloest habt, achtet auf den Unterschied und ueberlegt euch wieso dieser Unterschied auftritt. 
			controller.updateBoard();
		}
	}

}
