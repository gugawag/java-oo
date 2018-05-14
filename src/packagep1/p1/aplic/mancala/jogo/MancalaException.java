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
 * A classe que representa qualquer exceção do jogo Mancala.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Paraíba.
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
   * @param   motivo   O motivo da exceção.
   */
  public MancalaException(String motivo) {
    super(motivo);
  }
}
