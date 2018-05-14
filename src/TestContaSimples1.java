import junit.framework.TestCase;

public class TestContaSimples1 extends TestCase {
	public void testContaSimples1() {
		ContaSimples1 umaConta = new ContaSimples1("Jacques Sauve", "123.456.789.01", 123);
		assertEquals("Nome errado", "Jacques Sauve", umaConta.getNome());
		assertEquals("cpf errado", "123.456.789.01", umaConta.getCPF());
		assertEquals("Número errado", 123, umaConta.getNúmero());
		assertEquals("Saldo errado", 0.0, umaConta.getSaldo(), 0.01);
		umaConta.depositar(100.0);
		assertEquals("Saldo errado", 100.0, umaConta.getSaldo(), 0.01);
		assertTrue("Nao consegui sacar", umaConta.sacar(45.0));
		assertEquals("Saldo errado", 55.0, umaConta.getSaldo(), 0.01);
		assertFalse("Consegui sacar demais", umaConta.sacar(56.0));
		assertEquals("Saldo errado", 55.0, umaConta.getSaldo(), 0.01);
	}
}
