/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */

package p1.io;
import java.io.*;

/**
 * Uma classe utilit�ria para entrada padr�o.
 * Foi criada para:
 *	1. esconder excecoes para alunos principiantes
 *	2. dar mensagens de erro e ficar em loop com NumberFormatException
 *
 * @see	  p1.io.PromptingReader
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */

public class Entrada {
	/** O Reader usado para a entrada */
	public static final PromptingReaderSemExcecao in = new PromptingReaderSemExcecao(new InputStreamReader(System.in));

	public static void main(String[] args) {
		in.testar(); // sem capturar exce��es, pois exce��es n�o devem chegar at� aqui
	}
}
