/*
 * Para uso em exemplo de exce��es
 */

import p1.aplic.cartas.*;
import p1.io.*;
import p1.util.*;

public class Cartas13 {
	public static void main(String[] args) {
        int     rodadas = 0;
        String  resposta;
        boolean respostaOK = false;

        while(!respostaOK) {
            resposta = Entrada.in.lerLinha("Quantas rodadas quer jogar?");
            if(resposta == null) {
                // fim de entrada
                System.exit(0);
            }
            rodadas = Formata.convInt(resposta);
            if(rodadas <= 0 ) {
    			System.err.println("Forneca um numero positivo, por favor.");
            } else {
                respostaOK = true;
            }
		}

        // MaiorCartaSegura � um jogo onde quem det�m a maior carta ganha a rodada
        new MaiorCartaSegura3().joga(rodadas);
	} // main
} // Cartas13

