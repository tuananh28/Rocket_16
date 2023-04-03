import java.util.List;

public class Program {
	public static void main(String[] args) {

		DIContainer container = new DIContainer();

		// get bean
		DepartmentController departmentController = container.initController();

		// using controller
		List<String> departments = departmentController.getAllDepartments();
		for (String nameDepartment : departments) {
			System.out.println(nameDepartment);
		}
	}
}
