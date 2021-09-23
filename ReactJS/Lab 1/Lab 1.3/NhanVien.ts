import { CanBo } from "./CanBo";

export class NhanVien extends CanBo {
    private task: string;
    constructor(name: string, age: number, gender: string, address: string, task: string) {
        super(name, age, gender, address);
        this.task = task;
    }
    public printInforNhanVien() {
        console.log("Thông tin nhân viên");
        super.printInforCanBo();
        console.log("task : " + this.task);
    }
}