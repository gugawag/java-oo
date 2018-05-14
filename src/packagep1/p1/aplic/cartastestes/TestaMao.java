package p1.aplic.cartastestes;

import junit.framework.*;
import p1.aplic.cartas.*;
import java.util.*;

/**
 * Testes da classe Mao
 *
 */
public class TestaMao extends TestCase {
    protected Carta asPaus;
    protected Carta reiCopas;
    protected Carta seisCopas;

	public TestaMao(String name) {
		super(name);
	}
	public static void main(String[] args) {
		junit.textui.TestRunner.run (suite());
	}
	protected void setUp() {
        asPaus = new Carta(Carta.AS, Carta.PAUS);
        reiCopas = new Carta(Carta.REI, Carta.COPAS);
        seisCopas = new Carta(6, Carta.COPAS);
	}
	public static Test suite() {
		return new TestSuite(TestaMao.class);
	}
    public void testAdicionar() {
        Mao mao = new Mao();
        assertEquals("Mao nao vazia no inicio", 0, mao.númeroDeCartas());
        mao.adicionar(asPaus);
        assertEquals("Deveria ter 1 carta", 1, mao.númeroDeCartas());
        assertEquals("AS de PAUS", mao.toString());
        mao.adicionar(reiCopas);
        assertEquals("Deveria ter 2 cartas", 2, mao.númeroDeCartas());
        assertEquals("AS de PAUS, REI de COPAS", mao.toString());
    }
    public void testTrocar() {
        Mao mao = new Mao();
        mao.adicionar(asPaus);
        mao.adicionar(reiCopas);
        assertEquals("AS de PAUS, REI de COPAS", mao.toString());
        mao.trocar(0,1);
        assertEquals("REI de COPAS, AS de PAUS", mao.toString());
        mao.trocar(asPaus, reiCopas);
        assertEquals("AS de PAUS, REI de COPAS", mao.toString());
    }
    public void testRemover() {
        Mao mao = new Mao();
        mao.adicionar(asPaus);
        mao.adicionar(reiCopas);
        assertEquals("AS de PAUS, REI de COPAS", mao.toString());
        mao.remover(0);
        assertEquals("REI de COPAS", mao.toString());
        mao.adicionar(asPaus);
        mao.remover(reiCopas);
        assertEquals("AS de PAUS", mao.toString());
    }
    public void testCartaEm() {
        Mao mao = new Mao();
        mao.adicionar(asPaus);
        mao.adicionar(reiCopas);
        assertEquals(asPaus, mao.cartaEm(0));
        assertEquals(reiCopas, mao.cartaEm(1));
        assertEquals(reiCopas, mao.cartaNoTopo());
    }
    public void testValor() {
        Mao mao = new Mao();
        assertEquals(0, mao.valor());
        mao.adicionar(asPaus);
        mao.adicionar(reiCopas);
        assertEquals(14, mao.valor());
        Mao mao2 = new Mao();
        mao.adicionar(asPaus);
        mao.adicionar(seisCopas);
        assertTrue(mao.compareTo(mao2) > 0);
    }
}