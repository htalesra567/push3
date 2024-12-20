package com.cdac.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Helper {
	Connection connection = null;
	PreparedStatement ps = null;
	Scanner sc = new Scanner(System.in);
	ResultSet rs = null;
	
	public Helper() {
	
	try {
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","cdac");
	System.out.println("Connection established");
	}
	catch(SQLException e) {
		e.getMessage();
	}
	
	
}
	
	public void RegisterUser() {
		
		System.out.println("enter the username");
		String username =sc.nextLine();
		System.out.println("enter password");
		String password = sc.nextLine();
		System.out.println("enter name");
		String name = sc.nextLine();
		System.out.println("enter email");
		String email = sc.nextLine();
		System.out.println("enter city");
		String city = sc.nextLine();
		
		try {
			ps = connection.prepareStatement("insert into users values(?,?,?,?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, email);
			ps.setString(5, city);
			

			ps.execute();
			
			System.out.println("user registered");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showUsersCity() {
		
		System.out.println("enter the city");
		String city = sc.nextLine();
		
		try {
			ps = connection.prepareStatement("select * from users where city = ?");
			ps.setString(1, city);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getString(1)+" ");
				System.out.print(rs.getString(2)+" ");
				System.out.print(rs.getString(3)+ " ");
				System.out.print(rs.getString(4)+ " ");
				System.out.println(rs.getString(5));
			}
			
			
		}
		catch(SQLException e) {
			e.getStackTrace();
		}
	}
	
	public void updatePassword() {
		System.out.println("enter username");
		String user = sc.nextLine();
		System.out.println("enter new password");
		String pass = sc.nextLine();
		
		
		try {
			ps= connection.prepareStatement("update users set password =? where username =?");
			ps.setString(1, pass);
			ps.setString(2, user);
			
			ps.execute();
			System.out.println("password changed");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void display() {
		System.out.println("enter the username");
		String user = sc.nextLine();
		
		try {
			ps = connection.prepareStatement("select * from users where username = ?");
			ps.setString(1, user);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getString(1)+" ");
				System.out.print(rs.getString(2)+" ");
				System.out.print(rs.getString(3)+ " ");
				System.out.print(rs.getString(4)+ " ");
				System.out.println(rs.getString(5));
			}
		}
		catch(SQLException e) {
			e.getStackTrace();
		}
	}
	
	
	}

