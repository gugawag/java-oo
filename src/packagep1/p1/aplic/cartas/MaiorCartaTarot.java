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
 * O jogo de Maior Carta, mas com baralho de Tarot.
 * Uma boa demosntração da vantagem de Factory Methods.
 *
 * @author Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
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
