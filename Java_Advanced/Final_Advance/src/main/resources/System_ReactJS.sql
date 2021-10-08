-- Drop the database if it already exists
DROP DATABASE IF EXISTS TestingSystem;
-- Create database
CREATE DATABASE IF NOT EXISTS TestingSystem;
USE TestingSystem;

-- Create table user
DROP TABLE IF EXISTS 	`User`;
CREATE TABLE IF NOT EXISTS `User` (
	`id` 			SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`username`	 	CHAR(50) NOT NULL UNIQUE CHECK (LENGTH(`username`) >= 6 AND LENGTH(`username`) <= 50),
	`email` 		CHAR(50) NOT NULL UNIQUE CHECK (LENGTH(`email`) >= 6 AND LENGTH(`email`) <= 50),
	`password` 		VARCHAR(800) NOT NULL,
	`fullname` 		NVARCHAR(50) NOT NULL,
    `role` 			ENUM('Admin','Employee','Manager') DEFAULT 'Employee',
	`status`		TINYINT DEFAULT 0 -- 0: Not Active, 1: Active
);

-- Create table Registration_User_Token
DROP TABLE IF EXISTS 	`Registration_User_Token`;
CREATE TABLE IF NOT EXISTS `Registration_User_Token` (
	id 				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`token`	 		CHAR(36) NOT NULL UNIQUE,
	`user_id` 		SMALLINT UNSIGNED NOT NULL,
	`expiryDate` 	DATETIME NOT NULL
);

-- password: 123456
INSERT INTO `User` 	(`username`,			`email`,						`password`,												 FullName   ,	`status`, 	`role`	)
VALUE				('admin'		    ,	'Email1@gmail.com',		'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	'admin'		,       0   , 'Manager' ),
					('manager'		    ,	'Email2@gmail.com',		'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	'manager'	,       0   , 'Manager' ),
					('user'		        ,	'Email3@gmail.com',		'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	'user'		,       0   , 'Manager' ),
					('Username4'		,	'Email4@gmail.com',		'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	'Fullname4'	,       0   , 'Manager' ),
					('Username5'		,	'Email5@gmail.com',		'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	'Fullname5'	,       0   , 'Manager' ),
					('Username6'		,	'Email6@gmail.com',		'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	'Fullname6'	,       0   , 'Employee'),
					('Username7'		,	'Email7@gmail.com',		'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	'user'		,       0   , 'Employee'),
					('Username8'		,	'Email8@gmail.com',		'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	'Fullname8'	,       0   , 'Employee'),
					('Username9'		,	'Email9@gmail.com',		'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	'Fullname9'	,       0   , 'Manager' ),
					('Username10'		,   'Email10@gmail.com',	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi',	'Fullname10',       0   , 'Employee');
