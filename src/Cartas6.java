import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import p1.aplic.cartas.Baralho;
import p1.aplic.cartas.Carta;
import p1.io.Entrada;

public class Cartas6 {
	public static void main(String[] args) {

		Baralho baralho = new Baralho();
		baralho.baralhar();
		// List é uma "Coleção" de objetos genéricos
		List<Carta> aMao = new ArrayList<Carta>();

		int n = Entrada.in.lerInt("Quantas cartas na mao? ");

		for (int i = 0; i < n; i++) {
			aMao.add(baralho.pegaCarta());
		}

		// dedo server para varrer (iterar) as cartas na mao
		Iterator<Carta> dedo = aMao.iterator();
		Carta maiorCarta = null;
		while (dedo.hasNext()) {
			Carta proximaCarta = dedo.next();
			if (maiorCarta == null || proximaCarta.compareTo(maiorCarta) > 0) {
				maiorCarta = proximaCarta;
			}
		}
		// List tem um toString bonitinho também! :-)
		System.out.println("A mao: " + aMao);
		System.out.println("A maior carta: "
				+ (maiorCarta == null ? "nao tem" : maiorCarta));
	}
}
