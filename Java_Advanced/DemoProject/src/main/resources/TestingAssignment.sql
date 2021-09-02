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
    FirstName				NVARCHAR(50) NOT NULL,
    LastName				NVARCHAR(50) NOT NULL,	
    DepartmentID 			TINYINT UNSIGNED,	
    CreateDate				DATETIME DEFAULT NOW(), 
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID) ON DELETE SET NULL
);
/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Department
INSERT INTO Department	(DepartmentName, author_id	,	CreateDate	 ,	ModifiedDate)
VALUES                  (N'Marketing'	,	5		,	'2021-03-05' ,	'2021-03-05'),
						(N'Sale'		,	1		,	'2021-03-07' ,	'2021-03-07'),
						(N'Bảo vệ'		,	2		,	'2021-03-08' ,	'2021-03-08'),
						(N'Nhân sự'		,	3		,	'2021-03-10' ,	'2021-03-10'),
						(N'Kỹ thuật'	,	4		,	NOW()		 ,	NOW()		),
						(N'Tài chính'	,	6		,	NOW()		 ,	NOW()		),
						(N'Phó giám đốc',	7		,	'2021-04-07' ,	'2021-04-07'),
						(N'Giám đốc'	,	8		,	'2021-04-07' ,	'2021-04-07'),
						(N'Thư kí'		,	9		,	'2021-04-09' ,	'2021-04-09'),
						(N'Bán hàng'	,	5		,	'2021-04-09' ,	'2021-04-09'),
                        (N'Bán hàng1'	,	5		,	'2021-04-09' ,	'2021-04-09');

-- Add data Account
INSERT INTO `Account`(Email								, Username			, FirstName,	LastName,		 DepartmentID	,	CreateDate)
VALUES 				('tuananh@gmail.com'	            , 'tuananhbui'		,'Anh'	,		'Bui Tuan '	    ,   '1'			,	'2021-03-05'),
					('account1@gmail.com'				, 'quanganh'		,'Anh'	,		'Tong Quang'	,   '1'			,	'2021-03-05'),
                    ('account2@gmail.com'				, 'vanchien'		,'Chien',		'Nguyen Van'	,   '2'			,	'2021-03-07'),
                    ('account3@gmail.com'				, 'cocoduongqua'	,'Do'	,		'Duong'			,   '3'			,	'2021-03-08'),
                    ('account4@gmail.com'				, 'doccocaubai'		,'Thang',		'Nguyen Chien'  ,   '4'			,	'2021-03-10'),
                    ('hoamai@gmail.com'		            , 'hoamai'			,'Mai'	,		'Bui Thi Hoa'	,   '1'			,	NOW()),
                    ('songcodaoly@gmail.com'			, 'huanhoahong'		,'Huan'	,		'Bui Xuan'		,   '7'			,	NOW()),
                    ('sontungmtp@gmail.com'				, 'tungnui'			,'Tung'	,		'Nguyen Thanh'	,   '8'			,	'2021-04-07'),
                    ('duongghuu@gmail.com'				, 'duongghuu'		,'Huu'	,		'Duong Van'		,   '9'			,	'2021-04-07'),
                    ('vtiaccademy@gmail.com'			, 'vtiaccademy'		,'Ai'	,		'Vi Ti'			,   '10'		,	'2021-04-09');

ALTER TABLE Department
ADD FOREIGN KEY (author_id) REFERENCES `Account`(AccountID);