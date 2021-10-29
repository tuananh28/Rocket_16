package behavior.observer;

public class Product extends Subject {

	private String nameProduct;

	public Product(String nameProduct) {
		this.setNameProduct(nameProduct);
	}

	public void updateNewNameProduct(String newNameProduct) {
		this.setNameProduct(newNameProduct);
		notifyToObserver("Tao vừa mới update tên thành " + newNameProduct + ", mày cập nhập theo đi");
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

}
