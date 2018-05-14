public class Grana2 {
	public static void main(String[] args) {
		double x = 1.00;
		for (int i = 0; i < 10; i++) {
			System.out.println(x);
			// aplica 10% de juros
			x += x * 0.1;
		}
	}
}