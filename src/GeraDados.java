public class GeraDados {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("Sintaxe: GeraDados numLinhas");
			System.exit(1);
		}
		int numLinhas = Integer.parseInt(args[0]);
		for (int i = 0; i < numLinhas; i++) {
			geraUmaLinha();
		}
	}

	static void geraUmaLinha() {
		System.out.println(geraPalavra(8, 20) + ":" + geraPalavra(20, 40));
	}

	static String geraPalavra(int tamMin, int tamMax) {
		StringBuffer campo = new StringBuffer();
		int tam = intAleatório(tamMin, tamMax);
		for (int i = 0; i < tam; i++) {
			campo.append((char) ((int) 'a' + intAleatório(0, 26)));
		}
		return campo.toString();
	}

	static int intAleatório(int min, int max) {
		return (int) (Math.random() * (max - min)) + min;
	}
}
