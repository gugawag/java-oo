/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */
package p1.aplic.banco;

import java.util.*;
import java.io.*;

/**
 * Classe que implementa um movimento de transa��es.
 * Um movimento � apenas uma s�rie de transa��es feitas.
 * Todas as transa��es devem entrar aqui em ordem cronol�gica.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */
public class Movimento implements Serializable {
    static final long serialVersionUID = 6598108299168173551L;
    // a cole��o deve manter a ordem de inser��o
	private Vector transa��es;

	// Construtores
    /**
     * Controi um Movimento vazio (sem transa��es).
     */
	public Movimento() {
		transa��es = new Vector();
	}

	/**
	 * Adiciona uma transa��es ao movimento.
	 * @param transa��o A transa��o a adicionar ao movimento.
	 */
	public void add(Transacao transa��o) {
		transa��es.add(transa��o);
	}

	/**
	 * Fornece um Iterator para varrer as transa��es por data.
	 * @return O Iterator.
	 */
	public Iterator getTransa��es() {
		return transa��es.iterator();
	}
}
