import java.time.LocalDate;

public class Program {

	public static void main(String[] args) {		
			// Department
			Department dep1 = new Department();
			dep1.DepartmentID = 1;
			dep1.DepartmentName = "Marketing";
			
			Department dep2 = new Department();
			dep2.DepartmentID = 2;
			dep2.DepartmentName = "Sale";
			
			Department dep3 = new Department();
			dep3.DepartmentID = 3;
			dep3.DepartmentName = "BOD";
			
			// Position
			Position pos1 = new Position();
			pos1.PositionID = 1;
			pos1.PositionName = PositionName.DEV;
			
			Position pos2 = new Position();
			pos2.PositionID = 2;
			pos2.PositionName = PositionName.TEST;
			
			Position pos3 = new Position();
			pos3.PositionID = 3;
			pos3.PositionName = PositionName.PM;
			
			// Group 
			Group group1 = new Group();
			group1.GroupID = 1;
			group1.GroupName = "Testing System";
			
			Group group2 = new Group();
			group2.GroupID = 2;
			group2.GroupName = "Development";
			
			Group group3 = new Group();
			group3.GroupID = 3;
			group3.GroupName = "Sale";
			
			// Account
			Account acc1 = new Account();
			acc1.AccountID = 1;
			acc1.Email = "account1@gmail.com";
			acc1.Username = "Account1";
			acc1.FullName = "FullName1";
			acc1.Department = dep1;
			acc1.Position = pos1;
			acc1.CreateDate = LocalDate.of(2020, 12, 12);
			acc1.groups = new Group[] {group1, group2};
			
			Account acc2 = new Account();
			acc2.AccountID = 2;
			acc2.Email = "account2@gmail.com";
			acc2.Username = "Account2";
			acc2.FullName = "FullName2";
			acc2.Department = dep2;
			acc2.Position = pos3;
			acc2.CreateDate = LocalDate.of(2020, 10, 05);
			acc2.groups = new Group[] {group1, group3};
			
			Account acc3 = new Account();
			acc3.AccountID = 3;
			acc3.Email = "account3@gmail.com";
			acc3.Username = "Account3";
			acc3.FullName = "FullName3";
			acc3.Department = dep3;
			acc3.Position = pos2;
			acc3.CreateDate = LocalDate.of(2017, 03, 22);
			Group[] groupAcc3 = {group2, group3};
			acc3.groups = groupAcc3;
			
			// Add Group Account
			group1.accounts = new Account[] {acc1, acc2};
			group2.accounts = new Account[] {acc1, acc3};
			group3.accounts = new Account[] {acc2};
			
			// Type Question
			TypeQuestion typeQues1 = new TypeQuestion();
			typeQues1.TypeID = 1;
			typeQues1.TypeName = TypeName.ESSAY;
			
			TypeQuestion typeQues2 = new TypeQuestion();
			typeQues2.TypeID = 2;
			typeQues2.TypeName = TypeName.MULTIPLE_CHOICE;
			
			TypeQuestion typeQues3 = new TypeQuestion();
			typeQues3.TypeID = 3;
			typeQues3.TypeName = TypeName.ESSAY;
			
			// Category Question
			CategoryQuestion cateQues1 = new CategoryQuestion();
			cateQues1.CategoryID = 1;
			cateQues1.CategoryName = "Java";
			
			CategoryQuestion cateQues2 = new CategoryQuestion();
			cateQues2.CategoryID = 2;
			cateQues2.CategoryName = "ASP.NET";
			
			CategoryQuestion cateQues3 = new CategoryQuestion();
			cateQues3.CategoryID = 3;
			cateQues3.CategoryName = "SQL";
			
			// Question
			Question ques1 = new Question();
			ques1.QuestionID = 1;
			ques1.Content = "Content question 1";
			ques1.categoryQuestion = cateQues1;
			ques1.typeQuestion = typeQues2;
			ques1.CreatorID = acc3;
			ques1.CreateDate = LocalDate.of(2019, 03, 12);
			
			Question ques2 = new Question();
			ques2.QuestionID = 2;
			ques2.Content = "Content question 2";
			ques2.categoryQuestion = cateQues2;
			ques2.typeQuestion = typeQues2;
			ques2.CreatorID = acc2;
			ques2.CreateDate = LocalDate.of(2019, 11, 20);
			
			Question ques3 = new Question();
			ques3.QuestionID = 3;
			ques3.Content = "Content question 3";
			ques3.categoryQuestion = cateQues1;
			ques3.typeQuestion = typeQues1;
			ques3.CreatorID = acc3;
			ques3.CreateDate = LocalDate.of(2018, 10, 29);
			
			// Answer
			Answer ans1 = new Answer();
			ans1.AnswerID = 1;
			ans1.Content = "Content answer 1";
			ans1.question = ques2;
			ans1.isCorrect = true;
			
			Answer ans2 = new Answer();
			ans2.AnswerID = 2;
			ans2.Content = "Content answer 2";
			ans2.question = ques3;
			ans2.isCorrect = false;
			
			Answer ans3 = new Answer();
			ans3.AnswerID = 3;
			ans3.Content = "Content answer 3";
			ans3.question = ques2;
			ans3.isCorrect = false;
			
			// Exam
			Exam ex1 = new Exam();
			ex1.ExamID = 1;
			ex1.Code = "VTI001";
			ex1.Title = "Đề thi Java";
			ex1.categoryQuestion = cateQues2;
			ex1.Duration = 60;
			ex1.CreatorID = acc1;
			ex1.CreateDate = LocalDate.of(2017, 04, 05);
			ex1.questions = new Question[] {ques1, ques3};
			
			Exam ex2 = new Exam();
			ex2.ExamID = 2;
			ex2.Code = "VTI002";
			ex2.Title = "Đề thi ASP.NET";
			ex2.categoryQuestion = cateQues3;
			ex2.Duration = 90;
			ex2.CreatorID = acc3;
			ex2.CreateDate = LocalDate.of(2019, 04, 10);
			ex2.questions = new Question[] {ques2};
			
			Exam ex3 = new Exam();
			ex3.ExamID = 3;
			ex3.Code = "VTI003";
			ex3.Title = "Đề thi SQL";
			ex3.categoryQuestion = cateQues1;
			ex3.Duration = 60;
			ex3.CreatorID = acc1;
			ex3.CreateDate = LocalDate.of(2016, 10, 05);
			ex3.questions = new Question[] {ques2, ques3};
			
			// Add Question Exam
			ques1.exams = new Exam[] {ex1, ex3};
			ques1.exams = new Exam[] {ex2, ex3};
			ques1.exams = new Exam[] {ex1, ex2, ex3};
			
			System.out.println("In thông tin account trên hệ thống");
			System.out.println("Thông tin Account1: " + "\nID: " + acc1.AccountID + "\nEmail" + acc1.Email + "\nDepartment: " + acc1.Department.DepartmentName +
							"\nPosition: " + acc1.Position.PositionName + "\nGroup: " + acc1.groups[0].GroupName + ", " + acc1.groups[1].GroupName +
							"\nCreateDate: " + acc1.CreateDate);
			
			System.out.println("---------------------------------------");
			
			System.out.println("Thông tin Account2: " + "\nID: " + acc2.AccountID + "\nEmail" + acc2.Email + "\nDepartment: " + acc2.Department.DepartmentName +
					"\nPosition: " + acc2.Position.PositionName + "\nGroup: " + acc2.groups[0].GroupName + ", " + acc2.groups[1].GroupName +
					"\nCreateDate: " + acc2.CreateDate);
			
			System.out.println("---------------------------------------");
			
			System.out.println("Thông tin Account3: " + "\nID: " + acc3.AccountID + "\nEmail" + acc3.Email + "\nDepartment: " + acc3.Department.DepartmentName +
					"\nPosition: " + acc3.Position.PositionName + "\nGroup: " + acc3.groups[0].GroupName + ", " + acc3.groups[1].GroupName +
					"\nCreateDate: " + acc3.CreateDate);
			
			System.out.println("---------------------------------------");
	}

}
