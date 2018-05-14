/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ciência da Computação
 * Departamento de Sistemas e Computação
 * Universidade Federal da Paraíba
 *
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 * Não redistribuir sem permissão.
 */

package p1.io;
import java.io.*;

/**
 * Uma classe utilitária para entrada padrão.
 * Foi criada para:
 *	1. esconder excecoes para alunos principiantes
 *	2. dar mensagens de erro e ficar em loop com NumberFormatException
 *
 * @see	  p1.io.PromptingReader
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */

public class Entrada {
	/** O Reader usado para a entrada */
	public static final PromptingReaderSemExcecao in = new PromptingReaderSemExcecao(new InputStreamReader(System.in));

	public static void main(String[] args) {
		in.testar(); // sem capturar exceções, pois exceções não devem chegar até aqui
	}
}
