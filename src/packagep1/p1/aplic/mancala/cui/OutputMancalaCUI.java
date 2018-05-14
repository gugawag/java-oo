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
import java.util.*; 

/**
 * Classe que recebe os eventos de jogo e fornece a saída
 * com interface a caractere.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 */
public class OutputMancalaCUI implements MancalaListener {

  /**
   * Recebe o evento de início de jogo.
   *
   * @param   evento   O evento INICIO_DE_JOGO.
   *                   O evento contém o jogo fonte e o primeiro jogador.
   */
  public void inicioDeJogo(MancalaEvent evento) {
    JogoMancala jogo = (JogoMancala)evento.getSource();
    mostraTabuleiro(jogo, evento.getJogadorAtual());
  }

  /**
   * Recebe o evento de jogada feita.
   *
   * @param   evento   O evento JOGADOR_JOGOU.
   *                   O evento contém o jogo fonte,
   *                   o buraco jogado, quem jogou,
   *                   e o próximo jogador.
   */
  public void jogadorJogou(MancalaEvent evento) {
    JogoMancala jogo = (JogoMancala)evento.getSource();
    System.out.println("Jogador " + evento.getJogadorQueJogou().getNome() +
                       " jogou buraco " + (evento.getBuraco().getNúmero()+1));
    mostraTabuleiro(jogo, evento.getJogadorAtual());
  }

  /**
   * Recebe o evento de fim de jogo.
   *
   * @param   evento   O evento FIM_DE_JOGO.
   *                   O evento contém o jogo fonte,
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
   * Desenha o tabuleiro na saída.
   *
   * @param   jogo   O jogo sendo jogado.
   * @param   jogadorAtual   O próximo jogadora jogar.
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
      System.out.print( buraco.getNúmeroDeSementes() + "  " );
      espacoLinhaMancala += "   ";
    }
    mostraJogador(jogo.getJogador(1), jogadorAtual, jogo);

    // linha das mancalas
    System.out.print(jogo.getKalaha(jogo.getJogador(1)).getNúmeroDeSementes() + "   " );
    System.out.print( espacoLinhaMancala );
    System.out.println(jogo.getKalaha(jogo.getJogador(0)).getNúmeroDeSementes());

    // linha de buracos do jogador de baixo
    System.out.print( "   " );
    for(int i = 0; i < Tabuleiro.NUM_BURACOS; i++) {
      Buraco buraco = jogo.getTabuleiro().getBuraco(Tabuleiro.EM_BAIXO, i);
      System.out.print( buraco.getNúmeroDeSementes() + "  " );
      espacoLinhaMancala += "   ";
    }
    mostraJogador(jogo.getJogador(0), jogadorAtual, jogo);
    System.out.println(SEPARADOR);
    System.out.println("   1  2  3  4  5  6");
    p1.io.Entrada.in.lerLinha();
  }

  /**
   * Imprima a informação de um jogador na saída.
   *
   * @param   jogador   O jogador sendo impresso.
   * @param   jogadorAtual   Quem é o próximo jogador a jogar no jogo.
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

