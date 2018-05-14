/*
 * Uso de composição de objetos, passagem de objetos como parâmetros,
 * exemplos de laços, etc.
 */

import java.util.ArrayList;
import java.util.List;

import p1.aplic.cartas.Carta;

public class Cartas10 {
	public static void main(String[] args) {

		// vamos construir um baralho comum
		// (não usaremos a classe Baralho)
		// O objeto baralho vai conter outros objetos (Cartas)
		List baralho = new ArrayList();
		// enche o baralho
		for (int valor = Carta.menorValor(); valor <= Carta.maiorValor(); valor++) {
			for (int naipe = Carta.primeiroNaipe(); naipe <= Carta
					.últimoNaipe(); naipe++) {
				baralho.add(new Carta(valor, naipe));
			}
		}

		// Traça o baralho
		int numCartas = baralho.size();
		for (int posição = 0; posição < numCartas; posição++) {
			// escolhe uma posição aleatória entre posição e numCartas-1
			int posAleatória = posição
					+ (int) ((numCartas - posição) * Math.random());
			// troca as cartas em posição e posAleatória
			Carta temp = (Carta) baralho.get(posição);
			baralho.set(posição, baralho.get(posAleatória));
			baralho.set(posAleatória, temp);
		}

		// imprime o baralho resultante
		System.out.println(baralho);
	} // main
} // Cartas10
