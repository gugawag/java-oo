import java.io.*;

public class CharCount {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("Sintaxe: WordCount arq [arq ...]");
			System.exit(1);
		}
		for (int i = 0; i < args.length; i++) {
			try {
				System.out.println(args[i] + ": " + contaCaracteres(args[i]));
			} catch (IOException e) {
				System.err.println(args[i] + ": Erro: " + e.getMessage());
			}
		}
	}

	static int contaCaracteres(String nomeArquivo) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(nomeArquivo));
		int numCarac = 0;
		try {
			while (in.read() >= 0) {
				numCarac++;
			}
		} finally {
			in.close(); // isso é feito mesma que haja exceção
		}
		return numCarac;
	}
}
