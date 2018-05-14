/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */
package p1.aplic.banco;

import java.util.*;
import java.io.*;
import p1.aplic.geral.*;

/**
 * Classe de ag�ncia banc�ria simples.
 * Nesta vers�o, h� uma �nica ag�ncia. A ag�ncia tem uma conta "caixa" para
 * dep�sitos e saques. A ag�ncia pode ser "persistente". Isto significa que
 * tudo que ocorreu de movimenta��o de contas pode ser gravado em disco
 * para uso posterior ao fechar a ag�ncia.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */
public class Agencia {
  protected static boolean    aberto = false;
  protected static Conta    caixa = null;
  protected static Movimento  movimento = null; // movimento da agencia como um todo
  protected static HashMap    titulares = null;
  protected static HashMap    contas = null;

  /**
   * Recupera a conta "caixa".
   * @return A conta caixa.
   */
  public static Conta getContaCaixa() {
    abrirCaixa();
    return caixa;
  }

  /**
   * Recupera todo o movimento da ag�ncia.
   * @return O movimento da ag�ncia.
   */
  public static Movimento getMovimento() {
    abrirCaixa();
    return movimento;
  }

  /**
   * Obtem o iterador de todos os titulares da ag�ncia.
   * @return O iterador de titulares da ag�ncia.
   */
  public static Iterator getTitulares() {
    abrirCaixa();
    return titulares.values().iterator();
  }

  /**
   * Adiciona um titular � ag�ncia.
   * @param titular O titular a adicionar.
   */
  public static void addTitular(Pessoa titular) {
    abrirCaixa();
    titulares.put(titular.getCPF(), titular);
  }

  /**
   * Localiza um titular pela chave (cpf, cgc, ...).
   * @return O titular pesquisado. Retorna null se n�o achar.
   */
  public static Pessoa localizarTitular(String chave) {
    abrirCaixa();
    return (Pessoa)titulares.get(chave);
  }

  /**
   * Obtem a iterador de todas as contas da ag�ncia.
   * @return O iterador de contas da ag�ncia.
   */
  public static Iterator getContas() {
    abrirCaixa();
    return contas.values().iterator();
  }

  /**
   * Adiciona uma conta � ag�ncia.
   * @param conta A conta a adicionar.
   */
  public static void addConta(Conta conta) {
    abrirCaixa();
    contas.put(Integer.toString(conta.getN�mero()), conta);
  }

  /**
   * Localiza uma conta pelo n�mero.
   * @return A conta pesquisada.<br>Retorna null se n�o localizar.
   */
  public static Conta localizarConta(int n�mero) {
    abrirCaixa();
    return (Conta)contas.get(Integer.toString(n�mero));
  }

  /**
   * Fecha uma conta.
   * @param n�mero O n�mero da conta a fechar.
     * @throws NaoPodeFecharContaException se a conta n�o existir ou tiver saldo
   */
  /* observe visibilidade "package": tem que fechar a partir de fechar() da conta */
  static void fecharConta(int n�mero) throws NaoPodeFecharContaException {
    abrirCaixa();
    Conta c = localizarConta(n�mero);
    if(c == null) {
      throw new NaoPodeFecharContaException(c, "Conta nao existe");
    }
    if(c.getSaldo() != 0.0) {
      throw new NaoPodeFecharContaException(c, "Saldo nao esta zerado");
    }
    contas.remove(Integer.toString(n�mero));
    // tem que repensar o fechamento de contas porque
    // do jeito que esta, nao some do arquivo agencia
  }

  /**
   * Fechamento do caixa e grava��o dos dados em arquivo.
   * Aborta o programa com mensagem se houver problemas.
   */
   /* deveria usar exce��es se der pau aqui, mas vamos poupar os alunos principiantes (usamos isso em programas iniciais) */
  public static void fecharCaixa() {
    // usamos serializacao de objetos para manter os tipos dos objetos
    // se nao fizesse isso, teria problemas em distinguir tipos de contas, de pessoas, ...
    ObjectOutputStream out = null;
    try {
      try {
        out = new ObjectOutputStream(new FileOutputStream(getNomeArquivo()));
        } catch( FileNotFoundException e ) {
          System.err.println("Nao pode criar " + getNomeArquivo());
          System.exit(1);
        }
      Vector tudo = new Vector();  // junta tudo num unico objeto
                    // para nao perder as ligacoes entre objetos
      tudo.add(titulares);
      tudo.add(contas);
      tudo.add(movimento);
      out.writeObject(tudo);
      out.close();
    } catch(IOException e) {
      System.err.println(e);
      System.exit(1);
    }
  }

  /**
   * Abertura do caixa (da agencia) e leitura dos dados persistentes gravados em arquivo.
     * Aborta o programa com mensagem se houver problemas.
   */
  public static void abrirCaixa() {
    if(aberto) {
      return;
    }
    titulares = new HashMap();
    contas = new HashMap();
    movimento = new Movimento();
    aberto = true; // elimina recursao ao criar a conta caixa
    ObjectInputStream in = null;
    try {
      try {
        in = new ObjectInputStream(new FileInputStream(getNomeArquivo()));
      } catch( FileNotFoundException e ) {
        // nao achar o arquivo significa que estamos come�ando do zero
        caixa = new ContaCaixa();
        addConta(caixa);
        return;
      }
      Vector tudo = new Vector();
      tudo = (Vector)in.readObject();
      titulares = (HashMap)tudo.get(0);
      contas = (HashMap)tudo.get(1);
      movimento = (Movimento)tudo.get(2);
      caixa = localizarConta(0);
      in.close();
    } catch(Exception e) {
      System.err.println(e);
      System.exit(1);
    }
  }

  protected static String getNomeArquivo() {
    return "agencia.dat";
  }
}
