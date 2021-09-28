var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
//hàm tạo Department
function callAPICreateDepartment() {
    return __awaiter(this, void 0, void 0, function* () {
        console.log("Step1: call API Create Department!");
        return "Create Department successfully!";
    });
}
//hàm tạo Position
function callAPICreatePosition() {
    return __awaiter(this, void 0, void 0, function* () {
        console.log("Step2: call API Create Position!");
        return "Create Position successfully!";
    });
}
//hàm tạo Account
function callAPICreateAccount() {
    return __awaiter(this, void 0, void 0, function* () {
        console.log("Step3: call API Create Account!");
        return "Create Account successfully!";
    });
}
// Viết hàm tổng hợp đẻ tạo mới 3 đối tượng.
// 1. Tạo Department
// 2. Tạo Position
// 3. Tạo Account.
// Bất cứ bước nào gặp lỗi sẽ dừng chương trình.
function create_NewObject() {
    return __awaiter(this, void 0, void 0, function* () {
        //call API Department
        let resultCreateDepartment = yield callAPICreateDepartment();
        console.log(resultCreateDepartment);
        //Call API Position
        let resultCreatePosition = yield callAPICreatePosition();
        console.log(resultCreatePosition);
        //call API Account
        let resultCreateAccount = yield callAPICreateAccount();
        console.log(resultCreateAccount);
    });
}
create_NewObject();
