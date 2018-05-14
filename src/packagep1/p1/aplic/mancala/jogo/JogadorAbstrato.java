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
 * A parte comum de qualquer jogador: manter nome e posição (EM_BAIXO ou EM_CIMA).
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 */
public abstract class JogadorAbstrato implements Jogador {
  private String nome;
  private int posição;

  /**
   * Construtor genérico de um jogador.
   *
   * @param   nome   O nome do jogador.
   * @param   posição   A posição do jogador (EM_BAIXO ou EM_CIMA).
   */
  public JogadorAbstrato(String nome, int posição) {
    this.nome = nome;
    this.posição = posição;
  }

  /**
   * Obtém o nome do jogador.
   *
   * @return  O nome do jogador
   */
  public String getNome() {
    return nome;
  }

  /**
   * Informa a posição do jogador.
   *
   * @return  A posição do jogador (EM_BAIXO ou EM_CIMA)
   */
  public int getPosição() {
    return posição;
  }

  /**
   * Pede ao jogador para escolher um buraco para jogar.
   *
   * @param   jogo   O jogo do qual o jogador está participando.
   * @return  O número do buraco (entre 0 e 5)
   * @throws  MancalaException se o buraco escolhido não for possível.
   */
  public abstract int escolheJogada(JogoMancala jogo) throws MancalaException;
}

