-- create database
DROP DATABASE IF EXISTS Testing_System_5;
CREATE DATABASE Testing_System_5;
USE Testing_System_5;

-- create table : address
DROP TABLE IF EXISTS Address;
CREATE TABLE Address(
	AddressID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    AddressName 			NVARCHAR(100) NOT NULL UNIQUE KEY
);

-- create table: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 			NVARCHAR(30) NOT NULL UNIQUE KEY
);

-- create table : Detail Department
DROP TABLE IF EXISTS DetailDepartment;
CREATE TABLE DetailDepartment(
	DepartmentID 			TINYINT UNSIGNED PRIMARY KEY,
    AddressID 				TINYINT UNSIGNED, -- UNIQUE KEY,  -- NOT NULL ,
    EmulationPoint 			TINYINT UNSIGNED,
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID),
	FOREIGN KEY(AddressID) REFERENCES Address(AddressID)
);

-- create table: Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    Username				VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    FirstName				NVARCHAR(50) NOT NULL,
    LastName				NVARCHAR(50) NOT NULL,	-- create field fullName in POJO
    DepartmentID 			TINYINT UNSIGNED NOT NULL,	-- Set default waiting
    CreateDate				DATETIME DEFAULT NOW(), -- Cannot update this field
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID)
);



/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Address
INSERT INTO Address(AddressName)
VALUES
				(N'P501'),
				(N'P502'),
				(N'P503'),
				(N'P504'),
				(N'P505'),
				(N'P401'),
				(N'P402'),
				(N'P403'),
				(N'P404'),
				(N'P405');

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
						(N'Bán hàng'	);

-- Add data DetailDepartment
INSERT INTO DetailDepartment	(  DepartmentID		, AddressID, 	EmulationPoint)
VALUES 							(		1,				1,					1	),
								(		2,				2,					4	),
								(		3,				3,					6	),
								(		4,				4,					7	),
								(		5,				5,					2	),
								(		6,				6,					1	),
								(		7,				7,					5	),
								(		8,				8,					6	),
								(		9,				9,					8	),
								(		10,				10,					9	);




-- Add data Account
INSERT INTO `Account`(Email								, Username			, FirstName,	LastName,		 DepartmentID	, 	CreateDate)
VALUES 				('haidang29productions@gmail.com'	, 'dangblack'		,'Dang'	,		'Nguyen Hai'	,   '5'			,	'2020-03-05'),
					('account1@gmail.com'				, 'quanganh'		,'Anh'	,		'Tong Quang'	,   '1'		    ,	'2020-03-05'),
                    ('account2@gmail.com'				, 'vanchien'		,'Chien',		'Nguyen Van'	,   '2'			,	'2020-03-07'),
                    ('account3@gmail.com'				, 'cocoduongqua'	,'Do'	,		'Duong'			,   '3'			,	'2020-03-08'),
                    ('account4@gmail.com'				, 'doccocaubai'		,'Thang',		'Nguyen Chien'  ,   '4'			,	'2020-03-10'),
                    ('dapphatchetngay@gmail.com'		, 'khabanh'			,'Kha'	,		'Ngo Ba'		,   '6'			,	NOW()),
                    ('songcodaoly@gmail.com'			, 'huanhoahong'		,'Huan'	,		'Bui Xuan'		,   '7'			,	NOW()),
                    ('sontungmtp@gmail.com'				, 'tungnui'			,'Tung'	,		'Nguyen Thanh'	,   '8'			,	'2020-04-07'),
                    ('duongghuu@gmail.com'				, 'duongghuu'		,'Huu'	,		'Duong Van'		,   '9'			,	'2020-04-07'),
                    ('vtiaccademy@gmail.com'			, 'vtiaccademy'		,'Ai'	,		'Vi Ti'			,   '10'		,	'2020-04-09');
