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

/**
 * Uma carta de um baralho para jogar poquer.
 * Uma diferença com uma carta comum é que o AS vale mais que o Rei no poquer.
 * A outra diferença é que cartas de poquer não podem ter valor 2, 3, 4, 5.
 *
 * @author Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */
public class CartaPoquer extends Carta {
    /**
     * Valor da carta AS. Usado para construir uma carta: new Carta(Carta.AS, Carta.PAUS)
     * O AS no poquer vale mais que o REI
     */
	public static final int AS = 14;

    /**
     * Construtor de uma carta de poquer
     * @param valor O valor da carta (6, 7, 8, 9, 10, VALETE, DAMA, REI, AS).
     * @param naipe O naipe da carta (PAUS, OUROS, COPAS, ESPADAS).
     */
	public CartaPoquer(int valor, int naipe) {
        // não verifica o valor para não lançar exceção,
        // já que esta classe é para principiantes em programação
        super(valor, naipe);
	}

   	protected static final String[] nomeDeCarta = {
        "",
        "",
        "",
        "",
        "",
        "",
		"SEIS",
		"SETE",
		"OITO",
		"NOVE",
		"DEZ",
		"VALETE",
		"DAMA",
		"REI",
        "AS",
	};

    public static int menorValor() {
        return 6;
    }

    public static int maiorValor() {
        return AS;
    }

    /**
     * Representa a carta como String.
     * @return Um string representando a carta.
     */
    // novo toString é identico ao de Carta mas acessa arrays diferentes!
    // por isso, seu código é repetido aqui
    // não precisariamos disso se tivessemos polimorfismo de arrays em Java
	public String toString() {
		return nomeDeCarta[getValor()] + " de " + nomeDeNaipe[getNaipe()];
	}
}
