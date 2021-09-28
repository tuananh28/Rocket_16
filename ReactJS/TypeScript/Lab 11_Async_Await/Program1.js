var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
function callAPI() {
    return __awaiter(this, void 0, void 0, function* () {
        console.log("Thực hiện call API từ server");
        return "Call API Success";
    });
}
function callAPICreateAccount() {
    return __awaiter(this, void 0, void 0, function* () {
        console.log("STEP1: Thực hiện đoạn lệnh trước khi gọi API!");
        //Thực hiện call API, thêm await để xử lý bất đồng bộ.  
        let result = yield callAPI();
        console.log("STEP2: Thực hiện Call API và trả về kết quả: ", result);
        // Đoạn lệnh phía dưới sẽ thực thi sau khi hoàn thành chạy API.
        console.log("STEP3: Thực hiện đoạn lệnh sau khi gọi API!");
    });
}
// Demo Kết quả
callAPICreateAccount();
