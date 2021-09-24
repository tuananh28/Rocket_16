import { CanBo } from "./CanBo";

export class KySu extends CanBo {
    private specialized: string;
    constructor(name: string, age: number, gender: string, address: string, specialized: string) {
        super(name, age, gender, address);
        this.specialized = specialized;
    }
    public printInforKysu() {
        console.log("Thông tin Kỹ Sư");
        super.printInforCanBo();
        console.log("Specialized: " + this.specialized);
    }
}