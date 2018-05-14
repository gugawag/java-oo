/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */
package p1.aplic.correio;

import p1.aplic.geral.*;
import java.io.*;

/**
 * Classe que representa uma mensagem normal de correio eletronico.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */

public class MensagemTexto extends MensagemAbstrata implements Serializable {
  static final long serialVersionUID = 7693744891877165882L;
  protected String  conte�do;

  /**
   * Cria uma mensagem textual de correio eletr�nico
   * @param remetente O remetente da mensagem
   * @param assunto O assunto da mensagem
   * @param cont�udo O conte�do da mensagem, podendo conter v�rias linhas
   */
  public MensagemTexto(String remetente, String assunto, String conte�do) {
    super(remetente, assunto);
    this.conte�do = conte�do;
  }

  /**
   * Recupera o conte�do da mensagem.
   * O conte�do � um String podendo conter v�rias linhas.
   * @return O conte�do da mensagem
   */
  public String getConte�do() {
    return conte�do;
  }

  /**
   * Exibir a mensagem. Os dados da mensagem s�o apresentados na sa�da padr�o.
   * Ap�s este m�todo, a mensagem � considerada "lida".
   */
  public void exibir() {
    System.out.println("De: " + remetente);
    System.out.println("Data: " + dataEnvio.DDMMAAAAHHMM());
    System.out.println("Assunto: " + assunto);
    System.out.println(conte�do);
    estado |= LIDA;
  }

  /**
   * Testa a igualdade de um objeto com esta mensagem.
   * @param objeto O objeto a comparar com esta mensagem.
   * @return true se o objeto for igual a esta mensagem, false caso contr�rio.
   */
  public boolean equals(Object objeto) {
    if(! (objeto instanceof MensagemTexto)) {
      return false;
    }
    MensagemTexto outra = (MensagemTexto)objeto;
    return super.equals(objeto) &&
           getConte�do().equals(outra.getConte�do());
  }

  /**
   * Forne�a uma representa��o da mensagem como String
   * @return A representa��o da mensagem como String.
   */
  public String toString() {
    return "Remetente: " + remetente +
           ", Data: " + dataEnvio.DDMMAAAAHHMM() +
           ", Assunto: " + assunto +
           ", Conte�do: " + conte�do;
  }
}
