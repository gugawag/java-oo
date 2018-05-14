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
 * Interface de um jogo Mancala. O JogoMancala possui
 * dois jogadores, um tabuleiro e sabe as regras do jogo.
 * Objetos que implementam essa interface controlam o jogo
 * e repassam eventos importantes para a interface com o usuário.
 * Para jogar, o método <tt>umaJogada()</tt> deve ser chamada
 * até que <tt>fimDeJogo()</tt> retorne true.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 */

public interface JogoMancala {
  /**
   * Constante usa para pedir uma jogada do jogo sem gerar eventos de interface
   * (Está fedendo: preciso refatorar isso)
   */
  public final static int SEM_EVENTO = 0;

  /**
   * Constante usa para pedir uma jogada do jogo com geração de eventos de interface
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
   * @return  true, se o jogo acabou; false, caso contrário.
   */
  public boolean fimDeJogo();
  
  /**
   * Faz uma jogada para o jogadorAtual do jogo no buraco indicado por indexBuraco.
   * 
   * @param   indexBuraco   O índice (de 0 a 5) do buraco escolhido.
   * @param   querEvento   igual a SEM_EVENTO, para uma jogada que não aparecer na interface com o usuário.
   *          Seria o caso para estratégias de jogadores automatizados que querem tentar várias jogadas.
   *          Uma jogada normal (com efeito total) usa COM_EVENTO.
   * @return  O próximo jogador a jogar.
   * @throws  MancalaException se um buraco ilegal for escolhido.
   */
  public Jogador umaJogada(int indexBuraco, int querEvento) throws MancalaException;

  /**
   * Obtém o jogador que ganhou a partida.
   *
   * @return  O jogador que ganhou a partida, ou null se tiver sido empate.
   */
  public Jogador getGanhador();

  /**
   * Obtém um jogador através do seu número. O jogador de baixo é 0, o de cima é 1.
   *
   * @param   númeroDoJogador   o número do jogador (0 = em baixo, 1 = em cima).
   * @return  O jogador indicado.
   */
  public Jogador getJogador(int númeroDoJogador);

  /**
   * Obtem o jogador cuja vez é de jogar.
   *
   * @return  O jogador cuja vez é de jogar.
   */
  public Jogador getJogadorAtual();

  /**
   * Obtem a Kalaha do jogador indicado.
   *
   * @param   jogador   O jogador cuja Kalaha se deseja.
   * @return  Uma referência ao buraco representando a Kalaha do jogador.
   */
  public Buraco getKalaha(Jogador jogador);

  /**
   * Obtém o tabuleiro sendo usado para o jogo.
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
   * Normalmente usado para conectar o jogo a uma interface com o usuário.
   *
   * @param   listener   O objeto que deseja receber os eventos do jogo.
   */
  public void addMancalaListener(MancalaListener listener);
}

