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
 * Interface de um jogador, seja humano ou computador,
 * apoiado em interface gráfica ou textual.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 */
public interface Jogador {
  /**
   * Obtém o nome do jogador.
   *
   * @return  O nome do jogador
   */
  String getNome();

  /**
   * Informa a posição do jogador.
   *
   * @return  A posição do jogador (EM_BAIXO ou EM_CIMA)
   */
  int getPosição();

  /**
   * Pede ao jogador para escolher um buraco para jogar.
   *
   * @param   jogo   O jogo do qual o jogador está participando.
   * @return  O número do buraco (entre 0 e 5)
   * @throws  MancalaException se o buraco escolhido não for possível.
   */
  int escolheJogada(JogoMancala jogo) throws MancalaException;
}

