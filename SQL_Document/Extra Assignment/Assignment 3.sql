DROP DATABASE IF EXISTS `Manager_Fresher`;
CREATE DATABASE `Manager_Fresher`;
USE `Fresher`;

INSERT INTO `Trainee` 	( 	  Full_Name	 	, 	Birth_Date,	Gender  ,ET_IQ	,ET_Gmath	,ET_English ,Training_Class ,Evaluation_Notes,		VTI_Account			    )
VALUES					( 'Bùi Tuấn Anh' 	, '1999-11-28', 'MALE'	, 18	,	15		,	42	 	,	'Rocket_16'	,  'Học tiếp'	 ,'tuananh.bui@lms.vti.edu.vn'  ),
						( 'Bùi Thị Hoa Mai' , '1998-01-05', 'FEMALE', 17	,	16		,	32	 	,	'Rocket_14'	,  'Học tiếp'	 ,'hoamai.bui@lms.vti.edu.vn'   ),
                        ( 'Lê Văn Hải' 		, '1998-10-07', 'MALE'	, 11	,	12		,	16	 	,   'Railway_11',  'Học lại'	 ,'vanhai.le@lms.vti.edu.vn'    ),
                        ( 'Trần Văn Kiên' 	, '1999-05-05', 'MALE'	, 17	,	16		,	44	 	,	'Rocket_16'	,  'Học tiếp'	 ,'vankien.tran@lms.vti.edu.vn' ),
                        ( 'Nguyễn Hữu Hải'  , '1995-07-12', 'MALE'  , 15	,	16		,	48	 	,	'Rocket_14' ,  'Học tiếp'	 ,'huuhai.nguyen@lms.vti.edu.vn'),
                        ( 'Nguyễn Thị Hương', '1999-07-15', 'FEMALE', 12	,	08		,	20	 	,	'Railway_16',  'Học lại'	 ,'huong.nguyen@lms.vti.edu.vn'	),
                        ( 'Nguyễn Hà Lê'  	, '2002-12-12', 'FEMALE', 10	,	12		,	38	 	,	'Railway_15',  'Học tiếp'	 ,'hale.nguyen@lms.vti.edu.vn'	),
                        ( 'Đào Đức Minh'  	, '2000-05-25','Unknown', 0		,	08		,	19	 	,	'Railway_15',  'Học tiếp'	 ,'ducminh.dao@lms.vti.edu.vn'	),
                        ( 'Trần Thị Hoa'  	, '1998-08-12', 'FEMALE', 15	,	16		,	38	 	,	'Rocket_15' ,  'Học tiếp'	 ,'hoa.tran@lms.vti.edu.vn'		),
                        ( 'Trần Hoàng Nam'  , '1996-07-22', 'MALE'  , 18	,	20		,	50	 	,	'Rocket_16' ,  'Học tiếp'	 ,'hoangnam.tran@lms.vti.edu.vn');
 SELECT * From trainee;

INSERT INTO `Data Types1` 	( `Name`	, `Code`	,ModifiedDate )
VALUES						('LonDon'	, 'VTI01'	, '2019-05-12'),
							('England'	, 'VTI02'	, '2020-12-12'),
                            ('Paris'	, 'VTI03'	, '2021-08-12'),
                            ('Berlin'	, 'VTI04'	, '2020-11-22'),
                            ('HaNoi'	, 'VTI05'	, '2020-07-09'),
                            ('TP.HCM'	, 'VTI06'	, '2020-01-14'),
                            ('ToKyo'	, 'VTI07'	, '2020-05-28'),
                            ('Osaka'	, 'VTI08'	, '2020-08-26'),
                            ('NewYork'	, 'VTI09'	, '2021-06-28'),
                            ('Berjin'	, 'VTI10'	, '2020-06-28');

-- SELECT * From `Data Types1`;

INSERT INTO `Data Types2` 	(	`Name`			, 	BirthDate	, Gender, IsDeletedFlag)
VALUES					  	('Bùi Tuấn Anh' 	, '1999-11-28'	, 	'0'	, 		'0' 	),
							('Bùi Thị Hoa Mai' 	, '1998-01-05'	, 	'1'	, 		'0'     ),
                            ('Lê Văn Hải' 		, '1998-10-07'	, 	'0'	, 		'0'     ),
                            ('Trần Văn Kiên' 	, '1999-05-05'	, 	'0'	, 		'0'     ),
                            ('Nguyễn Hữu Hải'  	, '1995-07-12'	, 	'0'	, 		'1'     ),
                            ('Nguyễn Thị Hương'	, '1999-07-15'	, 	'1'	, 		'0'     ),
                            ('Nguyễn Hà Lê'  	, '2002-12-12'	, 	'1'	, 		'0'     ),
                            ('Đào Đức Minh'  	, '2000-05-25'	, 	'0'	, 		'1'     ),
                            ('Trần Thị Hoa'  	, '1998-08-12'	, 	'1'	, 		'0'     ),
                            ('Trần Hoàng Nam'  	, '1996-07-22'	, 	'0'	, 		'1'     );
-- SELECT * From `Data Types2`;

-- Question 2: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào, 
-- nhóm chúng thành các tháng sinh khác nhau

SELECT 		*
FROM 		`Trainee`
GROUP BY 	month(Birth_Date)
HAVING 		ET_IQ > 0 AND ET_Gmath > 0 AND ET_English > 0;

-- Viết lệnh để lấy ra thực tập sinh có tên dài nhất, lấy ra các thông tin sau: 
-- tên, tuổi, các thông tin cơ bản (như đã được định nghĩa trong table)

SELECT 		*
FROM 		`Trainee`
WHERE 		character_length(Full_Name) = (SELECT MAX(character_length(Full_Name)) FROM `Trainee`);

-- Question 4: Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là 
-- những người đã vượt qua bài test đầu vào và thỏa mãn số điểm như sau:
--  ET_IQ + ET_Gmath>=20
--  ET_IQ>=8
--  ET_Gmath>=8
--  ET_English>=18

SELECT		* 
FROM 		`Trainee`
WHERE 		ET_IQ + ET_Gmath>=20 AND ET_IQ>=8  AND ET_Gmath>=8 AND  ET_English>=18;

-- Question 5: xóa thực tập sinh có TraineeID = 3
DELETE
FROM 		`Trainee`
WHERE 		TraineeID = 3;

-- Question 6: Thực tập sinh có TraineeID = 5 được chuyển sang lớp "'Rocket_16'". Hãy cập nhật 
-- thông tin vào database

UPDATE `Trainee`
SET 	Training_Class = 'Rocket_16'
WHERE	TraineeID = 5 ;