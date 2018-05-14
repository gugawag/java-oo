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
 * Um baralho para jogar poquer.
 * Num baralho de poquer, tem 36 cartas: 9 valores (6, 7, 8, 9, 10, valete, dama, rei, as)
 * de 4 naipes (ouros, espadas, copas, paus).
 *
 * @author Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */
public class BaralhoPoquer extends Baralho {
    /**
     * Cria uma carta para este baralho.
     * @param valor O valor da carta a criar.
     * @param naipe O naipe da carta a criar.
     * @return A carta criada.
     */
    // Factory Method permite criar um novo baralho (com cartas diferentes)
    // sem mudar o cliente do baralho
    protected Carta criaCarta(int valor, int naipe) {
        return new CartaPoquer(valor, naipe);
    }

    /**
     * Recupera o valor da menor carta poss�vel deste baralho.
     * � poss�vel fazer um la�o de menorValor() at� maiorValor() para varrer
     * todos os valores poss�veis de cartas.
     * @return O menor valor.
     */
    public int menorValor() {
        return CartaPoquer.menorValor();
    }

    /**
     * Recupera o valor da maior carta poss�vel deste baralho.
     * � poss�vel fazer um la�o de menorValor() at� maiorValor() para varrer
     * todos os valores poss�veis de cartas.
     * @return O maior valor.
     */
    public int maiorValor() {
        return CartaPoquer.maiorValor();
    }
}
