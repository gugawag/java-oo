package p1.aplic.bancotestes;

import java.util.*;
import junit.framework.*;
import p1.aplic.banco.*;
import p1.aplic.geral.*;

/**
 * Testes da classe ContaSimples.
 *
 */
public class TestaContaSimples extends TestCase {
    protected ContaSimples conta1;
    protected ContaSimples conta2;
    protected Pessoa pessoa;
    protected Data hoje;
    protected Data ontem;
    protected Real zeroReal;
    protected Real cemReais;
    protected Conta caixa;

	public TestaContaSimples(String name) {
		super(name);
	}
	public static void main(String[] args) {
		junit.textui.TestRunner.run (suite());
	}
	public static Test suite() {
		return new TestSuite(TestaContaSimples.class);
	}
	protected void setUp() {
        conta1 = new ContaSimples("nome1", "cpf1", 1017);
        pessoa = new Pessoa("nome2", "cpf2");
        conta2 = new ContaSimples(pessoa, 1018);
        hoje = new Data();
		ontem = (Data)hoje.clone();
        ontem.somarDia(-1);
        zeroReal = new Real(0.0);
        cemReais = new Real(100.0);
        caixa = Agencia.getContaCaixa();
    }
    public void testAccessor() {
        assertEquals(1017, conta1.getNúmero());
        assertEquals(new Pessoa("nome1", "cpf1"), conta1.getTitular());
        assertEquals("nome1", conta1.getNome());
        assertEquals("cpf1", conta1.getCPF());
        assertEquals(new Pessoa("nome2", "cpf2"), conta2.getTitular());
        assertEquals("nome2", conta2.getNome());
        assertEquals("cpf2", conta2.getCPF());
        Data d = conta1.getDataAbertura();
        assertEquals(hoje.getDia(), d.getDia());
        assertEquals(hoje.getMes(), d.getMes());
        assertEquals(hoje.getAno(), d.getAno());
        assertEquals(0.0, conta1.getSaldo(), 0.005);
        assertEquals(zeroReal, conta1.getSaldoMonetário());
    }
    public void testDepositar() {
        Conta conta3 = new ContaSimples("nome3", "cpf3", 1019);
        conta3.depositar(100.0);
        assertEquals(100.0, conta3.getSaldo(), 0.005);
        assertEquals(cemReais, conta3.getSaldoMonetário());
    }
    public void testSacar() {
        Conta conta4 = new ContaSimples("nome4", "cpf4", 1020);
        conta4.depositar(100.0);
        boolean res;
        res = conta4.sacar(23.10);
        assertTrue(res == true);
        assertEquals(76.90, conta4.getSaldo(), 0.005);
        res = conta4.sacar(76.91);
        assertTrue(res == false);
        assertEquals(76.90, conta4.getSaldo(), 0.005);
        res = conta4.sacar(76.90);
        assertTrue(res == true);
        assertEquals(0.0, conta4.getSaldo(), 0.005);
    }
    public void testTransferir() {
        Conta conta5 = new ContaSimples("nome5", "cpf5", 1021);
        Conta conta6 = new ContaSimples("nome6", "cpf6", 1022);
        conta5.depositar(100.0);
        boolean res;
        res = conta5.transferir(conta6, 50.13);
        assertTrue(res == true);
        assertEquals(49.87, conta5.getSaldo(), 0.005);
        assertEquals(50.13, conta6.getSaldo(), 0.005);
        res = conta5.transferir(conta6, 59.88);
        assertTrue(res == false);
        assertEquals(49.87, conta5.getSaldo(), 0.005);
        assertEquals(50.13, conta6.getSaldo(), 0.005);
        res = conta5.transferir(conta6, 40.0, "uma transferenciazinha");
        assertTrue(res == true);
        assertEquals(9.87, conta5.getSaldo(), 0.005);
        assertEquals(90.13, conta6.getSaldo(), 0.005);
    }
    public void testToString() {
        assertEquals("ContaSimples numero 1017, titular nome1, data " + hoje.DDMMAAAA() + ", saldo R$0,00",
            conta1.toString());
    }
    public void testFechar() {
        Conta conta7 = new ContaSimples("nome7", "cpf7", 1023);
        Conta conta8 = new ContaSimples("nome8", "cpf8", 1024);
        conta8.depositar(100.0);
        try {
            conta7.fechar();
        } catch(NaoPodeFecharContaException e) {
            fail("Houve NaoPodeFecharContaException");
        }
        try {
            conta8.fechar();
            fail("Nao houve NaoPodeFecharContaException");
        } catch(NaoPodeFecharContaException e) {
        }
    }
    public void testMovimento() {
        Conta conta9 = new ContaSimples("nome9", "cpf9", 1025);
        Conta conta10 = new ContaSimples("nome10", "cpf10", 1026);
        conta9.depositar(100.0);
        conta9.transferir(conta10, 40.0, "Pagamento do carro");
        // verificar as duas transacoes da conta9
        assertEquals(2, numElementos(conta9.getTransações()));
        Iterator it = conta9.getTransações();
        // transacao 1
        Transacao t = (Transacao)it.next();
        Data d = t.getData();
        assertEquals(hoje.getDia(), t.getData().getDia());
        assertEquals(hoje.getMes(), t.getData().getMes());
        assertEquals(hoje.getAno(), t.getData().getAno());
        assertEquals(conta9, t.getContaCrédito());
        assertEquals(caixa, t.getContaDébito());
        assertEquals(100.0, t.getValor(), 0.005);
        assertEquals("deposito", t.getDescrição());
        // transacao 2
        t = (Transacao)it.next();
        d = t.getData();
        assertEquals(hoje.getDia(), t.getData().getDia());
        assertEquals(hoje.getMes(), t.getData().getMes());
        assertEquals(hoje.getAno(), t.getData().getAno());
        assertEquals(conta10, t.getContaCrédito());
        assertEquals(conta9, t.getContaDébito());
        assertEquals(40.0, t.getValor(), 0.005);
        assertEquals("Pagamento do carro", t.getDescrição());
        // verificar a transacão da conta10
        assertEquals(1, numElementos(conta10.getTransações()));
        it = conta10.getTransações();
        // transacao 1
        t = (Transacao)it.next();
        d = t.getData();
        assertEquals(hoje.getDia(), t.getData().getDia());
        assertEquals(hoje.getMes(), t.getData().getMes());
        assertEquals(hoje.getAno(), t.getData().getAno());
        assertEquals(conta10, t.getContaCrédito());
        assertEquals(conta9, t.getContaDébito());
        assertEquals(40.0, t.getValor(), 0.005);
        assertEquals("Pagamento do carro", t.getDescrição());

// nao vou testar o número de transações no caixa da agencia porque depende
// de outros testes e não só deste método
// posso voltar a testar isso nos testes de ContaCaixa ou Agencia
//        assertEquals(3, numElementos(Agencia.getMovimento().getTransações()));
    }
    public int numElementos(Iterator it) {
        int n = 0;
        while(it.hasNext()) {
            it.next();
            n++;
        }
        return n;
    }
    public void testaExtrato() {
        Conta conta11 = new ContaSimples("nome11", "cpf11", 1027);
        Conta conta12 = new ContaSimples("nome12", "cpf12", 1028);
        conta11.depositar(234.56);
        conta11.transferir(conta12, 40.0, "Teste de extrato");
		Extrato extrato11 = conta11.criarExtrato(ontem, hoje);
        assertEquals(2, numElementos(extrato11.getTransações()));
   }
}