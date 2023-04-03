DROP DATABASE IF EXISTS final_example_4;
CREATE DATABASE final_example_4;
USE final_example_4;

CREATE TABLE `User`(
    UserID      TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
    FullName    VARCHAR(50) NOT NULL ,
    Email       VARCHAR(50) UNIQUE NOT NULL ,
    Password    VARCHAR(50) NOT NULL ,
    ExpInYear   TINYINT UNSIGNED,
    ProSkill    ENUM('DEV','TEST','JAVA','SQL'),
    Role        ENUM('ADMIN','USER')
);

INSERT INTO `User`  (       FullName      ,         Email         , Password, ExpInYear ,  ProSkill , Role  )
VALUES              (   'Bùi Tuấn Anh'    , 'tuananh@gmail.com'   , '123456',       5   ,   'DEV'   ,'ADMIN'),
                    (  'Bùi Thị Hoa Mai'  , 'hoamai@gmail.com'    , '050199',       5   ,   'TEST'  ,'ADMIN'),
                    (  'Nguyễn Hoàng Anh' , 'hoanganh@gmail.com'  , '111199',       1   ,   'SQL'   , 'USER'),
                    (    'Nguyễn Hữ Tùng' , 'huutung@gmail.com'   , '123456',      NULL ,   'TEST'  , 'USER'),
                    (    'Lê Thúy Quỳnh'  , 'thuyquynh@gmail.com' , '123456',       1   ,   'JAVA'  , 'USER'),
                    (    'Đào Tuấn Minh'  , 'tuanminh@gmail.com'  , '123456',      NULL ,   'JAVA'  , 'USER'),
                    (    'Nguyễn Thị Linh', 'linhnguyen@gmail.com', '123456',       5   ,   'JAVA'  , 'USER'),
                    (  'Trương Hoàng Minh', 'hoangminh@gmail.com' , '123456',       5   ,   'SQL'   , 'USER'),
                    (    'Nguyễn Đào Lực' , 'daoluc@gmail.com'    , '123456',       5   ,   'TEST'  , 'USER');