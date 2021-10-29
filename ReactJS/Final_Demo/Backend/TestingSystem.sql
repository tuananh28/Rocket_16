-- Drop the database if it already exists
DROP DATABASE IF EXISTS TestingSystem;
-- Create database
CREATE DATABASE IF NOT EXISTS TestingSystem;
USE TestingSystem;

-- Create table user
DROP TABLE IF EXISTS 	`User`;
CREATE TABLE IF NOT EXISTS `User` ( 	
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`username`	 	CHAR(50) NOT NULL UNIQUE CHECK (LENGTH(`username`) >= 6 AND LENGTH(`username`) <= 50),
	`email` 		CHAR(50) NOT NULL UNIQUE CHECK (LENGTH(`email`) >= 6 AND LENGTH(`email`) <= 50),
	`password` 		VARCHAR(800) NOT NULL,
    `firstName` 	NVARCHAR(50) NOT NULL,
	`lastName` 		NVARCHAR(50) NOT NULL,
    `role` 			ENUM('Admin','Employee','Manager') DEFAULT 'Employee',
	`status`		TINYINT DEFAULT 0, -- 0: Not Active, 1: Active
    `avatarUrl`		VARCHAR(500)
);

-- Create table Registration_User_Token
DROP TABLE IF EXISTS 	`Registration_User_Token`;
CREATE TABLE IF NOT EXISTS `Registration_User_Token` ( 	
	id 				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`token`	 		CHAR(36) NOT NULL UNIQUE,
	`user_id` 		SMALLINT UNSIGNED NOT NULL,
	`expiryDate` 	DATETIME NOT NULL
);

-- Create table Reset_Password_Token
DROP TABLE IF EXISTS 	`Reset_Password_Token`;
CREATE TABLE IF NOT EXISTS `Reset_Password_Token` ( 	
	id 				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`token`	 		CHAR(36) NOT NULL UNIQUE,
	`user_id` 		SMALLINT UNSIGNED NOT NULL,
	`expiryDate` 	DATETIME NOT NULL
);

-- create table: Group
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	id 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    totalMember		TINYINT	UNSIGNED DEFAULT 0,
    `name` 			NVARCHAR(50) NOT NULL UNIQUE KEY
);

-- password: 123456
INSERT INTO `User` 	(`username`	,		`email`		,						`password`							   , 	`firstName` ,		`lastName`	, 	`status`, 	`role`		,  	`avatarUrl`				)
VALUE				('tuananh'	, 'tuananh@vti.com' ,'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Bùi'	,		'Tuấn Anh'	,		1	,	'Admin' 	,		null				), 
					('username1', 'email1@gmail.com','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Bùi'	,		'Hoa Mai'	,		0	,	'Manager' 	,		null				), 
					('username2', 'email2@gmail.com','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Lê'	,		'Hữu Anh'	,		0	,	'Manager' 	,		null				), 
					('username3', 'email3@gmail.com','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Nguyễn',		'Đình Nam'	,		0	,	'Manager' 	,		null				), 
					('username4', 'email4@gmail.com','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Nguyễn',		'Duy Mạnh'	,		0	,	'Manager' 	,		null				),
					('username5', 'email5@gmail.com','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Phan'	,		'Mạnh Tùng'	,		0	,	'Employee'	,		null				),
					('username6', 'email6@gmail.com','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Nguyễn',		'Mạnh Tuấn'	,		0	,	'Employee'	,		null				),
					('username7', 'email7@gmail.com','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Nguyễn',		'Thị Thủy'	,		0	,	'Employee'	,		null				),
					('username8', 'email8@gmail.com','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Nguyễn',		'Duy Anh'	,		0	,	'Manager' 	,		null				),
					('username9', 'email9@gmail.com','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',		'Đào'	,		'Văn Trường',		0	, 	'Employee'	,		null				);
                    
-- Add data Group
INSERT INTO `Group`(`name`, totalMember) 
VALUES
						(N'Marketing'	, 			1),
						(N'Sale'		, 			2),
						(N'Bảo vệ'		, 			3),
						(N'Nhân sự'		, 			4),
						(N'Kỹ thuật'	, 			5),
						(N'Tài chính'	, 			6),
						(N'Phó giám đốc', 			7),
						(N'Giám đốc'	, 			8),
						(N'Thư kí'		, 			9),
						(N'Bán hàng'	, 			10),
                        (N'Bóng chuyền'	, 			10),
                        (N'Bóng đá'		, 			10),
                        (N'Bóng bàn'	, 			10),