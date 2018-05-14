/*
 * Movimentação simples de uma conta bancária
 */

// Precisaremos usar classes já prontas no programa
// Aqui, estamos trazendo essas classes para "dentro" do nosso programa
import p1.aplic.banco.*; // para poder manusear contas bancárias

// Programa Banco1
public class Banco1 {
	// O programa sempre tem um "método" main que é onde começa a execução
	public static void main(String args[]) {
		// Abra uma conta de número 1 para João com CPF 309140605-06
		// A conta será "referenciada" com a variável umaConta
		ContaSimples umaConta = new ContaSimples("Joao", "30914060506", 1);
		// Nesta conta, deposite R$1000,00
		umaConta.depositar(1000.0);

		// Imprima o saldo da conta de João
		double saldo = umaConta.getSaldo();
		System.out.print("Saldo da conta de Joao antes do saque: ");
		System.out.println(saldo);

		// Saque R$300,00 desta conta
		umaConta.sacar(300.0);
		// Imprima o objeto umaConta
		System.out.println(umaConta);
		// Imprima o saldo da conta de João
		System.out.println("Saldo da conta de Joao depois do saque: "
				+ umaConta.getSaldo());
	} // fim do método main
} // fim da classe Banco1
