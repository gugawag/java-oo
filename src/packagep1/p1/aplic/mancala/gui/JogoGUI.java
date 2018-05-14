/*
 * Desenvolvido para a disciplina Programacao 2
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */
package p1.aplic.mancala.gui;
import p1.aplic.mancala.jogo.*;
import java.awt.*;
import java.applet.*;

/**
 *
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 */
public class JogoGUI extends Applet {
  JogoMancala jogo;
  public void init() {
    Jogador j1 = criaJogador(getParameter("jogador1"), Tabuleiro.EM_BAIXO);
    Jogador j2 = criaJogador(getParameter("jogador2"), Tabuleiro.EM_CIMA);
    jogo = new UmJogo(j1, j2);
    jogo.addMancalaListener(new OutputMancalaGUI());
  }
  public void start() {
    jogo.iniciaJogo();
  }

  private Jogador criaJogador(String nome, int posi��o) {
    if(nome.equals("ENIAC")) {
      return new JogadorComputador1(nome, posi��o);
    } else if(nome.equals("PDP11")) {
      return new JogadorComputador2(nome, posi��o);
    } else {
      return new JogadorHumanoGUI(nome, posi��o);
    }
  }

  public static void main(String[] args) {
    // ver TIJ p 647
  }
}

