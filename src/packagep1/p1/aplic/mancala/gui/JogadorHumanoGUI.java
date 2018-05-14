/*
 * Desenvolvido para a disciplina Programacao 2
 * Curso de Bacharelado em Ciência da Computação
 * Departamento de Sistemas e Computação
 * Universidade Federal da Paraíba
 *
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 * Não redistribuir sem permissão.
 */
package p1.aplic.mancala.gui;
import p1.aplic.mancala.jogo.*;
import p1.io.*;

/**
 *
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 */
public class JogadorHumanoGUI extends JogadorAbstrato {
  public JogadorHumanoGUI(String nome, int posição) {
    super(nome, posição);
  }

  public int escolheJogada(JogoMancala jogo) throws MancalaException {
    return 0;
  }
}
