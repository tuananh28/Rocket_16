-- create database
DROP DATABASE IF EXISTS Testing_System_4;
CREATE DATABASE Testing_System_4;
USE Testing_System_4;

-- create table 1: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 			NVARCHAR(30) NOT NULL UNIQUE KEY
);

-- create table 2: Position
DROP TABLE IF EXISTS Position;
CREATE TABLE `Position` (
	PositionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName			ENUM('Dev','Test','ScrumMaster','PM') NOT NULL UNIQUE KEY
);

-- create table 2: Salary
DROP TABLE IF EXISTS Salary;
CREATE TABLE `Salary` (
	SalaryID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    SalaryName			ENUM('600','700','1500','2000') NOT NULL UNIQUE KEY -- 600: Dev, Test: 700, Scrum Master: 1500, PM: 2000
);

-- create table 3: Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    Username				VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    FirstName				NVARCHAR(50) NOT NULL,
    LastName				NVARCHAR(50) NOT NULL,	-- create field fullName in POJO
    CreateDate				DATETIME DEFAULT NOW() -- Cannot update this field
);

-- create table 4: Group
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName				NVARCHAR(50) NOT NULL UNIQUE KEY,
    CreateDate				DATETIME DEFAULT NOW() -- Cannot update this field
);

-- create table 6: TypeQuestion
DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion (
    TypeID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName 		ENUM('0','1') NOT NULL UNIQUE KEY -- 0:  Esay, 1: Multiple-Choice
);

-- create table 7: CategoryQuestion
DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion(
    CategoryID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
    CategoryName			NVARCHAR(50) NOT NULL UNIQUE KEY
);

-- create table 8: Question
DROP TABLE IF EXISTS Question;
CREATE TABLE Question(
    QuestionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(100) NOT NULL,
    CreateDate				DATETIME DEFAULT NOW() -- Cannot update this field
);

-- create table 9: Answer
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer(
    Answers					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(100) NOT NULL,
    isCorrect				BIT DEFAULT 1
);

-- create table 10: Exam
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam (
    ExamID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code1`					CHAR(10) NOT NULL,	-- L-1: if duration >= 180p, M-1: if duration >= 90p, S-1: otherwise -- Cannot update this field
    `Code2`					CHAR(10), -- NOT NULL,	-- L-1: if duration >= 180p, M-1: if duration >= 90p, S-1: otherwise -- Cannot update this field
    Title					NVARCHAR(50) NOT NULL,
    Duration				TINYINT UNSIGNED NOT NULL DEFAULT 45,
    CreateDate				DATETIME DEFAULT NOW() -- Cannot update this field
);
/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Department
INSERT INTO Department(DepartmentName)
VALUES
						(N'Marketing'	),
						(N'Sale'		),
						(N'Bảo vệ'		),
						(N'Nhân sự'		),
						(N'Kỹ thuật'	),
						(N'Tài chính'	),
						(N'Phó giám đốc'),
						(N'Giám đốc'	),
						(N'Thư kí'		),
						(N'Bán hàng'	);

-- Add data position
INSERT INTO Position	(`PositionName`	)
VALUES 					('Dev'			),
						('Test'			),
						('ScrumMaster'	);

-- Add data salary
INSERT INTO Salary		(SalaryName	)
VALUES 					('600'		),
						('700'		),
						('1500'		);


-- Add data Account
INSERT INTO `Account`(Email								, Username			, FirstName,	LastName,			CreateDate)
VALUES 				('haidang29productions@gmail.com'	, 'dangblack'		,'Dang'	,		'Nguyen Hai'	,	'2020-03-05'),
					('account1@gmail.com'				, 'quanganh'		,'Anh'	,		'Tong Quang'	,	'2020-03-05'),
                    ('account2@gmail.com'				, 'vanchien'		,'Chien',		'Nguyen Van'	,	'2020-03-07'),
                    ('account3@gmail.com'				, 'cocoduongqua'	,'Do'	,		'Duong'			,	'2020-03-08'),
                    ('account4@gmail.com'				, 'doccocaubai'		,'Thang',		'Nguyen Chien'  ,	'2020-03-10'),
                    ('dapphatchetngay@gmail.com'		, 'khabanh'			,'Kha'	,		'Ngo Ba'		,	NOW()),
                    ('songcodaoly@gmail.com'			, 'huanhoahong'		,'Huan'	,		'Bui Xuan'		,	NOW()),
                    ('sontungmtp@gmail.com'				, 'tungnui'			,'Tung'	,		'Nguyen Thanh'	,	'2020-04-07'),
                    ('duongghuu@gmail.com'				, 'duongghuu'		,'Huu'	,		'Duong Van'		,	'2020-04-07'),
                    ('vtiaccademy@gmail.com'			, 'vtiaccademy'		,'Ai'	,		'Vi Ti'			,	'2020-04-09');

-- Add data Group
INSERT INTO `Group`	(  GroupName			, CreateDate)
VALUES 				(N'Testing System'		,'2019-03-05'),
					(N'Developement'		,'2020-03-07'),
                    (N'VTI Sale 01'			,'2020-03-09'),
                    (N'VTI Sale 02'			,'2020-03-10'),
                    (N'VTI Sale 03'			,'2020-03-28'),
                    (N'VTI Creator'			,'2020-04-06'),
                    (N'VTI Marketing 01'	,'2020-04-07'),
                    (N'Management'			,'2020-04-08'),
                    (N'Chat with love'		,'2020-04-09'),
                    (N'Vi Ti Ai'			,'2020-04-10');

-- Add data TypeQuestion
INSERT INTO TypeQuestion	(TypeName	)
VALUES 						('0'),
							('1');


-- Add data CategoryQuestion
INSERT INTO CategoryQuestion		(CategoryName	)
VALUES 								('Java'			),
									('ASP.NET'		),
									('ADO.NET'		),
									('SQL'			),
									('Postman'		),
									('Ruby'			),
									('Python'		),
									('C++'			),
									('C Sharp'		),
									('PHP'			);

-- Add data Question
INSERT INTO Question	(Content			, CreateDate )
VALUES 					(N'Câu hỏi về Java'	,'2020-04-05'),
						(N'Câu Hỏi về PHP'	,'2020-04-05'),
						(N'Hỏi về C#'		,'2020-04-06'),
						(N'Hỏi về Ruby'		,'2020-04-06'),
						(N'Hỏi về Postman'	,'2020-04-06'),
						(N'Hỏi về ADO.NET'	,'2020-04-06'),
						(N'Hỏi về ASP.NET'	,'2020-04-06'),
						(N'Hỏi về C++'		,'2020-04-07'),
						(N'Hỏi về SQL'		,'2020-04-07'),
						(N'Hỏi về Python'	,'2020-04-07');

-- Add data Answers
INSERT INTO Answer	(  Content		, isCorrect	)
VALUES 				(N'Trả lời 01'	,	0		),
					(N'Trả lời 02'	,	1		),
                    (N'Trả lời 03'	,	0		),
                    (N'Trả lời 04'	,	1		),
                    (N'Trả lời 05'	,	1		),
                    (N'Trả lời 06'	,	1		),
                    (N'Trả lời 07'	,	0		),
                    (N'Trả lời 08'	,	0		),
                    (N'Trả lời 09'	,	1		),
                    (N'Trả lời 10'	,	1		);

-- Add data Exam
INSERT INTO Exam	(`Code1`			, Title				, Duration	,  CreateDate )
VALUES 				('S-1'			, N'Đề thi C#'			,	60		, '2019-04-05'),
					('S-2'			, N'Đề thi PHP'			,	60		, '2019-04-05'),
                    ('M-1'			, N'Đề thi C++'			,	120		, '2019-04-07'),
                    ('S-3'			, N'Đề thi Java'		,	60		, '2020-04-08'),
                    ('M-2'			, N'Đề thi Ruby'		,	120		, '2020-04-10'),
                    ('S-4'			, N'Đề thi Postman'		,	60		, '2020-04-05'),
                    ('S-5'			, N'Đề thi SQL'			,	60		, '2020-04-05'),
                    ('S-6'			, N'Đề thi Python'		,	60		, '2020-04-07'),
                    ('L-1'			, N'Đề thi ADO.NET'		,	180		, '2020-04-07'),
                    ('L-2'			, N'Đề thi ASP.NET'		,	180		, '2020-04-08');

select  * from exam;