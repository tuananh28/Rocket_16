class Department {
    // Khai báo các thuộc tính
    private id: number;

    private name: string;

    // Hàm tạo 2 tham số.
    constructor(id: number, name: string) {
        this.id = id;
        this.name = name;
    }
    // Nhóm hàm getter, setter
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

}
// Khai báo 1 function để in thông tin các phòng ban.
function printInforDepartment(department: Department): void {
    console.log("ID: " + department.getid() + " Department Name: " + department.getname());
}
// Export Department, printInforDepartment sang class khác sử dụng
export { Department, printInforDepartment }