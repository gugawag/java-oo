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
 *
 * Regras deste jogo de Mancala (tamb�m chamado Kalaha).
 * Mancala � jogado com sete buracos -- seis buracos de jogo
 * e um buraco de pontua��o, a <I>Kalaha</I> -- por jogador.
 * No in�cio do jogo, cada um dos 12 buracos de jogo cont�m
 * 3 sementes (ou contas, ou pedras, ou bolas, ...).
 * Para jogar, o jogador escolhe um buraco a partir do qual ele
 * vai "semear" as sementes. Cada semente do buraco � colocada,
 * uma de cada vez, em buracos sucessivos, movendo-se em sentido
 * anti-hor�rio. Sementes colocadas numa Kalaha s�o pontos para
 * o dono da Kalaha. Sementes n�o s�o colocadas na Kalaha do oponente.
 * Se a �ltima semente cair na Kalaha do jogador, ele pode jogar novamente
 * Se a �ltima semente cair num buraco vazio do pr�prio jogador, 
  * ele captura as sementes do buraco oposto e as transfere para sua Kalaha
 * Todas as sementes capturadas, al�m da semente que fez a captura,
 * s�o colocadas na Kalaha do jogador.
 * O jogo termina quando todos os buracos em algum lado do tabuleiro estejam vazios.
 * O jogador com sementes em jogo os recolhe para sua Kalaha.
 * O ganhador � o jogador com mais sementes na sua Kalaha.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.0
 * <br>
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 */
public class UmJogo implements JogoMancala {
  private final static int SEMENTES_INICIAIS = 3;
  private Jogador[] jogadores;
  private Jogador jogadorAtual;
  private Tabuleiro tabuleiro;
  private Collection mancalaListeners = new LinkedList();

  /**
   * Construtor de um jogo de Mancala com dois jogadores.
   *
   * @param   jogador1   O primeiro jogador.
   * @param   jogador2   O segundo jogador.
   */
  public UmJogo(Jogador jogador1, Jogador jogador2) {
    jogadores = new Jogador[2];
    jogadores[0] = jogador1;
    jogadores[1] = jogador2;
    inicializaTabuleiro();
  }

  /**
   * Inicializa a configura��o do tabuleiro.
   * Neste jogo, temos 3 sementes em cada buraco (que n�o seja Kalaha).
   *
   */
  private void inicializaTabuleiro() {
    tabuleiro = new Tabuleiro();
    for(int i = 0; i < Tabuleiro.NUM_BURACOS; i++) {
      Buraco buraco = tabuleiro.getBuraco(Tabuleiro.EM_BAIXO, i);
      buraco.adicionaSementes(SEMENTES_INICIAIS);
      buraco = tabuleiro.getBuraco(Tabuleiro.EM_CIMA, i);
      buraco.adicionaSementes(SEMENTES_INICIAIS);
    }
  }

  /**
   * Obt�m o tabuleiro sendo usado para o jogo.
   *
   * @return  O tabuleiro sendo usado para o jogo.
   */
  public Tabuleiro getTabuleiro() {
    return tabuleiro;
  }

  /**
   * Altera o tabuleiro sendo usado para o jogo.
   *
   * @param   tabuleiro   O tabuleiro a usar.
   */
  public void setTabuleiro(Tabuleiro tabuleiro) {
    this.tabuleiro = tabuleiro;
  }

  /**
   * Obtem o jogador cuja vez � de jogar.
   *
   * @return  O jogador cuja vez � de jogar.
   */
  public Jogador getJogadorAtual() {
    return jogadorAtual;
  }

  /**
   * Obt�m um jogador atrav�s do seu n�mero. O jogador de baixo � 0, o de cima � 1.
   *
   * @param   n�meroDoJogador   o n�mero do jogador (0 = em baixo, 1 = em cima).
   * @return  O jogador indicado.
   */
  public Jogador getJogador(int n�meroDoJogador) {
    return jogadores[n�meroDoJogador];
  }

  /**
   * Obt�m o jogador que ganhou a partida.
   *
   * @return  O jogador que ganhou a partida, ou null se tiver sido empate.
   */
  public Jogador getGanhador() {
    int diferen�a = getKalaha(jogadores[0]).getN�meroDeSementes() -
                    getKalaha(jogadores[1]).getN�meroDeSementes();
    if(diferen�a > 0) {
      return jogadores[0];
    } else if(diferen�a < 0) {
      return jogadores[1];
    } else {
      return null; //empate
    }
  }

  /**
   * Obtem a Kalaha do jogador indicado.
   *
   * @param   jogador   O jogador cuja Kalaha se deseja.
   * @return  Uma refer�ncia ao buraco representando a Kalaha do jogador.
   */
  public Buraco getKalaha(Jogador jogador) {
    return tabuleiro.getKalaha(jogador.getPosi��o());
  }

  /**
   * Avisa ao jogo que queremos iniciar.
   *
   */
  public void iniciaJogo() {
    jogadorAtual = jogadores[0];
    disparaMancalaEvent(MancalaEvent.INICIO_DE_JOGO, null, jogadorAtual, null);
  }

  /**
   * Faz uma jogada para o jogadorAtual do jogo no buraco indicado por indexBuraco.
   * 
   * @param   indexBuraco   O �ndice (de 0 a 5) do buraco escolhido.
   * @param   querEvento   igual a SEM_EVENTO, para uma jogada que n�o aparecer na interface com o usu�rio.
   *          Seria o caso para estrat�gias de jogadores automatizados que querem tentar v�rias jogadas.
   *          Uma jogada normal (com efeito total) usa COM_EVENTO.
   * @return  O pr�ximo jogador a jogar.
   * @throws  MancalaException se um buraco ilegal for escolhido.
   */
  public Jogador umaJogada(int indexBuraco, int querEvento) throws MancalaException {
    Buraco buracoEscolhido = tabuleiro.getBuraco(jogadorAtual.getPosi��o(), indexBuraco);
    Buraco �ltimoBuraco = semeia(buracoEscolhido);
    Jogador quemJogou = jogadorAtual;
    Jogador pr�ximoJogador = jogadorAtual;
    // v� quem � o pr�ximo jogador
    if(!jogaNovamente(�ltimoBuraco)) {
       pr�ximoJogador = jogadorAtual.equals(jogadores[0]) ?
                        jogadores[1] : jogadores[0];
    }
    if(querEvento == COM_EVENTO) {
      jogadorAtual = pr�ximoJogador;
      // gera evento de mudan�a de tabuleiro
      disparaMancalaEvent(MancalaEvent.JOGADOR_JOGOU, buracoEscolhido, jogadorAtual, quemJogou);
    }
    return pr�ximoJogador;
  }

  /**
   * Informa se o jogador corrente pode jogar novamente
   *
   * @param   �ltimoBuraco   O �ltimo buraco em que uma semente caiu.
   * @return  true, se o jogador pode jogar novamente.
   */
  private boolean jogaNovamente(Buraco �ltimoBuraco) {
    return �ltimoBuraco.equals(getKalaha(jogadorAtual));
  }

  /**
   * Informa quem � o jogador oposto de um certo jogador.
   *
   * @param   jogador   O jogador cujo oponente procuramos.
   * @return  O oponente do jogador
   */
  private Jogador jogadorOposto(Jogador jogador) {
    return jogador.equals(jogadores[0]) ?
           jogadores[1] : jogadores[0];
  }

  /**
   * Espalha as sementes de um buraco como resultado de uma jogada e
   * aplica a regra de roubar as sementes opostas quando o �ltimo
   * buraco est� vazio e � do pr�prio jogador.
   *
   * @param   buracoEscolhido   O buraco escolhido para jogar.
   * @return  O �ltimo buraco onde uma semente foi depositada.
   */
  private Buraco semeia(Buraco buracoEscolhido) {
    int numSementes = buracoEscolhido.getN�meroDeSementes();
    buracoEscolhido.removeSementes(numSementes);
    Buraco buracoCorrente = buracoEscolhido;
    while(numSementes > 0) {
      buracoCorrente = tabuleiro.pr�ximoBuraco(buracoCorrente);
      if(buracoCorrente.equals(getKalaha(jogadorOposto(jogadorAtual)))) {
        continue; // n�o p�e semente na Kalaha do oponente
      }
      numSementes--;
      buracoCorrente.adicionaSementes(1);
    }
    // se o �ltimo buraco � meu e estava vazio, rouba sementes do buraco oposto
    if(tabuleiro.getPosi��o(buracoCorrente) == jogadorAtual.getPosi��o() &&
       buracoCorrente.getN�meroDeSementes() == 1) {
      // rouba
      Buraco buracoOposto = tabuleiro.buracoOposto(buracoCorrente);
      numSementes = buracoOposto.getN�meroDeSementes();
      buracoOposto.removeSementes(numSementes);
      getKalaha(jogadorAtual).adicionaSementes(numSementes);
    }
    return buracoCorrente;
  }

  /**
   * Verifica se o jogo acabou.
   *
   * @return  true, se o jogo acabou; false, caso contr�rio.
   */
  public boolean fimDeJogo() {
    if(tabuleiro.ladoEst�Vazio(Tabuleiro.EM_BAIXO) ||
       tabuleiro.ladoEst�Vazio(Tabuleiro.EM_CIMA)) {
      recolheSementes(jogadores[0]);
      recolheSementes(jogadores[1]);
      disparaMancalaEvent(MancalaEvent.FIM_DE_JOGO, null, null, null);
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * No fim do jogo, recolhe as sementes de um jogador para a Kalaha dele.
   *
   * @param   jogador   O jogador cujas sementes devem ser recolhidas � Kalaha.
   */
  private void recolheSementes(Jogador jogador) {
    for(int i = 0; i < Tabuleiro.NUM_BURACOS; i++) {
      Buraco buraco = tabuleiro.getBuraco(jogador.getPosi��o(), i);
      int numSementes = buraco.getN�meroDeSementes();
      buraco.removeSementes(numSementes);
      getKalaha(jogador).adicionaSementes(numSementes);
    }
  }

  /**
   * Adiciona um listener interessado em receber eventos do jogo.
   * Normalmente usado para conectar o jogo a uma interface com o usu�rio.
   *
   * @param   listener   O objeto que deseja receber os eventos do jogo.
   */
  public synchronized void addMancalaListener(MancalaListener l) {
    if(mancalaListeners.contains(l)) {
	    return;
    }
    mancalaListeners.add(l);
  }

  /**
   * Remove um listener n�o mais interessado em receber eventos do jogo.
   *
   * @param   listener   O listener a ser descadastrado.
   */
  public synchronized void removeMancalaListener(MancalaListener l) {
    mancalaListeners.remove(l);
  }

  /**
   * Envia um evento de jogo para todos os listeners cadastrados.
   * Os eventos podem indicar:
   * 1) o in�cio do jogo (INICIO_DE_JOGO);
   * 2) Uma jogada de algum jogador (JOGADOR_JOGOU);
   * 3) o fim do jogo (FIM_DE_JOGO).
   *
   * @param   oQueOcorreu   Indica um dos tr~es eventos acima.
   * @param   buraco   o buraco que foi jogado.
   * @param   jogadorAtual   O jogador que passa a ser o jogador atual.
   * @param   jogadorQueJogou   o jogador que acabou de jogar.
   */
  void disparaMancalaEvent(int oQueOcorreu, Buraco buraco, Jogador jogadorAtual, Jogador jogadorQueJogou) {
    Collection ml;
    MancalaEvent evento = new MancalaEvent(this, buraco, jogadorAtual, jogadorQueJogou);
    synchronized (this) {
      // A interface Collection n�o tem clone()
      // mas a classe LinkedList tem.
      // Clonar para evitar problemas de sincroniza��o
      // durante a propaga��o
      ml = (Collection)((LinkedList)mancalaListeners).clone();
    }
    Iterator it = ml.iterator();
    while(it.hasNext()) {
      MancalaListener umListener = (MancalaListener)(it.next());
      switch(oQueOcorreu) {
      case MancalaEvent.INICIO_DE_JOGO:
  	    umListener.inicioDeJogo(evento);
        break;
      case MancalaEvent.JOGADOR_JOGOU:
  	    umListener.jogadorJogou(evento);
        break;
      case MancalaEvent.FIM_DE_JOGO:
  	    umListener.fimDeJogo(evento);
        break;
      }
  	}
  }
}

