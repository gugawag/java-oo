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
 * Uma carta de um baralho para jogar Tarot.
 * Deixei as palavras em inglês aqui porque não as conheço em português.
 * As cartas de Tarot são diferentes das cartas comuns de várias formas.
 * Um baralho de tarot tem 78 cartas: A Minor Arcana tem 56 cartas
 * (14 cartas de 4 naipes) e a Major Arcana tem 22 cartas
 * (22 cartas de figuras, sem naipes).
 *
 * @author Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */
public class CartaTarot extends Carta {
	// Minor Arcana tem 14 cartas de 4 naipes (56 cartas)
    /**
     * Valor da carta ONE.
     */
	public static final int ONE = 1;
    /**
     * Valor da carta TWO.
     */
	public static final int TWO = 2;
    /**
     * Valor da carta THREE.
     */
	public static final int THREE = 3;
    /**
     * Valor da carta FOUR.
     */
	public static final int FOUR = 4;
    /**
     * Valor da carta FIVE.
     */
	public static final int FIVE = 5;
    /**
     * Valor da carta SIX.
     */
	public static final int SIX = 6;
    /**
     * Valor da carta SEVEN.
     */
	public static final int SEVEN = 7;
    /**
     * Valor da carta EIGHT.
     */
	public static final int EIGHT = 8;
    /**
     * Valor da carta NINE.
     */
	public static final int NINE = 9;
    /**
     * Valor da carta TEN.
     */
	public static final int TEN = 10;
    /**
     * Valor da carta PAGE.
     */
	public static final int PAGE = 11;
    /**
     * Valor da carta KNIGHT.
     */
	public static final int KNIGHT = 12;
    /**
     * Valor da carta QUEEN.
     */
	public static final int QUEEN = 13;
    /**
     * Valor da carta KING.
     */
	public static final int KING = 14;

	// Major Arcana (22 cartas com figuras simbolicas)
    // ONE ate TWENTY-ONE e FOOL (nao tem vários naipes aqui, mas usaremos "naipe" MAJOR_ARCANA)
    /**
     * Valor da carta ELEVEN.
     */
	public static final int ELEVEN = 11;
    /**
     * Valor da carta TWELVE.
     */
	public static final int TWELVE = 12;
    /**
     * Valor da carta THIRTEEN.
     */
	public static final int THIRTEEN = 13;
    /**
     * Valor da carta FOURTEEN.
     */
	public static final int FOURTEEN = 14;
    /**
     * Valor da carta FIFTEEN.
     */
	public static final int FIFTEEN = 15;
    /**
     * Valor da carta SIXTEEN.
     */
	public static final int SIXTEEN = 16;
    /**
     * Valor da carta SEVENTEEN.
     */
	public static final int SEVENTEEN = 17;
    /**
     * Valor da carta EIGHTTEEN.
     */
	public static final int EIGHTEEN = 18;
    /**
     * Valor da carta NINETEEN.
     */
	public static final int NINETEEN = 19;
    /**
     * Valor da carta TWENTY.
     */
	public static final int TWENTY = 20;
    /**
     * Valor da carta TWENTY-ONE.
     */
	public static final int TWENTY_ONE = 21;
    /**
     * Valor da carta FOOL.
     */
	public static final int FOOL = 22;

    /**
     * Valor do naipe WANDS.
     */
	public static final int WANDS = 0;     // 4 naipes com 14 cartas cada
    /**
     * Valor do naipe PENTACLES
     */
	public static final int PENTACLES = 1;
    /**
     * Valor do naipe CUPS
     */
	public static final int CUPS = 2;
    /**
     * Valor do naipe SWORDS
     */
	public static final int SWORDS = 3;
    /**
     * Valor do "naipe" MAJOR_ARCANA. Não é um naipe, mas é usado na construção
     * da carta para especificar uma carta da MAJOR ARCANA.
     */
	public static final int MAJOR_ARCANA = 4;  // naipe especial para 22 cartas da major arcana

    /**
     * Construtor de uma carta de tarot.
     * @param valor O valor da carta (ONE, ...TWENTY-ONE, PAGE, KNIGHT, QUEEN, KING, FOOL).
     * @param naipe O naipe da carta (WANDS, PENTACLES, CUPS, SWORDS).
     */
	public CartaTarot(int valor, int naipe) {
        super(valor, naipe);
	}

    /**
     * Compare esta carta a outra. Major Arcana é considerado maior que
     * qualquer carta da Minor Arcana. Dentro de cada Arcana, o valor da carta
     * dita qual é maior.
     * @param outra A carta a comparar a esta.
     * @return Zero se forem iguais. Um valor < 0 se a carta for menor que a outra carta.
     * Um valor > 0 se a carta for maior que a outra carta.
     */
    public int compareTo(CartaTarot outra) {
        int naipe = getNaipe();
        int outroNaipe = outra.getNaipe();
        if(naipe != MAJOR_ARCANA && outroNaipe != MAJOR_ARCANA) {
            return getValor() - outra.getValor();
        } else if(naipe != MAJOR_ARCANA && outroNaipe == MAJOR_ARCANA) {
            return -1;
        } else if(naipe == MAJOR_ARCANA && outroNaipe != MAJOR_ARCANA) {
            return 1;
        } else { // naipe == MAJOR_ARCANA && outroNaipe == MAJOR_ARCANA
            return getValor() - outra.getValor();
        }
    }

   	private static final String[] nomeDeCartaMinorArcana = {
		"",
		"ONE",
		"TWO",
		"THREE",
		"FOUR",
		"FIVE",
		"SIX",
		"SEVEN",
		"EIGHT",
		"NINE",
		"TEN",
		"PAGE",
		"KNIGHT",
		"QUEEN",
		"KING",
    };
   	private static final String[] nomeDeCartaMajorArcana = {
		"",
		"ONE",
		"TWO",
		"THREE",
		"FOUR",
		"FIVE",
		"SIX",
		"SEVEN",
		"EIGHT",
		"NINE",
		"TEN",
		"ELEVEN",
		"TWELVE",
		"THIRTEEN",
		"FOURTEEN",
		"FIFTEEN",
		"SIXTEEN",
		"SEVENTEEN", 
		"EIGHTEEN",
		"NINETEEN",
		"TWENTY",
		"TWENTY_ONE",
		"FOOL",
	};

	private static final String[] nomeDeNaipe = {
		"WANDS",
		"PENTACLES",
		"CUPS",
		"SWORDS",
		"MAJOR ARCANA",
	};

    /**
     * Recupera o valor da menor carta deste tipo que pode ser criada.
     * É possível fazer um laço de menorValor() até maiorValor() para varrer
     * todos os valores possíveis de cartas.
     * @return O menor valor.
     */
    public static int menorValor() {
        return ONE;
    }

    /**
     * Recupera o valor da maior carta deste tipo que pode ser criada.
     * É possível fazer um laço de menorValor() até maiorValor() para varrer
     * todos os valores possíveis de cartas.
     * @return O maior valor.
     */
    public static int maiorValor() {
        return KING;
    }

    /**
     * Recupera o "primeiro naipe" das cartas deste tipo.
     * Ser "primeiro naipe" não significa muita coisa, já que naipes não tem valor
     * (um naipe não é menor ou maior que o outro).
     * Fala-se de "primeiro naipe" e "último naipe" para poder
     * fazer um laço de primeiroNaipe() até últimoNaipe() para varrer
     * todos os naipes possíveis de cartas.
     * @return O primeiro naipe.
     */
    public static int primeiroNaipe() {
        return WANDS;
    }

    /**
     * Recupera o "último naipe" das cartas deste tipo.
     * Ser "último naipe" não significa muita coisa, já que naipes não tem valor
     * (um naipe não é menor ou maior que o outro).
     * Fala-se de "primeiro naipe" e "último naipe" para poder
     * fazer um laço de primeiroNaipe() até últimoNaipe() para varrer
     * todos os naipes possíveis de cartas.
     * @return O primeiro naipe.
     */
    public static int últimoNaipe() {
        return SWORDS;
    }

    /**
     * Representa a carta como String.
     * @return Um string representando a carta.
     */
	public String toString() {
        int naipe = getNaipe();
        int valor = getValor();
        if(naipe == MAJOR_ARCANA) {
    		return nomeDeCartaMajorArcana[valor] + " de " + nomeDeNaipe[naipe];
        } else {
    		return nomeDeCartaMinorArcana[valor] + " de " + nomeDeNaipe[naipe];
        }
	}
}

