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

import java.io.*;
import java.util.*;

/**
 * Classe que representa uma caixa de mensagens de correio eletronico.
 * Uma caixa pode conter várias mensagens.
 * Uma caixa pertence a um "titular".
 * <p>A caixa inclui um "cursor" de mensagem. Isto é, existe
 * o conceito de "mensagem corrente" e pode-se avançar e recuar
 * na lista de mensagens (mudando assim a mensagem corrente).
 * <p>Algumas operações podem ser aplicadas à mensagem corrente: excluir, por exemplo.
 * Outras operações se aplicam à caixa como um todo (salvar, removeCaixaPostal).
 * <p>A caixa postal é salva em disco com a operação salvar.
 * Ao criar uma caixa postal, caso exista uma cópia em disco, a caixa
 * é inicializada com as mensagens que estão no disco.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */

public class CaixaPostal implements Serializable {
  static final long serialVersionUID = 7121517428757951951L;
  private Vector mensagens;
  private int índiceMensagemCorrente;
  private String titular;

  /**
   * Construção de uma CaixaPostal anônima (sem titular).
   */
  public CaixaPostal() {
    this("");
  }

  /**
   * Construção de uma Caixa Postal
   * Caso haja uma cópia da caixa postal deste titular em disco,
   * as mensagens em disco são carregados na caixa postal sendo criada.
   * No início, a mensagem corrente será a primeira mensagem da caixa.
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
        // nao achar o arquivo significa que estamos começando do zero
        mensagens = new Vector();
      }
    } catch(Exception e) {
      System.err.println(e);
      System.exit(1);
    }
    índiceMensagemCorrente = Math.min(0, mensagens.size()-1);
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
   * Recupera o número de mensagens na caixa postal
   * @return O número de mensagens na caixa postal
   */
  public int númeroDeMensagens() {
    return mensagens.size();
  }

  /**
   * Insira uma nova mensagem no final da caixa postal
   * @param m A Mensagem sendo inserida.
   */
  public void inserir(Mensagem m) {
    mensagens.add(m);
    índiceMensagemCorrente = Math.max(índiceMensagemCorrente, 0);
  }

  /**
   * Recupera a mensagem corrente.
   * <p>A caixa inclui um "cursor" de mensagem. Isto é, existe
   * o conceito de "mensagem corrente" e pode-se avançar e recuar
   * na lista de mensagens (mudando assim a mensagem corrente).
   * @return A mensagem corrente.
   */
  public Mensagem mensagemCorrente() {
    return índiceMensagemCorrente >= 0 ? (Mensagem)mensagens.get(índiceMensagemCorrente) : null;
  }

  /**
   * Avançar o cursor da caixa postal. A mensagem corrente passa a ser a próxima,
   * caso haja. Se a mensagem corrente for a última da caixa postal, não há mudança.

   */
  public void avançar() {
    índiceMensagemCorrente++;
    índiceMensagemCorrente = Math.min(índiceMensagemCorrente, mensagens.size()-1);
  }

  /**
   * Recuar o cursor da caixa postal. A mensagem corrente passa a ser a anterior,
   * caso haja. Se a mensagem corrente for a primeira da caixa postal, não há mudança.
   */
  public void recuar() {
    índiceMensagemCorrente--;
    índiceMensagemCorrente = Math.max(índiceMensagemCorrente, 0);
  }

  /**
   * Forneça um iterador para as mensagens da caixa postal.
   * @return O iterador de mensagens.
   */
  public Iterator iterator() {
    return mensagens.iterator();
  }

  /**
   * Excluir a mensagem Corrente da caixa postal.
   * A exclusão é apenas lógica. A mensagem está marcada para ser excluída
   * mas só é, de fato, excluída ao salvar a caixa postal.
   * @return true, se houve mensagem excluída, false caso contrário (caixa vazia)
   */
  public boolean excluir() {
    if(índiceMensagemCorrente >= 0 && índiceMensagemCorrente < mensagens.size()) {
      mensagemCorrente().excluir();
      índiceMensagemCorrente = Math.min(índiceMensagemCorrente, mensagens.size()-1);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Salvar a caixa postal em disco.
   * Neste momento, as mensagens marcadas para exclusão são removidas
   * (isto é, não são gravadas em disco)
   */
  public void salvar() {
    // primeiro, remover as mensagens excluídas
    Iterator it = iterator();
    while(it.hasNext()) {
      Mensagem m = (Mensagem)it.next();
      if(m.isExcluída()) {
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
    índiceMensagemCorrente = Math.min(índiceMensagemCorrente, mensagens.size()-1);
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
