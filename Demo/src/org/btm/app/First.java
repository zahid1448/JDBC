package org.btm.app;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class First extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Scanner sc=new Scanner(System.in);
		System.out.println("enetr the id!!!");
		String sid=sc.next();
		int id=Integer.parseInt(sid);
		sc.close();
		//String sid=req.getParameter("i");
//		int id=Integer.parseInt(sid);
		Connection con=null;
		PreparedStatement stm=null;
		ResultSet st=null;
	String str="select * from btm1.students where id=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			stm=con.prepareStatement(str);
			stm.setInt(1,id);
			st=stm.executeQuery();
			if(st.next()) {
				String name=st.getString(2);
				String dept=st.getString(4);
				String per=st.getString(3);
				PrintWriter out=resp.getWriter();
				out.println("<html><body bgcolor='yellow'>"
						+ "<h1>student dtails are "
						   +name+"----"+dept+"-----"+per+" "+ "</h1>"
								+ "</body></html>");
				out.close();
			}
			else
			{
				PrintWriter out=resp.getWriter();
				out.println("<html><body bgcolor='yellow'>"
						+ "<h1>student dtails are not found "
						   +" "+ "</h1>"
								+ "</body></html>");
				out.close();
			}
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(st!=null)
			{
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(stm!=null)
			{
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(con!=null)
			{
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
		



