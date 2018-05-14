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
import java.net.*;
import java.applet.*;

/**
 * Classe que representa uma mensagem de áudio de correio eletronico.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */

public class MensagemAudio extends MensagemAbstrata implements Serializable {
  static final long serialVersionUID = 4756562040979715146L;
  protected String  arquivoÁudio;

  /**
   * Cria uma mensagem de áudio de correio eletrônico
   * @param remetente O remetente da mensagem
   * @param assunto O assunto da mensagem
   * @param arquivoÁudio O arquivo contendo o áudio da mensagem
   */
  public MensagemAudio(String remetente, String assunto, String arquivoÁudio) {
    super(remetente, assunto);
    this.arquivoÁudio = arquivoÁudio;
  }

  /**
   * Recupera o arquivo de áudio da mensagem.
   * @return O arquivo de áudio da mensagem.
   */
  public String getarquivoÁudio() {
    return arquivoÁudio;
  }

  /**
   * Exibir a mensagem. O arquivo de áudio é tocado.
   * Após este método, a mensagem é considerada "lida".
   */
  public void exibir() {
    try {
      URL u = new URL("file", "localhost", arquivoÁudio);
      AudioClip clip = Applet.newAudioClip(u);
      System.out.println("Se tiver multimidia no computador, o clip deve estar tocando");
      clip.play();
    } catch(Exception e) {
      System.out.println("Nao pode abrir Audio Clip: " + arquivoÁudio);
    }
    estado |= LIDA;
  }   

  /**
   * Testa a igualdade de um objeto com esta mensagem.
   * @param objeto O objeto a comparar com esta mensagem.
   * @return true se o objeto for igual a esta mensagem, false caso contrário.
   */
  public boolean equals(Object objeto) {
    if(! (objeto instanceof MensagemAudio)) {
      return false;
    }
    MensagemAudio outra = (MensagemAudio)objeto;
    return super.equals(objeto) &&
           getarquivoÁudio().equals(outra.getarquivoÁudio());
  }

  /**
   * Forneça uma representação da mensagem como String
   * @return A representação da mensagem como String.
   */
  public String toString() {
    return "Remetente: " + remetente +
           ", Data: " + dataEnvio.DDMMAAAAHHMM() +
           ", Assunto: " + assunto +
           ", Arquivo de áudio: " + arquivoÁudio;
  }
}
