package com.cdac.table1;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Helper helper = new Helper();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1. create table");
			System.out.println("2. display table");
			System.out.println("0. exit");
			int ch = scanner.nextInt();
			
			
			if(ch ==0 ) {
				break;
			}
			
			switch(ch) {
			
			case 1: 
					helper.CreateTable();
					break;
					
			case 2: 
					helper.display();
					break;
			default : 
					System.out.println("enter a valid option ");
			}
		}
	}

}
