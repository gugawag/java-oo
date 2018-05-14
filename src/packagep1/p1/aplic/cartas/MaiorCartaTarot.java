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
 * O jogo de Maior Carta, mas com baralho de Tarot.
 * Uma boa demosntra��o da vantagem de Factory Methods.
 *
 * @author Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */
public class MaiorCartaTarot extends MaiorCarta {
    /**
     * Cria um baralho para jogar o jogo
     * @return O baralho.
     */
    protected Baralho criaBaralho() {
        return new BaralhoTarot();
    }
}
