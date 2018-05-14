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

import java.io.*;
import java.util.*;

/**
 * Classe que representa uma caixa de mensagens de correio eletronico.
 * Uma caixa pode conter v�rias mensagens.
 * Uma caixa pertence a um "titular".
 * <p>A caixa inclui um "cursor" de mensagem. Isto �, existe
 * o conceito de "mensagem corrente" e pode-se avan�ar e recuar
 * na lista de mensagens (mudando assim a mensagem corrente).
 * <p>Algumas opera��es podem ser aplicadas � mensagem corrente: excluir, por exemplo.
 * Outras opera��es se aplicam � caixa como um todo (salvar, removeCaixaPostal).
 * <p>A caixa postal � salva em disco com a opera��o salvar.
 * Ao criar uma caixa postal, caso exista uma c�pia em disco, a caixa
 * � inicializada com as mensagens que est�o no disco.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */

public class CaixaPostal implements Serializable {
  static final long serialVersionUID = 7121517428757951951L;
  private Vector mensagens;
  private int �ndiceMensagemCorrente;
  private String titular;

  /**
   * Constru��o de uma CaixaPostal an�nima (sem titular).
   */
  public CaixaPostal() {
    this("");
  }

  /**
   * Constru��o de uma Caixa Postal
   * Caso haja uma c�pia da caixa postal deste titular em disco,
   * as mensagens em disco s�o carregados na caixa postal sendo criada.
   * No in�cio, a mensagem corrente ser� a primeira mensagem da caixa.
   * @param titular O titular da caixa postal.
   */
  public CaixaPostal(String titular) {
    this.titular = titular;
    ObjectInputStream in = null;
    try {
      try {
        in = new ObjectInputStream(new FileInputStream(getNomeArquivo()));
        mensagens = (Vector)in.readObject();
        in.close();
      } catch( FileNotFoundException e ) {
        // nao achar o arquivo significa que estamos come�ando do zero
        mensagens = new Vector();
      }
    } catch(Exception e) {
      System.err.println(e);
      System.exit(1);
    }
    �ndiceMensagemCorrente = Math.min(0, mensagens.size()-1);
  }

  protected String getNomeArquivo() {
    return titular + ".correio";
  }
  /**
   * Recupera o titular da caixa postal
   * @return O titular da caixa postal.
   */
  public String getTitular() {
    return titular;
  }

  /**
   * Recupera o n�mero de mensagens na caixa postal
   * @return O n�mero de mensagens na caixa postal
   */
  public int n�meroDeMensagens() {
    return mensagens.size();
  }

  /**
   * Insira uma nova mensagem no final da caixa postal
   * @param m A Mensagem sendo inserida.
   */
  public void inserir(Mensagem m) {
    mensagens.add(m);
    �ndiceMensagemCorrente = Math.max(�ndiceMensagemCorrente, 0);
  }

  /**
   * Recupera a mensagem corrente.
   * <p>A caixa inclui um "cursor" de mensagem. Isto �, existe
   * o conceito de "mensagem corrente" e pode-se avan�ar e recuar
   * na lista de mensagens (mudando assim a mensagem corrente).
   * @return A mensagem corrente.
   */
  public Mensagem mensagemCorrente() {
    return �ndiceMensagemCorrente >= 0 ? (Mensagem)mensagens.get(�ndiceMensagemCorrente) : null;
  }

  /**
   * Avan�ar o cursor da caixa postal. A mensagem corrente passa a ser a pr�xima,
   * caso haja. Se a mensagem corrente for a �ltima da caixa postal, n�o h� mudan�a.

   */
  public void avan�ar() {
    �ndiceMensagemCorrente++;
    �ndiceMensagemCorrente = Math.min(�ndiceMensagemCorrente, mensagens.size()-1);
  }

  /**
   * Recuar o cursor da caixa postal. A mensagem corrente passa a ser a anterior,
   * caso haja. Se a mensagem corrente for a primeira da caixa postal, n�o h� mudan�a.
   */
  public void recuar() {
    �ndiceMensagemCorrente--;
    �ndiceMensagemCorrente = Math.max(�ndiceMensagemCorrente, 0);
  }

  /**
   * Forne�a um iterador para as mensagens da caixa postal.
   * @return O iterador de mensagens.
   */
  public Iterator iterator() {
    return mensagens.iterator();
  }

  /**
   * Excluir a mensagem Corrente da caixa postal.
   * A exclus�o � apenas l�gica. A mensagem est� marcada para ser exclu�da
   * mas s� �, de fato, exclu�da ao salvar a caixa postal.
   * @return true, se houve mensagem exclu�da, false caso contr�rio (caixa vazia)
   */
  public boolean excluir() {
    if(�ndiceMensagemCorrente >= 0 && �ndiceMensagemCorrente < mensagens.size()) {
      mensagemCorrente().excluir();
      �ndiceMensagemCorrente = Math.min(�ndiceMensagemCorrente, mensagens.size()-1);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Salvar a caixa postal em disco.
   * Neste momento, as mensagens marcadas para exclus�o s�o removidas
   * (isto �, n�o s�o gravadas em disco)
   */
  public void salvar() {
    // primeiro, remover as mensagens exclu�das
    Iterator it = iterator();
    while(it.hasNext()) {
      Mensagem m = (Mensagem)it.next();
      if(m.isExclu�da()) {
        it.remove();
      }
    }
    ObjectOutputStream out = null;
    try {
      try {
        out = new ObjectOutputStream(new FileOutputStream(getNomeArquivo()));
      } catch(FileNotFoundException e) {
        System.err.println("Nao pode criar " + getNomeArquivo());
        System.exit(1);
      }
      out.writeObject(mensagens);
      out.close();
    } catch(IOException e) {
      System.err.println(e);
      System.exit(1);
    }
    �ndiceMensagemCorrente = Math.min(�ndiceMensagemCorrente, mensagens.size()-1);
  }

  /**
   * Remove uma caixa postal armazenada em disco.
   * @param titular O titular da caixa postal a ser removida.
   */
  public static void removeCaixaPostal(String titular) {
    File f = new File(titular + ".correio");
    try {
      f.delete();
    } catch(Exception e) {}
  }
}
