/*
 * la�os aninhados
 */

import p1.aplic.cartas.*;
import p1.io.*;
import p1.util.*;

public class Cartas8 {
	public static void main(String[] args) {

		String resposta = Entrada.in
				.lerLinha("Quantas rodadas de poquer simples voce quer jogar? ");
		int rodadas = Formata.convInt(resposta);

		int suasVit�rias = 0;
		int minhasVit�rias = 0;

		for (int i = 0; i < rodadas; i++) {
			Baralho baralho = new BaralhoPoquer();
			baralho.baralhar();
			Mao suaMao = new MaoPoquer();
			Mao minhaMao = new MaoPoquer();
			for (int n = 1; n <= 5; n++) {
				suaMao.adicionar(baralho.pegaCarta());
				minhaMao.adicionar(baralho.pegaCarta());
			}
			System.out.println("Sua mao: " + suaMao);
			System.out.println("Minha mao: " + minhaMao);
			int compara��o = suaMao.compareTo(minhaMao);
			if (compara��o > 0) {
				System.out.println("Voce ganha.");
				suasVit�rias++;
			} else if (compara��o < 0) {
				System.out.println("Eu ganho.");
				minhasVit�rias++;
			} else {
				System.out.println("Empate.");
			}
		}
		System.out.println("Voce ganhou " + suasVit�rias + " vezes, eu ganhei "
				+ minhasVit�rias + " vezes, "
				+ (rodadas - suasVit�rias - minhasVit�rias) + " empates.");
	} // main
} // Cartas8
