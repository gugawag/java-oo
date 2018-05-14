/*
 * break com r�tulo
 */

import p1.aplic.cartas.*;
import p1.io.*;
import p1.util.*;

public class Cartas9 {
	public static void main(String[] args) {

        String resposta = Entrada.in.lerLinha("Quantas rodadas de poquer simples voce quer jogar? ");
        int rodadas = Formata.convInt(resposta);

      	int suasVit�rias = 0;
		int minhasVit�rias = 0;
        // tem que contar empates porque pode ter
        // rodadas n�o jogadas por falta de cartas
        int empates = 0;

        // todas as cartas v�m do mesmo baralho (para poder esvazia-lo)
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
            int compara��o = suaMao.compareTo(minhaMao);
			if(compara��o > 0) {
				System.out.println("Voce ganha.");
				suasVit�rias++;
			} else if(compara��o < 0) {
				System.out.println("Eu ganho.");
				minhasVit�rias++;
			} else {
				System.out.println("Empate.");
                empates++;
			}
		}
		System.out.println("Voce ganhou " + suasVit�rias
			+ " vezes, eu ganhei " + minhasVit�rias + " vezes, "
			+ empates + " empates.");
	} // main
} // Cartas9