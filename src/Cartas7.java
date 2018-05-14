/*
 * Leitura em laço, com tratamento de erro
 */

import p1.aplic.cartas.*;
import p1.io.*;

public class Cartas7 {
	public static void main(String[] args) {
		int rodadas = 0;
		String resposta;
		boolean respostaOK = false;

		while (!respostaOK) {
			resposta = Entrada.in.lerLinha("Quantas rodadas quer jogar?");
			if (resposta == null) {
				// fim de entrada
				System.exit(0);
			}
			rodadas = Integer.parseInt(resposta);
			if (rodadas <= 0) {
				System.err.println("Forneca um numero positivo, por favor.");
			} else {
				respostaOK = true;
			}
		}

		// MaiorCarta é um jogo onde quem detém a maior carta ganha a rodada
		new MaiorCarta().joga(rodadas);
	} // main
} // Cartas7

