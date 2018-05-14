public class Grana1 {
	public static void main(String[] args) {
		double x, y;
		x = 10000000000.0;
		y = 0.01;
		for (int i = 0; i < 10; i++) {
			System.out.println(x + y);
			x *= 10;
		}
	}
}
