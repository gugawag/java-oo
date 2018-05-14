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
 * Um baralho para jogar poquer.
 * Num baralho de poquer, tem 36 cartas: 9 valores (6, 7, 8, 9, 10, valete, dama, rei, as)
 * de 4 naipes (ouros, espadas, copas, paus).
 *
 * @author Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
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
     * Recupera o valor da menor carta possível deste baralho.
     * É possível fazer um laço de menorValor() até maiorValor() para varrer
     * todos os valores possíveis de cartas.
     * @return O menor valor.
     */
    public int menorValor() {
        return CartaPoquer.menorValor();
    }

    /**
     * Recupera o valor da maior carta possível deste baralho.
     * É possível fazer um laço de menorValor() até maiorValor() para varrer
     * todos os valores possíveis de cartas.
     * @return O maior valor.
     */
    public int maiorValor() {
        return CartaPoquer.maiorValor();
    }
}
