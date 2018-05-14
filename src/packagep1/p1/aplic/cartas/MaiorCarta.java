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
 * Um jogo de cartas simples.
 * Cada jogador recebe uma carta do baralho.
 * A maior carta ganha.
 * Repete para cada rodada.
 *
 * @author Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */
public class MaiorCarta {
  private int     suasVitórias;  // pontuação
  private int     minhasVitórias;
  private Baralho baralho;

  /**
   * Construtor do jogo.
   */
   public MaiorCarta() {
    suasVitórias = 0;
    minhasVitórias = 0;
    // Factory method para permitir jogar com outros baralhos
    // com override de criaBaralho()
    baralho = criaBaralho();
    baralho.baralhar();
  }
    
  /**
   * Cria um baralho para jogar.
   * @return O baralho.
   */
  protected Baralho criaBaralho() {
    return new Baralho();
  }

  /**
   * Joga o jogo de Maior Carta.
   * @param rodadas O número de rodadas a jogar.
   */
  public void joga(int rodadas) {
    for(int i = 0; i < rodadas; i++) {
      Carta suaCarta = baralho.pegaCarta();
      System.out.print("Sua carta: " + suaCarta + " ");
      Carta minhaCarta = baralho.pegaCarta();
      System.out.print("Minha carta: " + minhaCarta + " ");
      if(suaCarta.compareTo(minhaCarta) > 0) {
        System.out.println("Voce ganha.");
        suasVitórias++;
      } else if(suaCarta.compareTo(minhaCarta) < 0) {
        System.out.println("Eu ganho.");
        minhasVitórias++;
      } else {
        System.out.println("Empate.");
      }
    }
    System.out.println("Voce ganhou " + suasVitórias +
      " vezes, eu ganhei " + minhasVitórias + " vezes, " +
      (rodadas-suasVitórias-minhasVitórias) + " empates.");
  }
}

