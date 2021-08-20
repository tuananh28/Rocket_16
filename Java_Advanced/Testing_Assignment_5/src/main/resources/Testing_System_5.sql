-- create database
DROP DATABASE IF EXISTS Testing_System_5;
CREATE DATABASE Testing_System_5;
USE Testing_System_5;

-- create table : address
DROP TABLE IF EXISTS Address;
CREATE TABLE Address(
	AddressID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    AddressName 			NVARCHAR(100) NOT NULL UNIQUE KEY
);

-- create table: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 			NVARCHAR(30) NOT NULL UNIQUE KEY
);

-- create table : Detail Department
DROP TABLE IF EXISTS DetailDepartment;
CREATE TABLE DetailDepartment(
	DepartmentID 			TINYINT UNSIGNED PRIMARY KEY,
    AddressID 				TINYINT UNSIGNED, -- UNIQUE KEY,  -- NOT NULL ,
    EmulationPoint 			TINYINT UNSIGNED,
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID),
	FOREIGN KEY(AddressID) REFERENCES Address(AddressID)
);

-- create table: Posittion
DROP TABLE IF EXISTS Position;
CREATE TABLE `Position` (
	PositionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName			ENUM('Dev','Test','ScrumMaster','PM') NOT NULL UNIQUE KEY
);

-- create table: Salary
DROP TABLE IF EXISTS Salary;
CREATE TABLE `Salary` (
	SalaryID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    SalaryName			ENUM('600','700','1500','2000') NOT NULL UNIQUE KEY -- 600: Dev, Test: 700, Scrum Master: 1500, PM: 2000
);

-- create table: Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    Username				VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    FirstName				NVARCHAR(50) NOT NULL,
    LastName				NVARCHAR(50) NOT NULL,	-- create field fullName in POJO
    DepartmentID 			TINYINT UNSIGNED NOT NULL,	-- Set default waiting
    PositionID				TINYINT UNSIGNED NOT NULL,	-- Set default Dev
    SalaryID				TINYINT UNSIGNED NOT NULL, -- Set default 600
    CreateDate				DATETIME DEFAULT NOW(), -- Cannot update this field
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID),
    FOREIGN KEY(PositionID) REFERENCES `Position`(PositionID),
    FOREIGN KEY(SalaryID) REFERENCES `Salary`(SalaryID)
);

-- create table: Employee
DROP TABLE IF EXISTS `Employee`;
CREATE TABLE `Employee`(
	AccountID				TINYINT UNSIGNED PRIMARY KEY,
	WorkingNumberOfYear		TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(AccountID) REFERENCES `Account` (AccountID)
);

-- create table: Manager
DROP TABLE IF EXISTS `Manager`;
CREATE TABLE `Manager`(
	AccountID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ManagementNumberOfYear 		TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(AccountID) REFERENCES `Account` (AccountID)
);

-- create table: Group
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName				NVARCHAR(50) NOT NULL UNIQUE KEY,
    CreatorID				TINYINT UNSIGNED NOT NULL, -- Cannot update this field
    CreateDate				DATETIME DEFAULT NOW() -- Cannot update this field
);

-- create table: GroupAccount
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount(
	GroupID					TINYINT UNSIGNED NOT NULL,
    AccountID				TINYINT UNSIGNED NOT NULL,
    JoinDate				DATETIME DEFAULT NOW(),
    PRIMARY KEY (GroupID,AccountID),
    FOREIGN KEY(AccountID) REFERENCES `Account` (AccountID),
    FOREIGN KEY(GroupID) REFERENCES `Group` (GroupID)
);

-- create table: TypeQuestion
DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion (
    TypeID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName 		ENUM('0','1') NOT NULL UNIQUE KEY -- 0:  Esay, 1: Multiple-Choice
);

-- create table: CategoryQuestion
DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion(
    CategoryID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
    CategoryName			NVARCHAR(50) NOT NULL UNIQUE KEY
);

-- create table: Question
DROP TABLE IF EXISTS Question;
CREATE TABLE Question(
    QuestionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(100) NOT NULL,
    CategoryID				TINYINT UNSIGNED NOT NULL,
    TypeID					TINYINT UNSIGNED NOT NULL,
    CreatorID				TINYINT UNSIGNED NOT NULL UNIQUE KEY, -- Cannot update this field
    CreateDate				DATETIME DEFAULT NOW(), -- Cannot update this field
    FOREIGN KEY(CategoryID) 	REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY(TypeID) 		REFERENCES TypeQuestion(TypeID),
    FOREIGN KEY(CreatorID) 		REFERENCES `Account`(AccountId)
);

-- create table: Answer
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer(
    Answers					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(100) NOT NULL,
    QuestionID				TINYINT UNSIGNED NOT NULL,
    isCorrect				BIT DEFAULT 1,
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID)
);

-- create table: Exam
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam(
    ExamID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code`					CHAR(10) NOT NULL,	-- L-1: if duration >= 180p, M-1: if duration >= 90p, S-1: otherwise -- Cannot update this field
    Title					NVARCHAR(50) NOT NULL,
    CategoryID				TINYINT UNSIGNED NOT NULL,
    Duration				TINYINT UNSIGNED NOT NULL DEFAULT 45,
    CreatorID				TINYINT UNSIGNED NOT NULL, -- Cannot update this field
    CreateDate				DATETIME DEFAULT NOW(), -- Cannot update this field
    FOREIGN KEY(CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY(CreatorID) 	REFERENCES `Account`(AccountId)
);

-- create table: ExamQuestion
DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion(
    ExamID				TINYINT UNSIGNED NOT NULL,
	QuestionID			TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID),
    FOREIGN KEY(ExamID) REFERENCES Exam(ExamID),
    PRIMARY KEY (ExamID,QuestionID)
);
/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Address
INSERT INTO Address(AddressName)
VALUES
				(N'P501'),
				(N'P502'),
				(N'P503'),
				(N'P504'),
				(N'P505'),
				(N'P401'),
				(N'P402'),
				(N'P403'),
				(N'P404'),
				(N'P405');

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

-- Add data DetailDepartment
INSERT INTO DetailDepartment	(  DepartmentID		, AddressID, 	EmulationPoint)
VALUES 							(		1,				1,					1	),
								(		2,				2,					4	),
								(		3,				3,					6	),
								(		4,				4,					7	),
								(		5,				5,					2	),
								(		6,				6,					1	),
								(		7,				7,					5	),
								(		8,				8,					6	),
								(		9,				9,					8	),
								(		10,				10,					9	);

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
INSERT INTO `Account`(Email								, Username			, FirstName,	LastName,		 DepartmentID	, PositionID, SalaryID, 	CreateDate)
VALUES 				('haidang29productions@gmail.com'	, 'dangblack'		,'Dang'	,		'Nguyen Hai'	,   '5'			,   '1',		'1'		,	'2020-03-05'),
					('account1@gmail.com'				, 'quanganh'		,'Anh'	,		'Tong Quang'	,   '1'			,   '2',		'2'		,	'2020-03-05'),
                    ('account2@gmail.com'				, 'vanchien'		,'Chien',		'Nguyen Van'	,   '2'			,   '3',		'3'		,	'2020-03-07'),
                    ('account3@gmail.com'				, 'cocoduongqua'	,'Do'	,		'Duong'			,   '3'			,   '3',		'3'		,	'2020-03-08'),
                    ('account4@gmail.com'				, 'doccocaubai'		,'Thang',		'Nguyen Chien'  ,   '4'			,   '3',		'3'		,	'2020-03-10'),
                    ('dapphatchetngay@gmail.com'		, 'khabanh'			,'Kha'	,		'Ngo Ba'		,   '6'			,   '3',		'3'		,	NOW()),
                    ('songcodaoly@gmail.com'			, 'huanhoahong'		,'Huan'	,		'Bui Xuan'		,   '7'			,   '2',		'2'		,	NOW()),
                    ('sontungmtp@gmail.com'				, 'tungnui'			,'Tung'	,		'Nguyen Thanh'	,   '8'			,   '1',		'1'		,	'2020-04-07'),
                    ('duongghuu@gmail.com'				, 'duongghuu'		,'Huu'	,		'Duong Van'		,   '9'			,   '2',		'2'		,	'2020-04-07'),
                    ('vtiaccademy@gmail.com'			, 'vtiaccademy'		,'Ai'	,		'Vi Ti'			,   '10'		,   '1',		'1'		,	'2020-04-09');

-- Add data Employee
INSERT INTO Employee	(AccountID,		WorkingNumberOfYear)
VALUES 					(	1,					1			),
						(	2,					2			),
						(	3,					1			),
						(	4,					3			),
						(	5,					4			);

-- Add data Manager
INSERT INTO Manager		(AccountID,		ManagementNumberOfYear)
VALUES 					(	6,					2			),
						(	7,					3			),
						(	8,					1			),
						(	9,					5			),
                        (	10,					6			);

-- Add data Group
INSERT INTO `Group`	(  GroupName			, CreatorID		, CreateDate)
VALUES 				(N'Testing System'		,   5			,'2019-03-05'),
					(N'Developement'		,   1			,'2020-03-07'),
                    (N'VTI Sale 01'			,   2			,'2020-03-09'),
                    (N'VTI Sale 02'			,   3			,'2020-03-10'),
                    (N'VTI Sale 03'			,   4			,'2020-03-28'),
                    (N'VTI Creator'			,   6			,'2020-04-06'),
                    (N'VTI Marketing 01'	,   7			,'2020-04-07'),
                    (N'Management'			,   8			,'2020-04-08'),
                    (N'Chat with love'		,   9			,'2020-04-09'),
                    (N'Vi Ti Ai'			,   10			,'2020-04-10');

-- Add data GroupAccount
INSERT INTO `GroupAccount`	(  GroupID	, AccountID	, JoinDate	 )
VALUES 						(	1		,    1		,'2019-03-05'),
							(	1		,    2		,'2020-03-07'),
							(	3		,    3		,'2020-03-09'),
							(	3		,    4		,'2020-03-10'),
							(	5		,    5		,'2020-03-28'),
							(	1		,    3		,'2020-04-06'),
							(	1		,    7		,'2020-04-07'),
							(	8		,    3		,'2020-04-08'),
							(	1		,    9		,'2020-04-09'),
							(	10		,    10		,'2020-04-10');

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
INSERT INTO Question	(Content			, CategoryID, TypeID		, CreatorID	, CreateDate )
VALUES 					(N'Câu hỏi về Java'	,	1		,   '1'			,   '1'		,'2020-04-05'),
						(N'Câu Hỏi về PHP'	,	10		,   '2'			,   '2'		,'2020-04-05'),
						(N'Hỏi về C#'		,	9		,   '2'			,   '3'		,'2020-04-06'),
						(N'Hỏi về Ruby'		,	6		,   '1'			,   '4'		,'2020-04-06'),
						(N'Hỏi về Postman'	,	5		,   '1'			,   '5'		,'2020-04-06'),
						(N'Hỏi về ADO.NET'	,	3		,   '2'			,   '6'		,'2020-04-06'),
						(N'Hỏi về ASP.NET'	,	2		,   '1'			,   '7'		,'2020-04-06'),
						(N'Hỏi về C++'		,	8		,   '1'			,   '8'		,'2020-04-07'),
						(N'Hỏi về SQL'		,	4		,   '2'			,   '9'		,'2020-04-07'),
						(N'Hỏi về Python'	,	7		,   '1'			,   '10'	,'2020-04-07');

-- Add data Answers
INSERT INTO Answer	(  Content		, QuestionID	, isCorrect	)
VALUES 				(N'Trả lời 01'	,   1			,	0		),
					(N'Trả lời 02'	,   1			,	1		),
                    (N'Trả lời 03'	,   1			,	0		),
                    (N'Trả lời 04'	,   1			,	1		),
                    (N'Trả lời 05'	,   2			,	1		),
                    (N'Trả lời 06'	,   3			,	1		),
                    (N'Trả lời 07'	,   4			,	0		),
                    (N'Trả lời 08'	,   8			,	0		),
                    (N'Trả lời 09'	,   9			,	1		),
                    (N'Trả lời 10'	,   10			,	1		);

-- Add data Exam
INSERT INTO Exam	(`Code`			, Title					, CategoryID	, Duration	, CreatorID		, CreateDate )
VALUES 				('S-1'			, N'Đề thi C#'			,	1			,	60		,   '5'			,'2019-04-05'),
					('S-2'			, N'Đề thi PHP'			,	10			,	60		,   '1'			,'2019-04-05'),
                    ('M-1'			, N'Đề thi C++'			,	9			,	120		,   '2'			,'2019-04-07'),
                    ('S-3'			, N'Đề thi Java'		,	6			,	60		,   '3'			,'2020-04-08'),
                    ('M-2'			, N'Đề thi Ruby'		,	5			,	120		,   '4'			,'2020-04-10'),
                    ('S-4'			, N'Đề thi Postman'		,	3			,	60		,   '6'			,'2020-04-05'),
                    ('S-5'			, N'Đề thi SQL'			,	2			,	60		,   '7'			,'2020-04-05'),
                    ('S-6'			, N'Đề thi Python'		,	8			,	60		,   '8'			,'2020-04-07'),
                    ('L-1'			, N'Đề thi ADO.NET'		,	4			,	180		,   '9'			,'2020-04-07'),
                    ('L-2'			, N'Đề thi ASP.NET'		,	7			,	180		,   '10'		,'2020-04-08');

-- Add data ExamQuestion
INSERT INTO ExamQuestion(ExamID	, QuestionID	)
VALUES 					(	1	,		5		),
						(	2	,		10		),
						(	3	,		4		),
						(	4	,		3		),
						(	5	,		7		),
						(	6	,		10		),
						(	7	,		2		),
						(	8	,		10		),
						(	9	,		9		),
						(	10	,		8		);

select * from address