/*
 * Desenvolvido para a disciplina Programacao 2
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */
 
package p1.aplic.mancala.jogo;
import java.util.*;

/**
 * Um jogador autom�tico bastante burrinho.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 */
public class JogadorComputador1 extends JogadorAbstrato {
  /**
   * Construtor de um jogador autom�tico (computador)
   * com algoritmo bem burrinho para jogar.
   *
   * @param   nome   O nome do jogador.
   * @param   posi��o   A posi��o do jogador (EM_BAIXO ou EM_CIMA).
   */
  public JogadorComputador1(String nome, int posi��o) {
    super(nome, posi��o);
  }

  /**
   * Pede ao jogador para escolher um buraco para jogar.
   * A estrat�gia � burra: o primeiro buraco que cont�m sementes
   *
   * @param   jogo   O jogo do qual o jogador est� participando.
   * @return  O n�mero do buraco (entre 0 e 5)
   * @throws  MancalaException se o buraco escolhido n�o for poss�vel.
   */
  public int escolheJogada(JogoMancala jogo) throws MancalaException {
    for(int i = 0; i < Tabuleiro.NUM_BURACOS; i++) {
      Buraco buraco = jogo.getTabuleiro().getBuraco(getPosi��o(), i);
      if(buraco.getN�meroDeSementes() > 0) {
        return i;
      }
    }
    throw new MancalaException("A partida nao terminou mas nao tenho sementes!");
  }
}

