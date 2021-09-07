-- create database
DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;

-- create table: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 			NVARCHAR(30) NOT NULL UNIQUE KEY,
    author_id				TINYINT UNSIGNED,
    CreateDate				DATETIME DEFAULT NOW(),
    ModifiedDate			DATETIME DEFAULT NOW() 
);

-- create table: Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(50) NOT NULL UNIQUE KEY, 
    Username				VARCHAR(50) NOT NULL UNIQUE KEY,
    `password` 				VARCHAR(800) NOT NULL,
    FirstName				NVARCHAR(50) NOT NULL,
    LastName				NVARCHAR(50) NOT NULL,	
    DepartmentID 			TINYINT UNSIGNED,	
    CreateDate				DATETIME DEFAULT NOW(),
    `Role` 					ENUM('Admin','User','Manager') NOT NULL DEFAULT 'User',
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID) ON DELETE SET NULL
);
/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Department
INSERT INTO Department	(DepartmentName, author_id	,	CreateDate	 ,	ModifiedDate)
VALUES                  (N'Marketing'	,	5		,	'2020-03-05' ,	'2020-03-05'),
						(N'Sale'		,	1		,	'2020-03-07' ,	'2020-03-07'),
						(N'Bảo vệ'		,	2		,	'2020-03-08' ,	'2020-03-08'),
						(N'Nhân sự'		,	3		,	'2020-03-10' ,	'2020-03-10'),
						(N'Kỹ thuật'	,	4		,	NOW()		 ,	NOW()		),
						(N'Tài chính'	,	6		,	NOW()		 ,	NOW()		),
						(N'Phó giám đốc',	7		,	'2020-04-07' ,	'2020-04-07'),
						(N'Giám đốc'	,	8		,	'2020-04-07' ,	'2020-04-07'),
						(N'Thư kí'		,	9		,	'2020-04-09' ,	'2020-04-09'),
						(N'Bán hàng'	,	5		,	'2020-04-09' ,	'2020-04-09'),
                        (N'Bán hàng1'	,	5		,	'2020-04-09' ,	'2020-04-09');

-- Add data Account
-- password: 123456
INSERT INTO `Account`(Email								, Username			,	`password`,															FirstName,		LastName,		 DepartmentID	,	CreateDate		,	`Role`		)
VALUES 				('haidang29productions@gmail.com'	, 'dangblack'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Dang'	,		'Nguyen Hai'	,   '1'			,	'2020-03-05'	,	'Admin'		),
					('account1@gmail.com'				, 'quanganh'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Anh'	,		'Tong Quang'	,   '1'			,	'2020-03-05'	,	'Admin'		),
                    ('account2@gmail.com'				, 'vanchien'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Chien',		'Nguyen Van'	,   '2'			,	'2020-03-07'	,	'User'		),
                    ('account3@gmail.com'				, 'cocoduongqua'	,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Do'	,		'Duong'			,   '3'			,	'2020-03-08'	,	'User'		),
                    ('account4@gmail.com'				, 'doccocaubai'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Thang',		'Nguyen Chien'  ,   '4'			,	'2020-03-10'	,	'User'		),
                    ('dapphatchetngay@gmail.com'		, 'khabanh'			,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Kha'	,		'Ngo Ba'		,   '1'			,	NOW()			,	'Admin'		),
                    ('songcodaoly@gmail.com'			, 'huanhoahong'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Huan'	,		'Bui Xuan'		,   '7'			,	NOW()			,	'Admin'		),
                    ('sontungmtp@gmail.com'				, 'tungnui'			,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Tung'	,		'Nguyen Thanh'	,   '8'			,	'2020-04-07'	,	'Manager'	),
                    ('duongghuu@gmail.com'				, 'duongghuu'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Huu'	,		'Duong Van'		,   '9'			,	'2020-04-07'	,	'Manager'	),
                    ('vtiaccademy@gmail.com'			, 'vtiaccademy'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Ai'	,		'Vi Ti'			,   '10'		,	'2020-04-09'	,	'Manager'	);

ALTER TABLE Department
ADD FOREIGN KEY (author_id) REFERENCES `Account`(AccountID);