export class CanBo {
    private name: string;
    private age: number;
    private gender: string;
    private address: string;

    constructor(name: string, age: number, gender: string, address: string) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public getname(): string {
        return this.name;
    }
    public setname(value: string) {
        this.name = value;
    }
    public getage(): number {
        return this.age;
    }
    public setage(value: number) {
        this.age = value;
    }
    public getgender(): string {
        return this.gender;
    }
    public setgender(value: string) {
        this.gender = value;
    }
    public getaddress(): string {
        return this.address;
    }
    public setaddress(value: string) {
        this.address = value;
    }
    public printInforCanBo() {
        console.log("Name : " + this.name
            + " Age : " + this.age
            + " Gender : " + this.gender
            + " Address : " + this.address);
    }
}