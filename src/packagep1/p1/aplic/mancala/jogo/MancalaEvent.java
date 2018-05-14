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

/**
 * Representação de um evento "interessante" de um jogo de Mancala.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 */
public class MancalaEvent extends java.util.EventObject {
  /**
   * Um possível evento de jogo: o jogo acabou de iniciar mas ninguém jogou ainda.
   */
  public final static int INICIO_DE_JOGO = 0;

  /**
   * Um possível evento de jogo: um jogador acabou de jogar.
   */
  public final static int JOGADOR_JOGOU = 1;

  /**
   * Um possível evento de jogo: o jogo acabou.
   */
  public final static int FIM_DE_JOGO = 2;

  private Buraco buraco;
  private Jogador jogadorAtual;
  private Jogador jogadorQueJogou;

  /**
   * Construtor de um evento de jogo.
   *
   * @param   source   O jogo que é a fonte do evento.
   * @param   buraco   O buraco que acabou de ser jogado.
   * @param   jogadorAtual   O próximo jogador a jogar.
   * @param   jogadorQueJogou   Quem acabou de jogar.
   */
  public MancalaEvent(JogoMancala source, Buraco buraco, Jogador jogadorAtual, Jogador jogadorQueJogou) {
    super(source);
    this.buraco = buraco;
    this.jogadorAtual = jogadorAtual;
    this.jogadorQueJogou = jogadorQueJogou;
  }

  /**
   * Accessor para o buraco jogado.
   *
   * @return  O buraco que foi jogado.
   */
  public Buraco getBuraco() {
    return buraco;
  }

  /**
   * Accessor para o jogador que acabou de jogar.
   *
   * @return  O jogador que acabou de jogar.
   */
  public Jogador getJogadorQueJogou() {
    return jogadorQueJogou;
  }

  /**
   * Accessor para o próximo jogador a jogar.
   *
   * @return  O próximo jogador a jogar.
   */
  public Jogador getJogadorAtual() {
    return jogadorAtual;
  }
}
