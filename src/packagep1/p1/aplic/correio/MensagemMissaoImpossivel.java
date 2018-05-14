/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ciência da Computação
 * Departamento de Sistemas e Computação
 * Universidade Federal da Paraíba
 *
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 * Não redistribuir sem permissão.
 */
package p1.aplic.correio;

import p1.aplic.geral.*;
import java.io.*;

/**
 * Classe que representa uma mensagem textual de correio eletronico mas que se auto-destroi depois de lida.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 */

public class MensagemMissaoImpossivel extends MensagemTexto {
  static final long serialVersionUID = 7693744891877165882L;
  /**
   * Cria uma mensagem textual de correio eletrônico
   * @param remetente O remetente da mensagem
   * @param assunto O assunto da mensagem
   * @param contéudo O conteúdo da mensagem, podendo conter várias linhas
   */
  public MensagemMissaoImpossivel(String remetente, String assunto, String conteúdo) {
    super(remetente, assunto, conteúdo);
  }

  /**
   * Exibir a mensagem. Os dados da mensagem são apresentados na saída padrão.
   * Após este método, a mensagem se auto-destroi.
   */
  public void exibir() {
    super.exibir();
    excluir();
  }

  /**
   * Testa a igualdade de um objeto com esta mensagem.
   * @param objeto O objeto a comparar com esta mensagem.
   * @return true se o objeto for igual a esta mensagem, false caso contrário.
   */
  public boolean equals(Object objeto) {
    if(! (objeto instanceof MensagemMissaoImpossivel)) {
      return false;
    }
    MensagemMissaoImpossivel outra = (MensagemMissaoImpossivel)objeto;
    return super.equals(objeto);
  }
}
