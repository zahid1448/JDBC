package org.btm.UppApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
public class RollBack {
public static void main(String[] args) throws Exception{
	Connection con=null;
	PreparedStatement pt=null;
	PreparedStatement pt1=null;
	//PreparedStatement pt2=null;
	//String isql="insert into gru.students values(6,'vijay',40.09,12345)";
	//String usql1="update gru.students set name=kundan,per=99.09,paswd=1234 where id=17";
	String usql="insert into gru.students values(?,?,?,?)";
	//String usql="delete from gru.students where id=2";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		System.out.println("connection stablished");
		//Savepoint savepoint1 = con.setSavepoint("Savepoint1");
	    con.setAutoCommit(false);
		pt=con.prepareStatement(usql); 
		pt.setInt(1,20);
		pt.setString(2,"name");
	    pt.setDouble(3,99.09);
	    pt.setString(4,"1234");
		int prr=pt.executeUpdate();
	pt1=con.prepareStatement(usql);
	pt1.setInt(1,21);
	pt1.setString(2,"mss");
	pt1.setDouble(3, 34.77);
	pt1.setString(4,"kumar");
    int prr1= pt1.executeUpdate();
        System.out.println("data inserted");
	//if(prr>0&&prr1>0) {
		con.commit();
	//}
	} catch (ClassNotFoundException|SQLException e) 
	{
		try{
            if(con!= null)
                con.rollback();
            System.out.println("roll back");
        }catch(SQLException ex){
            ex.printStackTrace();
        }
	}
	finally {
	if(pt1!=null) {
			try {
			pt1.close();
			} catch (SQLException e) {
				e.printStackTrace();
		}
			if(pt!=null) {
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


