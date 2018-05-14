public class Fita implements Alugavel {
  public static final int NORMAL = 0;
  public static final int LAN�AMENTO = 1;
  public static final int INFANTIL = 2;

  private String t�tulo;
  private Classificacao classifica��o;

  public Fita(String t�tulo, int c�digoDePre�o) {
    this.t�tulo = t�tulo;
    setC�digoDePre�o(c�digoDePre�o);
  }

  public String getT�tulo() {
    return t�tulo;
  }

  public int getC�digoDePre�o() {
    return classifica��o.getC�digoDePre�o();
  }

  public void setC�digoDePre�o(int c�digoDePre�o) {
    switch(c�digoDePre�o) {
    case NORMAL:
      classifica��o = new ClassificacaoNormal();
      break;
    case LAN�AMENTO:
      classifica��o = new ClassificacaoLancamento();
      break;
    case INFANTIL:
      classifica��o = new ClassificacaoInfantil();
      break;
    }
  }
  public double getValorDoAluguel(int diasAlugada) {
    return classifica��o.getValorDoAluguel(diasAlugada);
  }
  public int getPontosDeAlugadorFrequente(int diasAlugada) {
    return classifica��o.getPontosDeAlugadorFrequente(diasAlugada);
  }
}

