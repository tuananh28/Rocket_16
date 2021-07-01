DROP DATABASE IF EXISTS `Testing_System_Assignment_2`;
CREATE DATABASE IF NOT EXISTS `Testing_System_Assignment_2`;
USE `Testing_System_Assignment_1`;

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
                        ('Scrum Master'),
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
                    ('dientran112@gmail.com'	,'dien18'		,'Trần Văn Diễn'	,		2		,	2		,'2020-11-27'),
					('hieubui@gmail.com'	,'hieuchoat'	,'Bùi Minh Hiếu'	,		2		,	1		,'2020-07-30');
 
INSERT INTO `Group` (GroupName	, CreatorID	,CreateDate)
VALUES				
					('London'	,	1		,'2020-10-25'),
                    ('Seoul'	,	5		,'2021-05-28'),
                    ('Tokyo'	,	10		,'2020-04-12'),
                    ('EngLand'	,	2		,'2020-01-06'),
                    ('Berlin'	,	4		,'2021-05-18'),
                    ('Paris'	,	3		,'2019-02-27');
                    

INSERT INTO `GroupAccount`(GroupID, AccountID	, JoinDate)
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
	
INSERT INTO `CategoryQuestion` (	CategoryName	)
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
                        ('Câu hỏi Postman'	,	5		, 	1	,	9		,'2020-05-28'),
                        ('Câu hỏi PHP'		,	6		, 	2	,	8		,'2020-05-28');
 
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
                    ('Câu hỏi Postman'		,		5	,	0	),
                    ('Câu hỏi PHP'			,		6	,	1	);
                    
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