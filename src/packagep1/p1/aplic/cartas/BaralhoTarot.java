/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */

package p1.aplic.cartas;

import java.util.*;

/**
 * Um baralho para jogar Tarot.
 * As cartas de Tarot s�o diferentes das cartas comuns de v�rias formas.
 * Um baralho de Tarot tem 78 cartas:
 * A Minor Arcana tem 56 cartas (14 cartas de 4 naipes)
 * e a Major Arcana tem 22 cartas (22 cartas de figuras, sem naipes).
 *
 * @author Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */
public class BaralhoTarot extends Baralho {
    /**
     * Cria um baralho de Tarot.
     */
	public BaralhoTarot() {
        super(); // cria minor Arcana
        // cria Major Arcana
		for(int valor = CartaTarot.ONE; valor <= CartaTarot.FOOL; valor++) {
            super.baralho.add(criaCarta(valor, CartaTarot.MAJOR_ARCANA));
        }
    }

    /**
     * Cria uma carta para este baralho.
     * @param valor O valor da carta a criar.
     * @param naipe O naipe da carta a criar.
     * @return A carta criada.
     */
    // Factory Method permite criar um novo baralho (com cartas diferentes)
    // sem mudar o cliente do baralho
    protected Carta criaCarta(int valor, int naipe) {
        return new CartaTarot(valor, naipe);
    }

    /**
     * Recupera o valor da menor carta poss�vel deste baralho.
     * � poss�vel fazer um la�o de menorValor() at� maiorValor() para varrer
     * todos os valores poss�veis de cartas.
     * @return O menor valor.
     */
    public int menorValor() {
        return CartaTarot.menorValor();
    }

    /**
     * Recupera o valor da maior carta poss�vel deste baralho.
     * � poss�vel fazer um la�o de menorValor() at� maiorValor() para varrer
     * todos os valores poss�veis de cartas.
     * @return O maior valor.
     */
    public int maiorValor() {
        return CartaTarot.maiorValor();
    }

    /**
     * Recupera o "primeiro naipe" das cartas que podem estar no baralho.
     * Ser "primeiro naipe" n�o significa muita coisa, j� que naipes n�o tem valor
     * (um naipe n�o � menor ou maior que o outro).
     * Fala-se de "primeiro naipe" e "�ltimo naipe" para poder
     * fazer um la�o de primeiroNaipe() at� �ltimoNaipe() para varrer
     * todos os naipes poss�veis de cartas.
     * @return O primeiro naipe.
     */
    public int primeiroNaipe() {
        return CartaTarot.primeiroNaipe();
    }

    /**
     * Recupera o "�ltimo naipe" das cartas que podem estar no baralho.
     * Ser "�ltimo naipe" n�o significa muita coisa, j� que naipes n�o tem valor
     * (um naipe n�o � menor ou maior que o outro).
     * Fala-se de "primeiro naipe" e "�ltimo naipe" para poder
     * fazer um la�o de primeiroNaipe() at� �ltimoNaipe() para varrer
     * todos os naipes poss�veis de cartas.
     * @return O primeiro naipe.
     */
    public int �ltimoNaipe() {
        return CartaTarot.�ltimoNaipe();
    }
}
