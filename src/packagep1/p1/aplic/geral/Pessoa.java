/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */
package p1.aplic.geral;

import java.io.*;

/**
 * Classe representando uma pessoa f�sica.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */

public class Pessoa implements Serializable {
  static final long serialVersionUID = -3961425924658203637L;
  private String nome;
  private String cpf;

  // Construtores
  /*
   * Constroi uma pessoa com nome e CPF dados.
   * @param nome O nome da pessoa.
   * @param cpf O CPF da pessoa.
   */
  public Pessoa(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
  }

  /*
   * Constroi uma pessoa com nome dado e sem CPF.
   * @param nome O nome da pessoa.
   */
  public Pessoa(String nome) {
    this(nome, "");
  }

  /**
   * Recupera o nome da pessoa.
   * @return O nome da pessoa.
   */
  public String getNome() {
    return nome;
  }

  /**
   * Recupera o CPF da pessoa.
   * @return O CPF associado � pessoa.
   */
  public String getCPF() {
    return cpf;
  }

  /**
   * Ajusta o nome da pessoa.
   * @param nome O nome da pessoa.
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Ajusta o CPF da pessoa.
   * @param cpf O CPF associado � pessoa.
   */
  public void setCPF(String cpf) {
    this.cpf = cpf;
  }

  /**
   * Representa a pessoa como string
   */
  public String toString() {
    return "Nome " + nome + ", cpf " + cpf;
  }
 
  /**
   * Testa a igualdade de um objeto com esta pessoa.
   * @param objeto O objeto a comparar com esta pessoa.
   * @return true se o objeto for igual a esta pessoa, false caso contr�rio.
   */
  public boolean equals(Object objeto) {
    if(! (objeto instanceof Pessoa)) {
      return false;
    }
    Pessoa outra = (Pessoa)objeto;
    return getNome().equals(outra.getNome())
            && getCPF().equals(outra.getCPF());
  }
}
