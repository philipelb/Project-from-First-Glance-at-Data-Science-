import java.util.ArrayList;
import java.util.Random;

import ledControl.BoardController;
import ledControl.LedConfiguration;

/**
 * @author Philip Elberfeld, Tom Kersten, Shifa Erol
 * @version 01. 02.01.2023
 */

public class DodgeMain {
	static ArrayList<Auto> Autos = new ArrayList<>();
	static ArrayList<Lines> line = new ArrayList<>();

	public static void main(String[] args) {
		// größeres Board falls gewünscht
		BoardController.getBoardController(LedConfiguration.LED_20x20_EMULATOR);
		BoardController controller = BoardController.getBoardController();

		/*
		 * Die Objekte der anderen Klassen werden erstellt
		 */

		Character c = new Character(controller, 9, 19);
		scripture script = new scripture(controller, 5, 10);
		Random rng = new Random();

		randomNumber(rng, controller);

		boolean spielen = true;
		boolean overAll = false;

		int i = 0;
		int j = 1;
		int counter = 0;

		script.draw(counter);

		controller.updateBoard();

		/*
		 * OverAll bekommt den Wert von script.play() übergeben.
		 * 
		 * Das ist die Eingabe des Spielers ob er Spielen möchte oder nicht.
		 */
		overAll = script.play();

		/*
		 * Ist der Wert von OverAll false wird das LED-Board geschlossen.
		 */
		if (!overAll) {
			System.exit(0);
		}

		controller.updateBoard();

		/*
		 * solange OverAll den Wert true hat wird der folgende Code ausgeführt
		 */

		while (overAll) {

			/*
			 * erste Linien und Autos werden erstellt
			 */
			generateFirstLines(controller);
			while (i < 4) {
				generateCar(controller, rng);
				i++;
			}

			controller.resetColors();
			/*
			 * Solange kein Objekt der Liste Autos außerhalb der Anzeige ist gibt die
			 * CheckOut() Methode true als Wert zurück und fall() kann weiter ausgeführt
			 * werden.
			 * 
			 */

			while (CheckOut()) {

				fall(controller, c, j);
				j++;

				c.draw();
				c.moveToSide();
				/*
				 * Berühren sich Charakter und ein Objekt von der Liste Autos gibt die Methode
				 * check true zurück und die Methode Ende() wird ausgeführt.
				 */

				if (check(c)) {

					Ende(controller, script, overAll, rng, counter);
					counter = 0;
				}
			}

			counter++;
			/*
			 * Gibt die Methode CheckOut() den Wert false zurück werden neue Autos erstellt
			 * 
			 * und die Linien neu gezeichent
			 */
			generateCar(controller, rng);

			generateFirstLines(controller);

			c.draw();
			c.moveToSide();

			controller.updateBoard();

		}

	}

	/*
	 * Diese Methode setzt das gesamte Board wieder zurück und zeichnet scripture.
	 * 
	 * Es wird geguckt ob der Spieler weiterspielen möchte wenn ja werden alle Autos
	 * aus der Liste gelöscht und 4 neue erstellt.
	 * 
	 * Möchte der Spieler nicht weiter spielen wird das LED-Board geschlossen.
	 * 
	 */

	public static void Ende(BoardController controller, scripture S, boolean overAll, Random rng, int counter) {
		controller.resetColors();

		// controller.setBoardColor(0, 0, 0);
		// controller.updateBoard();

		controller.sleep(300);
		controller.resetColors();
		S.draw(counter / 4);
		controller.updateBoard();
		if (!S.play()) {
			overAll = false;
			System.exit(0);
		} else {

			Autos.removeAll(Autos);
			int i = 0;
			while (i < 4) {
				generateCar(controller, rng);
				i++;
			}

			overAll = true;
		}

	}

	/*
	 * Checkt ob der Character in der gleichen Spalte wie ein Objekt von Auto ist
	 * 
	 * und ob Auto auf einer der y-Positionen von dem Character ist.
	 * 
	 */

	public static boolean check(Character c) {
		for (Auto auto : Autos) {
			if (c.getxPos() == auto.getxPos() && (auto.getyPos() == c.getyPos() || auto.getyPos() == c.getyPos() - 1
					|| auto.getyPos() == c.getyPos() - 2)) {
				return true;
			}
		}

		return false;
	}

	/*
	 * Lässt alle Objekte der Liste Autos einen nach unten bewegen und zeichnet
	 * diese dann neu.
	 * 
	 * Die Linien und der Charakter werden ebenfalls neu gezeichent.
	 * 
	 */

	public static void fall(BoardController controller, Character cha, int j) {
		controller.resetColors();

		for (Auto a : Autos) {
			a.move(j);
			a.draw();
		}

		for (Lines l : line) {
			l.draw(0);
			l.draw(19);
		}
		cha.draw();

		controller.updateBoard();

	}

	/*
	 * Checkt ob ein Objekt der Liste Auto ausserhalb vom LED-Board ist
	 *
	 */
	public static boolean CheckOut() {

		for (Auto auto2 : Autos) {
			if (auto2.Out()) {

				return false;
			}
		}
		return true;
	}

	/*
	 * Fügt Objekte der Liste line hinzu und zeichnet diese dann
	 */
	public static void generateFirstLines(BoardController board) {

		line.add(new Lines(board, 0, 1));

		line.add(new Lines(board, 0, 5));

		line.add(new Lines(board, 0, 9));

		line.add(new Lines(board, 0, 13));

		line.add(new Lines(board, 0, 17));

		for (Lines line : line) {
			line.draw(0);
			line.draw(19);
		}

	}

	/*
	 * Erstellt ein neues Auto A und fügt dieses zur Liste Autos hinzu.
	 *
	 * wenn die Liste Autos 5 groß ist wird das erste Element der Liste gelöscht.
	 * 
	 * Alle Elemente aus der Liste Autos werden gezeichent.
	 * 
	 */
	public static void generateCar(BoardController controller, Random rng) {

		int number = randomNumber(rng, controller);

		Auto A = new Auto(controller, number, 0);
		Autos.add(A);

		if (Autos.size() == 5) {
			Autos.remove(0);
		}

		controller.resetColors();

		for (Auto auto : Autos) {
			auto.draw();
		}

	}

	/*
	 * Generiert eine Zufallszahl zwischen 0 und 18.
	 * 
	 * Diese wird jedoch erst zurückgegeben wenn sie eine der entsprechenden
	 * x-Positionen der Spalten entspricht.
	 * 
	 *
	 */
	public static int randomNumber(Random rng, BoardController controller) {

		int i = 0;
		while (true) {
			int number = rng.nextInt(18);
			if (number == 17 || number == 13 || number == 9 || number == 5 || number == 1) {
				i = number;
				break;
			}
		}
		return i;

	}

}
