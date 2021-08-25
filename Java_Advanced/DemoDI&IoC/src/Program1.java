import java.util.List;

public class Program1 {
	public static void main(String[] args) {

		// get bean
		DepartmentRepository departmentRepository = new DepartmentRepository();
		AccountRepository accountRepository = new AccountRepository();
		DepartmentService departmentService = new DepartmentService(departmentRepository, accountRepository);
		DepartmentController departmentController = new DepartmentController(departmentService);

		// using controller
		List<String> departments = departmentController.getAllDepartments();
		for (String nameDepartment : departments) {
			System.out.println(nameDepartment);
		}
	}
}
