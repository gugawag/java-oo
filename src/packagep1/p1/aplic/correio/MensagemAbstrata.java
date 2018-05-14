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
 * Classe abstrata que representa uma mensagem de correio eletronico.
 * Uma mensagem contém um remetente, um assunto uma data de envio e algum conteúdo.
 * O conteúdo depende do tipo exato de mensagem (textual, áudio).
 * Uma mensagem pode ser exibida (lida) e marcada para exclusão.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */

public abstract class MensagemAbstrata implements Mensagem, Serializable {
  static final long serialVersionUID = 7891762193879048570L;
  protected static final int LIDA = 0x1;
  protected static final int EXCLUÍDA = 0x2;
  protected static final int NOVA = ~(LIDA | EXCLUÍDA);

  protected String  remetente;
  protected String  assunto;
  protected Data    dataEnvio;
  protected int     estado;

  protected MensagemAbstrata(String remetente, String assunto) {
    this.remetente = remetente;
    this.assunto = assunto;
    dataEnvio = new Data();
    estado = NOVA;
  }

  /**
   * Recupera o remetente da mensagem
   * @return O remetente da mensagem
   */
  public String getRemetente() {
    return remetente;
  }

  /**
   * Recupera o assunto da mensagem
   * @return O assunto da mensagem
   */
  public String getAssunto() {
    return assunto;
  }

  /**
   * Recupera a data de envio da mensagem
   * @return A data de envio da mensagem
   */
  public Data getDataEnvio() {
    return dataEnvio;
  }

  /**
   * Informa se a mensagem foi lida ou não
   * @return true se a mensagem foi lida, false caso contrário
   */
  public boolean isLida() {
    return (estado & LIDA) == LIDA;
  }

  /**
   * Informa se a mensagem foi excluída ou não
   * @return true se a mensagem foi excluída, false caso contrário
   */
  public boolean isExcluída() {
    return (estado & EXCLUÍDA) == EXCLUÍDA;
  }

  /**
   * Marcar a mensagem como excluída.
   * A exclusão deve ser feita pela coleção que armazena as mensagens.
   * Um exemplo de tal coleção é CaixaPostal.
   */
  public void excluir() {
    estado |= EXCLUÍDA;
  }

  /**
   * Marcar a mensagem como não excluída.
   */
  public void marcarNãoExcluída() {
    estado &= ~EXCLUÍDA;
  }

  /**
   * Marcar a mensagem como não lida.
   */
  public void marcarNãoLida() {
    estado &= ~LIDA;
  }

  /**
   * Testa a igualdade de um objeto com esta mensagem.
   * @param objeto O objeto a comparar com esta mensagem.
   * @return true se o objeto for igual a esta mensagem, false caso contrário.
   */
  public boolean equals(Object objeto) {
    if(! (objeto instanceof Mensagem)) {
      return false;
    }
    Mensagem outra = (Mensagem)objeto;
    return getRemetente().equals(outra.getRemetente())
           && getAssunto().equals(outra.getAssunto());
  }

  /**
   * Exibir a mensagem. Isso poderá imprimir algo na saída
   * ou provocar outras saídas relacionadas com a leitura da mensagem.
   * Após este método, a mensagem é considerada "lida".
   */
  public abstract void exibir();

  /**
   * Forneça uma representação da mensagem como String
   * @return A representação da mensagem como String.
   */
  public abstract String toString();
}
