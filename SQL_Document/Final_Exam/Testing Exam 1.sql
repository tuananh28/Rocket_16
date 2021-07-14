DROP DATABASE IF EXISTS Requirement_1;
CREATE DATABASE Requirement_1;
USE Requirement_1;

CREATE TABLE CUSTOMER(
    CustomerID TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Name`        VARCHAR(50),
    Phone       INT(10),
    Email       VARCHAR(50) UNIQUE KEY ,
    Address     VARCHAR(100),
    Note        VARCHAR(100)
);
DROP TABLE IF EXISTS CAR;
CREATE TABLE CAR(
    CarID       TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Maker       CHAR(20),
    Model       CHAR(20),
    `Year`      DATETIME DEFAULT NOW(),
    Color       VARCHAR(20),
    Note        VARCHAR(50)
);

CREATE TABLE CAR_ORDER(
    OrderID         TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    CustomerID      TINYINT UNSIGNED NOT NULL ,
    CarID           TINYINT UNSIGNED NOT NULL ,
    Amount          TINYINT DEFAULT 1,
    SalePrice       DECIMAL (7,3),
    OrderDate       DATETIME DEFAULT NOW(),
    DeliveryDate    DATETIME DEFAULT NOW(),
    DeliveryAddress VARCHAR(50),
    `Staus`           ENUM ('0','1','2') DEFAULT'0',-- 0: đã đặt hàng, 1: đã giao, 2: đã hủy
    Note            VARCHAR(50),
    CONSTRAINT kp_CustomerID FOREIGN KEY (CustomerID) REFERENCES `CUSTOMER`(CustomerID),
    CONSTRAINT kp_CarID FOREIGN KEY (CarID) REFERENCES `CAR`(CarID)
);

INSERT INTO `requirement_1`.`customer` (`Name`, `Phone`, `Email`, `Address`, `Note`) VALUES ('Bùi Tuấn Anh', '0989696569', 'qnah28@gmail.com', 'Bắc Ninh', 'VIP');
INSERT INTO `requirement_1`.`customer` (`Name`, `Phone`, `Email`, `Address`, `Note`) VALUES ('Bùi Thị Hoa Mai', '0988988565', 'hoamai@gmail.com', 'Hải Dương', 'VIP');
INSERT INTO `requirement_1`.`customer` (`Name`, `Phone`, `Email`, `Address`, `Note`) VALUES ('Đinh Thị Thủy', '0988565526', 'dinhthuy@gmail.com', 'Hà Nội', 'Member');
INSERT INTO `requirement_1`.`customer` (`Name`, `Phone`, `Email`, `Address`, `Note`) VALUES ('Nguyễn Hữu Tùng', '0988989898', 'huytung@gmail.com', 'Hà Nội', 'VIP');
INSERT INTO `requirement_1`.`customer` (`Name`, `Phone`, `Email`, `Address`, `Note`) VALUES ('Nguyễn Văn Linh', '0259895365', 'vanlinh@gmail.com', 'Hải Phòng', 'Member');
INSERT INTO `requirement_1`.`customer` (`Name`, `Phone`, `Email`, `Address`, `Note`) VALUES ('Nguyễn Thùy Linh', '0959895623', 'thuylinh@gmail.com', 'Quảng Ninh', 'Member');

INSERT INTO `requirement_1`.`car` (`Maker`, `Model`, `Year`, `Color`, `Note`) VALUES ('TOYOTA', 'T100', '2020-12-15', 'Red', 'New');
INSERT INTO `requirement_1`.`car` (`Maker`, `Model`, `Year`, `Color`, `Note`) VALUES ('TOYOTA', 'T200', '2021-05-06', 'Black', 'New');
INSERT INTO `requirement_1`.`car` (`Maker`, `Model`, `Year`, `Color`, `Note`) VALUES ('TOYOTA', 'T300', '2018-05-12', 'White', 'Old');
INSERT INTO `requirement_1`.`car` (`Maker`, `Model`, `Year`, `Color`, `Note`) VALUES ('VINFAST', 'V100', '2019-08-07', 'Black', 'Old');
INSERT INTO `requirement_1`.`car` (`Maker`, `Model`, `Year`, `Color`, `Note`) VALUES ('VINFAST', 'V200', '2015-05-16', 'White', 'New');
INSERT INTO `requirement_1`.`car` (`Maker`, `Model`, `Year`, `Color`, `Note`) VALUES ('VINFAST', 'V300', '2017-07-07', 'White', 'New');
INSERT INTO `requirement_1`.`car` (`Maker`, `Model`, `Year`, `Color`, `Note`) VALUES ('BMW', 'B100', '2020-1-2', 'Black', 'Old');
INSERT INTO `requirement_1`.`car` (`Maker`, `Model`, `Year`, `Color`, `Note`) VALUES ('BMW', 'B200', '2021-5-25', 'Red', 'New');
INSERT INTO `requirement_1`.`car` (`Maker`, `Model`, `Year`, `Color`, `Note`) VALUES ('BMW', 'B300', '2019-9-10', 'Black', 'Old');
INSERT INTO `requirement_1`.`car` (`Maker`, `Model`, `Year`, `Color`, `Note`) VALUES ('BMW', 'B400', '2018-6-2', 'White', 'New');

INSERT INTO `requirement_1`.`car_order` (`CustomerID`, `CarID`, `Amount`, `SalePrice`, `OrderDate`, `DeliveryDate`, `DeliveryAddress`, `Staus`, `Note`) VALUES ('1', '3', '3', '3500.00', '2021-05-09', '2021-07-07', 'Bắc Ninh', '1', 'Đã thanh toán');
INSERT INTO `requirement_1`.`car_order` (`CustomerID`, `CarID`, `Amount`, `SalePrice`, `OrderDate`, `DeliveryDate`, `DeliveryAddress`, `Staus`, `Note`) VALUES ('2', '6', '5', '4522.00', '2020-06-12', '2020-07-05', 'Hải Dương', '0', 'Còn nợ');
INSERT INTO `requirement_1`.`car_order` (`CustomerID`, `CarID`, `Amount`, `SalePrice`, `OrderDate`, `DeliveryDate`, `DeliveryAddress`, `Staus`, `Note`) VALUES ('3', '6', '1', '1500.00', '2021-04-05', '2021-05-05', 'Hà Nội', '1', 'Đã thanh toán');
INSERT INTO `requirement_1`.`car_order` (`CustomerID`, `CarID`, `Amount`, `SalePrice`, `OrderDate`, `DeliveryDate`, `DeliveryAddress`, `Staus`, `Note`) VALUES ('4', '8', '3', '3500.00', '2021-05-09', '2021-07-07', 'Hà Nội', '1', 'Đã thanh toán');
INSERT INTO `requirement_1`.`car_order` (`CustomerID`, `CarID`, `Amount`, `SalePrice`, `OrderDate`, `DeliveryDate`, `DeliveryAddress`, `Staus`, `Note`) VALUES ('1', '9', '2', '2500.00', '2020-01-06', '2020-01-28', 'Bắc Ninh', '0', 'Còn nợ');
INSERT INTO `requirement_1`.`car_order` (`CustomerID`, `CarID`, `Amount`, `SalePrice`, `OrderDate`, `DeliveryDate`, `DeliveryAddress`, `Staus`, `Note`) VALUES ('2', '7', '2', '2000.00', '2020-01-06', '2020-01-28', 'Hà Nội', '2', 'Hủy Hàng');

/* 2. Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã
mua và sắp sếp tăng dần theo số lượng oto đã mua. */

SELECT		C.Name, t.NumberCars
		FROM	    `CUSTOMER`	c
		JOIN		(
						-- SUBQUERY GET CUSTOMER ID bought AND number of cars
						SELECT		co.CustomerID ,SUM(co.Amount) AS NumberCars
						FROM		`CAR_ORDER`	co
						WHERE		co.Staus = '1'
						GROUP BY	co.CustomerID
						HAVING		SUM(co.Amount) > 0
					)	AS	t	ON c.CustomerID = t.CustomerID
		ORDER BY t.NumberCars ASC;
/* 3. Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều
oto nhất trong năm nay.*/

/* 4. Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của
những năm trước. In ra số lượng bản ghi đã bị xóa.*/
/* 5. Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn
hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto
và tên hãng sản xuất. */
/* 6. Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ
vào database (DeliveryDate < OrderDate + 15). */

