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
 * Uma classe utilitária para entrada e saída padrão.
 * Contém streams estáticos in, out, err
 * Foi criado para que "in" fosse un Reader e não um InputStream
 * porque InputStream não tem um metodo readLine().
 * Também se queria uma solução em português para os alunos principiantes
 * entenderem que isso <I>não</I> é Java comum.
 * Os streams out e err foram adicionados para manter a uniformidade.<p>
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */

public class Console {
	/** Um Reader que permite chamar readLine() da entrada padrão */
	public static final PromptingReader in = new PromptingReader(new InputStreamReader(System.in));
	/** Um Writer para a saída padrão */
	public static final PrintWriter out = new PrintWriter(System.out, true); // com autoflush de println()
	/** Um Writer para a saída padrão de erros */
	public static final PrintWriter err = new PrintWriter(System.err, true);

	public static void main(String[] args) {
		try {
			in.testar();
		} catch(Exception e) {
			err.println(e);
		}
	}
}
