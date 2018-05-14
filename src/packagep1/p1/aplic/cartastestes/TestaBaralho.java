package p1.aplic.cartastestes;

import junit.framework.*;
import p1.aplic.cartas.*;
import java.util.*;

/**
 * Testes da classe Baralho.
 *
 */
public class TestaBaralho extends TestCase {
	protected Baralho  b1; // fica intacto

	public TestaBaralho(String name) {
		super(name);
	}
	public static void main(String[] args) {
		junit.textui.TestRunner.run (suite());
	}
	protected void setUp() {
        b1 = new Baralho();
	}
	public static Test suite() {
		return new TestSuite(TestaBaralho.class);
	}
	public void testN�meroDeCartas() {
        assertEquals(1, b1.menorValor());
        assertEquals(13, b1.maiorValor());
        assertEquals(52, b1.n�meroDeCartas());
    }
	public void testBaralhoNovo() {
        assertTrue(baralhoEst�Completo(b1));
    }
	public void testBaralhar() {
        Baralho b2 = new Baralho();
        b2.baralhar();
        assertTrue(baralhoEst�Completo(b2));
    }
    public boolean baralhoEst�Completo(Baralho b) {
        Vector cartasJ�Vistas = new Vector();
        Iterator it = b.iterator();
        while(it.hasNext()) {
            Carta c = (Carta)it.next();
            // v� se carta est� ok
            int v = c.getValor();
            int n = c.getNaipe();
            assertTrue("Valor n�o ok", v >= c.menorValor() && v <= c.maiorValor());
            assertTrue("Naipe n�o ok", n >= c.primeiroNaipe() && n <= c.�ltimoNaipe());
            assertTrue("Carta j� vista", !cartasJ�Vistas.contains(c));
            cartasJ�Vistas.add(c);
        }
        return cartasJ�Vistas.size() == 52;
    }
	public void testPegaCarta() {
        Vector cartasJ�Vistas = new Vector();
        Baralho b3 = new Baralho();
        Carta c;
        while((c = b3.pegaCarta()) != null) {
            // v� se carta est� ok
            int v = c.getValor();
            int n = c.getNaipe();
            assertTrue("Valor n�o ok", v >= c.menorValor() && v <= c.maiorValor());
            assertTrue("Naipe n�o ok", n >= c.primeiroNaipe() && n <= c.�ltimoNaipe());
            assertTrue("Carta j� vista", !cartasJ�Vistas.contains(c));
            cartasJ�Vistas.add(c);
        }
        assertEquals("Baralho n�o vazio", 0, b3.n�meroDeCartas());
    }
}