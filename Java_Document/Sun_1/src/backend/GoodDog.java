package backend;

public class GoodDog extends Animal implements Swimable ,Climbable{

	private int height = 0;
	private int weight = 0;
	private String color = "";

	public static int numberOfDogs = 0;

	public GoodDog(String name, int height, int weight) {
		super(name);
		System.out.println("This object was initialized!");
		this.setName(name);
		this.setHeight(height);
		this.setWeight(weight);
		numberOfDogs++;
	}

	public GoodDog(String name, String color) {
		super(name);
		this.setColor(color);

	}

	public void Speak() {
		System.out.println(this.getName() + "says arf!");
	}

	public void change_info(String name, int height, int weight) {
		this.setName(name);
		this.setHeight(height);
		this.setWeight(weight);
	}

	public void info() {
		System.out.println(this.getName() + "weighs " + this.weight + "and is " + this.height + "tall.");
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void swim() {
		System.out.println("Swimming");

	}

	@Override
	public void Climb() {
		System.out.println("Climbing");
		
	}

}
