/*
 * Desenvolvido para a disciplina Programacao 2
 * Curso de Bacharelado em Ciência da Computação
 * Departamento de Sistemas e Computação
 * Universidade Federal da Paraíba
 *
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 * Não redistribuir sem permissão.
 */
 
package p1.aplic.mancala.jogo;

/**
 * Listeners de um jogo de Mancala são normalmente objetos que implementam
 * interfaces com o usuário para o jogo. Tais objetos
 * devem implementar essa interface.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 */
public interface MancalaListener extends java.util.EventListener {
  /**
   * Este método do listener é chamado para indicar que o jogo iniciou.
   *
   * @param   evento   O objeto que descreve o inicio do jogo.
   */
   void inicioDeJogo(MancalaEvent evento);

  /**
   * Este método do listener é chamado para indicar que um jogador jogou.
   *
   * @param   evento   O objeto que descreve a jogada feita.
   */
   void jogadorJogou(MancalaEvent evento);

  /**
   * Este método do listener é chamado para indicar que o jogo terminou.
   *
   * @param   evento   O objeto que descreve o resultado do jogo.
   */
   void fimDeJogo(MancalaEvent evento);
}

