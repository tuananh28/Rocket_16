 DROP DATABASE IF EXISTS `ThucTap`;
 CREATE DATABASE `ThucTap`;
 USE `ThucTap`;
 
 /*----------------------------- TẠO BẢNG ----------------------------*/
 CREATE TABLE `Khoa`(
	Makhoa 		CHAR(10) PRIMARY KEY NOT NULL,
    Tenkhoa  	VARCHAR(30) UNIQUE KEY NOT NULL,
    Dienthoai	CHAR(10) UNIQUE KEY
 );
 
 CREATE TABLE `GiangVien`(
	MaGV 		MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    HotenGV   	VARCHAR(30) NOT NULL,
    Luong 		DECIMAL(5,2) NOT NULL,
    Makhoa		CHAR(10) NOT NULL,
    CONSTRAINT Kp_MakhoaGV FOREIGN KEY (Makhoa) REFERENCES `Khoa`(Makhoa)
 );
 
 CREATE TABLE `SinhVien`(
	MaSV 		MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    HotenSV 	VARCHAR(30) NOT NULL,
    Makhoa		CHAR(10) NOT NULL,
    Namsinh		SMALLINT NOT NULL,
    Quequan		VARCHAR(30),
    CONSTRAINT Kp_MakhoaSV FOREIGN KEY (Makhoa) REFERENCES `Khoa`(Makhoa)
 );
 
 CREATE TABLE `DeTai`(
	MaDT 		CHAR(10) PRIMARY KEY,
    TenDT 		VARCHAR(50) UNIQUE KEY NOT NULL,
    Kinhphi		INT NOT NULL,
    NoiThucTap 	VARCHAR(30) NOT NULL
 );
 
 CREATE TABLE `HuongDan`(
	MaSV 		MEDIUMINT UNSIGNED NOT NULL,
    MaDT 		CHAR(10) NOT NULL,
    MaGV 		MEDIUMINT UNSIGNED NOT NULL,
    Ketqua 		DECIMAL(5,2),
    CONSTRAINT Kp_MaSV FOREIGN KEY (MaSV) REFERENCES `SinhVien` (MaSV),
    CONSTRAINT Kp_MaDT FOREIGN KEY (MaDT) REFERENCES `DeTai` (MaDT),
    CONSTRAINT Kp_MaGV FOREIGN KEY (MaGV) REFERENCES `GiangVien` (MaGV)
 );
 
 /*------------------------------CSDL----------------------------------*/
 
 INSERT INTO `Khoa` (Makhoa,		Tenkhoa			,	Dienthoai)
 VALUES				('CNSH',  'Công Nghệ Sinh Học'	,'0975896363'),
					('CNTT',  'Công Nghệ Thông Tin'	,'0689875913'),
                    ('QLTN',  'Quản Lý Tài Nguyên'	,'0984587569'),
                    ('QLTC',  'Quản Lý Tài Chính'	,'0984595624'),
                    ( 'KKT',  	'Khoa Kế Toán'		,'0958956215'),
                    ('KTPT','Kế hoạch và phát triển','0966688899'),
                    ('KKTH',  'Khoa Kinh Tế Học'	,'0998656969'),
                    ('KHQL', 'Khoa Khoa Học Quản Lý','0978789696'),
                    ('KDT',  	 'Khoa Đầu Tư'		,'0998963653'),
                    ('DLKS', 'Du lịch và Khách sạn'	,'0912345678'),
                    ('NNKT','Khoa Ngoại ngữ Kinh tế','0341896446'),
                    ('QTKD', 'Quản trị kinh doanh'	,'0241586963');

INSERT INTO	`GiangVien` (	HotenGV			,	Luong	,Makhoa)
VALUES					( 'Lê Thị Oanh'		,	'125.1'	,'CNTT'),
						( 'Hoàng Thị Thúy'	,	'52.12'	,'CNSH'),
                        ('Lê Hoàng Oanh'	,	'73.75'	,'QLTN'),
                        ('Trần Thị Tuyết'	,	'225.4'	,'QLTC'),
                        ('Lê Thị Oanh'		,	'57.5'	, 'KKT'),
                        ('Nguyễn Thị Kiều'	,	'785.1'	,'QTKD'),
                        ('Bùi Minh Triết'	,	'556.2'	,'KHQL'),
                        ('Nguyễn Hữu Hải'	,	'72.2'	,'QTKD'),
                        ('Nguyễn Hoàng Nam'	,	'77.3'	,'NNKT');
 
 INSERT INTO `SinhVien` (		HotenSV		,Makhoa, Namsinh,	Quequan	 )
 VALUES					(	'Bùi Tuấn Anh'	,'CNTT',  1999	, 'Bắc Ninh' ),
						( 'Bùi Thị Hoa Mai'	,'CNTT',  1998	, 'Hải Dương'),
                        ( 'Nguyễn Tuấn Anh'	,'KKT' ,  2000	,  'Hà Nội'  ),
                        (	'Lê Thị Thu'	,'DLKS',  2002	,  'Hà Nội'  ),
                        ('Đào Lê Phương Mai','KHQL',  1999	,  'TP.HCM'  ),
                        ('Nguyễn Thị Phương','CNTT',  2000	, 'Bắc Ninh' ),
                        (	'Bùi Tuấn Anh'	,'DLKS',  1999	,  'Hà Nội'  ),
                        ('Nguyễn Hoàng Năng','QLTC',  2000	, 'Hải Dương'),
                        ('Nguyễn Thị Hoa'	,'QTKD',  1999	,  'TP.HCM'  ),
                        (  'Trần Hải Nam'	,'CNTT',  1999	,  'TP.HCM'  );

INSERT INTO	`DeTai` (  MaDT	,			   TenDT					,Kinhphi, NoiThucTap)
VALUES				( 'A01'	,   'HTTT quản lý các trường ĐH'		, 20000 ,'Bắc Ninh'	),
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
                      (	 7	, 'D05'	,	1 	,'8.5' ),
                      (	 8	, 'D05'	,	2 	,'0.0' ),
                      (	 9	, 'A02'	,	6 	, NULL ),
                      (	 10	, 'A01'	,	7 	, NULL );
/*--------------------------------------TRUY VẤN CSDL--------------------------------------*/
-- 2.	Đưa ra thông tin gồm mã số, họ tên và tên khoa của tất cả các giảng viên
SELECT GV.MaGV, GV.HotenGV, K.Tenkhoa
FROM `GiangVien` GV
JOIN `Khoa` K
USING (Makhoa);

-- 3.	Đưa ra thông tin gồm mã số, họ tên và tên khoa của các giảng viên của khoa ‘CNTT va QLTN’
SELECT 	GV.MaGV, GV.HotenGV, K.Tenkhoa
FROM 	`Giangvien`GV
JOIN 	`Khoa`K
USING	(Makhoa)
WHERE	GV.Makhoa IN ( 'CNTT' , 'QLTN'); 

-- 4.	Cho biết số sinh viên của khoa ‘Công Nghệ Thông Tin’
SELECT  Makhoa,COUNT(Makhoa) AS 'Số Lượng'
FROM	`SinhVien`
WHERE 	Makhoa = 'CNTT';

-- 5.	Đưa ra danh sách gồm mã số, họ tênvà tuổi của các sinh viên khoa ‘Kế Toán’
SELECT	 *
FROM	`SinhVien`
WHERE	Makhoa = 'KKT';

-- 6.	Cho biết số giảng viên của khoa ‘Quản trị kinh doanh’
SELECT 	Makhoa,COUNT(Makhoa) AS 'Số Lượng'
FROM	`GiangVien`
WHERE	Makhoa = 'QTKD';
-- 7.	Cho biết thông tin về sinh viên không tham gia thực tập
SELECT	*
FROM	`SinhVien`
WHERE	MaSV NOT IN (SELECT MaSV FROM `HuongDan`);
-- 8.	Đưa ra mã khoa, tên khoa và số giảng viên của mỗi khoa
SELECT 		K.Makhoa,K.Tenkhoa, COUNT(GV.Makhoa) AS'Số Lượng'
FROM		`Khoa` K
JOIN		`GiangVien` GV
USING		(Makhoa)
GROUP BY	GV.Makhoa;

-- 9.	Cho biết số điện thoại của khoa mà sinh viên có tên ‘Bùi Tuấn Anh’ đang theo học

SELECT 	K.Makhoa,K.Dienthoai
FROM	`SinhVien` SV
JOIN	`Khoa` K
USING	(Makhoa)
WHERE	SV.HotenSV = 'Bùi Tuấn Anh';
-- 10.	Cho biết mã số và tên của các đề tài do giảng viên ‘Hoàng Thị Thúy’ hướng dẫn
SELECT 	HD.*,GV.HotenGV
FROM	`HuongDan` HD
JOIN	`GiangVien` GV
USING	(MaGV)
WHERE 	GV.HotenGV = 'Hoàng Thị Thúy';
-- 11.	Cho biết tên đề tài không có sinh viên nào thực tập
SELECT	TenDT
FROM	`DeTai`
WHERE 	MaDT NOT IN ( SELECT MaDT FROM	`HuongDan`);
-- 12.	Cho biết mã số, họ tên, tên khoa của các giảng viên hướng dẫn từ 3 sinh viên trở lên.
SELECT 		GV.*,COUNT(HD.MaGV) 'Số lượng Sinh Viên'
FROM		`GiangVien` GV
JOIN		`HuongDan` HD
USING		(MaGV)
GROUP BY	HD.MaGV
HAVING		COUNT(HD.MaGV) > 3;

-- 13.	Cho biết mã số, tên đề tài của đề tài có kinh phí cao nhất

SELECT 		*
FROM		`Detai`
WHERE		Kinhphi = (SELECT MAX(Kinhphi) FROM	`Detai`);
-- 14.	Cho biết mã số và tên các đề tài có nhiều hơn 2 sinh viên tham gia thực tập

SELECT		DT.MaDT,DT.TenDT, COUNT(MaSV) AS 'Số Sinh Viên'
FROM		`HuongDan` HD
JOIN 		`DeTai` DT
USING 		(MaDT)
GROUP BY 	MaDT
HAVING		COUNT(MaSV) > 2;

-- 15.	Đưa ra mã số, họ tên và điểm của các sinh viên khoa ‘A02 và D05’
SELECT  SV.*,HD.Ketqua
FROM	`SinhVien` SV
JOIN	`HuongDan` HD
USING	(MaSV)
WHERE	HD.MaDT = 'A02' OR HD.MaDT = 'D05';


-- 16.	Đưa ra tên khoa, số lượng sinh viên của mỗi khoa

SELECT 	 	K.*, COUNT(SV.Makhoa) AS ' Số lượng SV'
FROM		`SinhVien` SV
JOIN		`Khoa` K
USING		(Makhoa)
GROUP BY	SV.Makhoa;
-- 17.	Cho biết thông tin về các sinh viên thực tập tại quê nhà

SELECT 	SV.*
FROM	`SinhVien` SV
JOIN	`HuongDan` HD
USING	(MaSV)
JOIN	`DeTai` DT
USING	(MaDT)
WHERE	SV.Quequan = DT.NoiThucTap;
-- 18.	Hãy cho biết thông tin về những sinh viên chưa có điểm thực tập

SELECT *
FROM 	`SinhVien` SV
JOIN	`HuongDan` HD
USING 	(MaSV)
WHERE	HD.Ketqua IS NULL;
-- 19.	Đưa ra danh sách gồm mã số, họ tên các sinh viên có điểm thực tập bằng 0

SELECT  SV.*
FROM	`SinhVien` SV
JOIN	`HuongDan` HD
USING 	(MaSV)
WHERE	HD.Ketqua = '0.0';
