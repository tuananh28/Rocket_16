DROP DATABASE IF EXISTS `Testing_System_Assignment_7`;
CREATE DATABASE IF NOT EXISTS `Testing_System_Assignment_7`;
USE `Testing_System_Assignment_1`;

/* Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo
 trước 1 năm trước */

DROP TRIGGER  IF EXISTS TG_Question1;
DELIMITER //
CREATE TRIGGER TG_Question1
    BEFORE INSERT  ON `Group`
    FOR EACH ROW
        BEGIN
            DECLARE CreateDate DATETIME DEFAULT  NOW();
        SET CreateDate = DATE_SUB(NOW(), INTERVAL 1 YEAR);
            IF NEW.CreateDate <= CreateDate THEN
                SIGNAL  SQLSTATE  '12345'
                SET  MESSAGE_TEXT  = 'Không thêm được group';
            END IF;
        END //
DELIMITER ;

INSERT INTO `Testing_System_Assignment_1`.`group` (GroupName, CreatorID, CreateDate  )
VALUES                                            (  'ABC'  ,   '1'    , '2020-01-01');


/* Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
 department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
 "Sale" cannot add more user" */

DROP TRIGGER IF EXISTS  TG_Question2;
DELIMITER //
CREATE TRIGGER TG_Question2
    BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN
        DECLARE  v_DepID TINYINT;
        SELECT   d.DepartmentID INTO v_DepID
        FROM    `department` d
        WHERE    d.DepartmentName = 'Sale';
        IF (NEW.DepartmentID = v_DepID) THEN
            SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
        END IF ;
    END //
DELIMITER ;
INSERT INTO `account` (         Email       ,   Username   ,    FullName    , DepartmentID , PositionID , CreateDate  )
VALUES                ('qnanh28@gmail.com'  , 'tuananh28'  , 'Bùi Tuấn Anh' ,       2      ,       1    , '2020-11-03');
-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS TG_Question3;
DELIMITER //
CREATE TRIGGER TG_Question3
    BEFORE INSERT ON `groupaccount`
    FOR EACH ROW
    BEGIN
        DECLARE var_CountGroupID TINYINT;
        SELECT  COUNT(GroupID) INTO var_CountGroupID
        FROM    `groupaccount`
        WHERE   GroupID = NEW.GroupID;
        IF (var_CountGroupID > 5 )
            THEN
            SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Group cannot add more user';
        END IF;
    END //
DELIMITER ;
INSERT INTO `groupaccount` (GroupID, AccountID,   JoinDate  )
VALUES                     (  '1'  ,    '1'   , '2020-04-12');
-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS TG_Question4;
DELIMITER $$
CREATE TRIGGER TG_Question4
    BEFORE INSERT ON `examquestion`
    FOR EACH ROW
    BEGIN
        DECLARE var_CountQuesInExam TINYINT;
        SELECT  COUNT(ExamID) INTO var_CountQuesInExam
        FROM    `examquestion`
        WHERE   ExamID = NEW.ExamID;
        IF(var_CountQuesInExam > 10)
            THEN
            SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Exam cannot add more Question';
        END IF;
    END $$
DELIMITER ;
/* Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
 admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
 còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
 tin liên quan tới user đó */

DROP TRIGGER IF EXISTS TG_Question5;
DELIMITER //
CREATE TRIGGER TG_Question5
    BEFORE DELETE ON `account`
    FOR EACH ROW
    BEGIN
        DECLARE v_Email VARCHAR(50);
        SET v_Email = 'admin@gmail.com';
        IF (OLD.Email = v_Email)
            THEN
            SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'This User Admin, you cant delete it!!';
        END IF ;
    END //
DELIMITER ;
DELETE FROM account WHERE Email = 'admin@gmail.com';
/* Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
 Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
 vào departmentID thì sẽ được phân vào phòng ban "waiting Department" */

DROP TRIGGER IF EXISTS TG_Question6;
DELIMITER //
CREATE TRIGGER TG_Question6
    BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN
        DECLARE v_WaitingRoom VARCHAR(30);
        SELECT  DepartmentID INTO v_WaitingRoom
        FROM `department`
        WHERE DepartmentName = 'Waiting Room';
        IF (NEW.DepartmentID IS NULL) THEN
            SET NEW.DepartmentID = v_WaitingRoom;
        end if ;
    END //
DELIMITER ;
insert into `department` (DepartmentID, DepartmentName)
values                   (     11     ,'Waiting Room' );
INSERT INTO `account` (         Email       ,   Username   ,    FullName     , PositionID , CreateDate  )
VALUES                ('banhbeo28@gmail.com', 'banhbeo28'  , 'Bùi Tuấn Anh'  ,       1    , '2020-11-03');
SELECT * FROM account;
/* Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
 question, trong đó có tối đa 2 đáp án đúng. */
DROP TRIGGER IF EXISTS TG_Question7;
DELIMITER //
CREATE TRIGGER TG_Question7
    BEFORE INSERT ON `answer`
    FOR EACH ROW
    BEGIN
        DECLARE v_CountAns TINYINT;
        DECLARE v_CountCorrect TINYINT;
        SELECT COUNT(QuestionID) INTO v_CountAns
        FROM `answer`
        WHERE QuestionID = NEW.QuestionID;
        SELECT COUNT(1) INTO v_CountCorrect
        FROM `answer`
        WHERE QuestionID = NEW.QuestionID AND isCorrect = NEW.isCorrect;
        IF (v_CountCorrect > 4 ) AND (v_CountCorrect > 2) THEN
            SIGNAL SQLSTATE '12345'
            SET  MESSAGE_TEXT = 'Cant insert more data pls check again!!';
        END IF;
    END //
DELIMITER ;
INSERT INTO `answer` ( Content  , QuestionID, isCorrect)
VALUES               ('Trigger' ,     1     ,    1     );

SELECT * FROM answer;
/* Question 8: Viết trigger sửa lại dữ liệu cho đúng:
 Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
 Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database */
USE `Fresher`;
DROP TRIGGER IF EXISTS TG_Question8;
DELIMITER //
CREATE TRIGGER TG_Question8
    BEFORE UPDATE ON `Trainee`
    FOR EACH ROW
    BEGIN
        IF NEW.Gender = 'MALE' THEN
            SET NEW.Gender = 'M';
        ELSEIF NEW.Gender = 'FEMALE' THEN
            SET  NEW.Gender = 'F';
        ELSEIF NEW.Gender = 'unknown' THEN
            SET NEW.Gender = 'U';
        END IF;
    END //
DELIMITER ;
-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS TG_Question9;
DELIMITER //
CREATE TRIGGER TG_Question9
    BEFORE DELETE ON `exam`
    FOR EACH ROW
    BEGIN
        DECLARE v_CreateDate DATETIME;
        SET v_CreateDate = DATE_SUB(NOW(),INTERVAL 2 DAY );
        IF (OLD.CreateDate > v_CreateDate) THEN
            SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Cannot Delete';
        END IF;
    END //
DELIMITER ;
DELETE FROM `exam` WHERE ExamID = 1;
/* Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
 question khi question đó chưa nằm trong exam nào */
 -- UPDATE
DROP TRIGGER IF EXISTS TG_Question10_up;
DELIMITER //
CREATE TRIGGER TG_Question10_up
    BEFORE UPDATE ON `question`
    FOR EACH ROW
    BEGIN
        DECLARE v_CountQuesByID TINYINT;
        SET v_CountQuesByID  = -1;
        SELECT  COUNT(1) INTO v_CountQuesByID
        FROM `examquestion`
        WHERE QuestionID = NEW.QuestionID;
            IF (v_CountQuesByID  != 1 ) THEN
                SIGNAL SQLSTATE  '12345'
                SET MESSAGE_TEXT = 'Cannot Update this Question';
            END IF;
    end //
DELIMITER ;

UPDATE `question` SET `Content` = 'Câu hỏi .NET' WHERE (QuestionID = 2);

-- DELETE
DROP TRIGGER IF EXISTS TG_Question10_Del;
DELIMITER //
CREATE TRIGGER TG_Question10_Del
    BEFORE DELETE ON `question`
    FOR EACH ROW
    BEGIN
        DECLARE v_CountQuesByID TINYINT;
        SET v_CountQuesByID = -1;
        SELECT COUNT(1) INTO v_CountQuesByID
        FROM examquestion
        WHERE examquestion.QuestionID = OLD.QuestionID;
        IF (v_CountQuesByID != -1) THEN
            SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Cannot Delete This Question !';
        end if;
    end //
DELIMITER ;
DELETE FROM `question` WHERE QuestionID = 2;

/*Question 12: Lấy ra thông tin exam trong đó:
Duration <= 30 thì sẽ đổi thành giá trị "Short time"
30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
Duration > 60 thì sẽ đổi thành giá trị "Long time" */

SELECT ExamID, Code, Title ,
       CASE
			WHEN Duration <= 30 THEN 'Short time'
			WHEN Duration <= 60 THEN 'Medium time'
			ELSE 'Longtime'
	   END AS Duration, CreateDate, Duration
FROM `exam` ;
/* Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
 là the_number_user_amount và mang giá trị được quy định như sau:2
Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher */
SELECT G.GroupID,G.GroupName, COUNT(GA.AccountID),
       CASE
            WHEN COUNT(GA.AccountID) <= 5 THEN 'Few'
            WHEN COUNT(GA.AccountID) <=20 THEN 'Normal'
            ELSE 'Higher'
       END AS 'the_number_user_amount'
FROM `group` G
LEFT JOIN `groupaccount` GA
USING (GroupID)
GROUP BY G.GroupID;
/* Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
 không có user thì sẽ thay đổi giá trị 0 thành "Không có User" */

SELECT D.* , COUNT(A.AccountID) ,
    CASE
        WHEN COUNT(A.AccountID) = 0 THEN 'Không có User nào'
        ELSE COUNT(A.AccountID)
    END AS 'the_number_user_amount'
FROM `department` D
LEFT JOIN  `Account` A
USING (DepartmentID)
GROUP BY A.DepartmentID;
