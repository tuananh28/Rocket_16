DROP DATABASE IF EXISTS Final_Example_1;
CREATE DATABASE Final_Example_1;
USE  Final_Example_1;

CREATE TABLE `Account`(
    AccountID   TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
    FullName    VARCHAR(50) NOT NULL ,
    Email       VARCHAR(50) NOT NULL ,
    Password    VARCHAR(100) NOT NULL ,
    ExpInYear   TINYINT UNSIGNED,
    ProSkill    ENUM('DEV', 'TEST', 'JAVA','SQL'),
    Category    ENUM('MANAGER', 'EMPLOYEE')
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

INSERT INTO `Account` (     FullName        ,       Email           , Password , ExpInYear , ProSkill  , Category )
VALUES                (   'Bùi Tuấn Anh'    , 'tuananh@gmail.com'   , '1234567',       5   ,   'DEV'   , 'MANAGER'),
                      (  'Bùi Thị Hoa Mai'  , 'hoamai@gmail.com'    , '0501998',       5   ,   'TEST'  , 'MANAGER'),
                      (  'Nguyễn Hoàng Anh' , 'hoanganh@gmail.com'  , '1111999',       1   ,   'SQL'   ,'EMPLOYEE'),
                      (    'Nguyễn Hữ Tùng' , 'huutung@gmail.com'   , '1234567',      NULL ,   'TEST'  ,'EMPLOYEE'),
                      (    'Lê Thúy Quỳnh'  , 'thuyquynh@gmail.com' , '1234567',       1   ,   'JAVA'  ,    NULL  ),
                      (    'Đào Tuấn Minh'  , 'tuanminh@gmail.com'  , '1234567',      NULL ,   'JAVA'  ,    NULL  ),
                      (    'Nguyễn Thị Linh', 'linhnguyen@gmail.com', '1234567',       5   ,   'JAVA'  ,'EMPLOYEE'),
                      (  'Trương Hoàng Minh', 'hoangminh@gmail.com' , '1234567',       5   ,   'SQL'   ,'EMPLOYEE'),
                      (    'Nguyễn Đào Lực' , 'daoluc@gmail.com'    , '1234567',       5   ,   'TEST'  ,'EMPLOYEE');

INSERT INTO `Project`   (ProjectName    , TeamSize)
VALUES                  ('Project DEV'  ,     1   ),
                        ('Project TEST' ,     1   ),
                        ('Project JAVA' ,     1   ),
                        ('Project SQL'  ,     1   ),
                        ('Project DEV'  ,     2   ),
                        ('Project SQL'  ,     2   ),
                        ('Project JAVA' ,     2   ),
                        ('Project TEST' ,     2   );

INSERT INTO `AccountProject`    (ProjectID, AccountID)
VALUES                          (   1     ,     1    ),
                                (   2     ,     2    ),
                                (   3     ,     3    ),
                                (   4     ,     4    ),
                                (   1     ,     5    ),
                                (   7     ,     2    ),
                                (   8     ,     1    ),
                                (   2     ,     8    ),
                                (   1     ,     7    );