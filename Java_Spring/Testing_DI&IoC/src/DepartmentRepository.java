import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

	public DepartmentRepository() {

	}

	public List<String> getAllDepartments() {
		// mock data
		List<String> departments = new ArrayList<>();
		departments.add("Sale");
		departments.add("BOD");

		return departments;
	}
}
