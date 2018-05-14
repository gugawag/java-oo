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
 * Este classe representa um buraco do tabuleiro do jogo de mancala.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 */
public class Buraco {
  /**
   * O número que identifica do buraco (de 0 a 13)
   */
  private int número;
  /**
   * O número de sementes no buraco
   */
  private int numSementes;

  /**
   * Construtor de um buraco com dada identificação
   *
   * @param   número   A identificação do buraco (de 0 a 13).
   */
  Buraco(int número) {
    this(número, 0);
  }

  /**
   * Construtor de um buraco com dada identificação e com sementes iniciais.
   *
   * @param   número   A identificação do buraco (de 0 a 13).
   * @param   numSementes   O número de sementes a colocar inicialmente no buraco.
   */
  Buraco(int número, int numSementes) {
    this.número = número;
    this.numSementes = numSementes;
  }

  /**
   * Informa quantas sementes estão no buraco.
   *
   * @return  O número de sementes no buraco.
   */
  public int getNúmeroDeSementes() {
    return numSementes;
  }

  /**
   * Informa a identificação do buraco.
   *
   * @return  A identificação do buraco (de 0 a 13)
   */
  public int getNúmero() {
    return número;
  }

  /**
   * Adiciona sementes ao buraco.
   *
   * @param   numSementes   O número de sementes a adicionar ao buraco.
   */
  void adicionaSementes(int numSementes) {
    this.numSementes += numSementes;
  }

  /**
   * Remove sementes do buraco.
   *
   * @param   numSementes   O número de sementes a remover do buraco.
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
    return "Buraco " + número + ", " + getNúmeroDeSementes() + " sementes";
  }
}

