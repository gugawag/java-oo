/*
 * Decis�es com cartas
 */

import p1.aplic.cartas.*;

public class Cartas1 {
	public static void main(String[] args) {
		Baralho baralho = new Baralho();
		baralho.baralhar();
		Carta carta1 = baralho.pegaCarta();
		Carta carta2 = baralho.pegaCarta();
		int compara��o = carta1.compareTo(carta2);
		if (compara��o < 0) {
			System.out.println(carta1 + " vale menos que " + carta2);
		} else if (compara��o == 0) {
			System.out.println(carta1 + " vale tanto quanto " + carta2);
		} else {
			System.out.println(carta1 + " vale mais que " + carta2);
		}
	}
}
