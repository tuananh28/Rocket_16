
import java.time.LocalDate;


public class Question {
    int QuestionID;
    String Content;
    CategoryQuestion categoryQuestion;
    TypeQuestion typeQuestion;
    Account CreatorID ;
    Account account;
    LocalDate CreateDate;
    Exam [] exams;
}
