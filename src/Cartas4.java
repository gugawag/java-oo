/*
 * La�o: N�mero conhecido de vezes
 */

import p1.aplic.cartas.*;
import p1.io.*;

public class Cartas4 {
	public static void main(String[] args) {

		int rodadas = Entrada.in.lerInt("Quantas rodadas quer jogar?");

		int suasVit�rias = 0;
		int minhasVit�rias = 0;
		Baralho baralho = new Baralho();
		baralho.baralhar();

		for (int i = 0; i < rodadas; i++) {
			Carta suaCarta = baralho.pegaCarta();
			System.out.print("Sua carta: " + suaCarta + "; ");
			Carta minhaCarta = baralho.pegaCarta();
			System.out.print("Minha carta: " + minhaCarta + "; ");
			if (suaCarta.compareTo(minhaCarta) > 0) {
				System.out.println("Voce ganha.");
				suasVit�rias++;
			} else if (suaCarta.compareTo(minhaCarta) < 0) {
				System.out.println("Eu ganho.");
				minhasVit�rias++;
			} else {
				System.out.println("Empate.");
			}
		} // for
		System.out.println("Voce ganhou " + suasVit�rias + " vezes, eu ganhei "
				+ minhasVit�rias + " vezes, "
				+ (rodadas - suasVit�rias - minhasVit�rias) + " empates.");
	} // main
} // Cartas4
