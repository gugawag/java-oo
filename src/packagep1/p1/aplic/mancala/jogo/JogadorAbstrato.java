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
 * A parte comum de qualquer jogador: manter nome e posi��o (EM_BAIXO ou EM_CIMA).
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 */
public abstract class JogadorAbstrato implements Jogador {
  private String nome;
  private int posi��o;

  /**
   * Construtor gen�rico de um jogador.
   *
   * @param   nome   O nome do jogador.
   * @param   posi��o   A posi��o do jogador (EM_BAIXO ou EM_CIMA).
   */
  public JogadorAbstrato(String nome, int posi��o) {
    this.nome = nome;
    this.posi��o = posi��o;
  }

  /**
   * Obt�m o nome do jogador.
   *
   * @return  O nome do jogador
   */
  public String getNome() {
    return nome;
  }

  /**
   * Informa a posi��o do jogador.
   *
   * @return  A posi��o do jogador (EM_BAIXO ou EM_CIMA)
   */
  public int getPosi��o() {
    return posi��o;
  }

  /**
   * Pede ao jogador para escolher um buraco para jogar.
   *
   * @param   jogo   O jogo do qual o jogador est� participando.
   * @return  O n�mero do buraco (entre 0 e 5)
   * @throws  MancalaException se o buraco escolhido n�o for poss�vel.
   */
  public abstract int escolheJogada(JogoMancala jogo) throws MancalaException;
}

