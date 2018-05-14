/*
 * break com rótulo
 */

import p1.aplic.cartas.*;
import p1.io.*;
import p1.util.*;

public class Cartas9 {
	public static void main(String[] args) {

        String resposta = Entrada.in.lerLinha("Quantas rodadas de poquer simples voce quer jogar? ");
        int rodadas = Formata.convInt(resposta);

      	int suasVitórias = 0;
		int minhasVitórias = 0;
        // tem que contar empates porque pode ter
        // rodadas não jogadas por falta de cartas
        int empates = 0;

        // todas as cartas vêm do mesmo baralho (para poder esvazia-lo)
        Baralho baralho = new BaralhoPoquer();
        baralho.baralhar();
      externo:
		for(int i = 0; i < rodadas; i++) {
            Mao suaMao = new MaoPoquer();
            Mao minhaMao = new MaoPoquer();
            for(int n = 1; n <= 5; n++) {
                Carta c1 = baralho.pegaCarta();
                Carta c2 = baralho.pegaCarta();
                if(c1 == null || c2 == null) {
                    System.err.println("Baralho esta vazio!");
                    break externo;
                }
                suaMao.adicionar(c1);
                minhaMao.adicionar(c2);
            }
			System.out.println("Sua mao: " + suaMao);
			System.out.println("Minha mao: " + minhaMao);
            int comparação = suaMao.compareTo(minhaMao);
			if(comparação > 0) {
				System.out.println("Voce ganha.");
				suasVitórias++;
			} else if(comparação < 0) {
				System.out.println("Eu ganho.");
				minhasVitórias++;
			} else {
				System.out.println("Empate.");
                empates++;
			}
		}
		System.out.println("Voce ganhou " + suasVitórias
			+ " vezes, eu ganhei " + minhasVitórias + " vezes, "
			+ empates + " empates.");
	} // main
} // Cartas9