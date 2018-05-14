/*
 * Desenvolvido para a disciplina Programacao 2
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */
package p1.aplic.mancala.cui;
import p1.aplic.mancala.jogo.*;
import p1.io.*;

/**
 * Interface a caractere para jogar Mancala.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 */
public class JogadorHumanoCUI extends JogadorAbstrato {
  /**
   * Construtor de um jogador humano com interface a caractere.
   *
   * @param   nome   O nome do jogador.
   * @param   posi��o   A posi��o do jogador (EM_BAIXO ou EM_CIMA).
   */
  public JogadorHumanoCUI(String nome, int posi��o) {
    super(nome, posi��o);
  }

  /**
   * Pede ao jogador, na entrada padr�o, para escolher um buraco para jogar.
   *
   * @param   jogo   O jogo do qual o jogador est� participando.
   * @return  O n�mero do buraco (entre 0 e 5)
   * @throws  MancalaException se o buraco escolhido n�o for poss�vel.
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
        numBuraco = jogo.getTabuleiro().numAIndex(Integer.parseInt(resp)-1, this.getPosi��o());
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
