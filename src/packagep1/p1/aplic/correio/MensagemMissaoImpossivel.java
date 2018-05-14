/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */
package p1.aplic.correio;

import p1.aplic.geral.*;
import java.io.*;

/**
 * Classe que representa uma mensagem textual de correio eletronico mas que se auto-destroi depois de lida.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 */

public class MensagemMissaoImpossivel extends MensagemTexto {
  static final long serialVersionUID = 7693744891877165882L;
  /**
   * Cria uma mensagem textual de correio eletr�nico
   * @param remetente O remetente da mensagem
   * @param assunto O assunto da mensagem
   * @param cont�udo O conte�do da mensagem, podendo conter v�rias linhas
   */
  public MensagemMissaoImpossivel(String remetente, String assunto, String conte�do) {
    super(remetente, assunto, conte�do);
  }

  /**
   * Exibir a mensagem. Os dados da mensagem s�o apresentados na sa�da padr�o.
   * Ap�s este m�todo, a mensagem se auto-destroi.
   */
  public void exibir() {
    super.exibir();
    excluir();
  }

  /**
   * Testa a igualdade de um objeto com esta mensagem.
   * @param objeto O objeto a comparar com esta mensagem.
   * @return true se o objeto for igual a esta mensagem, false caso contr�rio.
   */
  public boolean equals(Object objeto) {
    if(! (objeto instanceof MensagemMissaoImpossivel)) {
      return false;
    }
    MensagemMissaoImpossivel outra = (MensagemMissaoImpossivel)objeto;
    return super.equals(objeto);
  }
}
