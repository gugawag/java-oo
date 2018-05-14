package p1.aplic.bancotestes;

import junit.framework.*;
import p1.aplic.banco.*;

/**
 * Testes da classe Real2.
 *
 */
public class TestaReal2 extends TestCase {
  protected Real2 zero;
  protected Real2 zero2;
  protected Real2 quaseZero;
  protected Real2 umCentavo;
  protected Real2 menosUmCentavo;
  protected Real2 menosUmEVinteETres;

  public TestaReal2(String name) {
    super(name);
  }
  public static void main(String[] args) {
    junit.textui.TestRunner.run (suite());
  }
  protected void setUp() {
    zero = new Real2();
    zero2 = new Real2(0.0);
    quaseZero = new Real2(0.004999);
    umCentavo = new Real2(0.01);
    menosUmCentavo = new Real2(-0.01);
    menosUmEVinteETres = new Real2(-1.23);
  }
  public static Test suite() {
    return new TestSuite(TestaReal2.class);
  }
  public void testEquals() {
    assertTrue(!zero.equals(null));
    assertEquals(zero, zero);
    assertEquals(zero, zero2);
    assertEquals(new Real2(0.01), umCentavo);
    assertTrue(!zero.equals(umCentavo));
    assertEquals(zero, quaseZero);
  }
  public void testCompareTo() {
    assertEquals("1", 0, zero.compareTo(zero));
    assertEquals("2", 0, zero.compareTo(new Real2()));
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
    Real2 z1 = new Real2();
    z1.setValor(0.004999);
    assertEquals("1", 0.0, z1.getValor(), 0.0);
    z1.setValor(0.01);
    assertEquals("2", 0.01, z1.getValor(), 0.0);
    z1.setValor(-0.01);
    assertEquals("3", -0.01, z1.getValor(), 0.0);
  }
}