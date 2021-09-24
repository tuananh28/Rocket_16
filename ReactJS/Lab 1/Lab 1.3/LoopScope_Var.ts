import { CongNhan } from './CongNhan';
//  Thử tạo ra các worker bằng cách gán các giá trị từ biến khai báo với Var
// Tạo worker1:
// Khai báo ra các biến lưu thông tin worker dùng var, ở đây thấy cấu trúc của Var khai báo khá cởi mở, không yêu cầu về kểu dữ liệu

var name: string = "congnhan1";
var age: number = 18;
var gender: string = "Male";
var address: string = "Hà Nội";
var rank: number = 7;

var congnhan1 = new CongNhan(name, age, gender, address, rank);
console.log('Thông tin worker1');
congnhan1.printInforCongNhan();
// Sau khi in thông tin xong thực hiện khai báo lại biến worker1, dùng var nên không báo lỗi, khó quản lý cấu trúc chương trình.
console.log('\n---Thông tin Công nhân 1 Sau khi khai báo biến var lại 1 lần nữa---');
var congnhan1 = new CongNhan("cong_nhan1", 20, "FeMale", "HN", 10);
congnhan1.printInforCongNhan();
// Khai báo Worker2
var congnhan2 = new CongNhan("Worker2_Name2", 22, "Male", "HN", 9);
// Viết hàm để in thông tin các biến
console.log('\nIn thông tin thông qua khai báo thêm 1 hàm: ');
function printWorker_array(): void{
    var workerArray: CongNhan[]; //khai báo 1 mảng
    workerArray = [congnhan1, congnhan2];// Do worker1, worker2 khai báo var nên có phạm vi toàn cục, có thể gọi trong hàm được luôn
    workerArray.forEach(element => {
        console.log(element);
    });
    congnhan2 = new CongNhan("Worker2_Name2_Change", 22, "Male_Change", "HN_Change", 9);// khai báo lại worker2 trong hàm này. thay đổi giá trị
    var congnhan3 = new CongNhan("Worker3", 22, "Male", "HN", 9);// Worker4 khai báo bên trong hàm, nên chỉ có phạm vi bên trong hàm này. ra ngoài sẽ không gọi được, giống khi báo với let

}

// Gọi hàm vừa khai báo bên trên để sử dụng
printWorker_array();  // ở đây vẫn lấy ra được các giá trị worker1 và worker đã khai báo bên ngoài

// In lại thông tin worker để kiểm tra sau khi thay đổi trong hàm printWorker_array();
console.log('Thông tin Worker sau khi thay đổi trong hàm printWorker_array');
console.log(congnhan2);
// console.log(congnhan3);  Không gọi worker3 để dụng được

