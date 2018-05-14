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
import p1.io.*;

/**
 *
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 */
public class JogadorHumanoGUI extends JogadorAbstrato {
  public JogadorHumanoGUI(String nome, int posi��o) {
    super(nome, posi��o);
  }

  public int escolheJogada(JogoMancala jogo) throws MancalaException {
    return 0;
  }
}
