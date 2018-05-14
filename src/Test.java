public class Fita {
  private String t�tulo;
  private double pre�o;

  public Fita(String t�tulo, double nome) {
    this.t�tulo = t�tulo;
    this.pre�o = pre�o;
  }
  public String getT�tulo() {
    return t�tulo;
  }
  public double getPre�o() {
    return pre�o;
  }
  public double getPre�oAluguel(int n�meroDeDiasAlugado) {
    return getPre�o() * n�meroDeDiasAlugado;
  }
}