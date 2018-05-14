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
 * Um jogador automático bastante burrinho.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 */
public class JogadorComputador1 extends JogadorAbstrato {
  /**
   * Construtor de um jogador automático (computador)
   * com algoritmo bem burrinho para jogar.
   *
   * @param   nome   O nome do jogador.
   * @param   posição   A posição do jogador (EM_BAIXO ou EM_CIMA).
   */
  public JogadorComputador1(String nome, int posição) {
    super(nome, posição);
  }

  /**
   * Pede ao jogador para escolher um buraco para jogar.
   * A estratégia é burra: o primeiro buraco que contém sementes
   *
   * @param   jogo   O jogo do qual o jogador está participando.
   * @return  O número do buraco (entre 0 e 5)
   * @throws  MancalaException se o buraco escolhido não for possível.
   */
  public int escolheJogada(JogoMancala jogo) throws MancalaException {
    for(int i = 0; i < Tabuleiro.NUM_BURACOS; i++) {
      Buraco buraco = jogo.getTabuleiro().getBuraco(getPosição(), i);
      if(buraco.getNúmeroDeSementes() > 0) {
        return i;
      }
    }
    throw new MancalaException("A partida nao terminou mas nao tenho sementes!");
  }
}

