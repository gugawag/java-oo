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
 * Um jogador autom�tico mais-ou-menos razo�vel para jogar Mancala.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 */
public class JogadorComputador2 extends JogadorAbstrato {
  /**
   * Construtor de um jogador autom�tico (computador)
   * com algoritmo razo�vel para jogar.
   *
   * @param   nome   O nome do jogador.
   * @param   posi��o   A posi��o do jogador (EM_BAIXO ou EM_CIMA).
   */
  public JogadorComputador2(String nome, int posi��o) {
    super(nome, posi��o);
  }

  /**
   * Pede ao jogador para escolher um buraco para jogar.
   * A estrat�gia � razo�vel: tenta todos os buracos e escolhe o que
   * d� "melhor" resultado, numa avalia��o simples.
   *
   * @param   jogo   O jogo do qual o jogador est� participando.
   * @return  O n�mero do buraco (entre 0 e 5)
   * @throws  MancalaException se o buraco escolhido n�o for poss�vel.
   */
  public int escolheJogada(JogoMancala jogo) throws MancalaException {
    // Jogador eh computador: devemos determinar a melhor jogada
    int melhorJogada = -1;
    int jogadaComRepeti��o = -1;
    int maxPedrasAdicionais = -1;

    // tente as possiveis jogadas
    Tabuleiro tabuleiroOriginal = jogo.getTabuleiro();
    int sementesOriginais = jogo.getKalaha(this).getN�meroDeSementes();
    for(int i = 0; i < Tabuleiro.NUM_BURACOS; i++) {
      if(tabuleiroOriginal.getBuraco(getPosi��o(), i).getN�meroDeSementes() > 0) {
        Tabuleiro tabuleiroDeTeste = (Tabuleiro)tabuleiroOriginal.clone();
        jogo.setTabuleiro(tabuleiroDeTeste);
        if(jogo.umaJogada(i, JogoMancala.SEM_EVENTO) == this) {
          jogadaComRepeti��o = i;
        }
        int pedrasAdicionais = jogo.getKalaha(this).getN�meroDeSementes() -
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
    } else if(jogadaComRepeti��o >= 0) {
      return jogadaComRepeti��o;
    } else {
      return melhorJogada;
    }
  }
}

