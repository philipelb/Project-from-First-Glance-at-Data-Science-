import ledControl.BoardController;
import ledControl.LedConfiguration;
import java.util.ArrayList;
import java.util.Random;
/**
*@author 	Philip Elberfeld, Tom Kersten, Nicolas Engel
*@version 	01. 11.01.2022
*/

public class DoodleJumpMain 
{
	static ArrayList<Platform> coords = new ArrayList<>();
	
	
	 
	public static void main(String[] args) 
	{
//		größeres Board falls gewünscht
		BoardController.getBoardController(LedConfiguration.LED_20x20_EMULATOR);
		BoardController controller = BoardController.getBoardController();
	
		scripture S = new scripture(controller, 0, 2);
		Doodle D = new Doodle(controller, 5, 7);

		Random rng = new Random();
		int i = 0;
		boolean spielen = true;
		boolean overAll = false;
		
		S.draw();
		controller.updateBoard();
/**				
 * overAll wird der wert von S.play() uebergeben
 */
		overAll = S.play();
		if (overAll == false)
		{
			System.exit(0);
		}
		
		controller.updateBoard();
/**		solange overAll true ist wird der gesamte code ausgef�hrt. 
*		Dies ist wichtig damit es m�glich ist, nach dem "Tod" des Doodles, mit dem auf True setzen von S.play das Spiel erneut zu beginnen
*/
		while (overAll)
		{
/**			
 * 			der erste Teil wird bei jedem "Neustart" des Spiels einmalig ausgef�hrt 
 * 			Der Doodle wird auf seine Startposition gesetzt und die startplatformen werden gezeichnet
 */
			D.setxPos(5);
			D.setyPos(7);
			firstPaltform(controller, D);
			controller.updateBoard();

			while (spielen == true) 
			{
				controller.resetColors();

				if (D.fall() == 100) {
					while (check2(D) == true) 
					{
						generatePlatform(controller, D, rng, i, S, overAll);
						i++;

						generatePlatform(controller, D, rng, i, S, overAll);
						i++;

					}
					fallUntil(controller, D, S, overAll);

					while (check(D) == true) 
					{
/**
 * 						bei jedem Sprung nach oben k�nnen die letzten zwei richtungsanweisungen ausgef�hrt werden 
 */
						up(controller, D);
						D.moveToSide();
						D.moveToSide();
						up(controller, D);
						D.moveToSide();
						D.moveToSide();

						if (check(D) == true) 
						{
							break;
						}
						up(controller, D);
						D.moveToSide();
						D.moveToSide();
						fallUntil(controller, D, S, overAll);
						if (check(D) == true) 
						{
							break;
						}
					}
					controller.updateBoard();
				} else 
				{
					break;
				}
			}
		}
		 
	}
	
/**
 * Erstellt jedes 2. mal eine Platform und fuegt sie zu der liste der Platformen hinzu
 * platformen werden mittels{@link #randomNumber(Random, BoardController)} zufaellig erstellt
 * wenn 5 Platformen sich in der Arrayliste befinden wird das vorderste Objekt geloescht da es sich dann in 
 * dem Fall auserhalb des 12x12 Blid befindet 
 * durch {@link #fallUntil(BoardController, Doodle, scripture, boolean)} bewegt sich der {@link Doodle} mit den 
 * Platformen nach unten dadurch wird verhindert das der {@link Doodle} aus dem Bild huepfen kann
 * 
 * @param controller
 * @param D
 * @param rng
 * @param i
 * @param S
 * @param overAll
 */
	public static void generatePlatform(BoardController controller, Doodle D, Random rng,int i,scripture S,boolean overAll )
	{
			int number = randomNumber(rng,controller);
			if (i % 2 ==0)
			{
				Platform B = new Platform(controller,number, 0);
				coords.add(B);
				if(coords.lastIndexOf(B) == 5)
				{
					coords.remove(0);
				}
			}
					
			controller.resetColors();
			for (Platform p: coords)
			{
				p.move();
				p.draw();				
			}
			fallUntil( controller, D,S, overAll);
			D.draw();
			controller.updateBoard();
	}
	
/**
 * Erstellt die ersten 5 Startplatformen mit von der Position des {@link Doodle} abhaengenden X Koordinaten
 * und fuegt sie zur ArrayListe hinzu 
 * Dies ist notwendig da ansonsten {@link #randomNumber(Random, BoardController)} nicht in der lage waere neue X Koordinaten
 * zu liefern 
 * @param controller
 * @param D
 */
	 public static void firstPaltform(BoardController controller,Doodle D)
	 {
		Platform B = new Platform(controller,D.getxPos()-1, D.getyPos()+3);
			coords.add(B);
		Platform C = new Platform(controller,D.getxPos()-1, D.getyPos()+1);
			coords.add(C);
		Platform E = new Platform(controller,D.getxPos()+2, D.getyPos()-1);
			coords.add(E);
		Platform F = new Platform(controller,D.getxPos()-3, D.getyPos()-3);
			coords.add(F);
		Platform G = new Platform(controller,D.getxPos()+2, D.getyPos()-5);
		coords.add(G); 	
	 }
	 
/**
 * Pr�ft f�r jede Platform ob der {@link Doodle} sich darauf befindet ist dies der Fall wird die Variable b auf true gesetzt 
 * Am ende wird b zur�ckgegeben 
 * @param D
 * @return b
 */
	 public static boolean check (Doodle D)
	 {
		 boolean b = false;
			for (Platform p: coords)
			{
				int y = p.getyPos();
				int x = p.getxPos();
				if (y -1 == D.getyPos() && ( x == D.getxPos() || x+1 == D.getxPos() || x+2 == D.getxPos()))
				{
					b = true;
				}
			}
			return b;
	 }
	
 /**
  * pr�ft ob der {@link Doodle} eine Platform weiter gewandert ist 
  * indem �berprueft wird ob der Doodle sich auf einer Platform befindet und ob diese Platform
  * sich auf der Koordinate Y = 6 befindet 
  * Dies bedeutet naemlich das dies die naechste Platform ist 
  * wenn beide Bedingungen zutreffen wird die Hilfsvariable c auf True gesetzt 
  * @param D
  * @return c
  */
	 public static boolean check2 (Doodle D)
	 {
		 boolean c = false;
			for (Platform p: coords)
			{
				int y = p.getyPos();
				int x = p.getxPos();
				int z = 6;
				if (y -1 == D.getyPos() && ( x == D.getxPos() || x+1 == D.getxPos() || x+2 == D.getxPos()) && y ==z)
				{
					c = true;
				}
			}
			return c;
	 }
	 
/**
 * bewegt den {@link Doodle} einen nach oben und erhaelt dabei alle Platform 
 * Notwendig da, soweit bekannt, nur das ganze Bild zurueckgesetzt werden kann und somt bei Bewegungen einzelner Dinge
 * Alle dargestellten Dinge erneut gezeichnet werden muessen 
 * @param controller
 * @param D
 */
	 public static void up(BoardController controller, Doodle D )
	 {
		controller.resetColors();
		D.moveUp();
		for (Platform p: coords)
		{
			p.draw();
		}
		D.draw();
		controller.updateBoard();
		controller.sleep(120);
	 }
	 
/**
 * Analog zu {@link #up(BoardController, Doodle)} nur mit dem Unterschied das 
 * hier die Fallgeschwindigkeit beeinflusst werden kann
 * @param controller
 * @param D
 * @param zeit
 */
	 public static void down(BoardController controller, Doodle D,int zeit )
	 {
		 controller.resetColors();
			D.moveDown();
			
			for (Platform p: coords)
			{
				
				p.draw();
				
			}
			D.draw();
			
			controller.updateBoard();
			controller.sleep(zeit);
	 }
	 
/**
 * bewegt den Doodle solange bis {@link #check(Doodle)} True zur�ckgibt nach unten.
 * Falls  {@link Doodle#fall()} den wert 1 zurueckgibt wird die Methode {@link #Ende(BoardController, scripture, boolean)}
 * aufgerufen
 * @param controller
 * @param D
 * @param S
 * @param overAll
 */
	 public static void fallUntil(BoardController controller, Doodle D,scripture S, boolean overAll)
	 {
		 while (check(D) == false)
		 {
			down(controller,D,120); 
			D.moveToSide();
			D.moveToSide();
			D.fall();
			if (D.fall() == 1)
			{
				Ende(controller,S, overAll);
				break;
			}
		 }
	 }
	
/**
 * Setzt das gesamte Bild zurueck und faerbt es anschlie�end f�r 1. Sekunde Rot ein.
 * Anschlie�end wird das Bild zur�ckgesetzt und {@link scripture#draw()} aufgerufen.
 * Danach wird {@link scripture#play()} abgefragt um die Option zu geben ob man spielen m�chte oder nicht 
 * Falls "N" gedrueckt wird wird das Programm geschlossen
 * @param controller
 * @param S
 * @param overAll
 */
	 public static void Ende (BoardController controller,scripture S, boolean overAll)
	 {
			controller.resetColors();
			controller.setBoardColor(127, 0, 0);
			controller.updateBoard();
			controller.sleep(1000);
			controller.resetColors();
			S.draw();
			controller.updateBoard();
			if (S.play() == false) 
			{
				overAll = false;
				System.exit(0);
			}
			else
			{
				overAll = true;
			}
		 
		 
		 
	 }
	
 /**
  * erstellt eine zufallszahl zwischen 0 und der X Koordinate des 4. Elements von {@link #coords} 
  * und der X Koordinate des 4. Elements von {@link #coords} und 9.
  * 9 wurde gew�hlt da von der X Koordinate aus die Platformen von {@link Platform#draw()} aufgebaut werden und dadurch 
  * kein teil einer Platform auserhalb des Boards liegen kann
  * @param rng
  * @param controller
  * @return i
  */
	 public static int randomNumber(Random rng,BoardController controller)
	 {
		 int limit = coords.get(4).getxPos();
		 int i = 0;
		 while (true)
		 {
			 int number = rng.nextInt(9); 
			 if ((number <= limit && number >= limit-6)|| (number > limit+2 && number <= limit+6)) 
			 { 
				i = number;
				break; 
			 }
		 }
		 return i;

		 
	 }
}







