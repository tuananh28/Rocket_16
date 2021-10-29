package behavior.observer;

public class Customer implements ProductObserver {

	private String name;

	public Customer(String name) {
		super();
		this.name = name;
	}

	@Override
	public void updateNewNameProduct(String message) {
		System.out.println("Tao là: " + name + ", đã nhận được thông báo như này: " + message + "\n Tao sẽ xử lý sau");
	}
}
