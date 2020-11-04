package org.btm.App;
import java.sql.*;
import java.util.Scanner;
public class Demoooo {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pt=null;
		PreparedStatement pt1=null;
		PreparedStatement pt2=null;
		String isql="insert into gru.students values(6,'vijay',40.09,12345)";
		String usql="update gru.students set name='zahid'where id=1";
		String dsql="delete from gru.students where id=2";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("connection stablished");
			pt=con.prepareStatement(isql);
			pt.addBatch();
			int arr[]=pt.executeBatch();
			for (int i : arr) {
				System.out.println(i);
			}
			pt1=con.prepareStatement(usql);
			pt1.addBatch();
			int arr1[]=pt1.executeBatch();
			for (int i : arr1) {
				System.out.println(i);
			}
			pt2=con.prepareStatement(dsql);
			pt2.addBatch();
			int arr2[]=pt2.executeBatch();
			for (int i : arr2) {
				System.out.println(i); 
			}
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(pt!=null) {
				try {
					pt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if(pt1!=null) {
					try {
						pt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					if(pt2!=null) {
						try {
							pt.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
}
}
	}
	}
