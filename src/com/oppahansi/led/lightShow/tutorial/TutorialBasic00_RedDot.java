/*
 * Created by: Institut für Informatik und Wirtschaftsinformatik, Universität Duisburg-Essen
 *
 * <p>For learning purpose only.
 */

/*
 * This program demonstrates the simplest application of the board.
 * It places and displays a red dot in the center.
 */

package com.oppahansi.led.lightShow.tutorial;

import ledControl.BoardController;

public class TutorialBasic00_RedDot {

	public static void main(String[] args) {
		// request the controller
		BoardController controller = BoardController.getBoardController();
		
		// at position (5, 5) set the red dot (red = 127, green = 0, blue = 0)
		controller.setColor(5, 5, 127, 0, 0);
		
		// display the newly drawn picture
		controller.updateBoard();
	}

}
