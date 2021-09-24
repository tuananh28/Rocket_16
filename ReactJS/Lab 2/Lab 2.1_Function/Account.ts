class Account {
    // Khai báo các thuộc tính.
    private name: string;
    private age: number;
    private gender: string;
    private address: string;

    // Hàm tạo full tham số cho Account
    constructor(name: string, age: number, gender: string, address: string) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }
    // Nhóm hàm getter và Setter
    public setname(v: string) {
        this.name = v;
    }
    public getname(): string {
        return this.name;
    }

    public setage(v: number) {
        this.age = v;
    }
    public getage(): number {
        return this.age;
    }

    public setgender(v: string) {
        this.gender = v;
    }
    public getgender(): string {
        return this.gender;
    }

    public setaddress(v: string) {
        this.address = v;
    }
    public getaddress(): string {
        return this.address;
    }

}

// Viết hàm để in thông tin nhân viên:
// Cách 1: Normal
function printInforStaff(account: Account): void {
    console.log("Name: " + account.getname() + " Age: " + account.getage() + " Gender: " + account.getgender() + " Address: " + account.getaddress());

}
// Cách 2:
let print_Account = function printInforStaff_Other(account: Account): void {
    console.log("Name: " + account.getname() + " Age: " + account.getage() + " Gender: " + account.getgender() + " Address: " + account.getaddress());
}

// Cách 3: arrow Function
let print_account_Arror_function = (account: Account) => {
    console.log("Name: " + account.getname() + " Age: " + account.getage() + " Gender: " + account.getgender() + " Address: " + account.getaddress());

}
// Cách 4: Viêt Arrow dưới dạng ngắn gọn hơn, bỏ ngoặc () trong khai báo biến đầu vào, bỏ {} trong đoạn return
let print_account_Arror_function_1 = account => console.log("Name: " + account.getname() + " Age: " + account.getage() + " Gender: " + account.getgender() + " Address: " + account.getaddress());

// Export sang class khác để sử dụng.
export { Account, printInforStaff, print_Account, print_account_Arror_function }
