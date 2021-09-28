class Possition {
    // Khai báo các thuộc tính.
    private id: number;
 
    private name: string;
    // Nhóm hàm getter setter
    public getname(): string {
        return this.name;
    }
    public setname(v: string) {
        this.name = v;
    }
 
    public getid(): number {
        return this.id;
    }
    public setid(v: number) {
        this.id = v;
    }
    // Hàm contructor
    constructor(id: number, name: string) {
        this.id = id;
        this.name = name;
    }
}
// Hàm in thông tin Position, viết bên ngoài class
function printInforPosition(position: Possition): void {
    console.log("ID: " + position.getid() + " Position Name: " + position.getname());
}
 
// Export Possition, printInforPosition sang class khác để sử dụng
export { Possition, printInforPosition }
