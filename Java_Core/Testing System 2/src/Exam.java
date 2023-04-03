
import java.time.LocalDate;


public class Exam {
    int ExamID;
    String Code;
    String Title;
    CategoryQuestion categoryQuestion;
    int Duration;
    Account CreatorID ;
    Account account;
    LocalDate CreateDate;
    Question[] questions;
}
