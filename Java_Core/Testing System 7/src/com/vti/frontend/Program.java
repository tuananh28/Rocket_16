package com.vti.frontend;

import com.vti.backend.Ex1_Static;
import com.vti.backend.Ex2_Final;
import com.vti.backend.Ex3_File;
import com.vti.backend.Ex4_IO_Stream;

public class Program {
	public static void main(String[] args) throws Exception {
		
		// Exercise 1
		Ex1_Static ex1 = new Ex1_Static();
		ex1.Question1();
		ex1.Question2();
		ex1.Question3();
		ex1.Question4();
		ex1.Question5();
		ex1.Quesiton6();
		ex1.Question7();
		ex1.Question8();
		
		// Exercise 2
		Ex2_Final ex2 = new Ex2_Final();
		ex2.Question1();
		ex2.Question2();
		ex2.Question3();
		
		// Exercise 3
		Ex3_File ex3 = new Ex3_File();
		ex3.AllQuestion();
		
		// Exercise 4
		Ex4_IO_Stream ex4 = new Ex4_IO_Stream();
		ex4.Question1();
		ex4.Question2();
		ex4.Question3();
		ex4.Question4();
	}
}
