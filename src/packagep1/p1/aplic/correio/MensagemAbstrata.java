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
 * Classe abstrata que representa uma mensagem de correio eletronico.
 * Uma mensagem cont�m um remetente, um assunto uma data de envio e algum conte�do.
 * O conte�do depende do tipo exato de mensagem (textual, �udio).
 * Uma mensagem pode ser exibida (lida) e marcada para exclus�o.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */

public abstract class MensagemAbstrata implements Mensagem, Serializable {
  static final long serialVersionUID = 7891762193879048570L;
  protected static final int LIDA = 0x1;
  protected static final int EXCLU�DA = 0x2;
  protected static final int NOVA = ~(LIDA | EXCLU�DA);

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
   * Informa se a mensagem foi lida ou n�o
   * @return true se a mensagem foi lida, false caso contr�rio
   */
  public boolean isLida() {
    return (estado & LIDA) == LIDA;
  }

  /**
   * Informa se a mensagem foi exclu�da ou n�o
   * @return true se a mensagem foi exclu�da, false caso contr�rio
   */
  public boolean isExclu�da() {
    return (estado & EXCLU�DA) == EXCLU�DA;
  }

  /**
   * Marcar a mensagem como exclu�da.
   * A exclus�o deve ser feita pela cole��o que armazena as mensagens.
   * Um exemplo de tal cole��o � CaixaPostal.
   */
  public void excluir() {
    estado |= EXCLU�DA;
  }

  /**
   * Marcar a mensagem como n�o exclu�da.
   */
  public void marcarN�oExclu�da() {
    estado &= ~EXCLU�DA;
  }

  /**
   * Marcar a mensagem como n�o lida.
   */
  public void marcarN�oLida() {
    estado &= ~LIDA;
  }

  /**
   * Testa a igualdade de um objeto com esta mensagem.
   * @param objeto O objeto a comparar com esta mensagem.
   * @return true se o objeto for igual a esta mensagem, false caso contr�rio.
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
   * Exibir a mensagem. Isso poder� imprimir algo na sa�da
   * ou provocar outras sa�das relacionadas com a leitura da mensagem.
   * Ap�s este m�todo, a mensagem � considerada "lida".
   */
  public abstract void exibir();

  /**
   * Forne�a uma representa��o da mensagem como String
   * @return A representa��o da mensagem como String.
   */
  public abstract String toString();
}
