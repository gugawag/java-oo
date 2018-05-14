import p1.aplic.banco;
/**
 * Classe de conta banc�ria simples.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */
public class ContaSimples1 {
  // atributos
  private String  nome;
  private String  cpf;
  private int     n�mero;
  private double  saldo;

  // construtor

  /**
   * Cria uma conta a partir de um nome e cpf de pessoa f�sica, e um n�mero de conta.
   * @param nome O nome do titular da conta.
   * @param cpf O CPF do titular da conta.
   * @param n�mero O n�mero da conta.
   */
  public ContaSimples1(String nome, String cpf, int n�mero) {
    this.nome = nome;
    this.cpf = cpf;
    this.n�mero = n�mero;
    saldo = 0.0;
  }

  // m�todos
  /**
   * Recupera o n�mero da conta.
   * @return O n�mero da conta.
   */
  public int getn�mero() {
    return n�mero;
  }

  /**
   * Recupera o nome do titular da conta.
   * @return O nome do titular da conta.
   */
  public String getNome() {
    return nome;
  }

  /**
   * Recupera o CPF do titular da conta.
   * @return O CPF do titular da conta.
   */
  public String getCPF() {
    return cpf;
  }

  /**
   * Recupera o saldo da conta.
   * @return O saldo da conta.
   */
  public double getSaldo() {
    return saldo;
  }

  /**
   * Efetua um dep�sito numa conta.
   * @param valor O valor a depositar.
   */
  public void depositar(double valor) {
    // credita a conta
    saldo += valor;
  }

  /**
   * Efetua sacada na conta.
   * @param valor O valor a sacar.
   * @return O sucesso ou n�o da opera��o.
   */
  public boolean sacar(double valor) {
    // debita a conta
    if(saldo - valor >= 0) {
      saldo -= valor;
      return true;
    } else {
      return false;
    }
  }

  /**
   * Transforma os dados da conta em um String.
   * @return O string com os dados da conta.
   */
  public String toString() {
    return "n�mero " + n�mero
            + ", nome " + nome
            + ", saldo " + saldo;
  }
}
