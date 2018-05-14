package p1.aplic.correiotestes;

import junit.framework.*;
import p1.aplic.correio.*;
import p1.aplic.geral.*;
import java.util.*;

/**
 * Testes da classe MensagemMissaoImpossivel
 *
 */
public class TestaMensagemMissaoImpossivel extends TestCase {
    protected Mensagem m1;
    protected Mensagem m2;
    protected Data hoje;

	public TestaMensagemMissaoImpossivel(String name) {
		super(name);
	}
	public static void main(String[] args) {
		junit.textui.TestRunner.run (suite());
	}
	protected void setUp() {
        m1 = new MensagemMissaoImpossivel("jacques", "sub1", "alo, alo");
        m2 = new MensagemMissaoImpossivel("alfredo", "sub2", "bye, bye");
        hoje = new Data();
	}
	public static Test suite() {
		return new TestSuite(TestaMensagemMissaoImpossivel.class);
	}
    public void testConstrutor() {
        assertEquals("1", "jacques", m1.getRemetente());
        assertEquals("2", "sub1", m1.getAssunto());
        assertEquals("3", "alo, alo", ((MensagemMissaoImpossivel)m1).getConteúdo());
        assertEquals("4", hoje.DDMMAAAA(), m1.getDataEnvio().DDMMAAAA());
        assertTrue("5", !m1.isLida());
        assertTrue("6", !m1.isExcluída());
    }
    public void testEstado() {
        assertTrue("1", !m2.isLida());
        assertTrue("2", !m2.isExcluída());
        m2.exibir();
        assertTrue("3", m2.isLida());
        assertTrue("4", m2.isExcluída());
        m2.marcarNãoLida();
        assertTrue("5", !m2.isLida());
        m2.marcarNãoExcluída();
        assertTrue("6", !m2.isExcluída());
    }
    public void testEquals() {
        assertTrue(!m1.equals(null));
        assertEquals(m1, m1);
        assertEquals(new MensagemMissaoImpossivel("jacques", "sub1", "alo, alo"), m1);
        assertTrue(!m1.equals(m2));
    }
}