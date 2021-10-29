package creational.factory;

public class Boss {
	public void view() {
		CarFactory factory = new CarFactory();
//		factory.view("Honda");
		factory.view("Yamaha");
	}
}
