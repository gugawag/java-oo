class ClassificacaoLancamento extends Classificacao {
  int getC�digoDePre�o() {
    return Fita.LAN�AMENTO;
  }

  double getValorDoAluguel(int diasAlugada) {
    return diasAlugada * 3;
  }

  int getPontosDeAlugadorFrequente(int diasAlugadas) {
    return (diasAlugadas > 1) ? 2 : 1;
  }
}
