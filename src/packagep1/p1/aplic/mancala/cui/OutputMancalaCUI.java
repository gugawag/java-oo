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
import java.util.*; 

/**
 * Classe que recebe os eventos de jogo e fornece a sa�da
 * com interface a caractere.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 */
public class OutputMancalaCUI implements MancalaListener {

  /**
   * Recebe o evento de in�cio de jogo.
   *
   * @param   evento   O evento INICIO_DE_JOGO.
   *                   O evento cont�m o jogo fonte e o primeiro jogador.
   */
  public void inicioDeJogo(MancalaEvent evento) {
    JogoMancala jogo = (JogoMancala)evento.getSource();
    mostraTabuleiro(jogo, evento.getJogadorAtual());
  }

  /**
   * Recebe o evento de jogada feita.
   *
   * @param   evento   O evento JOGADOR_JOGOU.
   *                   O evento cont�m o jogo fonte,
   *                   o buraco jogado, quem jogou,
   *                   e o pr�ximo jogador.
   */
  public void jogadorJogou(MancalaEvent evento) {
    JogoMancala jogo = (JogoMancala)evento.getSource();
    System.out.println("Jogador " + evento.getJogadorQueJogou().getNome() +
                       " jogou buraco " + (evento.getBuraco().getN�mero()+1));
    mostraTabuleiro(jogo, evento.getJogadorAtual());
  }

  /**
   * Recebe o evento de fim de jogo.
   *
   * @param   evento   O evento FIM_DE_JOGO.
   *                   O evento cont�m o jogo fonte,
   *                   e quem jogou.
   */
  public void fimDeJogo(MancalaEvent evento) {
    JogoMancala jogo = (JogoMancala)evento.getSource();
    System.out.println();
    System.out.println("Fim do jogo");
    mostraTabuleiro(jogo, evento.getJogadorAtual());
    System.out.println();
    if(jogo.getGanhador() == null) {
      System.out.println("Empate!");
    } else {
      System.out.println("Jogador " + jogo.getGanhador().getNome() + " ganhou!");
    }
  }

  /**
   * Desenha o tabuleiro na sa�da.
   *
   * @param   jogo   O jogo sendo jogado.
   * @param   jogadorAtual   O pr�ximo jogadora jogar.
   */
  private void mostraTabuleiro(JogoMancala jogo, Jogador jogadorAtual) {
    final String SEPARADOR = "-----------------------";
    String espacoLinhaMancala = "";  // Usado para colocar espacos na linha
                                     // da mancala

    System.out.println("  13 12 11 10  9  8");
    System.out.println(SEPARADOR);
    // linha de buracos do jogador de cima
    System.out.print( "   " );
    for(int i = Tabuleiro.NUM_BURACOS-1; i >= 0; i--) {
      Buraco buraco = jogo.getTabuleiro().getBuraco(Tabuleiro.EM_CIMA, i);
      System.out.print( buraco.getN�meroDeSementes() + "  " );
      espacoLinhaMancala += "   ";
    }
    mostraJogador(jogo.getJogador(1), jogadorAtual, jogo);

    // linha das mancalas
    System.out.print(jogo.getKalaha(jogo.getJogador(1)).getN�meroDeSementes() + "   " );
    System.out.print( espacoLinhaMancala );
    System.out.println(jogo.getKalaha(jogo.getJogador(0)).getN�meroDeSementes());

    // linha de buracos do jogador de baixo
    System.out.print( "   " );
    for(int i = 0; i < Tabuleiro.NUM_BURACOS; i++) {
      Buraco buraco = jogo.getTabuleiro().getBuraco(Tabuleiro.EM_BAIXO, i);
      System.out.print( buraco.getN�meroDeSementes() + "  " );
      espacoLinhaMancala += "   ";
    }
    mostraJogador(jogo.getJogador(0), jogadorAtual, jogo);
    System.out.println(SEPARADOR);
    System.out.println("   1  2  3  4  5  6");
    p1.io.Entrada.in.lerLinha();
  }

  /**
   * Imprima a informa��o de um jogador na sa�da.
   *
   * @param   jogador   O jogador sendo impresso.
   * @param   jogadorAtual   Quem � o pr�ximo jogador a jogar no jogo.
   * @param   jogo   O jogo sendo jogado.
   */
  private void mostraJogador(Jogador jogador, Jogador jogadorAtual, JogoMancala jogo) {
    // indicador da vez
    if(jogador == jogadorAtual) {
      System.out.print( "            -->" );
    } else {
      System.out.print( "               ");
    }
    // informacao sobre o jogador
    System.out.println("Jogador " + jogador.getNome());
  }
}

