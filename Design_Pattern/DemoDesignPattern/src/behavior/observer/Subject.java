package behavior.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

	private List<ProductObserver> observers;

	public Subject() {
		observers = new ArrayList<>();
	}

	public void addObserver(ProductObserver observer) {
		observers.add(observer);
	}

	public void removeObserver(ProductObserver observer) {
		observers.remove(observer);
	}

	public void notifyToObserver(String message) {
		for (ProductObserver observer : observers) {
			observer.updateNewNameProduct(message);
		}
	}
}
