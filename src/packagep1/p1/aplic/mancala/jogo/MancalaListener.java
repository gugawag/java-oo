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

/**
 * Listeners de um jogo de Mancala s�o normalmente objetos que implementam
 * interfaces com o usu�rio para o jogo. Tais objetos
 * devem implementar essa interface.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 */
public interface MancalaListener extends java.util.EventListener {
  /**
   * Este m�todo do listener � chamado para indicar que o jogo iniciou.
   *
   * @param   evento   O objeto que descreve o inicio do jogo.
   */
   void inicioDeJogo(MancalaEvent evento);

  /**
   * Este m�todo do listener � chamado para indicar que um jogador jogou.
   *
   * @param   evento   O objeto que descreve a jogada feita.
   */
   void jogadorJogou(MancalaEvent evento);

  /**
   * Este m�todo do listener � chamado para indicar que o jogo terminou.
   *
   * @param   evento   O objeto que descreve o resultado do jogo.
   */
   void fimDeJogo(MancalaEvent evento);
}

