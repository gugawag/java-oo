/*
 * Uso de composi��o de objetos, passagem de objetos como par�metros,
 * exemplos de la�os, etc.
 */

import java.util.ArrayList;
import java.util.List;

import p1.aplic.cartas.Carta;

public class Cartas10 {
	public static void main(String[] args) {

		// vamos construir um baralho comum
		// (n�o usaremos a classe Baralho)
		// O objeto baralho vai conter outros objetos (Cartas)
		List baralho = new ArrayList();
		// enche o baralho
		for (int valor = Carta.menorValor(); valor <= Carta.maiorValor(); valor++) {
			for (int naipe = Carta.primeiroNaipe(); naipe <= Carta
					.�ltimoNaipe(); naipe++) {
				baralho.add(new Carta(valor, naipe));
			}
		}

		// Tra�a o baralho
		int numCartas = baralho.size();
		for (int posi��o = 0; posi��o < numCartas; posi��o++) {
			// escolhe uma posi��o aleat�ria entre posi��o e numCartas-1
			int posAleat�ria = posi��o
					+ (int) ((numCartas - posi��o) * Math.random());
			// troca as cartas em posi��o e posAleat�ria
			Carta temp = (Carta) baralho.get(posi��o);
			baralho.set(posi��o, baralho.get(posAleat�ria));
			baralho.set(posAleat�ria, temp);
		}

		// imprime o baralho resultante
		System.out.println(baralho);
	} // main
} // Cartas10
