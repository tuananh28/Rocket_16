DROP DATABASE IF EXISTS `Testing_System_Assignment_3`;
CREATE DATABASE IF NOT EXISTS `Testing_System_Assignment_3`;
USE `Testing_System_Assignment_1`;
USE `Testing_System_Assignment_2`;

-- Question 2: lấy ra tất cả các phòng ban
SELECT *
FROM `department`;

-- Question 3: lấy ra id của phòng ban "Sale"
SELECT DepartmentID
FROM `Department`
WHERE DepartmentName = "Sale";

-- Question 4: lấy ra thông tin account có full name dài nhất
SELECT *
FROM `Account`
WHERE length(FullName) = (SELECT MAX( length(FullName)) FROM `Account`);

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
SELECT *
FROM `Account`
WHERE length(FullName) = ( SELECT MAX(length(FullName))FROM `Account` WHERE `DepartmentID` = 3);

-- Question 6: Lấy ra tên group đã tham gia trước ngày 2021-05-28
SELECT GroupName
FROM `Group`
WHERE CreateDate < "2021-05-28";

-- Question 7: Lấy ra ID của question có >= 4 câu trả lời

SELECT QuestionID
FROM Answer
GROUP BY QuestionID
HAVING COUNT(AnswerID) >= 4;

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 2020-05-21

SELECT `Code`
FROM `Exam`
WHERE Duration >= 60 AND CreateDate < "2020-05-21";

-- Question 9: Lấy ra 5 group được tạo gần đây nhất

SELECT *
FROM `Group`
ORDER BY CreateDate DESC
LIMIT 5;

-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT COUNT(AccountID) AS "Số Lượng"
FROM `Account`
WHERE DepartmentID = 2;

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"

SELECT * 
FROM `Account`
WHERE FullName LIKE "Đ%o";

-- Question 12: Xóa tất cả các exam được tạo trước ngày 2020-05-19

DELETE
FROM `Exam`
WHERE CreateDate < "2020-05-19";

SELECT * 
FROM `Exam`;

-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi

DELETE
FROM `Question`
WHERE Content Like "Câu hỏi%";

SELECT * 
FROM `question`;

-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn

UPDATE `Account`
SET FullName = "Nguyễn Bá Lộc" , Email = "loc.nguyenba@vti.com.vn"
WHERE AccountID = 5;

SELECT * 
FROM `Account`;

-- Question 15: update account có id = 5 sẽ thuộc group có id = 4
UPDATE `GroupAccount`
SET GroupID = 4
WHERE AccountID = 5 ;

SELECT * 
FROM `GroupAccount`;