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
	public void testNúmeroDeCartas() {
        assertEquals(1, b1.menorValor());
        assertEquals(13, b1.maiorValor());
        assertEquals(52, b1.númeroDeCartas());
    }
	public void testBaralhoNovo() {
        assertTrue(baralhoEstáCompleto(b1));
    }
	public void testBaralhar() {
        Baralho b2 = new Baralho();
        b2.baralhar();
        assertTrue(baralhoEstáCompleto(b2));
    }
    public boolean baralhoEstáCompleto(Baralho b) {
        Vector cartasJáVistas = new Vector();
        Iterator it = b.iterator();
        while(it.hasNext()) {
            Carta c = (Carta)it.next();
            // vê se carta está ok
            int v = c.getValor();
            int n = c.getNaipe();
            assertTrue("Valor não ok", v >= c.menorValor() && v <= c.maiorValor());
            assertTrue("Naipe não ok", n >= c.primeiroNaipe() && n <= c.últimoNaipe());
            assertTrue("Carta já vista", !cartasJáVistas.contains(c));
            cartasJáVistas.add(c);
        }
        return cartasJáVistas.size() == 52;
    }
	public void testPegaCarta() {
        Vector cartasJáVistas = new Vector();
        Baralho b3 = new Baralho();
        Carta c;
        while((c = b3.pegaCarta()) != null) {
            // vê se carta está ok
            int v = c.getValor();
            int n = c.getNaipe();
            assertTrue("Valor não ok", v >= c.menorValor() && v <= c.maiorValor());
            assertTrue("Naipe não ok", n >= c.primeiroNaipe() && n <= c.últimoNaipe());
            assertTrue("Carta já vista", !cartasJáVistas.contains(c));
            cartasJáVistas.add(c);
        }
        assertEquals("Baralho não vazio", 0, b3.númeroDeCartas());
    }
}