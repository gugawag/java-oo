public class Fita {
  public static final int NORMAL = 0;
  public static final int LAN�AMENTO = 1;
  public static final int INFANTIL = 2;

  private String t�tulo;
  private int c�digoDePre�o;

  public Fita(String t�tulo, int c�digoDePre�o) {
    this.t�tulo = t�tulo;
    this.c�digoDePre�o = c�digoDePre�o;
  }

  public String getT�tulo() {
    return t�tulo;
  }

  public int getC�digoDePre�o() {
    return c�digoDePre�o;
  }

  public void setC�digoDePre�o(int c�digoDePre�o) {
    this.c�digoDePre�o = c�digoDePre�o;
  }
}

