package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class ShapeManager {

	private List<Shape> shapes;

	public ShapeManager() {
		shapes = new ArrayList<>();
	}

	public void addShape(Shape shape) {
		shapes.add(shape);
	}

	public void drawAllShape() {
		for (Shape shape : shapes) {
			shape.draw();
		}
	}
}
