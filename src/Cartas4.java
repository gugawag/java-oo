/*
 * Laço: Número conhecido de vezes
 */

import p1.aplic.cartas.*;
import p1.io.*;

public class Cartas4 {
	public static void main(String[] args) {

		int rodadas = Entrada.in.lerInt("Quantas rodadas quer jogar?");

		int suasVitórias = 0;
		int minhasVitórias = 0;
		Baralho baralho = new Baralho();
		baralho.baralhar();

		for (int i = 0; i < rodadas; i++) {
			Carta suaCarta = baralho.pegaCarta();
			System.out.print("Sua carta: " + suaCarta + "; ");
			Carta minhaCarta = baralho.pegaCarta();
			System.out.print("Minha carta: " + minhaCarta + "; ");
			if (suaCarta.compareTo(minhaCarta) > 0) {
				System.out.println("Voce ganha.");
				suasVitórias++;
			} else if (suaCarta.compareTo(minhaCarta) < 0) {
				System.out.println("Eu ganho.");
				minhasVitórias++;
			} else {
				System.out.println("Empate.");
			}
		} // for
		System.out.println("Voce ganhou " + suasVitórias + " vezes, eu ganhei "
				+ minhasVitórias + " vezes, "
				+ (rodadas - suasVitórias - minhasVitórias) + " empates.");
	} // main
} // Cartas4
