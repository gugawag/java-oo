package p1.aplic.correiotestes;

import junit.framework.*;
import p1.aplic.correio.*;
import p1.aplic.geral.*;
import java.util.*;

/**
 * Testes da classe MensagemAudio
 *
 */
public class TestaMensagemAudio extends TestCase {
    protected Mensagem m1;
    protected Mensagem m2;
    protected Data hoje;

	public TestaMensagemAudio(String name) {
		super(name);
	}
	public static void main(String[] args) {
		junit.textui.TestRunner.run (suite());
	}
	protected void setUp() {
        m1 = new MensagemAudio("jacques", "sub1", "clip1.wav");
        m2 = new MensagemAudio("alfredo", "sub2", "clip2.wav");
        hoje = new Data();
	}
	public static Test suite() {
		return new TestSuite(TestaMensagemAudio.class);
	}
    public void testEquals() {
        assertTrue(!m1.equals(null));
        assertEquals(m1, m1);
        assertEquals(new MensagemAudio("jacques", "sub1", "clip1.wav"), m1);
        assertTrue(!m1.equals(m2));
    }
}