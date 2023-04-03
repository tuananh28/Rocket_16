
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;


public class Ex3_Date_Format {
	public static void main(String[] args) {

		// Create group
		Group group1 = new Group();
		group1.GroupID = 1;
		group1.GroupName = "Java Fresher";
		group1.CreateDate = LocalDate.of(2020, 04, 21);

		Group group2 = new Group();
		group2.GroupID = 2;
		group2.GroupName = "DB Fresher";
		group2.CreateDate = LocalDate.of(2020, 05, 22);

		Group group3 = new Group();
		group3.GroupID = 3;
		group3.GroupName = "C++ Fresher";
		group3.CreateDate = LocalDate.of(2020, 06, 23);

		// Create Deparment
		Department department1 = new Department();
		department1.DepartmentID = 1;
		department1.DepartmentName = "Sale";

		Department department2 = new Department();
		department2.DepartmentID = 2;
		department2.DepartmentName = "Marketting";

		Department department3 = new Department();
		department3.DepartmentID = 3;
		department3.DepartmentName = "HR";

		// Create Position
		Position position1 = new Position();
		position1.PositionID = 1;
		position1.PositionName = PositionName.PM;

		Position position2 = new Position();
		position2.PositionID = 2;
		position2.PositionName = PositionName.DEV;

		Position position3 = new Position();
		position3.PositionID = 3;
		position3.PositionName = PositionName.SCRUM_MASTER;

		// Create account
		Account account1 = new Account();
		account1.AccountID = 1;
		account1.CreateDate = LocalDate.of(2020, 03, 17);
		account1.Department = department1;
		account1.Email = "An@gmail.com";
		account1.FullName = "Nguyen Van An";
		account1.Position = position1;
		account1.Username = "an.nguyenvan";

		Account account2 = new Account();
		account2.AccountID = 2;
		account2.CreateDate = LocalDate.of(2020, 01, 9);
		account2.Department = department1;
		account2.Email = "Linh@gmail.com";
		account2.FullName = "Nguyen Hoai Linh";
		account2.Position = position3;
		account2.Username = "Linh.nguyenhoai";

		Account account3 = new Account();
		account3.AccountID = 3;
		account3.CreateDate = LocalDate.of(2020, 03, 19);
		account3.Department = department2;
		account3.Email = "ha@gmail.com";
		account3.FullName = "Pham Hai Ha";
		account3.Position = position1;
		account3.Username = "Ha.phamhai";

		// add group to account
		Group[] groupOfAccount1 = { group1 };
		account1.groups = groupOfAccount1;

		Group[] groupOfAccount2 = { group3 };
		account2.groups = groupOfAccount2;

		Group[] groupOfAccount3 = { group1 };
		account3.groups = groupOfAccount3;

		// add account to group
		Account[] accountOfGroups1 = { account1, account2, account3 };
		group1.accounts = accountOfGroups1;

		// Create CategoryQuestion
		CategoryQuestion category1 = new CategoryQuestion();
		category1.CategoryID = 1;
		category1.CategoryName = "JAVA";

		CategoryQuestion category2 = new CategoryQuestion();
		category2.CategoryID = 2;
		category2.CategoryName = "DB";

		CategoryQuestion category3 = new CategoryQuestion();
		category3.CategoryID = 3;
		category3.CategoryName = "C++";

		// Create TypeQuestion
		TypeQuestion type1 = new TypeQuestion();
		type1.TypeID = 1;
		type1.TypeName = TypeName.ESSAY;

		TypeQuestion type2 = new TypeQuestion();
		type2.TypeID = 2;
		type2.TypeName = TypeName.MULTIPLE_CHOICE;

		// Create Question
		Question question1 = new Question();
		question1.categoryQuestion = category1;
		question1.Content = "Dac diem chinh cua Java";
		question1.CreateDate = LocalDate.of(2020, 1, 7);
		question1.CreatorID = account1;
		question1.QuestionID = 1;
		question1.typeQuestion = type1;

		Question question2 = new Question();
		question2.categoryQuestion = category1;
		question2.Content = "Cac chuong trinh Java chu yeu";
		question2.CreateDate = LocalDate.of(2020, 2, 8);
		question2.CreatorID = account1;
		question2.QuestionID = 2;
		question2.typeQuestion = type2;

		Question question3 = new Question();
		question3.categoryQuestion = category1;
		question3.Content = "Quy tac thiet ke Database";
		question3.CreateDate = LocalDate.of(2019, 2, 9);
		question3.CreatorID = account2;
		question3.QuestionID = 3;
		question3.typeQuestion = type1;

		// Create exam
		Exam exam1 = new Exam();
		exam1.ExamID = 1;
		exam1.Code = "VTI01";
		exam1.Title = "Title1";
		exam1.CreatorID = account1;
		exam1.Duration = 60;
		exam1.CreateDate = LocalDate.of(2014, 02, 11);
		
		Exam exam2 = new Exam();
		exam2.Code = "VTI02";
		exam2.ExamID = 2;
		exam2.CreatorID = account2;
		exam2.Duration = 120;
		exam2.CreateDate = LocalDate.now();
		exam1.Title = "Title2";

		// add question to exam
		Question[] questionOfExam1 = { question1, question2 };
		exam1.questions = questionOfExam1;

		Question[] questionOfExam2 = { question3 };
		exam1.questions = questionOfExam2;

		// Create Answer
		Answer answer1 = new Answer();
		answer1.AnswerID = 1;
		answer1.Content = "Content1";
		answer1.isCorrect = true;
		answer1.question = question1;

		Answer answer2 = new Answer();
		answer2.AnswerID = 2;
		answer2.Content = "Content2";
		answer2.isCorrect = false;
		answer2.question = question1;

		// Question 1: In ra thông tin Exam thứ 1 và property create date sẽ được format
		// theo định dạng vietnamese
		
		System.out.println("\t --- Question 1 --- \t");
		Locale locale = new Locale("vi", "VN");
		DateFormat dateformat =DateFormat.getDateInstance(DateFormat.DEFAULT,locale);
		String date = dateformat.format(exam1.CreateDate);
		System.out.println(exam1.Code + ": " + date);

		// Question 2:
		// In ra thông tin: Exam đã tạo ngày nào theo định dạng
		// Năm – tháng – ngày – giờ – phút – giây

		System.out.println("\t --- Question 2 --- \t");
		String pattern = "\"E dd.MM.yyy 'at' hh:mm:ss a zzz\"";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Exam[] exams = { exam1, exam2 };
		for (Exam exam : exams) {
			date = simpleDateFormat.format(exam.CreateDate);
			System.out.println(exam.Code + ": " + date);
		}

		// Question 3: Chỉ in ra năm của create date property trong Question 2.
		System.out.println("\t --- Question 3 --- \t");
		pattern = "yyyy";
		simpleDateFormat = new SimpleDateFormat(pattern);
		for (Exam exam : exams) {
			date = simpleDateFormat.format(exam.CreateDate);
			System.out.println(exam.Code + ": " + date);
		}

		// Question 4: Chỉ in ra tháng và năm của create date property trong Question 2
		System.out.println("\t --- Question 4 --- \t");
		pattern = "yyyy-MM";
		simpleDateFormat = new SimpleDateFormat(pattern);
		for (Exam exam : exams) {
			date = simpleDateFormat.format(exam.CreateDate);
			System.out.println(exam.Code + ": " + date);
		}

		// Question 5: Chỉ in ra "MM-DD" của create date trong Question 2
		System.out.println("\t --- Question 5 --- \t");
		pattern = "MM-dd";
		simpleDateFormat = new SimpleDateFormat(pattern);
		for (Exam exam : exams) {
			date = simpleDateFormat.format(exam.CreateDate);
			System.out.println(exam.Code + ": " + date);
		}
	}
}
