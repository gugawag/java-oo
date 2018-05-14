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
 * Interface de um jogador, seja humano ou computador,
 * apoiado em interface gr�fica ou textual.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 */
public interface Jogador {
  /**
   * Obt�m o nome do jogador.
   *
   * @return  O nome do jogador
   */
  String getNome();

  /**
   * Informa a posi��o do jogador.
   *
   * @return  A posi��o do jogador (EM_BAIXO ou EM_CIMA)
   */
  int getPosi��o();

  /**
   * Pede ao jogador para escolher um buraco para jogar.
   *
   * @param   jogo   O jogo do qual o jogador est� participando.
   * @return  O n�mero do buraco (entre 0 e 5)
   * @throws  MancalaException se o buraco escolhido n�o for poss�vel.
   */
  int escolheJogada(JogoMancala jogo) throws MancalaException;
}

