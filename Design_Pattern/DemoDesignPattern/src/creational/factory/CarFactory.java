package creational.factory;

public class CarFactory {

	public void view(String type) {

		ICarView iView = null;

		if (type.equals("Honda")) {
			iView = new Honda();

		} else if (type.equals("Nexus")) {
			iView = new Nexus();

		} else if (type.equals("Toyota")) {
			iView = new Toyota();
		} else {
			System.out.println("Hiện tại xe chưa nhập vào");
			return;
		}

		iView.view();
	}
}
