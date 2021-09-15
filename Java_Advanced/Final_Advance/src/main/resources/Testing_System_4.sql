-- create database
DROP DATABASE IF EXISTS Testing_System_4;
CREATE DATABASE Testing_System_4;
USE Testing_System_4;


/*============================== CREATE TABLE=== =======================================*/
/*======================================================================================*/

-- create table 1: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 			NVARCHAR(30) NOT NULL UNIQUE KEY
);

-- create table 2: Posittion
DROP TABLE IF EXISTS Position;
CREATE TABLE `Position` (
	PositionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName			ENUM('Dev','Test','Scrum_Master','PM') NOT NULL UNIQUE KEY
);


-- create table 3: Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(50) NOT NULL UNIQUE KEY,
    Username				VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName				NVARCHAR(50) NOT NULL,
    DepartmentID 			TINYINT UNSIGNED,
    PositionID				TINYINT UNSIGNED,
    CreateDate				DATETIME DEFAULT NOW(),
    Password 		        VARCHAR(100) NOT NULL,
    Role			        ENUM('Admin','User','Manager') DEFAULT 'User',
    Status		            TINYINT DEFAULT 0, -- 0: Not Active, 1: Active
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID),
    FOREIGN KEY(PositionID) REFERENCES `Position`(PositionID)
);
-- Create table Registration_User_Token
DROP TABLE IF EXISTS 	`Registration_User_Token`;
CREATE TABLE IF NOT EXISTS `Registration_User_Token` (
	id 				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`token`	 		CHAR(36) NOT NULL UNIQUE,
	`user_id` 		SMALLINT UNSIGNED NOT NULL,
	`expiryDate` 	DATETIME NOT NULL
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
						(N'Waitting'	);

-- Add data position
INSERT INTO Position	(PositionName	)
VALUES 					('Dev'			),
						('Test'			),
						('Scrum_Master'	),
						('PM'			);


-- Add data Account
INSERT INTO `Account`(Email							, Username			, FullName				    ,                           Password                           ,Status, 	Role	  , DepartmentID	, PositionID, CreateDate)
VALUES 				('Email1@gmail.com'				, 'admin'		    ,'admin'				    ,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	0 , 	'Admin'   ,   '5'			,   '1'		,'2021-08-05'),
					('Email2@gmail.com'				, 'manager'		    ,'manager'				    ,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	0 , 	'Manager' ,   '1'			,   '2'		,'2021-08-05'),
                    ('Email3@gmail.com'				, 'Username3'		,'Fullname3'				,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	0 , 	'Manager' ,   '2'			,   '2'		,'2021-07-07'),
                    ('Email4@gmail.com'				, 'Username4'		,'Fullname4'				,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	0 , 	'Manager' ,   '3'			,   '4'		,'2021-07-08'),
                    ('Email5@gmail.com'				, 'Username5'		,'Fullname5'				,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	0 , 	'Manager' ,   '4'			,   '4'		,'2021-06-10'),
                    ('Email6@gmail.com'				, 'Username6'		,'Fullname6'				,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	0 , 	'User'    ,   '6'			,   '3'		,'2021-06-05'),
                    ('Email7@gmail.com'				, 'user'		    ,'user'				        ,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	0 , 	'User'    ,   '2'			,   '2'		, NULL		),
                    ('Email8@gmail.com'				, 'Username8'		,'Fullname8'				,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	0 , 	'User'    ,   '8'			,   '1'		,'2021-06-07'),
                    ('Email9@gmail.com'				, 'Username9'		,'Fullname9'				,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	0 , 	'Manager' ,   '2'			,   '2'		,'2021-07-07'),
                    ('Email10@gmail.com'			, 'Username10'		,'Fullname10'				,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	0 , 	'User'    ,   '10'		    ,   '1'		,'2021-04-09');