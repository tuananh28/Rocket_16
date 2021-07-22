DROP DATABASE IF EXISTS `TestingSystem_DB`;
CREATE DATABASE IF NOT EXISTS `TestingSystem_DB`;
USE `TestingSystem_DB`;


/*------------------------- TẠO BẢNG ---------------------------------
-----------------------------------------------------------------------*/

-- Table Department
DROP TABLE IF EXISTS `Department`;
CREATE TABLE `Department`(
	DepartmentID 	TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    DepartmentName 	VARCHAR(50) NOT NULL
);

-- Table Position
DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position`(
	PositionID 		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    PositionName 	ENUM('Dev', 'Test', 'Scrum Master', 'PM')  NOT NULL
    
);

-- Table Account
DROP TABLE IF EXISTS `Account`;
 CREATE TABLE `Account`(
	AccountID 		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Email 			VARCHAR(30) UNIQUE KEY NOT NULL,
    Username 		VARCHAR(50) UNIQUE KEY NOT NULL,
    FullName 		VARCHAR(60) NOT NULL,
    DepartmentID 	TINYINT UNSIGNED NOT NULL,
    PositionID 		TINYINT UNSIGNED NOT NULL,
    CreateDate 		DATETIME DEFAULT NOW(),
	CONSTRAINT kp_DepartmentID FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID) ON DELETE CASCADE ON UPDATE CASCADE
 );
 
 -- Table Group
 DROP TABLE IF EXISTS `Group`;
 CREATE TABLE `Group`(
	GroupID 		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    GroupName 		VARCHAR(20) NOT NULL,
    CreatorID 		TINYINT UNSIGNED NOT NULL,
    CreateDate 		DATETIME DEFAULT NOW(),
    CONSTRAINT kp_CreatorID1 FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID) ON DELETE CASCADE ON UPDATE CASCADE
 );
 
  -- Table GroupAccount
 DROP TABLE IF EXISTS `GroupAccount`;
 CREATE TABLE `GroupAccount`(
	GroupID 		TINYINT UNSIGNED NOT NULL,
    AccountID 		TINYINT UNSIGNED NOT NULL,
    JoinDate 		DATETIME DEFAULT NOW(),
    CONSTRAINT kp_GroupID FOREIGN KEY (GroupID) REFERENCES `Group` (GroupID) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT kp_AccountID FOREIGN KEY (AccountID) REFERENCES `Account` (AccountID) ON DELETE CASCADE ON UPDATE CASCADE
 );

 -- Table TypeQuestion
DROP TABLE IF EXISTS `TypeQuestion`;
 CREATE TABLE `TypeQuestion`(
	TypeID 			TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    TypeName 		ENUM('Essay', 'Multiple-Choice')
 
 );
  -- Table CategoryQuestion
 DROP TABLE IF EXISTS `CategoryQuestion`;
 CREATE TABLE `CategoryQuestion`(
	CategoryID 		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    CategoryName 	ENUM('Java', '.NET', 'SQL', 'Postman', 'Ruby','PHP')
 );
 
  -- Table Question
 DROP TABLE IF EXISTS `Question`;
 CREATE TABLE `Question`(
	QuestionID 		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Content 		VARCHAR(500) NOT NULL,
    CategoryID 		TINYINT UNSIGNED NOT NULL,
    TypeID 			TINYINT UNSIGNED NOT NULL,
    CreatorID 		TINYINT UNSIGNED NOT NULL,
    CreateDate 		DATETIME DEFAULT NOW(),
	CONSTRAINT kp_CategoryID1 FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT kp_TypeID FOREIGN KEY (TypeID) REFERENCES TypeQuestion (TypeID) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT kp_CreatorID2 FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID) ON DELETE CASCADE ON UPDATE CASCADE
 );
 
 -- Table Answer
 DROP TABLE IF EXISTS Answer;
 CREATE TABLE Answer(
	AnswerID 		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Content  		VARCHAR(500) NOT NULL,
    QuestionID 		TINYINT UNSIGNED NOT NULL,
    isCorrect 		BIT NOT NULL,
    CONSTRAINT kp_QuestionID FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID) ON DELETE CASCADE ON UPDATE CASCADE   
 );

 -- Table Exam
 DROP TABLE IF EXISTS Exam;
 CREATE TABLE Exam(
	ExamID 			TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Code` 			CHAR(15) NOT NULL UNIQUE KEY,
    Title  			VARCHAR(50) NOT NULL,
    CategoryID 		TINYINT UNSIGNED NOT NULL,
    Duration 		TINYINT UNSIGNED NOT NULL,
    CreatorID 		TINYINT UNSIGNED NOT NULL,
    CreateDate		DATETIME DEFAULT NOW(),
    CONSTRAINT kp_CategoryID2 FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT kp_CreatorID3  FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID) ON DELETE CASCADE ON UPDATE CASCADE
 );
 
 
 -- Table ExamQuestion
 DROP TABLE IF EXISTS ExamQuestion;
 CREATE TABLE ExamQuestion(
	ExamID 			TINYINT UNSIGNED NOT NULL,
    QuestionID 		TINYINT UNSIGNED NOT NULL,
    PRIMARY KEY(ExamID, QuestionID)
 );
 INSERT INTO `Department` (DepartmentName) 
VALUE
						('Marketing'	),
						('Sale'			),
						('Bảo vệ'		),
						('Nhân sự'		),
						('Kỹ thuật'		),
						('Tài chính'	),
						('Phó giám đốc'	),
						('Giám đóc'		),
						('Thư kí'		),
						('Bán hàng'		);
                        
INSERT INTO `Position` (PositionName)
VALUE
						('Dev'),
                        ('Test'),
                        ('PM');

INSERT INTO `Account`(Email					,UserName		,FullName			,DepartmentID 	,PositionID	,CreateDate)
VALUES
						
					('tuananh28@gmail.com'	,'tuananhbui'	,'Bùi Tuấn Anh'		,		5		, 	1		,'2018-12-05'),
                    ('hoamai@gmail.com'		,'hoamai98'		,'Bùi Thị Hoa Mai'	,		4		,	2		,'2020-10-25'),
                    ('lebinh@gmail.com'		,'lethibinh'	,'Lê Thị Binh'		,		3		,	3		,'2020-09-15'),
                    ('banglang@gmail.com'	,'bangblack'	,'Nguyễn Hữu Bằng'	,		8		,	4		,'2020-08-21'),
                    ('biwhite@gmail.com'	,'whiteblue'	,'Trần Tuấn Phương'	,		7		,	2		,'2021-04-16'),
                    ('lenguyen@gmail.com'	,'lenguyen'		,'Nguyễn Thị Lê'	,		2		,	2		,'2015-10-24'),
                    ('dangthao@gmail.com'	,'dangle'		,'Đặng Thị Thảo'	,		6		,	4		,'2014-05-11'),
                    ('khoile@gmail.com'		,'babycute'		,'Lê Hoàng Khôi'	,		1		,	1		,'2020-01-18'),
                    ('dientran112@gmail.com','dien18'		,'Trần Văn Diễn'	,		2		,	2		,'2020-11-27'),
					('hieubui@gmail.com'	,'hieuchoat'	,'Bùi Minh Hiếu'	,		2		,	1		,'2020-07-30');
 
INSERT INTO `Group` (GroupName	, CreatorID	,CreateDate)
VALUES				
					('London'	,	1		,'2020-10-25'),
                    ('Seoul'	,	5		,'2021-05-28'),
                    ('Tokyo'	,	10		,'2020-04-12'),
                    ('EngLand'	,	2		,'2020-01-06'),
                    ('Berlin'	,	4		,'2021-05-18'),
                    ('Paris'	,	3		,'2019-02-27');
                    

INSERT INTO `GroupAccount`(GroupID, AccountID, JoinDate)
VALUES
						
						(	1	,	1		,'2020-05-23'),
                        (	3	,	2		,'2020-04-15'),
                        (	1	,	3		,'2020-01-22'),
                        (	2	,	4		,'2020-08-14'),
                        (	2	,	5		,'2020-09-09'),
                        (	1	,	6		,'2020-10-25'),
                        (	3	,	7		,'2020-11-28'),
                        (	4	,	8		,'2020-01-05'),
                        (	2	,	9		,'2020-12-12'),
                        (	1	,	10		,'2020-03-25');
                        
INSERT INTO `TypeQuestion` (TypeName)
VALUE					
						 (		'Essay'		),
                         ('Multiple-Choice'	);
	
INSERT INTO `CategoryQuestion`(	CategoryName	)
VALUE
							 (		'Java'		),
							 (		'.NET'		),
							 (		'SQL'		),
							 (		'Ruby'		),
                             (		'Postman'	),
                             (		'PHP'		);
    
INSERT INTO `Question`	(	Content			,CategoryID	,TypeID	,CreatorID	,CreateDate	 )
VALUES					
						('Câu hỏi Java	'	,	1		,	1	,	2		,'2020-05-23'),
                        ('Câu hỏi Java	'	,	1		,	1	,	1		,'2020-05-23'),
						('Câu hỏi Java	'	,	1		,	1	,	4		,'2020-06-23'),
                        ('Câu hỏi .NET'		,	2		, 	2	,	3		,'2020-05-24'),
                        ('Câu hỏi SQL'		,	3		,	1	,	5		,'2020-05-25'),
                        ('Câu hỏi Ruby'		,	4		, 	1	,	7		,'2020-05-26'),
                        ('Câu hỏi Ruby'		,	4		, 	2	,	10		,'2020-05-27'),
                        ('Câu hỏi Postman'	,	5		, 	1	,	9		,'2021-05-28'),
                        ('Câu hỏi PHP'		,	6		, 	2	,	8		,'2021-05-30');
 
INSERT INTO `Answer` ( 		Content			,QuestionID	,isCorrect)
VALUES					
					('Câu hỏi Java	'		,		1	,	0	),
                    ('Câu hỏi Java	'		,		1	,	1	),
                    ('Câu hỏi Java	'		,		1	,	1	),
                    ('Câu hỏi Java	'		,		1	,	0	),
                    ('Câu hỏi .NET'			,		2	,	1	),
                    ('Câu hỏi SQL'			,		3	,	0	),
                    ('Câu hỏi Ruby'			,		4	,	0	),
                    ('Câu hỏi Ruby'			,		4	,	0	),
                    ('Câu hỏi Postman'		,		5	,	0	);
                    
INSERT INTO `Exam` (`code`	,		Title			,CategoryID , Duration	, CreatorID	,CreateDate)
VALUES
				(	'VTI01'	,	'Đề thi Java	'	,		1	,	60		,		2	,'2020-05-18'),
                (	'VTI02'	,	'Đề thi .NET'		,		2	,	90		,		5	,'2020-05-19'),
                (	'VTI03'	,	'Đề thi SQL'		,		3	,	60		,		7	,'2020-05-20'),
                (	'VTI04'	,	'Đề thi Ruby'		,		4	,	90		,		8	,'2020-05-21'),
                (	'VTI05'	,	'Đề thi Postman'	,		5	,	90		,		10	,'2020-05-23'),
                (	'VTI06'	,	'Đề thi PHP'		,		6	,	120		,		1	,'2020-05-24');
                
INSERT INTO `ExamQuestion` (ExamID,QuestionID)
VALUE
						(	1	,	1),
						(	2	,	1),
						(	3	,	3),
						(	4	,	4),
						(	5	,	5),
						(	6	,	6);