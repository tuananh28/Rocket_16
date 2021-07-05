DROP DATABASE IF EXISTS	`QUAN_LY_GIAO_HANG`;
CREATE	DATABASE `QUAN_LY_GIAO_HANG`;
USE	`QUAN_LY_GIAO_HANG`;

/*-----------------------------------------------------Table-----------------------------------------*/
CREATE TABLE `LOAIMATHANG`(
	MaLoaiMatHang				CHAR(10) PRIMARY KEY NOT NULL,
    TenLoaiMatHang				VARCHAR(30) NOT NULL
);

CREATE TABLE `DICHVU`(
	MaDichVu CHAR(10) PRIMARY KEY NOT NULL,
    TenDichVu VARCHAR(50) NOT NULL
);
CREATE TABLE `KHUVUC`(
	MaKhuVuc					CHAR(10) PRIMARY KEY NOT NULL,
    TenKhuVuc					VARCHAR(30) NOT NULL	
);

CREATE TABLE `KHOANGTHOIGIAN`(
	MaKhoangThoiGian			CHAR(10) PRIMARY KEY NOT NULL,
    MoTa						VARCHAR(100)
);

CREATE TABLE `KHACHHANG`(
	MaKhachHang 				CHAR(10) PRIMARY KEY NOT NULL,
    MaKhuVuc					CHAR(10) NOT NULL,
    TenKhachHang				VARCHAR(30) NOT NULL,
    TenCuaHang					VARCHAR(30) NOT NULL,
    SDTKhachHang				INT(11) NOT NULL,
    DiaChiEmail					VARCHAR(50) NOT NULL UNIQUE KEY,
    DiaChiNhanHang				VARCHAR(30) NOT NULL,
    CONSTRAINT	KP_MaKhuVuc FOREIGN KEY (MaKhuVuc) REFERENCES `KHUVUC` (MaKhuVuc)
);


CREATE TABLE `THANHVIENGIAOHANG`(
	MaThanhVienGiaoHang 		CHAR(10) PRIMARY KEY NOT NULL,
    TenThanhVienGiaoHang		VARCHAR(30) NOT NULL,
    NgaySinh 					DATETIME DEFAULT NOW(),
    GioiTinh					VARCHAR(6),
    SDTThanhVien				INT(11) NOT NULL,
    DiaChiThanhVien				VARCHAR(50) NOT NULL
);

CREATE TABLE `DANGKYGIAOHANG`(
	MaThanhVienGiaoHang 		CHAR(10) NOT NULL,
    MaKhoangThoiGianDKGiaoHang 	CHAR(10) NOT NULL,
    PRIMARY KEY	(MaThanhVienGiaoHang,MaKhoangThoiGianDKGiaoHang),
    CONSTRAINT KP_MaKhoangThoiGianDKGiaoHang FOREIGN KEY (MaKhoangThoiGianDKGiaoHang) REFERENCES `KHOANGTHOIGIAN` (MaKhoangThoiGian),
	 CONSTRAINT PK_MaThanhVienGiaoHang FOREIGN KEY (MaThanhVienGiaoHang) REFERENCES `THANHVIENGIAOHANG` (MaThanhVienGiaoHang)
);

CREATE TABLE `DONHANG_GIAOHANG`(
	MaDonHangGiaoHang 			CHAR(10) NOT NULL PRIMARY KEY,
    MaKhachHang					CHAR(10) NOT NULL,
    MaThanhVienGiaoHang			CHAR(10) NOT NULL,
    MaDichVu 					CHAR(10) NOT NULL,
    MaKhuVucGiaoHang 			CHAR(10) NOT NULL,
    TenNguoiNhan			 	VARCHAR(30) NOT NULL,
    DiaChiGiaoHang				VARCHAR(100) NOT NULL,
    SDTNguoiNhan 				INT(11) NOT NULL,
    MaKhoangThoiGianGiaoHang	CHAR(10) NOT NULL,
    NgayGiaoHang				DATETIME DEFAULT NOW(),
    PhuongThucThanhToan			VARCHAR(30) NOT NULL,
    TrangThaiPheDuyet			VARCHAR(30) NOT NULL,
    TrangThaiGiaoHang			VARCHAR(30),
	CONSTRAINT KP_MaKhachHang FOREIGN KEY (MaKhachHang) REFERENCES `KHACHHANG` (MaKhachHang),
    CONSTRAINT KP_MaThanhVienGiaoHang FOREIGN KEY (MaThanhVienGiaoHang) REFERENCES `THANHVIENGIAOHANG` (MaThanhVienGiaoHang),
    CONSTRAINT KP_MaDichVu FOREIGN KEY (MaDichVu) REFERENCES `DICHVU` (MaDichVu),
    CONSTRAINT KP_MaKhuVucGiaoHang FOREIGN KEY (MaKhuVucGiaoHang) REFERENCES `KHUVUC` (MaKhuVuc),
    CONSTRAINT KP_MaKhoangThoiGianGiaoHang FOREIGN KEY (MaKhoangThoiGianGiaoHang) REFERENCES `KHOANGTHOIGIAN` (MaKhoangThoiGian)
);

CREATE TABLE `CHITIET_DONHANG`(
	MaDonHangGiaoHang			CHAR(10) PRIMARY KEY NOT NULL ,
    TenSanPhamDuocGiao			VARCHAR(30) NOT NULL,
    SoLuong						TINYINT UNSIGNED NOT NULL,
    TrongLuong					DECIMAL(5,2) NOT NULL,
    MaLoaiMatHang				CHAR(10) NOT NULL,
    TienThuHo					DECIMAL(8,3) NOT NULL,
	CONSTRAINT	KP_MaDonHangGiaoHang FOREIGN KEY (MaDonHangGiaoHang) REFERENCES `DONHANG_GIAOHANG` (MaDonHangGiaoHang),
    CONSTRAINT	KP_MaLoaiMatHang FOREIGN KEY (MaLoaiMatHang) REFERENCES `LOAIMATHANG` (MaLoaiMatHang)
);
/*------------------------------------------------ CSDL ---------------------------------------------------------------------------*/
INSERT INTO `LOAIMATHANG` 	(MaLoaiMatHang,  TenLoaiMatHang		)
VALUES						(   'MH001'	  ,    'Quần Áo'   		),
							(	'MH002'	  ,	 'Túi Xách'	 		),
                            (	'MH003'	  ,	 'Giày Dép'	 		),
                            (	'MH004'	  ,	 'Mỹ Phẩm'	 		),
                            (	'MH005'	  ,	'Đồ Gia Dụng'		),
                            (	'MH006'	  ,	'Đồ Điện Tử' 		),
                            (	'MH007'	  ,'Thể thao & Du Lịch'	),
                            (	'MH008'	  ,	 'Thú Cưng'	 		),
                            (	'MH009'	  ,	 'Đồ chơi'	 		);

INSERT INTO	`DICHVU` ( MaDichVu , 				TenDichVu 				)
VALUES				 ( 'DV001'  , 'Giao Hàng Người Nhận Trả Phí' 		),
					 ( 'DV002'  , 'Giao Hàng Người Gửi Trả Phí' 		),
					 ( 'DV003'  , 'Giao Hàng Công Ích ( Không Tính Phí' );

INSERT INTO `KHUVUC` ( MaKhuVuc ,  	TenKhuVuc  		)
VALUES				 ( 'KV001'	,	'Khương Trung'	),
					 ( 'KV002'	,	 'Bạch Mai'		),
					 ( 'KV003'	,	 'Minh Khai'	),
					 ( 'KV004'	,	  'Đại Mỗ'		),
					 ( 'KV005'	,	  'Từ Sơn'		),
                     ( 'KV006'	,	  'Lục Ngạn'	),
                     ( 'KV007'	,	  'Tiên Du'		),
                     ( 'KV008'	,	  'Cầu Giấy'	),
                     ( 'KV009'	,	  'Long Biên'	),
                     ( 'KV010'	,	  'Hoàng Mai'	);
					
INSERT INTO `KHOANGTHOIGIAN` ( 		MaKhoangThoiGian 	, 		MoTa  	 )
VALUES						 (			'TG001'			, '7h - 9h Sáng' ),
							 (			'TG002'			, '9h - 11h Sáng'),
							 (			'TG003'			, '1h - 3h Chiều'),
							 (			'TG004'			, '3h - 5h Chiều'),
							 (			'TG005'			, '7h - 9h30 Tối');

INSERT INTO `THANHVIENGIAOHANG` ( MaThanhVienGiaoHang , TenThanhVienGiaoHang ,   NgaySinh 	, GioiTinh , SDTThanhVien , DiaChiThanhVien )
VALUES							(		'TV001'		  ,  'Nguyễn Ngọc Mai'   , '1999-11-28' ,   'Nữ'   , '0927345678' ,  'Bắc Giang'	),	
								(		'TV002'		  ,  'Lê Thị Phi Yến'    , '1998-01-05' ,   'Nữ'   , '0987567390' ,  'Bắc Ninh'		),	
                                (		'TV003'		  ,  'Trần Hữu Hải'		 , '2000-10-05' ,   'Nam'  , '0997047382' ,  'Hà Nội'		),	
                                (		'TV004'		  ,  'Cao Ngọc Thắng'    , '2001-05-05' ,   'Nam'  , '0913758498' ,  'Cao Bằng'		),	
                                (		'TV005'		  ,  'Nguyễn Thị Minh'   , '1996-12-26' ,   'Nữ'   , '0918590387' ,  'Hà Nội'		),	
                                (		'TV006'		  ,  'Trần Tiến Dũng'    , '1999-06-28' ,   'Nam'  , '0938776266' ,  'Bắc Giang'	);

INSERT INTO `DANGKYGIAOHANG` ( MaThanhVienGiaoHang , MaKhoangThoiGianDKGiaoHang )
VALUES						 (		'TV005'        , 			'TG001'			), 
							 (		'TV001'        , 			'TG005'			),
							 (		'TV005'        , 			'TG002'			),
							 (		'TV005'        , 			'TG003'			),
							 (		'TV002'        , 			'TG004'			);         			
                                 		
INSERT INTO	`KHACHHANG` (MaKhachHang, MaKhuVuc ,   TenKhachHang	   ,	 TenCuaHang			, SDTKhachHang ,		DiaChiEmail		, DiaChiNhanHang )
VALUES					( 'KH001'	, 'KV001'  , 'Bùi Tuấn Anh'    , 'Đồ chơi Công Nghệ'	, '0946912345' , 'tuananhbui@gmail.com' ,    'Hà Nội' 	 ),
						( 'KH002'	, 'KV009'  , 'Bùi Thị Hoa Mai' , 	 'Shop Baby'	 	, '0956985643' , 'hoamaibui@gmail.com'  ,    'Hà Nội' 	 ),
                        ( 'KH003'	, 'KV005'  , 'Nguyễn Huy Hoàng', 	 'Shop Olo'	 		, '0258987569' , 'huyhoang@gmail.com'  	,    'Bắc Ninh'  ),
                        ( 'KH004'	, 'KV009'  , 	'Lê Thị Hoa'   , 'Cửa hàng Tạp Hóa'	 	, '0458695263' , 'lehoai@gmail.com'  	,    'Hà Nội' 	 ),
                        ( 'KH005'	, 'KV007'  , 'Nguyễn Hoài Nam' , 'Đồ Điện Hoài Nam'	 	, '0898989895' , 'hoainam@gmail.com'  	,    'Bắc Ninh'  ),
                        ( 'KH006'	, 'KV009'  , 	'Trần Hà Lê'   , 'Thời trang Công Sở'	, '0256894565' , 'hale@gmail.com'  		,    'Hà Nội' 	 ),
                        ( 'KH007'	, 'KV004'  , 'Lê Văn Hải' 	   , 'Phụ Kiện Điện Thoại'	, '0258989563' , 'lehai@gmail.com'  	,    'Bắc Ninh'  ),
                        ( 'KH008'	, 'KV009'  , 'Nguyễn Văn Bình' , 'Thức Ăn Chó Mèo'	 	, '0989652563' , 'nguyenbinh@gmail.com' ,    'Hà Nội' 	 ),
                        ( 'KH009'	, 'KV008'  , 'Phạm Đức Bình'   ,'Cửa Hàng Điện Thoại'	, '0178993563' , 'phambinh@gmail.com'  	,    'Hà Nội' 	 ),
                        ( 'KH010'	, 'KV010'  , 'Bùi Tuấn Anh'   , 'Cửa Hàng Đồ Chơi'	 	, '0789223656' , 'anhthu@gmail.com'  	,    'Hà Nội' 	 );
                                
INSERT INTO	`DONHANG_GIAOHANG`	(MaDonHangGiaoHang	, MaKhachHang , MaThanhVienGiaoHang , MaDichVu , MaKhuVucGiaoHang , 	 TenNguoiNhan	, DiaChiGiaoHang, SDTNguoiNhan , MaKhoangThoiGianGiaoHang , NgayGiaoHang , PhuongThucThanhToan , TrangThaiPheDuyet , 	  TrangThaiGiaoHang )
VALUES					 		(		'DH001'		,	 'KH005'  ,	     'TV005'		, 'DV002'  ,     'KV001'		  , 'Bùi Tuấn Anh'     	, 'Hà Nội'	, '0946912345' ,			'TG005'		  , '2021-06-28' , 		'Tiền Mặt'	   ,	'Đã phê duyệt'	  ,	'Giao Hàng Thành Công'	),
								(		'DH002'		,	 'KH001'  ,	     'TV002'		, 'DV002'  ,     'KV002'		  , 'Bùi Thị Hoa Mai'  	, 'Hà Nội'	, '0956985643' ,			'TG001'		  , '2021-06-21' , 		'Banking'	   ,	'Đã phê duyệt'	  ,		'Đang Soạn Hàng'	),
								(		'DH003'		,	 'KH005'  ,	     'TV002'		, 'DV002'  ,     'KV003'		  , 'Nguyễn Huy Hoàng' 	, 'Hà Nội'	, '0258987569' ,			'TG002'	      , '2021-06-22' , 		'Ví Momo'	   ,	'Chưa phê duyệt'  ,				NUll		),
								(		'DH004'		,	 'KH002'  ,	     'TV005'		, 'DV001'  ,     'KV001'		  , 'Bùi Tuấn Anh'   	, 'Hà Nội'	, '0898989895' ,			'TG005'		  , '2021-06-24' , 		'Tiền Mặt'	   ,	'Đã phê duyệt'	  ,	'Giao Hàng Thành Công'	),
								(		'DH005'		,	 'KH001'  ,	     'TV005'		, 'DV001'  ,     'KV002'		  , 'Nguyễn Hoài Nam'  	, 'Hà Nội'	, '0256894565' ,			'TG003'		  , '2021-06-25' , 		'Tiền Mặt'	   ,	'Đã phê duyệt'	  ,		'Đang Soạn Hàng'	),
								(		'DH006'		,	 'KH003'  ,	     'TV001'		, 'DV001'  ,     'KV005'		  , 'Trần Hà Lê'    	, 'Hà Nội'	, '0258989563' ,			'TG002'		  , '2021-06-26' , 		'Banking'	   ,	'Đã phê duyệt'	  ,	'Giao Hàng Thành Công'	),
								(		'DH007'		,	 'KH010'  ,	     'TV002'		, 'DV003'  ,     'KV007'		  , 'Lê Văn Hải' 	    , 'Hà Nội'	, '0946912345' ,			'TG005'		  , '2021-06-27' , 		'Banking'	   ,	'Chưa phê duyệt'  ,				NULL		),
								(		'DH008'		,	 'KH008'  ,	     'TV005'		, 'DV002'  ,     'KV001'		  , 'Bùi Tuấn Anh'  	, 'Hà Nội'	, '0178993563' ,			'TG005'		  , '2020-06-29' , 		'Tiền Mặt'	   ,	'Đã phê duyệt'	  ,	'Giao Hàng Thất Bại'	),
								(		'DH009'		,	 'KH005'  ,	     'TV001'		, 'DV001'  ,     'KV002'		  , 'Phạm Đức Bình'    	, 'Hà Nội'	, '0789223656' ,			'TG002'		  ,	'2020-06-23' , 		'Tiền Mặt'	   ,	'Đã phê duyệt'	  ,	'Giao Hàng Thất Bại'	);
                                                  				
INSERT INTO	`CHITIET_DONHANG` ( MaDonHangGiaoHang , TenSanPhamDuocGiao , SoLuong , TrongLuong ,  MaLoaiMatHang 	, 	TienThuHo )
VALUES						  ( 	'DH001'		  ,	 'Thú Nhồi Bông'   , 	3    ,   	 8.2  ,		'MH008'		,	200.000   ),
							  ( 	'DH002'		  ,	 'Thú Nhồi Bông'   , 	2    ,	 	 6.5  ,		'MH008'		,	200.000   ),
                              ( 	'DH003'		  ,	 'Sạc Điện Thoại'  , 	1    ,	  	0.25  ,		'MH006'		,	250.000   ),
                              ( 	'DH004'		  ,	 	'Tai Nghe'     , 	1    ,	  	0.5  ,		'MH006'		,	1750.000  ),
                              ( 	'DH005'		  ,	 	'Áo Sơmi'	   , 	2    ,	  	1.75  ,		'MH001'		,	500.000   ),
                              ( 	'DH006'		  ,	 'Sạc Điện Thoại'  , 	2    ,	  	0.5  ,		'MH006'		,	500.000   ),
                              ( 	'DH007'		  ,	 	'Đèn ngủ'  	   , 	1    ,	  	0.25  ,		'MH005'		,	1250.000  ),
                              ( 	'DH008'		  ,	 'Chăn Lông Cừu'   , 	1    ,	  	3.2  ,		'MH005'		,	820.000   ),
                              ( 	'DH009'		  ,	 'Sạc Điện Thoại'  , 	1    ,	  	0.25  ,		'MH006'		,	250.000   );
								
/*---------------------------------------------------------TRUY VẤN CSDL---------------------------------------------------------*/
-- Câu 1: Xóa những khách hàng có tên là “Phạm Đức Bình”.
DELETE
FROM	`KHACHHANG`
WHERE	TenKhachHang = 'Phạm Đức Bình';
-- Câu 2: Cập nhật những khách hàng đang thường trú ở khu vực “Đại Mỗ” thành khu vực “Minh Khai”.
UPDATE	`KHACHHANG`
SET		MaKhuVuc = 'KV005'
WHERE	MaKhuVuc = 'KV004';
/* Câu 3: Liệt kê những thành viên (shipper) có họ tên bắt đầu là ký tự ‘Tr’ và có độ dài ít nhất là
25 ký tự (kể cả ký tự trắng).*/
SELECT  	TenThanhVienGiaoHang
FROM		`THANHVIENGIAOHANG`
WHERE		TenThanhVienGiaoHang LIKE "Tr%" and character_length(TenThanhVienGiaoHang) > 10; 
-- Câu 4: Liệt kê những đơn hàng có NgayGiaoHang nằm trong năm 2020 và có khu vực giao hàng là “Khương Trung”
SELECT 		*
FROM 		`DONHANG_GIAOHANG` GH 
JOIN 		`KHUVUC` KV
ON 			GH.MaKhuVucGiaoHang = KV.MaKhuVuc
GROUP BY	YEAR(2020)
HAVING  	KV.TenKhuVuc = 'Khương Trung';
/*Câu 5: Liệt kê MaDonHangGiaoHang, MaThanhVienGiaoHang, TenThanhVienGiaoHang,
NgayGiaoHang, PhuongThucThanhToan của tất cả những đơn hàng có trạng thái là “Da giao
hang”. Kết quả hiển thị được sắp xếp tăng dần theo NgayGiaoHang và giảm dần theo
PhuongThucThanhToan*/

SELECT 		MaDonHangGiaoHang,MaThanhVienGiaoHang,TV.TenThanhVienGiaoHang,NgayGiaoHang,PhuongThucThanhToan
FROM		`DONHANG_GIAOHANG` DH
JOIN		`THANHVIENGIAOHANG` TV
USING		(MaThanhVienGiaoHang)
WHERE		TrangThaiGiaoHang = 'Giao Hàng Thành Công'
ORDER BY	NgayGiaoHang ASC , PhuongThucThanhToan DESC;
-- Câu 6: Liệt kê những thành viên có giới tính là “Nam” và chưa từng được giao hàng lần nào.

SELECT	TenThanhVienGiaoHang, GioiTinh
FROM	`THANHVIENGIAOHANG`
WHERE	GioiTinh = 'Nam' AND MaThanhVienGiaoHang NOT IN (SELECT MaThanhVienGiaoHang FROM `DONHANG_GIAOHANG`);
/*Câu 7: Liệt kê họ tên của những khách hàng đang có trong hệ thống. Nếu họ tên trùng nhau
thì chỉ hiển thị 1 lần. Học viên cần thực hiện yêu cầu này bằng 2 cách khác nhau (mỗi cách
được tính 0.5 điểm)*/
-- Cách 1 :
SELECT 	DISTINCT(TenKhachHang)
FROM	`KHACHHANG`;

-- Cách 2 :

SELECT 		TenKhachHang
FROM 		`KHACHHANG` 
GROUP BY 	TenKhachHang;
/*Câu 8: Liệt kê MaKhachHang, TenKhachHang, DiaChiNhanHang, MaDonHangGiaoHang,
PhuongThucThanhToan, TrangThaiGiaoHang của tất cả các khách hàng đang có trong hệ
thống*/
SELECT 	DH.MaKhachHang,KH.TenKhachHang,KH.DiaChiNhanHang,DH.MaDonHangGiaoHang,DH.PhuongThucThanhToan,DH.TrangThaiGiaoHang
FROM	`DONHANG_GIAOHANG` DH
JOIN	`KHACHHANG` KH
USING	(MaKhachHang)
WHERE	DH.MaKhachHang IN ( SELECT MaKhachHang FROM `KHACHHANG`);
/*Câu 9: Liệt kê những thành viên giao hàng có giới tính là “Nữ” và từng giao hàng cho ít nhất 2
khách hàng khác nhau ở khu vực giao hàng là “Khương Trung”*/
SELECT 		MaThanhVienGiaoHang, TenThanhVienGiaoHang
FROM 		`THANHVIENGIAOHANG`
WHERE 		GioiTinh = 'Nữ' AND MaThanhVienGiaoHang IN (SELECT 		GH.MaThanhVienGiaoHang
														FROM 		`DONHANG_GIAOHANG` GH 
														JOIN 		`KHUVUC` KV
														ON 			KV.MaKhuVuc = GH.MaKhuVucGiaoHang
														WHERE 		KV.TenKhuVuc = 'Khương Trung'
														GROUP BY 	GH.MaThanhVienGiaoHang
														HAVING 		COUNT(DISTINCT GH.MaKhachHang) > 1);
/*Câu 10: Liệt kê những khách hàng đã từng yêu cầu giao hàng tại khu vực “Khương Trung” và
chưa từng được một thành viên giao hàng nào có giới tính là “Nam” nhận giao hàng*/
SELECT 	KH.MaKhachHang,KH.TenKhachHang
FROM 	`KHACHHANG` KH
JOIN	`DONHANG_GIAOHANG` DH USING	(MaKhachHang)
JOIN	`THANHVIENGIAOHANG` TV USING (MaThanhVienGiaoHang)
JOIN	`KHUVUC` KV USING (MaKhuVuc)
WHERE 	KV.TenKhuVuc ='Khương Trung' AND NOT TV.GioiTinh = 'Nam';
                                              		