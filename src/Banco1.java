/*
 * Movimenta��o simples de uma conta banc�ria
 */

// Precisaremos usar classes j� prontas no programa
// Aqui, estamos trazendo essas classes para "dentro" do nosso programa
import p1.aplic.banco.*; // para poder manusear contas banc�rias

// Programa Banco1
public class Banco1 {
	// O programa sempre tem um "m�todo" main que � onde come�a a execu��o
	public static void main(String args[]) {
		// Abra uma conta de n�mero 1 para Jo�o com CPF 309140605-06
		// A conta ser� "referenciada" com a vari�vel umaConta
		ContaSimples umaConta = new ContaSimples("Joao", "30914060506", 1);
		// Nesta conta, deposite R$1000,00
		umaConta.depositar(1000.0);

		// Imprima o saldo da conta de Jo�o
		double saldo = umaConta.getSaldo();
		System.out.print("Saldo da conta de Joao antes do saque: ");
		System.out.println(saldo);

		// Saque R$300,00 desta conta
		umaConta.sacar(300.0);
		// Imprima o objeto umaConta
		System.out.println(umaConta);
		// Imprima o saldo da conta de Jo�o
		System.out.println("Saldo da conta de Joao depois do saque: "
				+ umaConta.getSaldo());
	} // fim do m�todo main
} // fim da classe Banco1
