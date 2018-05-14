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
 * Uma classe utilit�ria para entrada e sa�da padr�o.
 * Cont�m streams est�ticos in, out, err
 * Foi criado para que "in" fosse un Reader e n�o um InputStream
 * porque InputStream n�o tem um metodo readLine().
 * Tamb�m se queria uma solu��o em portugu�s para os alunos principiantes
 * entenderem que isso <I>n�o</I> � Java comum.
 * Os streams out e err foram adicionados para manter a uniformidade.<p>
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */

public class Console {
	/** Um Reader que permite chamar readLine() da entrada padr�o */
	public static final PromptingReader in = new PromptingReader(new InputStreamReader(System.in));
	/** Um Writer para a sa�da padr�o */
	public static final PrintWriter out = new PrintWriter(System.out, true); // com autoflush de println()
	/** Um Writer para a sa�da padr�o de erros */
	public static final PrintWriter err = new PrintWriter(System.err, true);

	public static void main(String[] args) {
		try {
			in.testar();
		} catch(Exception e) {
			err.println(e);
		}
	}
}
