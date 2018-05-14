/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ciência da Computação
 * Departamento de Sistemas e Computação
 * Universidade Federal da Paraíba
 *
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 * Não redistribuir sem permissão.
 */

package p1.aplic.cartas;

import java.util.*;

/**
 * Um baralho para jogar Tarot.
 * As cartas de Tarot são diferentes das cartas comuns de várias formas.
 * Um baralho de Tarot tem 78 cartas:
 * A Minor Arcana tem 56 cartas (14 cartas de 4 naipes)
 * e a Major Arcana tem 22 cartas (22 cartas de figuras, sem naipes).
 *
 * @author Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
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
     * Recupera o valor da menor carta possível deste baralho.
     * É possível fazer um laço de menorValor() até maiorValor() para varrer
     * todos os valores possíveis de cartas.
     * @return O menor valor.
     */
    public int menorValor() {
        return CartaTarot.menorValor();
    }

    /**
     * Recupera o valor da maior carta possível deste baralho.
     * É possível fazer um laço de menorValor() até maiorValor() para varrer
     * todos os valores possíveis de cartas.
     * @return O maior valor.
     */
    public int maiorValor() {
        return CartaTarot.maiorValor();
    }

    /**
     * Recupera o "primeiro naipe" das cartas que podem estar no baralho.
     * Ser "primeiro naipe" não significa muita coisa, já que naipes não tem valor
     * (um naipe não é menor ou maior que o outro).
     * Fala-se de "primeiro naipe" e "último naipe" para poder
     * fazer um laço de primeiroNaipe() até últimoNaipe() para varrer
     * todos os naipes possíveis de cartas.
     * @return O primeiro naipe.
     */
    public int primeiroNaipe() {
        return CartaTarot.primeiroNaipe();
    }

    /**
     * Recupera o "último naipe" das cartas que podem estar no baralho.
     * Ser "último naipe" não significa muita coisa, já que naipes não tem valor
     * (um naipe não é menor ou maior que o outro).
     * Fala-se de "primeiro naipe" e "último naipe" para poder
     * fazer um laço de primeiroNaipe() até últimoNaipe() para varrer
     * todos os naipes possíveis de cartas.
     * @return O primeiro naipe.
     */
    public int últimoNaipe() {
        return CartaTarot.últimoNaipe();
    }
}
