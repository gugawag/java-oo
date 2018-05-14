public class Fita {
  private String título;
  private double preço;

  public Fita(String título, double nome) {
    this.título = título;
    this.preço = preço;
  }
  public String getTítulo() {
    return título;
  }
  public double getPreço() {
    return preço;
  }
  public double getPreçoAluguel(int númeroDeDiasAlugado) {
    return getPreço() * númeroDeDiasAlugado;
  }
}