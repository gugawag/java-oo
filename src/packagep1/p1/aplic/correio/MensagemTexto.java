/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ciência da Computação
 * Departamento de Sistemas e Computação
 * Universidade Federal da Paraíba
 *
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 * Não redistribuir sem permissão.
 */
package p1.aplic.correio;

import p1.aplic.geral.*;
import java.io.*;

/**
 * Classe que representa uma mensagem normal de correio eletronico.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */

public class MensagemTexto extends MensagemAbstrata implements Serializable {
  static final long serialVersionUID = 7693744891877165882L;
  protected String  conteúdo;

  /**
   * Cria uma mensagem textual de correio eletrônico
   * @param remetente O remetente da mensagem
   * @param assunto O assunto da mensagem
   * @param contéudo O conteúdo da mensagem, podendo conter várias linhas
   */
  public MensagemTexto(String remetente, String assunto, String conteúdo) {
    super(remetente, assunto);
    this.conteúdo = conteúdo;
  }

  /**
   * Recupera o conteúdo da mensagem.
   * O conteúdo é um String podendo conter várias linhas.
   * @return O conteúdo da mensagem
   */
  public String getConteúdo() {
    return conteúdo;
  }

  /**
   * Exibir a mensagem. Os dados da mensagem são apresentados na saída padrão.
   * Após este método, a mensagem é considerada "lida".
   */
  public void exibir() {
    System.out.println("De: " + remetente);
    System.out.println("Data: " + dataEnvio.DDMMAAAAHHMM());
    System.out.println("Assunto: " + assunto);
    System.out.println(conteúdo);
    estado |= LIDA;
  }

  /**
   * Testa a igualdade de um objeto com esta mensagem.
   * @param objeto O objeto a comparar com esta mensagem.
   * @return true se o objeto for igual a esta mensagem, false caso contrário.
   */
  public boolean equals(Object objeto) {
    if(! (objeto instanceof MensagemTexto)) {
      return false;
    }
    MensagemTexto outra = (MensagemTexto)objeto;
    return super.equals(objeto) &&
           getConteúdo().equals(outra.getConteúdo());
  }

  /**
   * Forneça uma representação da mensagem como String
   * @return A representação da mensagem como String.
   */
  public String toString() {
    return "Remetente: " + remetente +
           ", Data: " + dataEnvio.DDMMAAAAHHMM() +
           ", Assunto: " + assunto +
           ", Conteúdo: " + conteúdo;
  }
}
