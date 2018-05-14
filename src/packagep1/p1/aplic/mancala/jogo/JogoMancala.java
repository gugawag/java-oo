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
 * Interface de um jogo Mancala. O JogoMancala possui
 * dois jogadores, um tabuleiro e sabe as regras do jogo.
 * Objetos que implementam essa interface controlam o jogo
 * e repassam eventos importantes para a interface com o usu�rio.
 * Para jogar, o m�todo <tt>umaJogada()</tt> deve ser chamada
 * at� que <tt>fimDeJogo()</tt> retorne true.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 */

public interface JogoMancala {
  /**
   * Constante usa para pedir uma jogada do jogo sem gerar eventos de interface
   * (Est� fedendo: preciso refatorar isso)
   */
  public final static int SEM_EVENTO = 0;

  /**
   * Constante usa para pedir uma jogada do jogo com gera��o de eventos de interface
   */
  public final static int COM_EVENTO = 1;

  /**
   * Avisa ao jogo que queremos iniciar.
   *
   */
  public void iniciaJogo();

  /**
   * Verifica se o jogo acabou.
   *
   * @return  true, se o jogo acabou; false, caso contr�rio.
   */
  public boolean fimDeJogo();
  
  /**
   * Faz uma jogada para o jogadorAtual do jogo no buraco indicado por indexBuraco.
   * 
   * @param   indexBuraco   O �ndice (de 0 a 5) do buraco escolhido.
   * @param   querEvento   igual a SEM_EVENTO, para uma jogada que n�o aparecer na interface com o usu�rio.
   *          Seria o caso para estrat�gias de jogadores automatizados que querem tentar v�rias jogadas.
   *          Uma jogada normal (com efeito total) usa COM_EVENTO.
   * @return  O pr�ximo jogador a jogar.
   * @throws  MancalaException se um buraco ilegal for escolhido.
   */
  public Jogador umaJogada(int indexBuraco, int querEvento) throws MancalaException;

  /**
   * Obt�m o jogador que ganhou a partida.
   *
   * @return  O jogador que ganhou a partida, ou null se tiver sido empate.
   */
  public Jogador getGanhador();

  /**
   * Obt�m um jogador atrav�s do seu n�mero. O jogador de baixo � 0, o de cima � 1.
   *
   * @param   n�meroDoJogador   o n�mero do jogador (0 = em baixo, 1 = em cima).
   * @return  O jogador indicado.
   */
  public Jogador getJogador(int n�meroDoJogador);

  /**
   * Obtem o jogador cuja vez � de jogar.
   *
   * @return  O jogador cuja vez � de jogar.
   */
  public Jogador getJogadorAtual();

  /**
   * Obtem a Kalaha do jogador indicado.
   *
   * @param   jogador   O jogador cuja Kalaha se deseja.
   * @return  Uma refer�ncia ao buraco representando a Kalaha do jogador.
   */
  public Buraco getKalaha(Jogador jogador);

  /**
   * Obt�m o tabuleiro sendo usado para o jogo.
   *
   * @return  O tabuleiro sendo usado para o jogo.
   */
  public Tabuleiro getTabuleiro();
  
  /**
   * Altera o tabuleiro sendo usado para o jogo.
   *
   * @param   tabuleiro   O tabuleiro a usar.
   */
  public void setTabuleiro(Tabuleiro tabuleiro);
  
  /**
   * Adiciona um listener interessado em receber eventos do jogo.
   * Normalmente usado para conectar o jogo a uma interface com o usu�rio.
   *
   * @param   listener   O objeto que deseja receber os eventos do jogo.
   */
  public void addMancalaListener(MancalaListener listener);
}

