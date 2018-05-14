/*
 * Para uso em exemplo de exceções
 */

import p1.aplic.cartas.*;
import p1.io.*;

public class Cartas12 {
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

		// MaiorCartaSegura é um jogo onde quem detém a maior carta ganha a
		// rodada
		try {
			new MaiorCartaSegura2().joga(rodadas);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	} // main
} // Cartas12

