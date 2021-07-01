DROP DATABASE IF EXISTS  Assignment_4;
CREATE DATABASE  Assignment_4;
USE Assignment_4;

CREATE TABLE `Department`(
	Department_Number 	TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	Department_Name 	VARCHAR(20) NOT NULL
);

CREATE TABLE `Employee`(
	Employee_Number 	TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	Employee_Name 		VARCHAR(50) NOT NULL
);

CREATE TABLE `Employee_Skill`(
	Employee_Number 	TINYINT UNSIGNED NOT NULL,
    Skill_Code			VARCHAR(30) NOT NULL,
    `Date Registered`	DATETIME DEFAULT NOW(),
    CONSTRAINT kp_Employee FOREIGN KEY (Employee_Number) REFERENCES `Employee` (Employee_Number)
);

INSERT INTO `Department` 	(Department_Name)
VALUE						(	'London'	),
                            ( 	'Seoul'		),
							(	'Tokyo'		),
							(	'EngLand'	),
							(	'Berlin'	),
							(	'Paris'		);
                            
INSERT INTO  `Employee`		(	Employee_Name	)
VALUE						('Bùi Tuấn Anh'		),
							('Bùi Thị Hoa Mai'	),	
							('Lê Thị Binh'		),
                            ( 'Nguyễn Hữu Bằng'	),
							('Trần Tuấn Phương'	),
                            ( 'Nguyễn Thị Lê'	),
                            ( 'Đặng Thị Thảo'	),
                            ( 'Lê Hoàng Khôi'	),
                            ( 'Trần Văn Diễn'	),
                            ( 'Bùi Minh Hiếu'	);
                            
INSERT INTO `Employee_Skill`(	Employee_Number ,	Skill_Code	,	`Date Registered`)
VALUES						(			1		,	'Java Web'	,	  '2020-05-01' 	 ),
							(			2		,		'PHP'	,	  '2020-06-06'	 ),
                            (			3		,		'C#'	,	  '2019-07-28'	 ),
                            (			4		,	  'Postman'	,	  '2021-06-28'	 ),
                            (			5		,	'Java Swing',	  '2019-01-05'	 ),
                            (			6		,	'Java Core'	,	  '2018-09-09'	 ),
                            (			7		,		'C++'	,	  '2019-10-25'	 ),
                            (			8		,	'Java Web'	,	  '2020-06-06'	 ),
                            (			9		,		'C#'	,	  '2021-05-17'	 ),
                            (			10		,		'.NET'	,	  '2018-05-26'	 );
                            
-- Question 3: Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java
SELECT Employee_Name
FROM 	`Employee` E
JOIN 	`Employee_Skill` ES
ON 		E.Employee_Number = ES.Employee_Number
WHERE	Skill_Code LIKE 'Java%';
-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
-- Question 5: Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban. 
-- Question 6: Viết lệnh để lấy ra danh sách nhân viên có > 1 skills.
SELECT E.Employee_Name, COUNT(ES.Skill_Code) AS " Skills "
FROM `Employee` E
JOIN `Employee_Skill` ES
JOIN `Employee_Skill` ES
ON 		E.Employee_Number = ES.Employee_Number
GROUP BY ES.Employee_Number
HAVING COUNT(ES.Skill_Code) > 1;