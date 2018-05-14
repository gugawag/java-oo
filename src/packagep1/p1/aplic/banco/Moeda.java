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
 * Classe abstrata representando uma moeda gen�rica com centavos.
 * O motivo da exist�ncia dessa classe � de permitir a manipula��o
 * de valores financeiros sem se preocupar com fra��es de centavos.
 * Classes clientes podem usar double para manipular valores mas,
 * ao passar tais valores para uma Moeda, as fra��es de centavos
 * somem.
 * <P>A classe � abstrata porque n�o sabemos o nome da moeda e n�o temos portanto
 * um m�todo toString().
 *
 * @author Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1 (adicionei setCentavos)
 * <br>
 * Copyright (C) 1999, 2000 Universidade Federal da Para�ba.
 */

public abstract class Moeda implements Serializable {
  static final long serialVersionUID = -51315915643707243L;
  private long  centavos;

  /**
   * Controi um valor 0,0 como Moeda.
   */
  public Moeda() {
    this(0.0);
  }

  /**
   * Controi um valor como Moeda.
   * @param valor O valor a representar.
   */
  public Moeda(double valor) {
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
    if(valor >= 0) {
      this.centavos = (long)(valor*100.0 + 0.5);
    } else {
      this.centavos = (long)(valor*100.0 - 0.5);
    }
  }

  /**
   * Compara igualdade de duas moedas.
   * @param moeda O outro valor a comparar.
   */
  public boolean equals(Object outroObjeto) {
    if(!(outroObjeto instanceof Moeda)) {
      return false;
    }
    return getValor() == ((Moeda)outroObjeto).getValor();
  }

  /**
   * Compara dois valores de moeda.
   * @param outra A outra moeda a comparar.
   * @return 0 se a moeda for igual � outra moeda; -1 se ela for menor e +1 se for maior.
   */
   public int compareTo(Moeda outra) {
     long diferen�a = getCentavos() - outra.getCentavos();
     return diferen�a == 0 ? 0 : (diferen�a < 0 ? -1 : 1);
   }

  /**
   * Representa o valor da moeda como string.
   */
  public abstract String toString();

  protected long getCentavos() {
    return centavos;
  }
  protected void setCentavos(long centavos) {
    this.centavos = centavos;
  }
}