import { CanBo } from "./CanBo";

export class CongNhan extends CanBo {
    private rank: number;
    constructor(name: string, age: number, gender: string, address: string, rank: number) {
        super(name, age, gender, address);
        this.rank = rank;
    }

    public printInforCongNhan() {
        console.log("\nThông tin Công Nhân");
        super.printInforCanBo();
        console.log("Ranking: " + this.rank);
    }
}