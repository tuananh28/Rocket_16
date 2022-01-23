package frontend;

import backend.BadDog;
import backend.GoodDog;

public class Program {
	public static void main(String[] args) {
		GoodDog sparky = new GoodDog("Sparky", "Red");
		System.out.println(sparky.getName());
		System.out.println(sparky.getColor());
		sparky.swim();
		sparky.Climb();
//		sparky.info();
//		
//		sparky.change_info("Spartacus", 24, 45);
//		sparky.info();
		
		
		BadDog fiDog = new BadDog("Fido", 12);	
		System.out.println(fiDog.getName());
		System.out.println(fiDog.getAge());
		fiDog.swim();
	}
}
