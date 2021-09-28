import { Department } from "./Department";
import { Possition } from "./Position";

class Account {
    // Khai báo các thuộc tính.
    private id: number;
    private email: string;
    private username: string;
    private fullname: string;
    private department: Department;
    private position: Possition;
    private createDate: Date;
    // Hàm tạo full tham số cho Account
    constructor(id: number, email: string, username: string, fullname: string, department: Department, position: Possition, createDate: Date) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.fullname = fullname;
        this.department = department;
        this.position = position;
        this.createDate = createDate;

    }
    // Nhóm hàm getter và Setter
    public setid(v: number) {
        this.id = v;
    }
    public getid(): number {
        return this.id;
    }

    public setemail(v: string) {
        this.email = v;
    }
    public getemail(): string {
        return this.email;
    }

    public setusername(v: string) {
        this.username = v;
    }
    public getusername(): string {
        return this.username;
    }

    public setfullname(v: string) {
        this.fullname = v;
    }
    public getfullname(): string {
        return this.fullname;
    }

    public setdepartment(v: Department) {
        this.department = v;
    }
    public getdepartment(): Department {
        return this.department;
    }

    public setposition(v: Possition) {
        this.position = v;
    }
    public getposition(): Possition {
        return this.position;
    }

    public setcreateDate(v: Date) {
        this.createDate = v;
    }
    public getcreateDate(): Date {
        return this.createDate;
    }

}
// Hàm in thông tin Account, viết bên ngoài class
function printInforAccount(account: Account) {
    console.log("ID: " + account.getid() + " UserName: " + account.getusername() + " Fullname: " + account.getfullname() + " Department: " + account.getdepartment().getname() + " Position: " + account.getposition().getname());
}
// Export Account và hàm printInforAccount sang class khác để sử dụng.
export { Account, printInforAccount }