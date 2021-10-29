package structural.composite;

public class Program {
	public static void main(String[] args) {
		ShapeManager shapeManager = new ShapeManager();

		shapeManager.addShape(new Circle());
		shapeManager.addShape(new Triangle());
		shapeManager.addShape(new Circle());
		shapeManager.addShape(new Triangle());
		shapeManager.addShape(new Circle());
		shapeManager.addShape(new Triangle());

		shapeManager.drawAllShape();
	}
}
