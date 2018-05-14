/*
 * Desenvolvido para a disciplina Programacao 2
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */
package p1.aplic.mancala.cui;
import p1.aplic.mancala.jogo.*;
import java.util.*; 

/**
 * O controlador de jogo Mancala quando a interface � a caractere.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 */
public class JogoCUI {
  public static void main(String[] args) {
    Jogador j1 = null;
    Jogador j2 = null;
    switch(args.length) {
      case 0:
        j1 = criaJogador("ENIAC", Tabuleiro.EM_BAIXO);
        j2 = criaJogador("PDP11", Tabuleiro.EM_CIMA);
        break;
      case 1:
        j1 = criaJogador(args[0], Tabuleiro.EM_BAIXO);
        j2 = criaJogador("PDP11", Tabuleiro.EM_CIMA);
        break;
      case 2:
        j1 = criaJogador(args[0], Tabuleiro.EM_BAIXO);
        j2 = criaJogador(args[1], Tabuleiro.EM_CIMA);
        break;
      default:
        sintaxe();
    }
    // cria um Model
    JogoMancala jogo = new UmJogo(j1, j2);
    // cria uma View e cadastre-se junto ao Model
    jogo.addMancalaListener(new OutputMancalaCUI());
    try {
        joga(jogo);
    } catch(MancalaException e) {
        System.err.println(e.getMessage());
        System.exit(1);
    }
  }

  /**
   * Joga um jogo de Mancala com interface a caractere.
   *
   * @param   jogo   O objeto para controlar o jogo.
   * @throws  MancalaException em caso de erro de jogo.
   */
  private static void joga(JogoMancala jogo) throws MancalaException {
    jogo.iniciaJogo();
    Jogador jogadorAtual = jogo.getJogadorAtual();
    while(!jogo.fimDeJogo()) {
      jogadorAtual = jogo.umaJogada(jogadorAtual.escolheJogada(jogo), JogoMancala.COM_EVENTO);
    }
  }

  /**
   * Cria um jogador de acordo com nomes especiais conhecidos.
   *
   * @param   nome   O nome do jogador.
   *                 "ENIAC" � o nome de um computador com algoritmo burro.
   *                 "PDP11" � o nome de um computador com algoritmo melhorzinho.
   *                 Qualquer outro nome indica um jogador humano.
   * @return  O jogador correspondente.
   */
  private static Jogador criaJogador(String nome, int posi��o) {
    if(nome.equals("ENIAC")) {
      return new JogadorComputador1(nome, posi��o);
    } else if(nome.equals("PDP11")) {
      return new JogadorComputador2(nome, posi��o);
    } else {
      return new JogadorHumanoCUI(nome, posi��o);
    }
  }

  /**
   * D� mensagem de erro de sintaxe e cai fora.
   *
   */
  private static void sintaxe() {
    System.err.println("Sintaxe: JogoCUI [primeiro_nome] [segundo_nome]");
    System.err.println("         O nome ENIAC � um computador burro");
    System.err.println("         O nome PDP11 � um computador melhorzinho");
    System.exit(1);
  }
}

