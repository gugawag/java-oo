package p1.aplic.correiotestes;

import junit.framework.*;
import p1.aplic.correio.*;
import p1.aplic.geral.*;
import java.util.*;

/**
 * Testes da classe CaixaPostal
 *
 */
public class TestaCaixaPostal extends TestCase {
    protected CaixaPostal caixa0;
    protected CaixaPostal caixa1;
    protected CaixaPostal caixa2;
    protected Mensagem m1;
    protected Mensagem m2;
    protected Mensagem m3;

	public TestaCaixaPostal(String name) {
		super(name);
	}
	public static void main(String[] args) {
		junit.textui.TestRunner.run (suite());
	}
	protected void setUp() {
        CaixaPostal.removeCaixaPostal("zero");
        caixa0 = new CaixaPostal("zero");

        CaixaPostal.removeCaixaPostal("um");
        caixa1 = new CaixaPostal("um");
        m1 = new MensagemTexto("jacques", "sub1", "alo, alo");
        caixa1.inserir(m1);
        caixa1.salvar();
        caixa1 = new CaixaPostal("um");

        CaixaPostal.removeCaixaPostal("dois");
        caixa2 = new CaixaPostal("dois");
        m2 = new MensagemTexto("jacques", "sub2", "alo, alo");
        caixa2.inserir(m2);
        m3 = new MensagemTexto("jacques", "sub3", "alo, alo");
        caixa2.inserir(m3);
        caixa2.salvar();
        caixa2 = new CaixaPostal("dois");
	}
	public static Test suite() {
		return new TestSuite(TestaCaixaPostal.class);
	}
    public void testTitular() {
        assertNotNull("1", caixa0);
        assertEquals("2", "zero", caixa0.getTitular());
        assertNotNull("3", caixa1);
        assertEquals("4", "um", caixa1.getTitular());
        assertNotNull("5", caixa2);
        assertEquals("6", "dois", caixa2.getTitular());
    }
    public void testNúmeroDeMensagens() {
        assertEquals("1", 0, caixa0.númeroDeMensagens());
        assertEquals("2", 1, caixa1.númeroDeMensagens());
        assertEquals("3", 2, caixa2.númeroDeMensagens());
    }
    public void testMensagemCorrente() {
        assertNull("1", caixa0.mensagemCorrente());
        assertEquals("2", m1, caixa1.mensagemCorrente());
        assertEquals("3", m2, caixa2.mensagemCorrente());
    }
    public void testExcluir() {
        caixa1.excluir();
        assertTrue("1", caixa1.mensagemCorrente().isExcluída());
        caixa1.mensagemCorrente().marcarNãoExcluída();
        assertTrue("2", !caixa1.mensagemCorrente().isExcluída());
        assertEquals("3", 1, caixa1.númeroDeMensagens());
        caixa1.salvar();
        assertEquals("4", 1, caixa1.númeroDeMensagens());
        caixa1.excluir();
        caixa1.salvar();
        assertEquals("5", 0, caixa1.númeroDeMensagens());
        assertNull("6", caixa1.mensagemCorrente());
    }
    public void testAvançarRecuar() {
        assertEquals("1", m2, caixa2.mensagemCorrente());
        caixa2.avançar();
        assertEquals("2", m3, caixa2.mensagemCorrente());
        caixa2.avançar();
        assertEquals("2", m3, caixa2.mensagemCorrente());
        caixa2.recuar();
        assertEquals("1", m2, caixa2.mensagemCorrente());
        caixa2.recuar();
        assertEquals("1", m2, caixa2.mensagemCorrente());
    }
    public void testIterator() {
        Iterator it = caixa2.iterator();
        assertTrue("1", it.hasNext());
        assertEquals("2", m2, it.next());
        assertTrue("3", it.hasNext());
        assertEquals("4", m3, it.next());
        assertTrue("5", !it.hasNext());
    }
}