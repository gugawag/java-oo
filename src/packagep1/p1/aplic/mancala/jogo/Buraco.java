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
 * Este classe representa um buraco do tabuleiro do jogo de mancala.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 */
public class Buraco {
  /**
   * O n�mero que identifica do buraco (de 0 a 13)
   */
  private int n�mero;
  /**
   * O n�mero de sementes no buraco
   */
  private int numSementes;

  /**
   * Construtor de um buraco com dada identifica��o
   *
   * @param   n�mero   A identifica��o do buraco (de 0 a 13).
   */
  Buraco(int n�mero) {
    this(n�mero, 0);
  }

  /**
   * Construtor de um buraco com dada identifica��o e com sementes iniciais.
   *
   * @param   n�mero   A identifica��o do buraco (de 0 a 13).
   * @param   numSementes   O n�mero de sementes a colocar inicialmente no buraco.
   */
  Buraco(int n�mero, int numSementes) {
    this.n�mero = n�mero;
    this.numSementes = numSementes;
  }

  /**
   * Informa quantas sementes est�o no buraco.
   *
   * @return  O n�mero de sementes no buraco.
   */
  public int getN�meroDeSementes() {
    return numSementes;
  }

  /**
   * Informa a identifica��o do buraco.
   *
   * @return  A identifica��o do buraco (de 0 a 13)
   */
  public int getN�mero() {
    return n�mero;
  }

  /**
   * Adiciona sementes ao buraco.
   *
   * @param   numSementes   O n�mero de sementes a adicionar ao buraco.
   */
  void adicionaSementes(int numSementes) {
    this.numSementes += numSementes;
  }

  /**
   * Remove sementes do buraco.
   *
   * @param   numSementes   O n�mero de sementes a remover do buraco.
   */
  void removeSementes(int numSementes) {
    this.numSementes -= numSementes;
  }

  /**
   * Representa o buraco como string
   *
   * @return  Um string representando o buraco.
   */
  public String toString() {
    return "Buraco " + n�mero + ", " + getN�meroDeSementes() + " sementes";
  }
}

