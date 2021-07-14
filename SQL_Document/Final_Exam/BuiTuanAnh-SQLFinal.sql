DROP DATABASE IF EXISTS `Requirement`;
CREATE DATABASE `Requirement`;
USE `Requirement`;

CREATE TABLE `Student`(
    ID      TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Name    VARCHAR(50),
    Age     TINYINT UNSIGNED,
    Gender  ENUM('Male', 'Female')
);

CREATE TABLE `Subject`(
    ID      TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Name    VARCHAR(50)
);

CREATE TABLE `StudentSubject`(
    StudentID TINYINT UNSIGNED,
    SubjectID TINYINT UNSIGNED,
    Mark      TINYINT UNSIGNED,
    Date      DATETIME DEFAULT NOW(),
    PRIMARY KEY(StudentID, SubjectID)
);
/*1. Tạo table với các ràng buộc và kiểu dữ liệu
Thêm ít nhất 3 bản ghi vào table*/

INSERT INTO `Student` (     Name         , Age, Gender  )
VALUES                ('Bùi Tuấn Anh'    , 22 ,  'Male' ),
                      ('Bùi Thị Hoa Mai' , 28 , 'Female'),
                      ('Lê Thị Binh'	 , 18 , 'Female'),
                      ('Nguyễn Hữu Bằng' , 17 ,  'Male' ),
                      ('Trần Tuấn Phương', 32 ,  'Male' ),
                      ('Nguyễn Thị Lê'   , 35 , 'Female'),
                      ('Đặng Thị Thảo'   , 21 , 'Female'),
                      ('Lê Hoàng Khôi'   , 25 ,  'Male' ),
                      ('Trần Văn Diễn'   , 22 ,  'Male' ),
                      ('Bùi Minh Hiếu'   , 22 ,  'Male' );

INSERT INTO `Subject` (Name )
VALUES                ('Toán'),
                      ('Văn'),
                      ('Tiếng Anh'),
                      ('Địa Lý'),
                      ('Tin Học');

INSERT INTO `StudentSubject` (StudentID, SubjectID, Mark ,  Date      )
VALUES                       (    1    ,     5    ,  10  ,'2021-07-12'),
                             (    2    ,     5    ,  9   ,'2021-06-12'),
                             (    3    ,     1    ,  NULL,'2021-05-12'),
                             (    4    ,     1    ,  7   ,'2021-04-12'),
                             (    5    ,     5    ,  7   ,'2021-03-12'),
                             (    6    ,     2    ,  2   ,'2021-02-12'),
                             (    7    ,     3    ,  NULL,'2021-01-12'),
                             (    8    ,     5    ,  5   ,'2018-05-12'),
                             (    9    ,     4    ,  NULL,'2017-04-12'),
                             (    10   ,     5    ,  8   ,'2016-03-12');

-- 2. Viết lệnh để
-- a)   Lấy tất cả các môn học không có bất kì điểm nào
SELECT  S.Name
FROM   `Subject` S
JOIN   `StudentSubject` SS
ON      S.ID = SS.SubjectID
WHERE   SS.Mark IS NULL ;


-- b) Lấy danh sách các môn học có ít nhất 2 điểm */
SELECT  S.Name, COUNT(SS.Mark) AS 'So_luong'
FROM   `Subject` S
JOIN   `StudentSubject` SS
ON      S.ID = SS.SubjectID
GROUP BY SS.SubjectID
HAVING   `So_luong` <= 2;

/* 3. Tạo view có tên là "StudentInfo" lấy các thông tin về học sinh bao gồm:
Student ID,Subject ID, Student Name, Student Age, Student Gender,
Subject Name, Mark, Date
(Với cột Gender show 'Male' để thay thế cho 0, 'Female' thay thế cho 1 và
'Unknow' thay thế cho null)*/
CREATE OR REPLACE VIEW `StudentInfo` AS
SELECT ss.studentid , ss.subjectid , Stu.Name ,Stu.Age,
CASE Stu.Gender
    WHEN 1 THEN 'Female'
    when 0 THEN 'Male'
    ELSE 'Unknown'
    END AS 'Gender'  ,
Sub.Name as 'Subject Name' ,ss.Mark, ss.`Date`
FROM `studentsubject` ss
JOIN `student` Stu on Stu.id= ss.studentid
JOIN `subject` Sub on Sub.id= ss.subjectid ;
SELECT * FROM StudentInfo;

-- 4. Không sử dụng On Update Cascade & On Delete Cascade
/*a) Tạo trigger cho table Subject có tên là SubjectUpdateID:
Khi thay đổi data của cột ID của table Subject, thì giá trị tương
ứng với cột SubjectID của table StudentSubject cũng thay đổi
theo*/
DROP TRIGGER IF EXISTS `SubjectUpdateID`;
DELIMITER //
CREATE TRIGGER `SubjectUpdateID`
    BEFORE UPDATE  ON `Subject`
    FOR EACH ROW
    BEGIN
        UPDATE `StudentSubject`
        SET     SubjectID = NEW.ID
        WHERE   SubjectID = OLD.ID;
    end //
DELIMITER ;
UPDATE `Subject`
SET ID = 6
WHERE ID = 5;

BEGIN WORK ;
SELECT  * FROM Subject;
SELECT * FROM StudentSubject;
ROLLBACK ;

/*b) Tạo trigger cho table Student có tên là StudentDeleteID:
Khi xóa data của cột ID của table Student, thì giá trị tương ứng với
cột SubjectID của table StudentSubject cũng bị xóa theo*/
DROP TRIGGER IF EXISTS `StudentDeleteID`;
DELIMITER //
CREATE TRIGGER `StudentDeleteID`
    BEFORE DELETE ON `Student`
    FOR EACH ROW
    BEGIN
        DELETE
        FROM `StudentSubject`
        WHERE StudentID = OLD.ID;
    end //
DELIMITER ;
DELETE
FROM `Student`
WHERE ID = 1;
BEGIN WORK ;
ROLLBACK ;
/*5. Viết 1 store procedure (có 2 parameters: student name) sẽ xóa tất cả các
thông tin liên quan tới học sinh có cùng tên như parameter
Trong trường hợp nhập vào student name = "*" thì procedure sẽ xóa tất cả
các học sinh*/
DROP PROCEDURE IF EXISTS Ques_5;
DELIMITER //
CREATE PROCEDURE `Ques_5`(IN in_student_Name VARCHAR(50))
    BEGIN
        DELETE
        FROM `Student`
        WHERE in_student_Name = Name;
        IF(in_student_Name = '*') THEN
            DELETE
            FROM `Student`;
        end if ;
    end //
DELIMITER ;
CALL `Ques_5`('Bùi Tuấn Anh');
SELECT * FROM Student;
