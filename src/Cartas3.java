/*
 * Short-circuiting (curto circuito)
 */

import p1.aplic.cartas.*;

public class Cartas3 {
	public static void main(String[] args) {
		Baralho baralho = new Baralho();
		baralho.baralhar();
		Carta carta1 = baralho.pegaCarta();
		if (carta1.getValor() == Carta.VALETE
				|| carta1.getValor() == Carta.DAMA
				|| carta1.getValor() == Carta.REI) {
			System.out.println(carta1 + " eh uma figura");
		} else {
			System.out.println(carta1 + " nao eh uma figura");
		}

		// cuidado com a precedencia de && e ||
		if ((carta1.getNaipe() == Carta.OUROS || carta1.getNaipe() == Carta.COPAS)
				&& carta1.getValor() >= Carta.VALETE
				&& carta1.getValor() <= Carta.REI) {
			System.out.println(carta1 + " eh uma figura vermelha");
		} else {
			System.out.println(carta1 + " nao eh uma figura vermelha");
		}
	}
}
