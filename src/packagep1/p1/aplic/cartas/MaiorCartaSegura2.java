/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ciência da Computação
 * Departamento de Sistemas e Computação
 * Universidade Federal da Paraíba
 *
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 * Não redistribuir sem permissão.
 */

package p1.aplic.cartas;

import java.util.*;

/**
 * Como a classe MaiorCartaSegura, mas com tratamento de exceção diferente.
 * Não usa herança para que os alunos possam ver o exemplo antes de ver herança.
 *
 * @author Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */
public class MaiorCartaSegura2 {
  private int     suasVitórias;  // pontuação
  private int     minhasVitórias;
  private int     empates;
  private BaralhoSeguro baralho;

  /**
   * Construtor do jogo.
   */
  public MaiorCartaSegura2() {
    suasVitórias = 0;
    minhasVitórias = 0;
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
   * @param rodadas O número de rodadas a jogar.
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
        suasVitórias++;
      } else if(suaCarta.compareTo(minhaCarta) < 0) {
        System.out.println("Eu ganho.");
        minhasVitórias++;
      } else {
        System.out.println("Empate.");
        empates++;
      }
    }
    System.out.println("Voce ganhou " + suasVitórias +
                       " vezes, eu ganhei " + minhasVitórias + " vezes, " +
                       empates + " empates.");
  }
}

