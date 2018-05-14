/*
 * Desenvolvido para a disciplina Programacao 2
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */
package p1.aplic.mancala.jogo;
import java.util.*;

/**
 * Um tabuleiro do jogo de Mancala com 6 buracos e uma Kalaha para cada jogador.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 */
public class Tabuleiro {
  /**
   * Posi��o "em baixo" do tabuleiro, com buracos 1 a 6 e Kalaha � direita.
   */
  public final static int EM_BAIXO = 0;

  /**
   * Posi��o "em cima" do tabuleiro, com buracos 8 a 13 e Kalaha � esquerda.
   */
  public final static int EM_CIMA = 1;

  /**
   * Posi��o de um buraco indicando uma Kalaha.
   */
  public final static int KALAHA = 2;

  /**
   * N�mero de buracos por jogador (sem incluir Kalahas)
   */
  public final static int NUM_BURACOS = 6;

  private final static int TOTAL_BURACOS = 2*(NUM_BURACOS+1);
  private final static int PRIMEIRO_BURACO_EM_BAIXO = 0;
  private final static int �LTIMO_BURACO_EM_BAIXO = NUM_BURACOS-1;
  private final static int KALAHA_DIREITA = NUM_BURACOS;
  private final static int PRIMEIRO_BURACO_EM_CIMA = NUM_BURACOS+1;
  private final static int �LTIMO_BURACO_EM_CIMA = TOTAL_BURACOS-2;
  private final static int KALAHA_ESQUERDA = TOTAL_BURACOS-1;
  private Buraco[] buracos;

  /**
   * Construtor de um tabuleiro padr�o vazio para jogar Mancala.
   */
  Tabuleiro() {
    buracos = new Buraco[TOTAL_BURACOS];
    for(int i = 0; i < TOTAL_BURACOS; i++) {
      buracos[i] = new Buraco(i, 0);
    }
  }

  /**
   * Informa a Kalaha correspondendo a uma posi��o (EM_BAIXO ou EM_CIMA)
   * A Kalaha do jogador "em baixo" est� � direita.
   * A Kalaha do jogador "em cima" est� � esquerda.
   *
   * @param   posi��o   A posi��o de interesse (EM_BAIXO ou EM_CIMA).
   * @return  O buraco correpondendo � Kalaha da posi��o de interesse.
   */
  Buraco getKalaha(int posi��o) {
    return posi��o == EM_BAIXO ?
           buracos[KALAHA_DIREITA] :
           buracos[KALAHA_ESQUERDA];
  }

  /**
   * Informa o buraco correspondendo a um n�mero de buraco
   * de uma certa posi��o (EM_BAIXO ou EM_CIMA).
   *
   * @param   posi��o   A posi��o de interesse (EM_BAIXO ou EM_CIMA).
   * @param   n�meroDoBuraco   O n�mero do buraco (0 a 5) de interesse.
   * @return  O buraco de interesse.
   */
  public Buraco getBuraco(int posi��o, int n�meroDoBuraco) {
    return posi��o == EM_CIMA ? buracos[PRIMEIRO_BURACO_EM_CIMA + n�meroDoBuraco] :
                                buracos[PRIMEIRO_BURACO_EM_BAIXO + n�meroDoBuraco];
  }

  /**
   * Verifica se um lado do tabuleiro est� vazio.
   *
   * @param   posi��o   A posi��o de interesse (EM_BAIXO ou EM_CIMA).
   * @return  true se o lado do tabuleiro indicado pela posi��o est� vazio,
   *          isto �, com os 6 buracos vazios.
   */
  boolean ladoEst�Vazio(int posi��o) {
    for(int i = 0; i < Tabuleiro.NUM_BURACOS; i++) {
      Buraco buraco = getBuraco(posi��o, i);
      if(buraco.getN�meroDeSementes() > 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Informa o pr�ximo buraco depois de um certo buraco, incluindo Kalahas,
   * no sentido do jogo (anti-hor�rio).
   *
   * @param   buraco   O buraco de refer�ncia.
   * @return  O buraco depois do buraco de refer�ncia.
   */
  public Buraco pr�ximoBuraco(Buraco buraco) {
    return buracos[(buraco.getN�mero()+1)%TOTAL_BURACOS];
  }

  /**
   * Dado um buraco de refer�ncia, informa o buraco do lado oposto do tabuleiro.
   *
   * @param   buraco   O buraco de refer�ncia.
   * @return  O buraco do lado oposto do tabuleiro
   */
  Buraco buracoOposto(Buraco buraco) {
    int index = getPosi��o(buraco) == EM_BAIXO ?
                KALAHA_DIREITA + (KALAHA_DIREITA - buraco.getN�mero()):
                KALAHA_ESQUERDA + (KALAHA_ESQUERDA - buraco.getN�mero());
    return buracos[index % TOTAL_BURACOS];
  }

  /**
   * Informa se um buraco est� EM_CIMA, EM_BAIXO, ou � KALAHA.
   *
   * @param   buraco   O buraco de interesse.
   * @return  EM_BAIXO, para buracos de cima
   *          EM_CIMA, para buracos de baixo
   *          KALAHA para as duas Kalahas.
   */
  int getPosi��o(Buraco buraco) {
    int num = buraco.getN�mero();
    if(PRIMEIRO_BURACO_EM_BAIXO <= num && num <= �LTIMO_BURACO_EM_BAIXO) {
      return EM_BAIXO;
    } else if(PRIMEIRO_BURACO_EM_CIMA <= num && num <= �LTIMO_BURACO_EM_CIMA) {
      return EM_CIMA;
    } else {
      return KALAHA;
    }
  }

  /**
   * Converte um n�mero absoluto (de 0 a 13) para um �ndice de buraco (0 a 5)
   * Se o buraco n�o corresponder � posi��o desejada, lan�a exce��o.
   * (Isso fede e precisa de refatoramento)
   *
   * @param   numAbsoluto   Um n�mero de buraco do tabuleiro, de 0 a 13.
   * @param   posi��o   A posi��o (EM_BAIXO, EM_CIMA) na qual este buraco deve estar.
   * @return  O �ndice do buraco correspondente (de 0 a 5).
   * @throws  MancalaException se O buraco n�o se localiza na posi��o indicada.
   */
  public int numAIndex(int numAbsoluto, int posi��o) throws MancalaException {
    if(posi��o == EM_CIMA) {
      if(PRIMEIRO_BURACO_EM_CIMA <= numAbsoluto && numAbsoluto <= �LTIMO_BURACO_EM_CIMA) {
        return numAbsoluto - PRIMEIRO_BURACO_EM_CIMA;
      }
    } else {
      if(PRIMEIRO_BURACO_EM_BAIXO <= numAbsoluto && numAbsoluto <= �LTIMO_BURACO_EM_BAIXO) {
        return numAbsoluto - PRIMEIRO_BURACO_EM_BAIXO;
      }
    }
    throw new MancalaException("Esse buraco nao eh seu!");
  }

  /**
   * Duplica o tabuleiro. � um Deep Copy.
   *
   * @return  O clone do objeto.
   */
  public Object clone() {
    Tabuleiro novo = new Tabuleiro();
    for(int i = 0; i < TOTAL_BURACOS; i++) {
      novo.buracos[i].adicionaSementes(this.buracos[i].getN�meroDeSementes());
    }
    return novo;
  }
}

