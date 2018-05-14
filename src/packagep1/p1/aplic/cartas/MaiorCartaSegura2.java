/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */

package p1.aplic.cartas;

import java.util.*;

/**
 * Como a classe MaiorCartaSegura, mas com tratamento de exce��o diferente.
 * N�o usa heran�a para que os alunos possam ver o exemplo antes de ver heran�a.
 *
 * @author Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */
public class MaiorCartaSegura2 {
  private int     suasVit�rias;  // pontua��o
  private int     minhasVit�rias;
  private int     empates;
  private BaralhoSeguro baralho;

  /**
   * Construtor do jogo.
   */
  public MaiorCartaSegura2() {
    suasVit�rias = 0;
    minhasVit�rias = 0;
    empates = 0;
    // Factory method para permitir jogar com outros baralhos
    // com override de criaBaralho()
    baralho = criaBaralho();
    baralho.baralhar();
  }
    
  /**
   * Cria um baralho para jogar.
   * @return O baralho.
   */
  protected BaralhoSeguro criaBaralho() {
    return new BaralhoSeguro();
  }

  /**
   * Joga o jogo de Maior Carta.
   * @param rodadas O n�mero de rodadas a jogar.
   */
  public void joga(int rodadas) throws BaralhoVazioException {
    for(int i = 0; i < rodadas; i++) {
      Carta suaCarta, minhaCarta;
      suaCarta = baralho.pegaCarta();
      minhaCarta = baralho.pegaCarta();
      System.out.print("Sua carta: " + suaCarta + " ");
      System.out.print("Minha carta: " + minhaCarta + " ");
      if(suaCarta.compareTo(minhaCarta) > 0) {
        System.out.println("Voce ganha.");
        suasVit�rias++;
      } else if(suaCarta.compareTo(minhaCarta) < 0) {
        System.out.println("Eu ganho.");
        minhasVit�rias++;
      } else {
        System.out.println("Empate.");
        empates++;
      }
    }
    System.out.println("Voce ganhou " + suasVit�rias +
                       " vezes, eu ganhei " + minhasVit�rias + " vezes, " +
                       empates + " empates.");
  }
}

