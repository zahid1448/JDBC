package org.btm.loginApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Login {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ptm=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("eneter the name");
	String name=sc.nextLine();
	String password=sc.nextLine();
		//sc.close();
		String qry="select username from user where name=? and password=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/btm?","root","root");
			System.out.println("stablished the connection");
			ptm=con.prepareStatement(qry);
//			String name=sc.nextLine();
//			String password=sc.nextLine();
			ptm.setString(1,name);
			ptm.setString(2,password);
			rs=ptm.executeQuery();
			if(rs.next()) {
				String names=rs.getString(1);
				System.out.println("valid name"+names);
		    String passwords=rs.getString(2);
			System.out.println(" "+passwords);
			}
			else
			{
				System.err.println("invalid name/password----"+name+"--- "+password);
			}
		}
		catch(ClassNotFoundException |SQLException e){
			e.printStackTrace();
		}
		finally {
			if(ptm!=null) {
				try {
					ptm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
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
