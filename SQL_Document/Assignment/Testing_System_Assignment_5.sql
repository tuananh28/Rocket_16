DROP DATABASE IF EXISTS `Testing_System_Assignment_5`;
CREATE DATABASE `Testing_System_Assignment_5`;
USE `Testing_System_Assignment_1`;

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
-- Subquery
DROP VIEW IF EXISTS `DepartmentSale`;
CREATE VIEW `DepartmentSale` AS 
SELECT 	A.*
FROM	`Account` A
JOIN	`Department` D
USING	(DepartmentID)
WHERE	D.DepartmentName = 'Sale';

-- CTE
WITH `DepartmentSale` AS
(
	SELECT 	A.*
	FROM	`Account` A
	JOIN	`Department` D
	USING	(DepartmentID)
	WHERE	D.DepartmentName = 'Sale'
)
SELECT * FROM `DepartmentSale`;
-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
DROP VIEW IF EXISTS `MaxAccountOfGroup`;
CREATE VIEW `MaxAccountOfGroup` AS
SELECT		A.*,COUNT(GA.AccountID) AS 'So_Luong'
FROM 		`Account` A
JOIN		`GroupAccount` GA
USING		(AccountID)
GROUP BY	GA.AccountID
HAVING		COUNT(GA.AccountID) = (SELECT MAX(COUNTA)
									FROM ( SELECT 		COUNT(GA.AccountID) AS COUNTA 
											FROM  		`Account` A
											JOIN		`GroupAccount` GA
											USING		(AccountID)
											GROUP BY	GA.AccountID)AS Maxgroup);

-- CTE

WITH `MaxAccountOfGroup` AS
(
	SELECT		A.*,COUNT(GA.AccountID) AS 'So_Luong'
	FROM 		`Account` A
	JOIN		`GroupAccount` GA
	USING		(AccountID)
	GROUP BY	GA.AccountID
	HAVING		COUNT(GA.AccountID) = (SELECT MAX(COUNTA)
										FROM ( SELECT 		COUNT(GA.AccountID) AS COUNTA 
												FROM  		`Account` A
												JOIN		`GroupAccount` GA
												USING		(AccountID)
												GROUP BY	GA.AccountID)AS Maxgroup)
)
SELECT * FROM `MaxAccountOfGroup`;
/* Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ 
 được coi là quá dài) và xóa nó đi*/
 
CREATE OR REPLACE VIEW `DelContent300` AS
SELECT	Content 
FROM	`Question`
WHERE	character_length(Content) > 12;

-- CTE
WITH `DelContent300` AS
(
	SELECT	Content 
	FROM	`Question`
	WHERE	character_length(Content) > 12
)
DELETE FROM `DelContent300`;


-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất

CREATE OR REPLACE VIEW `MaxAccountOfDepartment` AS
SELECT		D.*,COUNT(A.DepartmentID) AS 'So_Luong'
FROM		`Department` D
JOIN		`Account` A
USING		(DepartmentID)
GROUP BY 	A.DepartmentID
HAVING		COUNT(A.DepartmentID) = (SELECT MAX(COUNTD)
									FROM ( SELECT COUNT(A.DepartmentID) AS COUNTD
											FROM	`Department` D
											JOIN	`Account` A
											USING	(DepartmentID)
											GROUP BY A.DepartmentID) AS MaxAccount);
-- CTE

WITH `MaxAccountOfDepartment` AS
(
	SELECT		D.*,COUNT(A.DepartmentID) AS 'So_Luong'
	FROM		`Department` D
	JOIN		`Account` A
	USING		(DepartmentID)
	GROUP BY 	A.DepartmentID
	HAVING		COUNT(A.DepartmentID) = (SELECT MAX(COUNTD)
										FROM ( SELECT COUNT(A.DepartmentID) AS COUNTD
												FROM	`Department` D
												JOIN	`Account` A
												USING	(DepartmentID)
												GROUP BY A.DepartmentID) AS MaxAccount)
)
SELECT * FROM `MaxAccountOfDepartment`;
-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
-- Cách 1

CREATE OR REPLACE VIEW `QuestionOfNguyen` AS
SELECT 	 	*
FROM		`Question`
WHERE		CreatorID IN (SELECT AccountID
							FROM `Account`
                            WHERE FullName LIKE 'Nguyễn%');
-- Cách 2

SELECT 		Q.*, A.FullName
	FROM 		Question Q 
	INNER JOIN 	`Account` A ON Q.CreatorID = A.AccountID
	WHERE		SUBSTRING_INDEX(FullName,' ',1) = 'Nguyen';
