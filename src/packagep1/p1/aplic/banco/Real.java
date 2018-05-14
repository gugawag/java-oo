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
import java.io.*;

/**
 * A moeda Real (Brasil). O importante aqui � o m�todo toString que
 * sabe o s�mbolo da moeda (R$).
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */

public class Real extends Moeda implements Serializable {

  /**
   * Controi um valor 0.0 em moeda Real
   */
  public Real() {
    this(0.0);
  }

  /**
   * Controi um valor em moeda Real.
   * @param valor O valor em reais.
   */
  public Real(double valor) {
    super(valor);
  }

  /**
   * Representa o valor da moeda como string
   */
  public String toString() {
    String resultado = "R$";
    long centavos = getCentavos();
    if(centavos < 0) {
      resultado += "-";
      centavos = -centavos;
    }
    long cent = centavos % 100;
    resultado += centavos/100 + "," + (cent < 10 ? "0" : "") + cent;
    return resultado;
  }
}
