DROP DATABASE IF EXISTS Final_Exam1;
CREATE DATABASE Final_Exam1;
USE Final_Exam1;

CREATE TABLE `User`(
	UserID 		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    FullName 	VARCHAR(50),
    Email 		VARCHAR(50) UNIQUE KEY,
    `Password` 	VARCHAR(100) NOT NULL,
    ExpInYear 	TINYINT UNSIGNED,
    ProSkill	ENUM('DEV', 'TEST', 'JAVA', 'SQL'),
    Category	ENUM('ADMIN', 'EMPLOYEE')
);

INSERT INTO `User`  (	FullName		,		Email			,   `Password`	,	ExpInYear	,	ProSkill	,	Category	)
VALUES				( 'Bùi Tuấn Anh'	,'tuananh28@gmail.com'	,	 '123456'	,		2		,		'DEV'	,	'ADMIN'		),
					( 'Bùi Thị Hoa Mai'	,'hoamai@gmail.com'		,	'maiahihi'	,		5		,		'TEST'	,	'ADMIN'		),
                    ( 'Lê Thị Binh'		,'lebinh@gmail.com'		,	'12345'		,		NULL	,		NULL	,	'EMPLOYEE'	),
                    ( 'Nguyễn Hữu Bằng'	,'banglang@gmail.com'	,	'abcxyz'	,		6		,		NULL	,	'EMPLOYEE'	),
                    ( 'Trần Tuấn Phương','biwhite@gmail.com'	,	'kiwi'		,		1		,		'JAVA'	,	'EMPLOYEE'	);
                    
SELECT * FROM `User`;