DROP DATABASE IF EXISTS `Fresher`;
CREATE DATABASE `Fresher`;
USE `Fresher`;

CREATE TABLE `Trainee`(
	TraineeID 			TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Full_Name 			VARCHAR(100) NOT NULL,
    Birth_Date 			DATETIME DEFAULT NOW(),
    Gender 				ENUM('male', 'female', 'unknown') NOT NULL,
    ET_IQ 				TINYINT UNSIGNED CHECK (ET_IQ <= 20),
    ET_Gmath			TINYINT UNSIGNED CHECK (ET_Gmath <=20),
    ET_English 			TINYINT UNSIGNED CHECK (ET_English <= 50),
    Training_Class 		CHAR(10) NOT NULL,
    Evaluation_Notes 	VARCHAR(1000)
);
ALTER TABLE `Trainee` ADD VTI_Account VARCHAR(50) NOT NULL UNIQUE KEY;

CREATE TABLE `Data Types1`(
	ID 					MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Name` 				VARCHAR(50),
    `Code` 				CHAR(5),
    ModifiedDate 		DATETIME DEFAULT NOW()
);

CREATE TABLE `Data Types2`(
	ID					MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Name`				VARCHAR(50),
    BirthDate			DATETIME DEFAULT NOW(),
    Gender				ENUM ('0','1'), -- 0 là Male, 1là Female, NULL là Unknown
    IsDeletedFlag 		ENUM ('0','1') NOT NULL -- 0 là đang hoạt động, 1 là đã xóa.
);
	