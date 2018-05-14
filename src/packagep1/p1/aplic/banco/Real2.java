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
 * A moeda Real (Brasil). Tem corte autom�tico de fra��es de centavos.
 * O motivo da exist�ncia dessa classe � de permitir a manipula��o
 * de valores financeiros sem se preocupar com fra��es de centavos.
 * Classes clientes podem usar double para manipular valores mas,
 * ao passar tais valores para uma Moeda, as fra��es de centavos
 * somem.
 *
 * ****** Esta classe tem erros e serve para ensinar testes de unidade ******
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */

public class Real2 {
  private long  centavos;

  /**
   * Controi um valor 0.0 em moeda Real
   */
  public Real2() {
    this(0.0);
  }

  /**
   * Controi um valor em moeda Real.
   * @param valor O valor em reais.
   */
  public Real2(double valor) {
    setValor(valor);
  }

  /**
   * Recupera o valor como double.
   */
  public double getValor() {
    return centavos / 100.0;
  }

  /**
   * Ajusta o valor a ser representado como moeda.
   * @param valor O valor a representar como moeda.
   */
  public void setValor(double valor) {
    // Vai perder fra��es de centavos aqui
    // Ajustar 0.5 centavos � para arredondar ao
    // centavo mais pr�ximo
    // Tem um erro aqui (vide Moeda.java para ver o correto)
    setCentavos((long)(valor*100.0 + 0.5));
  }
  /**
   * Compara igualdade de duas moedas.
   * @param moeda O outro valor a comparar.
   */
  public boolean equals(Object moeda) {
    if(!(moeda instanceof Real2)) {
      return false;
    }
    return getValor() == ((Real2)moeda).getValor();
  }

  /**
   * Compara dois valores de moeda.
   * @param outra A outra moeda a comparar.
   * @return 0 se a moeda for igual � outra moeda; -1 se ela for menor e +1 se for maior.
   */
   public int compareTo(Real2 outra) {
     long diferen�a = getCentavos() - outra.getCentavos();
     return diferen�a == 0 ? 0 : (diferen�a < 0 ? -1 : 1);
   }

  /**
   * Representa o valor da moeda como string
   */
  public String toString() {
    String resultado = "R$";
    long centavos = getCentavos();
    long cent = centavos % 100;
    resultado += centavos/100 + "," + (cent < 10 ? "0" : "") + cent;
      return resultado;
  }
  protected long getCentavos() {
    return centavos;
  }
  protected void setCentavos(long centavos) {
    this.centavos = centavos;
  }
}
