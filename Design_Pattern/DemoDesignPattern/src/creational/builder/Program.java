package creational.builder;

public class Program {
	public static void main(String[] args) {
		Student student = new Student()
				.setId(1)
				.setTen("Nguyen Van A")
				.build();
	}
}
