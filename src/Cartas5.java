/*
 * Laço: Coleção e iterador
 */

import p1.aplic.cartas.*;
import p1.io.*;
import java.util.*; // para usar Iterator

public class Cartas5 {
	public static void main(String[] args) {

		Baralho baralho = new Baralho();
		baralho.baralhar();
		// Mao é uma "Coleção" de objetos (do tipo Carta)
		Mao aMao = new Mao();

		int n = Entrada.in.lerInt("Quantas cartas na mao? ");

		for (int i = 0; i < n; i++) {
			aMao.adicionar(baralho.pegaCarta());
		}

		// dedo server para varrer (iterar) as cartas na mao
		Iterator dedo = aMao.iterator();
		Carta maiorCarta = (Carta) dedo.next();
		while (dedo.hasNext()) {
			Carta proximaCarta = (Carta) dedo.next();
			if (proximaCarta.compareTo(maiorCarta) > 0) {
				maiorCarta = proximaCarta;
			}
		}
		System.out.println("A mao: " + aMao);
		System.out.println("A maior carta: " + maiorCarta);
	}
}
