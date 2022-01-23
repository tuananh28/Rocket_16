package backend;

public class BadDog extends Animal implements Swimable{
	private int age = 0;
	public BadDog(String name, int age) {
		super(name);
		this.setAge(age);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public void swim() {
		System.out.println("Swimming");
		
	}
	

}
