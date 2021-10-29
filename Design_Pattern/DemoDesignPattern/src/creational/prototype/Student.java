package creational.prototype;

public class Student implements Cloneable {

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

	public int getId() {
		return id;
	}

	public String getTen() {
		return ten;
	}

	public String getLop() {
		return lop;
	}

	public int getDiem() {
		return diem;
	}

	public int getGPA() {
		return GPA;
	}

	@Override
	public Student clone() {
		Student newStudent = new Student();

		if (id > 0) {
			newStudent.setId(id);
		}

		if (null != ten && !ten.equals("")) {
			newStudent.setTen(ten);
		}

		// ...

		return newStudent;
	}

}
