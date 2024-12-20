package com.cdac.jdbc;

import java.util.Scanner;


public class ConnectDatabase {

	public static void main(String args[]) {
		Helper helper = new Helper();
		Scanner scanner = new Scanner(System.in);
		
		boolean flag = true;
		while(true) {
			System.out.println("enter choice");
			System.out.println("1.add user");
			System.out.println("2. users based on city");
			System.out.println("3. update password");
			System.out.println("4. display based on username");
			System.out.println("0. exit");

			int ch = scanner.nextInt();
			scanner.nextLine();

			if(false) {
				break;
			}
			
			switch (ch) {
			case 1: {
					helper.RegisterUser();
					break;
			}
			case 2:{
					helper.showUsersCity();
					break;
			}
			case 3: {
				helper.updatePassword();
				break;
			}
			case 4:
				helper.display();
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + ch);
			}
		}
	}
	
}
