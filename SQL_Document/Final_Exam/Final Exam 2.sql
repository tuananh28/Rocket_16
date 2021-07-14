DROP DATABASE IF EXISTS Final_Exam_2;
CREATE DATABASE Final_Exam_2;
USE Final_Exam_2;


 CREATE TABLE `GiangVien`(
	MaGV 		MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    HotenGV   	VARCHAR(30) NOT NULL,
    Luong 		DECIMAL(5,2) NOT NULL
 );

 CREATE TABLE `SinhVien`(
	MaSV 		MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    HotenSV 	VARCHAR(30) NOT NULL,
    Namsinh		SMALLINT NOT NULL,
    Quequan		VARCHAR(30)
 );

 CREATE TABLE `DeTai`(
	MaDT 		CHAR(10) PRIMARY KEY,
    TenDT 		VARCHAR(50) UNIQUE KEY NOT NULL,
    Kinhphi		INT NOT NULL,
    NoiThucTap 	VARCHAR(30) NOT NULL
 );

 CREATE TABLE `HuongDan`(
    HD_id       TINYINT UNSIGNED PRIMARY KEY  AUTO_INCREMENT,
	MaSV 		MEDIUMINT UNSIGNED ,
    MaDT 		CHAR(10) ,
    MaGV 		MEDIUMINT UNSIGNED ,
    Ketqua 		DECIMAL(5,2),
    CONSTRAINT Kp_MaSV FOREIGN KEY (MaSV) REFERENCES `SinhVien` (MaSV) ON DELETE CASCADE ,
    CONSTRAINT Kp_MaDT FOREIGN KEY (MaDT) REFERENCES `DeTai` (MaDT) ON DELETE CASCADE ,
    CONSTRAINT Kp_MaGV FOREIGN KEY (MaGV) REFERENCES `GiangVien` (MaGV) ON DELETE CASCADE
 );

 /*----------------------------CSDL----------------------------------*/

INSERT INTO	`GiangVien` (	HotenGV			,	Luong	)
VALUES					( 'Lê Thị Oanh'		,	'125.1'	),
						( 'Hoàng Thị Thúy'	,	'52.12'	),
                        ('Lê Hoàng Oanh'	,	'73.75'	),
                        ('Trần Thị Tuyết'	,	'225.4'	),
                        ('Lê Thị Oanh'		,	'57.5'	),
                        ('Nguyễn Thị Kiều'	,	'785.1'	),
                        ('Bùi Minh Triết'	,	'556.2'	),
                        ('Nguyễn Hữu Hải'	,	'72.2'	),
                        ('Nguyễn Hoàng Nam'	,	'77.3'	);

 INSERT INTO `SinhVien` (		HotenSV		, Namsinh,	Quequan	 )
 VALUES					(	'Bùi Tuấn Anh'	,  1999	, 'Bắc Ninh' ),
						( 'Bùi Thị Hoa Mai'	,  1998	, 'Hải Dương'),
                        ( 'Nguyễn Tuấn Anh'	,  2000	,  'Hà Nội'  ),
                        (	'Lê Thị Thu'	,  2002	,  'Hà Nội'  ),
                        ('Đào Lê Phương Mai',  1999	,  'TP.HCM'  ),
                        ('Nguyễn Thị Phương',  2000	, 'Bắc Ninh' ),
                        (	'Bùi Tuấn Anh'	,  1999	,  'Hà Nội'  ),
                        ('Nguyễn Hoàng Năng',  2000	, 'Hải Dương'),
                        ('Nguyễn Thị Hoa'	,  1999	,  'TP.HCM'  ),
                        (  'Trần Hải Nam'	,  1999	,  'TP.HCM'  );

INSERT INTO	`DeTai` (  MaDT	,			   TenDT					,Kinhphi, NoiThucTap)
VALUES				( 'A01'	,        'CONG NGHE SINH HOC'		    , 20000 ,'Bắc Ninh'	),
					( 'A02'	,'HTTT quản lý giáo vụ cho một Khoa'	,  5000 ,'Hải Dương'),
					( 'C01'	,'Nghiên cứu chế tạo sợi Nanô Platin'	,  3000 , 'Hà Nội'  ),
					( 'C02'	,    'Ứng dụng hóa học xanh'			,  200 	, 'Hà Nội'  ),
					( 'D05'	,'HTTT quản lý thư viện ở các trường ĐH', 10000 , 'TP.HCM'  );

INSERT INTO	`HuongDan`(MaSV	,  MaDT	,  MaGV	,Ketqua)
VALUES				  (	 1	, 'A01'	,   2 	,'7.0' ),
					  (	 2	, 'A02' ,	9 	,'8.5' ),
					  (	 3	, 'A01'	,	3 	,'6.2' ),
					  (	 4	, 'C01'	,	2 	,'9.0' ),
					  (	 5	, 'D05'	,	1 	,'0.0' ),
                      (	 6	, 'C01'	,	2 	,'9.8' ),
                      (	 7	, NULL	,	1 	,'8.5' ),
                      (	 8	, NULL	,	2 	,'0.0' ),
                      (	 9	, 'A02'	,	6 	, NULL ),
                      (	 10	, 'A01'	,	7 	, NULL );

-- 2. Viết lệnh để
-- a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
SELECT MaSV
FROM  `HuongDan`
WHERE  MaDT IS NULL;
-- b) Lấy ra số sinh viên làm đề tài ‘CONG NGHE SINH HOC’
SELECT  MaDT,COUNT(MaSV) AS 'So_luong'
FROM    `HuongDan`
GROUP BY MaDT
HAVING  MaDT = 'A01';
/*3. Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm:
mã số, họ tên và tên đề tài
(Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có")*/
CREATE OR REPLACE VIEW `SinhVienInfo`(ma_so, ho_ten, ten_de_tai) AS
SELECT SV.MaSV, SV.HotenSV , CASE WHEN TenDT IS NULL THEN 'Chưa có' ELSE TenDT END
FROM   `SinhVien` SV
LEFT JOIN  `HUONGDAN` HD ON SV.MASV = HD.MASV
LEFT JOIN   `DeTai` DT on DT.MaDT = HD.MaDT
group by SV.MaSV, SV.HotenSV ,DT.TenDT;

SELECT * FROM SinhVienInfo;

/*4. Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1900
thì hiện ra thông báo "năm sinh phải > 1900"*/

DROP TRIGGER IF EXISTS `Ques_4`;
DELIMITER //
CREATE TRIGGER `Ques_4`
    BEFORE INSERT ON `SinhVien`
    FOR EACH ROW
    BEGIN
        DECLARE var_BirthSV SMALLINT;
        SELECT Namsinh INTO var_BirthSV
        FROM `SinhVien`
        WHERE NEW.Namsinh = var_BirthSV;
        IF(NEW.Namsinh <= 1900) THEN
            SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'năm sinh phải > 1900';
        end if;
    end //
DELIMITER ;
INSERT INTO `SinhVien` (    HotenSV     , Namsinh, Quequan   )
VALUES                 ( 'Bùi Tuấn Anh' , 1890   , 'Bắc Ninh');

-- Cách 2
DROP TRIGGER IF EXISTS Trg_InsertToSinhVien;
DELIMITER $$
CREATE TRIGGER Trg_InsertToSinhVien
	BEFORE INSERT ON `SinhVien`
    FOR EACH ROW
    BEGIN
        IF (NEW.NamSinh <= '1950')
        THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Moi ban kiem tra lai nam sinh. ';
		END IF;
	END $$

INSERT INTO `SinhVien` (HotenSV, NamSinh, QueQuan)
VALUES ('Vũ Văn Bình', '1940', 'Hải Dương');
/*5. Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông
tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi*/

-- Cách 1
DROP TRIGGER IF EXISTS Ques_5;
DELIMITER //
CREATE TRIGGER Ques_5
    BEFORE DELETE ON `SinhVien`
    FOR EACH ROW
        DELETE
        FROM HuongDan
        WHERE HuongDan.MaSV IS NULL;
DELIMITER ;
DELETE
FROM `SinhVien`
WHERE MaSV = 1;
SELECT *FROM `SinhVien`;

-- Cách 2
ALTER TABLE HuongDan DROP FOREIGN KEY Kp_MaSV;
ALTER TABLE HuongDan ADD CONSTRAINT fk_HuongDan_SinhVien FOREIGN KEY (MaSV) REFERENCES SinhVien(MaSV) ON DELETE CASCADE;

DELETE FROM SinhVien
WHERE MaSV = '5';

select * FROM HuongDan