DROP DATABASE IF EXISTS ThucTap;
CREATE DATABASE ThucTap;
USE ThucTap;

CREATE TABLE `Country`(
    country_id   CHAR(10) PRIMARY KEY ,
    country_name VARCHAR(50)
);

CREATE TABLE `Location`(
    location_id     CHAR(10)  PRIMARY KEY ,
    street_address  VARCHAR(100),
    postal_code     INT,
    country_id      CHAR(10) NOT NULL ,
    CONSTRAINT kp_country_id FOREIGN KEY (country_id) REFERENCES `Country`(country_id)ON DELETE CASCADE
);

CREATE TABLE `Employee`(
    employee_id TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    full_name   VARCHAR(50),
    email       VARCHAR(50) UNIQUE KEY ,
    location_id CHAR(10) ,
    CONSTRAINT kp_location_id FOREIGN KEY (location_id) REFERENCES `Location`(location_id) ON DELETE CASCADE
);

INSERT INTO `Country` (country_id, country_name)
VALUES                (   'VN'   ,  'Việt Nam' ),
                      (   'USA'  ,  'American' ),
                      (   'ENG'  ,  'England'  ),
                      (   'THAIL',  'ThaiLand' ),
                      (   'KOR'  ,  'KOREA'    );

INSERT INTO `Location` (location_id, street_address, postal_code, country_id)
VALUES                 (   'HAN'   ,    'Hà Nội'   ,    '88800' ,   'VN'    ),
                       (   'SGN'   ,    'Sài Gòn'  ,    '88600' ,   'VN'    ),
                       (   'LON'   ,    'LonDon'   ,    '66520' ,   'ENG'   ),
                       (   'MAN'   , 'Manchester'  ,    '66525' ,   'ENG'   ),
                       (   'LIV'   ,  'Liverpool'  ,    '66528' ,   'ENG'   ),
                       (   'NYC'   ,    'New York' ,    '78956' ,   'USA'   ),
                       (   'WDC'   ,  'Washington' ,    '78953' ,   'USA'   ),
                       (   'BANG'  ,    'BangKok'  ,    '89562' ,   'THAIL' );

INSERT INTO `Employee` (      full_name     ,        email           , location_id)
VALUES                 ('Bùi Tuấn Anh'	    , 'tuananh28@gmail.com'	 ,    'HAN'   ),
                       ('Bùi Thị Hoa Mai'   , 'hoamai@gmail.com'	 ,    'HAN'   ),
                       ('Lê Thị Binh'	    , 'lebinh@gmail.com'     ,    'SGN'   ),
                       ('Nguyễn Hữu Bằng'   , 'banglang@gmail.com'	 ,    'SGN'   ),
                       ('Trần Tuấn Phương'  , 'biwhite@gmail.com'	 ,    'SGN'   ),
                       ('Nguyễn Thị Lê'     , 'lenguyen@gmail.com'	 ,    'MAN'   ),
                       ('Đặng Thị Thảo'     , 'dangthao@gmail.com'	 ,     NULL   ),
                       ('Lê Hoàng Khôi'     , 'khoile@gmail.com'	 ,    'LON'   ),
                       ('Trần Văn Diễn'     , 'dientran112@gmail.com',    'HAN'   ),
                       ('Bùi Minh Hiếu'     , 'hieubui@gmail.com'	 ,    'BANG'  );

-- 2. Viết lệnh để
-- a) Lấy tất cả các nhân viên thuộc Việt nam
SELECT E.*
FROM `Employee` E
WHERE E.location_id IN (SELECT L.location_id
                       FROM `Location` L
                       JOIN `Country` C
                       USING (Country_id) WHERE country_name = 'Việt Nam');
-- b) Lấy ra tên quốc gia của employee có email là "tuananh28@gmail.com"

SELECT country_name
FROM `Country`
WHERE country_id IN (   SELECT L.country_id
                        FROM `Employee` E
                        JOIN  `Location` L
                        ON E.location_id = L.location_id
                        WHERE E.email = 'tuananh28@gmail.com');

-- c) Thống kê mỗi country, mỗi location có bao nhiêu employee đang làm việc.

SELECT C.country_id,E.location_id,COUNT(E.employee_id) AS 'So_Luong'
FROM  `Country` C
JOIN Location L on C.country_id = L.country_id
JOIN Employee E on L.location_id = E.location_id
GROUP BY E.location_id, C.country_id;
-- 3. Tạo trigger cho table Employee chỉ cho phép insert mỗi quốc gia có tối đa 10 employee

DROP TRIGGER IF EXISTS Ques_3;
DELIMITER //
CREATE TRIGGER Ques_3
    BEFORE INSERT ON `Employee`
    FOR EACH ROW
    BEGIN
        DECLARE var_CountLocation CHAR(10) ;
        SELECT COUNT(location_id) INTO var_CountLocation
        FROM `Employee`
        WHERE location_id = NEW.location_id;
        IF(var_CountLocation > 10) THEN
            SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Cannot insert any more';
        end if;
    end //
DELIMITER ;
INSERT INTO `Employee` (    full_name    ,        email        , location_id)
VALUES                 ('Nguyễn Văn Linh','vanlinh13@gmail.com',   'BANG'   );
SELECT * FROM Employee;
/*4. Hãy cấu hình table sao cho khi xóa 1 location nào đó thì tất cả employee ở
location đó sẽ có location_id = null*/
DROP TRIGGER IF EXISTS Ques_4;
DELIMITER //
CREATE TRIGGER Ques_4
    BEFORE DELETE ON `Location`
    FOR EACH ROW
    BEGIN
        UPDATE  `Employee`
        SET     location_id = NULL
        WHERE   location_id = OLD.location_id;
    end //
DELIMITER ;
DELETE FROM `Location` WHERE location_id = 'HAN';

select *from employee;

-- Lay ten dat nuoc cua nhan vien neu nhan vien khong co contry se thanh vo gia cu
    SELECT  country_id,country_name
    FROM  `Country`
    WHERE country_id IN (SELECT country_id
                         FROM `location` L
                         JOIN `employee` e on L.location_id = e.location_id
                         GROUP BY e.location_id);





