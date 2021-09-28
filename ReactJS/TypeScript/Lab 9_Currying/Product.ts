export class Product {
    private name: string;
    private price: number;
  
    constructor(name: string, price: number) {
      this.name = name;
      this.price = price;
    }
    // Nhóm hàm getter và Setter
    public setname(v: string) {
      this.name = v;
    }
    public getname(): string {
      return this.name;
    }
  
    public setprice(v: number) {
      this.price = v;
    }
    public getprice(): number {
      return this.price;
    }
  }
  
  
  