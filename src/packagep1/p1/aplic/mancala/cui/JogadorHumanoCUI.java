/*
 * Desenvolvido para a disciplina Programacao 2
 * Curso de Bacharelado em Ciência da Computação
 * Departamento de Sistemas e Computação
 * Universidade Federal da Paraíba
 *
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 * Não redistribuir sem permissão.
 */
package p1.aplic.mancala.cui;
import p1.aplic.mancala.jogo.*;
import p1.io.*;

/**
 * Interface a caractere para jogar Mancala.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 */
public class JogadorHumanoCUI extends JogadorAbstrato {
  /**
   * Construtor de um jogador humano com interface a caractere.
   *
   * @param   nome   O nome do jogador.
   * @param   posição   A posição do jogador (EM_BAIXO ou EM_CIMA).
   */
  public JogadorHumanoCUI(String nome, int posição) {
    super(nome, posição);
  }

  /**
   * Pede ao jogador, na entrada padrão, para escolher um buraco para jogar.
   *
   * @param   jogo   O jogo do qual o jogador está participando.
   * @return  O número do buraco (entre 0 e 5)
   * @throws  MancalaException se o buraco escolhido não for possível.
   */
  public int escolheJogada(JogoMancala jogo) throws MancalaException {
    String resp;
    boolean ok = false;
    int numBuraco = 0;
    while(!ok) {
      resp = Entrada.in.lerLinha("Jogador " + getNome() + ": informe o numero do buraco: ");
      if(resp.startsWith("q")) {
        throw new MancalaException("Jogador " + getNome() + " abandonou o jogo. Tchau.");
      }
      try {
        numBuraco = jogo.getTabuleiro().numAIndex(Integer.parseInt(resp)-1, this.getPosição());
        ok = true;
      } catch(NumberFormatException e) {
        System.out.println("Tente algo numerico, ta?");
      } catch(MancalaException e) {
        System.out.println(e.getMessage());
      }
    }
    return numBuraco;
  }
}
