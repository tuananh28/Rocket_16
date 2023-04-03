DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;
DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
    DepartmentID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName NVARCHAR(30) NOT NULL UNIQUE KEY
);
DROP TABLE IF EXISTS Position;
CREATE TABLE `Position` (
    PositionID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName ENUM('Dev', 'Test', 'Scrum_Master', 'PM') NOT NULL UNIQUE KEY
);
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account` (
    AccountID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email VARCHAR(50) NOT NULL UNIQUE KEY,
    Username VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName NVARCHAR(50) NOT NULL,
    DepartmentID TINYINT UNSIGNED NOT NULL,
    PositionID TINYINT UNSIGNED NOT NULL,
    CreateDate DATETIME DEFAULT NOW(),
    FOREIGN KEY (DepartmentID)
        REFERENCES Department (DepartmentID),
    FOREIGN KEY (PositionID)
        REFERENCES `Position` (PositionID)
);

INSERT INTO Department(DepartmentName)
VALUES
(N'Marketing' ),
(N'Sale' ),
(N'Bảo vệ' ),
(N'Nhân sự' ),
(N'Kỹ thuật' ),
(N'Tài chính' ),
(N'Phó giám đốc'),
(N'Giám đốc' ),
(N'Thư kí' ),
(N'No person' ),
(N'Bán hàng' );
INSERT INTO Position (PositionName )
VALUES ('Dev' ),
('Test' ),
('Scrum_Master'),
('PM' );
INSERT INTO `Account`(Email , Username
, FullName , DepartmentID , PositionID,
CreateDate)
VALUES ('Email1@gmail.com' ,
'Username1' ,'Fullname1' , '5' , '1'
,'2020-03-05'),
('Email2@gmail.com' ,
'Username2' ,'Fullname2' , '1' , '2'
,'2020-03-05'),('Email3@gmail.com' , 'Username3' ,'Fullname3'
, '2' , '2' ,'2020-03-07'),
('Email4@gmail.com' , 'Username4' ,'Fullname4'
, '3' , '4' ,'2020-03-08'),
('Email5@gmail.com' , 'Username5' ,'Fullname5'
, '4' , '4' ,'2020-03-10'),
('Email6@gmail.com' , 'Username6' ,'Fullname6'
, '6' , '3' ,'2020-04-05'),
('Email7@gmail.com' , 'Username7' ,'Fullname7'
, '2' , '2' , NULL ),
('Email8@gmail.com' , 'Username8' ,'Fullname8'
, '8' , '1' ,'2020-04-07'),
('Email9@gmail.com' , 'Username9' ,'Fullname9'
, '2' , '2' ,'2020-04-07'),
('Email10@gmail.com' , 'Username10' ,'Fullname10'
, '10' , '1' ,'2020-04-09'),
('Email11@gmail.com' , 'Username11' ,'Fullname11'
, '10' , '1' , DEFAULT),
('Email12@gmail.com' , 'Username12'
,'Fullname12' , '10' , '1' , DEFAULT);