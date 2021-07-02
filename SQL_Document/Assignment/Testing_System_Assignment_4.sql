DROP DATABASE IF EXISTS `Testing_System_Assignment_4`;
CREATE DATABASE `Testing_System_Assignment_4`;
USE `Testing_System_Assignment_2`;

-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT 		A.* , D.DepartmentName
FROM 		`Account` A
JOIN		`Department` D
ON			A.DepartmentID = D.DepartmentID
GROUP BY	D.DepartmentName;
-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày '2018-12-05'
SELECT *
FROM 	`Account`
WHERE	CreateDate > '2018-12-05';
-- Question 3: Viết lệnh để lấy ra tất cả các developer 
SELECT  A.* , P.PositionName
FROM	`Account` A
JOIN	`Position` P
ON		A.PositionID = P.PositionID
WHERE	P.PositionName = 'Dev';
-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >1 nhân viên
SELECT 		D.DepartmentName, COUNT(A.DepartmentID) AS 'Số lượng' 
FROM 		`Account` A
JOIN		`Department` D
ON			A.DepartmentID = D.DepartmentID
GROUP BY	D.DepartmentName
HAVING		COUNT(A.DepartmentID) > 1;
-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT		Q.*,COUNT(EQ.QuestionID)
FROM		`Question` Q
JOIN		`ExamQuestion` EQ
ON			Q.QuestionID = EQ.QuestionID
GROUP BY	Q.Content
HAVING		COUNT(EQ.QuestionID) = (SELECT MAX(COUNTQ)
									FROM 
                                    (SELECT 	COUNT(Q.Content) AS COUNTQ
									FROM		`Question` Q
									JOIN		`ExamQuestion` EQ
									ON			Q.QuestionID = EQ.QuestionID
									GROUP BY	Q.Content)AS MAXcontent);
-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT 		CQ.*,COUNT(Q.CategoryID) AS 'Số lần'
FROM		`CategoryQuestion` CQ
JOIN		`Question` Q
ON			CQ.CategoryID = Q.CategoryID
GROUP BY	Q.Content;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
-- Question 9: Thống kê số lượng account trong mỗi group 
-- Question 10: Tìm chức vụ có ít người nhất
-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của 
-- question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, …
-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
-- Question 14:Lấy ra group không có account nào
-- Question 15: Lấy ra group không có account nào
-- Question 16: Lấy ra question không có answer nào