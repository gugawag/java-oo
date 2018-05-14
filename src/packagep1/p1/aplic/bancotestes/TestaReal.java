package p1.aplic.bancotestes;

import junit.framework.*;
import p1.aplic.banco.*;

/**
 * Testes da classe Real.
 *
 */
public class TestaReal extends TestCase {
    protected Real zero;
    protected Real zero2;
    protected Real quaseZero;
    protected Real umCentavo;
    protected Real menosUmCentavo;
    protected Real menosUmEVinteETres;

	public TestaReal(String name) {
		super(name);
	}
	public static void main(String[] args) {
		junit.textui.TestRunner.run (suite());
	}
	protected void setUp() {
        zero = new Real();
        zero2 = new Real(0.0);
        quaseZero = new Real(0.004999);
        umCentavo = new Real(0.01);
        menosUmCentavo = new Real(-0.01);
        menosUmEVinteETres = new Real(-1.23);
	}
	public static Test suite() {
		return new TestSuite(TestaReal.class);
	}
	public void testEquals() {
        assertTrue(!zero.equals(null));
        assertEquals(zero, zero);
        assertEquals(zero, zero2);
        assertEquals(new Real(0.01), umCentavo);
        assertTrue(!zero.equals(umCentavo));
        assertEquals(zero, quaseZero);
    }
	public void testCompareTo() {
        assertEquals("1", 0, zero.compareTo(zero));
        assertEquals("2", 0, zero.compareTo(new Real()));
        assertEquals("3", 0, zero.compareTo(zero2));
        assertTrue("4", zero.compareTo(umCentavo) < 0);
        assertTrue("5", zero.compareTo(menosUmCentavo) > 0);
        assertEquals("6", 0, zero.compareTo(quaseZero));
    }
	public void testGetValor() {
        assertEquals("1", 0.0, zero.getValor(), 0.0);
        assertEquals("2", 0.0, zero2.getValor(), 0.0);
        assertEquals("3", 0.0, quaseZero.getValor(), 0.0);
        assertEquals("4", 0.01, umCentavo.getValor(), 0.0);
        assertEquals("5", -0.01, menosUmCentavo.getValor(), 0.0);
    }
	public void testToString() {
        assertEquals("1", "R$0,00", zero.toString());
        assertEquals("2", "R$0,00", quaseZero.toString());
        assertEquals("3", "R$0,01", umCentavo.toString());
        assertEquals("4", "R$-1,23", menosUmEVinteETres.toString());
        assertEquals("5", "R$-0,01", menosUmCentavo.toString());
    }
	public void testSetValor() {
        Real z1 = new Real();
        z1.setValor(0.004999);
        assertEquals("1", 0.0, z1.getValor(), 0.0);
        z1.setValor(0.01);
        assertEquals("2", 0.01, z1.getValor(), 0.0);
        z1.setValor(-0.01);
        assertEquals("3", -0.01, z1.getValor(), 0.0);
    }
}