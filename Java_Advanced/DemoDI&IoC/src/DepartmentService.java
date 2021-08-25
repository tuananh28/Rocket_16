import java.util.List;

public class DepartmentService {

	private DepartmentRepository departmentRepository;

	@SuppressWarnings("unused")
	private AccountRepository accountRepository;

	public DepartmentService(DepartmentRepository departmentRepository, AccountRepository accountRepository) {
		this.departmentRepository = departmentRepository;
		this.accountRepository = accountRepository;
	}

	public List<String> getAllDepartments() {
		return departmentRepository.getAllDepartments();
	}
}
