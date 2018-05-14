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
import java.net.*;
import java.applet.*;

/**
 * Classe que representa uma mensagem de �udio de correio eletronico.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */

public class MensagemAudio extends MensagemAbstrata implements Serializable {
  static final long serialVersionUID = 4756562040979715146L;
  protected String  arquivo�udio;

  /**
   * Cria uma mensagem de �udio de correio eletr�nico
   * @param remetente O remetente da mensagem
   * @param assunto O assunto da mensagem
   * @param arquivo�udio O arquivo contendo o �udio da mensagem
   */
  public MensagemAudio(String remetente, String assunto, String arquivo�udio) {
    super(remetente, assunto);
    this.arquivo�udio = arquivo�udio;
  }

  /**
   * Recupera o arquivo de �udio da mensagem.
   * @return O arquivo de �udio da mensagem.
   */
  public String getarquivo�udio() {
    return arquivo�udio;
  }

  /**
   * Exibir a mensagem. O arquivo de �udio � tocado.
   * Ap�s este m�todo, a mensagem � considerada "lida".
   */
  public void exibir() {
    try {
      URL u = new URL("file", "localhost", arquivo�udio);
      AudioClip clip = Applet.newAudioClip(u);
      System.out.println("Se tiver multimidia no computador, o clip deve estar tocando");
      clip.play();
    } catch(Exception e) {
      System.out.println("Nao pode abrir Audio Clip: " + arquivo�udio);
    }
    estado |= LIDA;
  }   

  /**
   * Testa a igualdade de um objeto com esta mensagem.
   * @param objeto O objeto a comparar com esta mensagem.
   * @return true se o objeto for igual a esta mensagem, false caso contr�rio.
   */
  public boolean equals(Object objeto) {
    if(! (objeto instanceof MensagemAudio)) {
      return false;
    }
    MensagemAudio outra = (MensagemAudio)objeto;
    return super.equals(objeto) &&
           getarquivo�udio().equals(outra.getarquivo�udio());
  }

  /**
   * Forne�a uma representa��o da mensagem como String
   * @return A representa��o da mensagem como String.
   */
  public String toString() {
    return "Remetente: " + remetente +
           ", Data: " + dataEnvio.DDMMAAAAHHMM() +
           ", Assunto: " + assunto +
           ", Arquivo de �udio: " + arquivo�udio;
  }
}
