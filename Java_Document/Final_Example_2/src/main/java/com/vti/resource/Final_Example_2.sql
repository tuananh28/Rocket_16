DROP DATABASE IF EXISTS Final_Example_2;
CREATE DATABASE Final_Example_2;
USE  Final_Example_2;

CREATE TABLE `Account`(
    AccountID   TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
    FullName    VARCHAR(50) NOT NULL ,
    Email       VARCHAR(50) NOT NULL ,
    Password    VARCHAR(100) NOT NULL ,
    ExpInYear   TINYINT UNSIGNED,
    ProSkill    ENUM('DEV', 'TEST', 'JAVA','SQL'),
    Category    ENUM('MANAGER', 'EMPLOYEE') NOT NULL ,
    Role        ENUM('ADMIN','USER') NOT NULL
);

CREATE TABLE `Project`(
    ProjectID   TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
    ProjectName VARCHAR(50) NOT NULL ,
    TeamSize    TINYINT UNSIGNED NOT NULL
);

CREATE TABLE `AccountProject`(
    ProjectID   TINYINT UNSIGNED NOT NULL ,
    AccountID   TINYINT UNSIGNED NOT NULL ,
    PRIMARY KEY (ProjectID,AccountID)
);

INSERT INTO `Account` (     FullName        ,       Email           , Password , ExpInYear , ProSkill  , Category , Role  )
VALUES                (   'Bùi Tuấn Anh'    , 'tuananh@gmail.com'   , '1234567',       5   ,   'DEV'   , 'MANAGER','ADMIN'),
                      (  'Bùi Thị Hoa Mai'  , 'hoamai@gmail.com'    , '0501998',       5   ,   'TEST'  , 'MANAGER','ADMIN'),
                      (  'Nguyễn Hoàng Anh' , 'hoanganh@gmail.com'  , '1111999',       1   ,   'SQL'   ,'EMPLOYEE', 'USER'),
                      (    'Nguyễn Hữ Tùng' , 'huutung@gmail.com'   , '1234567',      NULL ,   'TEST'  ,'EMPLOYEE', 'USER'),
                      (    'Lê Thúy Quỳnh'  , 'thuyquynh@gmail.com' , '1234567',       1   ,   'JAVA'  ,'EMPLOYEE', 'USER'),
                      (    'Đào Tuấn Minh'  , 'tuanminh@gmail.com'  , '1234567',      NULL ,   'JAVA'  ,'EMPLOYEE', 'USER'),
                      (    'Nguyễn Thị Linh', 'linhnguyen@gmail.com', '1234567',       5   ,   'JAVA'  ,'EMPLOYEE', 'USER'),
                      (  'Trương Hoàng Minh', 'hoangminh@gmail.com' , '1234567',       5   ,   'SQL'   ,'EMPLOYEE', 'USER'),
                      (    'Nguyễn Đào Lực' , 'daoluc@gmail.com'    , '1234567',       5   ,   'TEST'  ,'EMPLOYEE', 'USER');

INSERT INTO `Project`   (ProjectName    , TeamSize)
VALUES                  ('Project DEV'  ,     1   ),
                        ('Project TEST' ,     2   ),
                        ('Project JAVA' ,     3   ),
                        ('Project SQL'  ,     4   );

INSERT INTO `AccountProject`    (ProjectID, AccountID)
VALUES                          (   1     ,     1    ),
                                (   2     ,     2    ),
                                (   3     ,     3    ),
                                (   4     ,     4    ),
                                (   1     ,     5    ),
                                (   2     ,     6    ),
                                (   3     ,     1    ),
                                (   4     ,     8    ),
                                (   1     ,     7    );

SELECT  A.Email, A.FullName,A.Category
FROM `Account` A
JOIN `AccountProject` AP USING (AccountID)
JOIN `Project` P USING (ProjectID)
WHERE  P.ProjectName = 'Project DEV';

Select * from `Account`