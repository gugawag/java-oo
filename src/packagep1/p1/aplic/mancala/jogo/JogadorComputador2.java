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
 * Um jogador automático mais-ou-menos razoável para jogar Mancala.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 */
public class JogadorComputador2 extends JogadorAbstrato {
  /**
   * Construtor de um jogador automático (computador)
   * com algoritmo razoável para jogar.
   *
   * @param   nome   O nome do jogador.
   * @param   posição   A posição do jogador (EM_BAIXO ou EM_CIMA).
   */
  public JogadorComputador2(String nome, int posição) {
    super(nome, posição);
  }

  /**
   * Pede ao jogador para escolher um buraco para jogar.
   * A estratégia é razoável: tenta todos os buracos e escolhe o que
   * dá "melhor" resultado, numa avaliação simples.
   *
   * @param   jogo   O jogo do qual o jogador está participando.
   * @return  O número do buraco (entre 0 e 5)
   * @throws  MancalaException se o buraco escolhido não for possível.
   */
  public int escolheJogada(JogoMancala jogo) throws MancalaException {
    // Jogador eh computador: devemos determinar a melhor jogada
    int melhorJogada = -1;
    int jogadaComRepetição = -1;
    int maxPedrasAdicionais = -1;

    // tente as possiveis jogadas
    Tabuleiro tabuleiroOriginal = jogo.getTabuleiro();
    int sementesOriginais = jogo.getKalaha(this).getNúmeroDeSementes();
    for(int i = 0; i < Tabuleiro.NUM_BURACOS; i++) {
      if(tabuleiroOriginal.getBuraco(getPosição(), i).getNúmeroDeSementes() > 0) {
        Tabuleiro tabuleiroDeTeste = (Tabuleiro)tabuleiroOriginal.clone();
        jogo.setTabuleiro(tabuleiroDeTeste);
        if(jogo.umaJogada(i, JogoMancala.SEM_EVENTO) == this) {
          jogadaComRepetição = i;
        }
        int pedrasAdicionais = jogo.getKalaha(this).getNúmeroDeSementes() -
                               sementesOriginais;
        if( pedrasAdicionais > maxPedrasAdicionais ) {
          maxPedrasAdicionais = pedrasAdicionais;
          melhorJogada = i;
        }
      }
    }
    jogo.setTabuleiro(tabuleiroOriginal);

    // tentamos todas as possibilidades: escolhe a melhor
    if(maxPedrasAdicionais > 1) {
      return melhorJogada;
    } else if(jogadaComRepetição >= 0) {
      return jogadaComRepetição;
    } else {
      return melhorJogada;
    }
  }
}

