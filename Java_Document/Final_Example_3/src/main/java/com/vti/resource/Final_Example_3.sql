DROP DATABASE IF EXISTS final_example_3;
CREATE DATABASE final_example_3;
USE final_example_3;

CREATE TABLE `Candidate`(
    CandidateID         TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
    FirstName           VARCHAR(50) NOT NULL ,
    LastName            VARCHAR(50) NOT NULL ,
    Phone               VARCHAR(20) UNIQUE ,
    Email               VARCHAR(20) UNIQUE NOT NULL ,
    Password            VARCHAR(100) NOT NULL ,
    ExpInYear           TINYINT UNSIGNED,
    ProSkill            ENUM('DEV','TEST','JAVA','SQL'),
    GraduationRank      ENUM('EXCELLENCE', 'GOOD', 'FAIR', 'POOR'),
    Category			ENUM('EXPERIENCECANDIDATE', 'FRESHERCANDIDATE') NOT NULL
);

INSERT INTO Candidate   (FirstName  , LastName  ,   Phone    ,        Email         , Password , ExpInYear  , ProSkill , GraduationRank ,       Category        )
VALUES                  ( 'Tuấn Anh',   'Bùi'   ,'0868102848','tuananh@gmail.com'   , '123456' ,      4     ,   'DEV'  ,  'EXCELLENCE'  , 'EXPERIENCECANDIDATE' ),
                        ( 'Hoa Mai' ,   'Bùi'   ,'0978965896','hoamai@gmail.com'    , '123456' ,      3     ,   'TEST' ,  'EXCELLENCE'  , 'EXPERIENCECANDIDATE' ),
                        ('Hữu Trọng',   'Nguyễn','0125897965','trongngu@gmail.com'  , '123456' ,      NULL  ,   'JAVA' ,      'POOR'    , 'FRESHERCANDIDATE'    ),
                        (   'Long'  ,   'Lê'    ,'0978945854','longle@gmail.com'    , '123456' ,      NULL  ,   'JAVA' ,      'GOOD'    , 'FRESHERCANDIDATE'    ),
                        (   'Thủy'  ,   'Đinh'  ,'0896985249','dinhthuy@gmail.com'  , '123456' ,      NULL  ,   'TEST' ,      'POOR'    , 'FRESHERCANDIDATE'    ),
                        (   'Minh'  ,   'Nguyễn','0358794586','tuanminh@gmail.com'  , '123456' ,      2     ,   'DEV'  ,      'GOOD'    , 'EXPERIENCECANDIDATE' ),
                        (   'Tiến'  ,   'Nguyễn','0254896252','dinhtien@gmail.com'  , '123456' ,      1     ,   'DEV'  ,      'GOOD'    , 'FRESHERCANDIDATE'    ),
                        (   'Đào'   ,   'Nguyễn','0889225468','huhudao@gmail.com'   , '123456' ,      1     ,   'DEV'  ,      'FAIR'    , 'FRESHERCANDIDATE'    ),
                        (   'Linh'  ,   'Nguyễn','0586265962','nguyenlinh@gmail.com', '123456' ,      2     ,   'SQL'  ,      'GOOD'    , 'EXPERIENCECANDIDATE' ),
                        ( 'Tuấn Anh',   'Mai'   ,'0689232695','anhmai@gmail.com'    , '123456' ,      1     ,   'SQL'  ,      'FAIR'    , 'FRESHERCANDIDATE'    );

