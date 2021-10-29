package behavior.observer;

public class Program {
	public static void main(String[] args) {
		// setup
		Product product = new Product("Iphone");

		Customer A = new Customer("A");
		Customer B = new Customer("B");
		Customer C = new Customer("C");
		Customer D = new Customer("D");

		product.addObserver(A);
		product.addObserver(B);

		// change product status
		product.updateNewNameProduct("Android");

	}
}
