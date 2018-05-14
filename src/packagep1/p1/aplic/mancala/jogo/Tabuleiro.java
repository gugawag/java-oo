/*
 * Desenvolvido para a disciplina Programacao 2
 * Curso de Bacharelado em Ciência da Computação
 * Departamento de Sistemas e Computação
 * Universidade Federal da Paraíba
 *
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 * Não redistribuir sem permissão.
 */
package p1.aplic.mancala.jogo;
import java.util.*;

/**
 * Um tabuleiro do jogo de Mancala com 6 buracos e uma Kalaha para cada jogador.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 */
public class Tabuleiro {
  /**
   * Posição "em baixo" do tabuleiro, com buracos 1 a 6 e Kalaha à direita.
   */
  public final static int EM_BAIXO = 0;

  /**
   * Posição "em cima" do tabuleiro, com buracos 8 a 13 e Kalaha à esquerda.
   */
  public final static int EM_CIMA = 1;

  /**
   * Posição de um buraco indicando uma Kalaha.
   */
  public final static int KALAHA = 2;

  /**
   * Número de buracos por jogador (sem incluir Kalahas)
   */
  public final static int NUM_BURACOS = 6;

  private final static int TOTAL_BURACOS = 2*(NUM_BURACOS+1);
  private final static int PRIMEIRO_BURACO_EM_BAIXO = 0;
  private final static int ÚLTIMO_BURACO_EM_BAIXO = NUM_BURACOS-1;
  private final static int KALAHA_DIREITA = NUM_BURACOS;
  private final static int PRIMEIRO_BURACO_EM_CIMA = NUM_BURACOS+1;
  private final static int ÚLTIMO_BURACO_EM_CIMA = TOTAL_BURACOS-2;
  private final static int KALAHA_ESQUERDA = TOTAL_BURACOS-1;
  private Buraco[] buracos;

  /**
   * Construtor de um tabuleiro padrão vazio para jogar Mancala.
   */
  Tabuleiro() {
    buracos = new Buraco[TOTAL_BURACOS];
    for(int i = 0; i < TOTAL_BURACOS; i++) {
      buracos[i] = new Buraco(i, 0);
    }
  }

  /**
   * Informa a Kalaha correspondendo a uma posição (EM_BAIXO ou EM_CIMA)
   * A Kalaha do jogador "em baixo" está à direita.
   * A Kalaha do jogador "em cima" está à esquerda.
   *
   * @param   posição   A posição de interesse (EM_BAIXO ou EM_CIMA).
   * @return  O buraco correpondendo à Kalaha da posição de interesse.
   */
  Buraco getKalaha(int posição) {
    return posição == EM_BAIXO ?
           buracos[KALAHA_DIREITA] :
           buracos[KALAHA_ESQUERDA];
  }

  /**
   * Informa o buraco correspondendo a um número de buraco
   * de uma certa posição (EM_BAIXO ou EM_CIMA).
   *
   * @param   posição   A posição de interesse (EM_BAIXO ou EM_CIMA).
   * @param   númeroDoBuraco   O número do buraco (0 a 5) de interesse.
   * @return  O buraco de interesse.
   */
  public Buraco getBuraco(int posição, int númeroDoBuraco) {
    return posição == EM_CIMA ? buracos[PRIMEIRO_BURACO_EM_CIMA + númeroDoBuraco] :
                                buracos[PRIMEIRO_BURACO_EM_BAIXO + númeroDoBuraco];
  }

  /**
   * Verifica se um lado do tabuleiro está vazio.
   *
   * @param   posição   A posição de interesse (EM_BAIXO ou EM_CIMA).
   * @return  true se o lado do tabuleiro indicado pela posição está vazio,
   *          isto é, com os 6 buracos vazios.
   */
  boolean ladoEstáVazio(int posição) {
    for(int i = 0; i < Tabuleiro.NUM_BURACOS; i++) {
      Buraco buraco = getBuraco(posição, i);
      if(buraco.getNúmeroDeSementes() > 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Informa o próximo buraco depois de um certo buraco, incluindo Kalahas,
   * no sentido do jogo (anti-horário).
   *
   * @param   buraco   O buraco de referência.
   * @return  O buraco depois do buraco de referência.
   */
  public Buraco próximoBuraco(Buraco buraco) {
    return buracos[(buraco.getNúmero()+1)%TOTAL_BURACOS];
  }

  /**
   * Dado um buraco de referência, informa o buraco do lado oposto do tabuleiro.
   *
   * @param   buraco   O buraco de referência.
   * @return  O buraco do lado oposto do tabuleiro
   */
  Buraco buracoOposto(Buraco buraco) {
    int index = getPosição(buraco) == EM_BAIXO ?
                KALAHA_DIREITA + (KALAHA_DIREITA - buraco.getNúmero()):
                KALAHA_ESQUERDA + (KALAHA_ESQUERDA - buraco.getNúmero());
    return buracos[index % TOTAL_BURACOS];
  }

  /**
   * Informa se um buraco está EM_CIMA, EM_BAIXO, ou é KALAHA.
   *
   * @param   buraco   O buraco de interesse.
   * @return  EM_BAIXO, para buracos de cima
   *          EM_CIMA, para buracos de baixo
   *          KALAHA para as duas Kalahas.
   */
  int getPosição(Buraco buraco) {
    int num = buraco.getNúmero();
    if(PRIMEIRO_BURACO_EM_BAIXO <= num && num <= ÚLTIMO_BURACO_EM_BAIXO) {
      return EM_BAIXO;
    } else if(PRIMEIRO_BURACO_EM_CIMA <= num && num <= ÚLTIMO_BURACO_EM_CIMA) {
      return EM_CIMA;
    } else {
      return KALAHA;
    }
  }

  /**
   * Converte um número absoluto (de 0 a 13) para um índice de buraco (0 a 5)
   * Se o buraco não corresponder à posição desejada, lança exceção.
   * (Isso fede e precisa de refatoramento)
   *
   * @param   numAbsoluto   Um número de buraco do tabuleiro, de 0 a 13.
   * @param   posição   A posição (EM_BAIXO, EM_CIMA) na qual este buraco deve estar.
   * @return  O índice do buraco correspondente (de 0 a 5).
   * @throws  MancalaException se O buraco não se localiza na posição indicada.
   */
  public int numAIndex(int numAbsoluto, int posição) throws MancalaException {
    if(posição == EM_CIMA) {
      if(PRIMEIRO_BURACO_EM_CIMA <= numAbsoluto && numAbsoluto <= ÚLTIMO_BURACO_EM_CIMA) {
        return numAbsoluto - PRIMEIRO_BURACO_EM_CIMA;
      }
    } else {
      if(PRIMEIRO_BURACO_EM_BAIXO <= numAbsoluto && numAbsoluto <= ÚLTIMO_BURACO_EM_BAIXO) {
        return numAbsoluto - PRIMEIRO_BURACO_EM_BAIXO;
      }
    }
    throw new MancalaException("Esse buraco nao eh seu!");
  }

  /**
   * Duplica o tabuleiro. É um Deep Copy.
   *
   * @return  O clone do objeto.
   */
  public Object clone() {
    Tabuleiro novo = new Tabuleiro();
    for(int i = 0; i < TOTAL_BURACOS; i++) {
      novo.buracos[i].adicionaSementes(this.buracos[i].getNúmeroDeSementes());
    }
    return novo;
  }
}

