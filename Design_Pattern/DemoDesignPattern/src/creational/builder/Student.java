package creational.builder;

public class Student {

	private int id;
	private String ten;
	private String lop;

	private int diem;
	private int GPA;

	public Student() {
	}

	public Student setId(int id) {
		this.id = id;
		return this;
	}

	public Student setTen(String ten) {
		this.ten = ten;
		return this;
	}

	public Student setLop(String lop) {
		this.lop = lop;
		return this;
	}

	public Student setDiem(int diem) {
		this.diem = diem;
		return this;
	}

	public Student setGPA(int gPA) {
		GPA = gPA;
		return this;
	}
	
	public Student build() {
		return this;
	}
}
