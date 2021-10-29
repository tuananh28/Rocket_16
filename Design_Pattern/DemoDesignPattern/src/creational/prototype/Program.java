package creational.prototype;

public class Program {
	public static void main(String[] args) {
		Student student = new Student().setId(1).setTen("A");

		Student student2 = student.clone();

		student.setId(3);

		System.out.println(student2.getId());
	}
}
