-- create database
DROP DATABASE IF EXISTS Testing_System_8;
CREATE DATABASE Testing_System_8;
USE Testing_System_8;

-- create table: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TotalMember				TINYINT	UNSIGNED,
    DepartmentName 			NVARCHAR(30) NOT NULL UNIQUE KEY,
    PositionName			ENUM('Dev','Test','ScrumMaster','PM') NOT NULL,
    CreateDate				DATETIME DEFAULT NOW()
);

-- create table: Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Username				VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    DepartmentID 			TINYINT UNSIGNED NOT NULL,	-- Set default waiting
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID)
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Department
INSERT INTO Department(DepartmentName, TotalMember, PositionName, 		CreateDate) 
VALUES
						(N'Marketing'	, 1,			'Dev', 			'2020-03-05'),
						(N'Sale'		, 2,			'Test', 		'2020-03-05'),
						(N'Bảo vệ'		, 3,			'ScrumMaster', 	'2020-03-07'),
						(N'Nhân sự'		, 4,			'PM', 			'2020-03-08'),
						(N'Kỹ thuật'	, 5,			'Dev', 			'2020-03-10'),
						(N'Tài chính'	, 6,			'ScrumMaster', 	NOW()		),
						(N'Phó giám đốc', 7,			'PM', 			NOW()		),
						(N'Giám đốc'	, 8,			'Test', 		'2020-04-07'),
						(N'Thư kí'		, 9,			'PM', 			'2020-04-07'),
						(N'Bán hàng'	, 1,			'Dev', 			'2020-04-09');
                        
-- Add data Account
INSERT INTO `Account`(Username		,DepartmentID)
VALUES 				('dangblack'	,   '5'		),
					('quanganh'		,	'1'		),
                    ('vanchien'		,	'1'		),
                    ('cocoduongqua'	,	'1'		),
                    ('doccocaubai'	,   '2'		),
                    ('khabanh'		,   '2'		),
                    ('huanhoahong'	,   '2'		),
                    ('tungnui'		,   '8'		),
                    ('duongghuu'	,   '9'		),
                    ('vtiaccademy'	,   '10'	);
