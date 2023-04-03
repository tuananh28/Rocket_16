import java.util.List;

public class DepartmentController {

	private DepartmentService service;

	public DepartmentController(DepartmentService service) {
		this.service = service;
	}

	public List<String> getAllDepartments() {
		return service.getAllDepartments();
	}
}
