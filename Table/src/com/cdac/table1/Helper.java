//6e90175c9d454f5c8a4f3be4dbebed46

package com.cdac.table1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Helper {
		Scanner scanner = new Scanner(System.in);
		PreparedStatement ps =null;
		Statement s = null;
		ResultSet rs = null;
		String tname =null;
		Connection connection = null;
		List<String> list = new ArrayList<String>();
		public Helper() {
			try {
				 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","cdac");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void CreateTable() {
			System.out.println("enter table name");
			 tname = scanner.nextLine().trim();
			try {
				String sql = "CREATE TABLE " + tname + " (ano INT)";

				s = connection.createStatement();
				s.executeUpdate(sql);
				System.out.println("table created");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			while(true) {
				System.out.println("enter choice");
				System.out.println("1.add column");
				System.out.println("2.set primary key");
				System.out.println("3.save");
				int ch = scanner.nextInt();
				
				if(ch ==3) {
					break;
				}
				
				switch(ch) {
				
				case 1:
					System.out.println("enter column name");
					scanner.nextLine();
					String cname = scanner.nextLine().trim();
					System.out.println("enter datatype(VARCHAR, INT,FLOAT)");
					String type = scanner.nextLine().trim();
					try {
						String sql = "alter table " + tname + " add column "+ cname + " " +type+" not null";
						s = connection.createStatement();
						s.executeUpdate(sql);
						list.add(cname);
						System.out.println("column added successfully");
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				 case 2:
	                    if (list.size() == 0) {
	                        System.out.println("No columns present to set primary key.");
	                        break;
	                    }

	                    System.out.println("Select which column to set as primary key:");
	                    for (String column : list) {
	                        System.out.println(column);
	                    }
	                    scanner.nextLine();
	                    String cno = scanner.nextLine().trim();  
	                   
	                    if (list.contains(cno)) {
	                        try {
	                            String sql = "ALTER TABLE " + tname + " ADD PRIMARY KEY (" + cno + ")";
	                            s.executeUpdate(sql);
	                            System.out.println("Primary key set on column: " + cno);
	                        } catch (SQLException e) {
	                            e.printStackTrace();
	                        }
	                    } else {
	                        System.out.println("Invalid column name. Primary key not set.");
	                    }
	                    break;
					
				}
					
			}}	
		
		public void display() {
			System.out.println("enter table name");
			tname = scanner.nextLine().trim();
			String sqlString = "describe "+tname+"";
			
			try {
				s = connection.createStatement();
				rs = s.executeQuery(sqlString);
				
				while(rs.next()) {
				System.out.print(rs.getString("field"));
				System.out.print(rs.getString("type"));
				System.out.print(rs.getString("null"));
				System.out.print(rs.getString("key"));
				System.out.print(rs.getString("default"));
				System.out.print(rs.getString("extra"));
				System.out.println();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
