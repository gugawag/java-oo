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
 * A classe que representa qualquer exce��o do jogo Mancala.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 */
public class MancalaException extends Exception {
  /**
   * Constroi uma MancalaException
   *
   */
  public MancalaException() {
    super();
  }

  /**
   * Constroi uma MancalaException
   *
   * @param   motivo   O motivo da exce��o.
   */
  public MancalaException(String motivo) {
    super(motivo);
  }
}
