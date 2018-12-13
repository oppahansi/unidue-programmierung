/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 */

/*
 * In diesem Beispiel werden die Farben der LEDs ueber die Methoden des
 * Controllers gesetzt. Es erfolgt kein direkter Zugriff auf das Array, obwohl
 * auch das moeglich waere.
 */
package com.oppahansi.led.lightShow.testing;

import ledControl.BoardController;

public class FunctionalityTest {
	
	// Ueber den Boardcontroller werden die LEDs gesteuert
	static BoardController controller;

	public static void main(String[] args) {
		// Der BoardController muss als erstes wie in dem folgenden Befehl 
		// angefordert werden.
		controller = BoardController.getBoardController();
		//controller.activatePhysicalBoard();
		
		// alle LEDs maximal rot faerben
		// Der Parameter ist ein dreielementiges Array, das fuer jede
		// Farbkomponente einen Wert zwischen 0 und 127 enthaelt.
		// Die Reihenfolge der Farben ist rgb, also rot, gruen, blau
		setFieldColor(new int[]{127,0,0});
		// das Bild eine Sekunde (bzw 1000 Millisekunden) stehen lassen
		controller.sleep(1000);
		// alle LEDs maximal gruen faerben
		setFieldColor(new int[]{0,127,0});
		// Bild eine Sekunde stehen lassen
		controller.sleep(1000);
		// alle LEDs maximal blau faerben
		setFieldColor(new int[]{0,0,127});
		// Bild eine Sekunde stehen lassen
		controller.sleep(1000);
		// alle LEDs maximal weiss faerben
		setFieldColor(new int[]{127,127,127});
		// Bild eine Sekunde stehen lassen
		controller.sleep(1000);
		// alle LEDs ausschalten, bzw. die Farbe auf schwarz setzen
		setFieldColor(new int[]{0,0,0});
		// Bild eine Sekunde stehen lassen
		controller.sleep(1000);
		// Testbild am Schluss
		rowColumnChaos();
		// Bild fuenf Sekunden stehen lassen
		controller.sleep(5000);
		// alle LEDs ausschalten, bzw. die Farbe auf schwarz setzen
		setFieldColor(new int[]{0,0,0});
	}
	
	
	public static void setFieldColor(int[] color){
		// Mittels dieser Schleife wird jede LED einzeln auf die durch den
		// Parameter color gegebene Farbe gesetzt.
		for (int x = 0; x < 12; x++){
			for (int y = 0; y < 12; y++){
				controller.setColor(x, y, color[0], color[1], color[2]);
			}
		}
		// sobald allen LEDs die gewuenschte Farbe zugeordnet wurde, muss die
		// Methode updateLedStripe() aufgerufen werden, damit das neue Bild
		// tatsaechlich sichtbar wird.
		controller.updateBoard();
	}
	
	
	// Methode um eine ganze Reihe von LEDs auf die gewuenschte Farbe zu setzen.
	public static void setRowColor(int row, int[] color){
		for (int x = 0; x < 12; x++){
			controller.setColor(x, row, color[0], color[1], color[2]);
		}
	}
	
	
	// Methode um eine ganze Spalte von LEDs auf die gewuenschte Farbe zu setzen.
	public static void setColumnColor(int column, int[] color){
		for (int y = 0; y < 12; y++){
			controller.setColor(column, y, color[0], color[1], color[2]);
		}
	}
	
	
	// Diese Methode setzt das als letztes zu sehende Bild aus sich schneidenden
	// Reihen und Spalten zusammen. Nachdem Reihen und Spalten gesetzt sind,
	// wird den LEDs an den Schnittpunkten noch eine Extrafarbe zugewiesen.
	public static void rowColumnChaos(){
		setColumnColor(2, new int[]{32, 0, 0});
		setColumnColor(6, new int[]{0, 32, 0});
		setColumnColor(10, new int[]{0, 0, 32});
		setRowColor(2, new int[]{32, 0, 0});
		setRowColor(6, new int[]{0, 32, 0});
		setRowColor(10, new int[]{0, 0, 32});
		controller.setColor(2, 2, 127, 0, 0);
		controller.setColor(2, 6, 32, 32, 0);
		controller.setColor(2, 10, 32, 0, 32);
		controller.setColor(6, 2, 32, 32, 0);
		controller.setColor(6, 6, 0, 127, 0);
		controller.setColor(6, 10, 0, 32, 32);
		controller.setColor(10, 2, 32, 0, 32);
		controller.setColor(10, 6, 0, 32, 32);
		controller.setColor(10, 10, 0, 0, 127);
		controller.updateBoard();
	}

}
