import p1.io.*;

public class TesteIO {
    public static void main(String[] args) {
	String	s;
	System.out.println("Leitura de linhas: Entre com varias linhas e termine com \"fim\"");
	while((s = Entrada.in.leLinha()) != null && !s.equals("fim")) {
		System.out.println("Linha <" + s + ">");
	}

	System.out.println("Leitura de palavras: Entre com varias linhas e termine com \"fim\"");
	while((s = Entrada.in.lePalavra()) != null && !s.equals("fim")) {
		System.out.println("Palavra <" + s + ">");
	}

	Integer	i;
	int isoma = 0;
	System.out.println("Leitura de inteiros: Entre com varios inteiros positivos na linha e termine com -1");
	while((i = Entrada.in.leInteiro()) != null && i.intValue() >= 0) {
		isoma += i.intValue();
		System.out.println("Inteiro = " + i + ", soma = " + isoma);
	}

	Double d;
	double dsoma = 0.0;
	System.out.println("Leitura de numeros reais: Entre com varios numeros na linha e termine com -1");
	while((d = Entrada.in.leDouble()) != null && d.doubleValue() >= 0) {
		dsoma += d.doubleValue();
		System.out.println("Numero real = " + d + ", soma = " + dsoma);
	}

	int ch;
	System.out.println("Leitura de caracteres: Entre com linhas ate o fim do arquivo (^Z)");
	while((ch = Entrada.in.read()) >= 0) {
		System.out.println("Caractere = " + (char)ch);
	}
    }
}

