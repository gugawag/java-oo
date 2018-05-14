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

/**
 * Uma carta de um baralho para jogar poquer.
 * Uma diferen�a com uma carta comum � que o AS vale mais que o Rei no poquer.
 * A outra diferen�a � que cartas de poquer n�o podem ter valor 2, 3, 4, 5.
 *
 * @author Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
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
        // n�o verifica o valor para n�o lan�ar exce��o,
        // j� que esta classe � para principiantes em programa��o
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
    // novo toString � identico ao de Carta mas acessa arrays diferentes!
    // por isso, seu c�digo � repetido aqui
    // n�o precisariamos disso se tivessemos polimorfismo de arrays em Java
	public String toString() {
		return nomeDeCarta[getValor()] + " de " + nomeDeNaipe[getNaipe()];
	}
}
