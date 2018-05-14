/*
 * Comparações de cartas
 */

import p1.aplic.cartas.*;

public class Cartas2 {
	public static void main(String[] args) {
		Carta carta1 = new Carta(Carta.AS, Carta.PAUS);
		Carta carta2 = new Carta(Carta.REI, Carta.PAUS);
		Carta carta3 = new Carta(Carta.REI, Carta.OUROS);
		int comparação = carta1.compareTo(carta2);
		if (comparação < 0) {
			System.out.println(carta1 + " vale menos que " + carta2);
		} else if (comparação == 0) {
			System.out.println(carta1 + " vale tanto quanto " + carta2);
		} else {
			System.out.println(carta1 + " vale mais que " + carta2);
		}

		String igualdade = carta2.equals(carta3) ? "sao iguais"
				: "nao sao iguais";
		System.out.println(carta2 + " e " + carta3 + " " + igualdade);
	}
}
