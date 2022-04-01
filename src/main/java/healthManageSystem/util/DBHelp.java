package healthManageSystem.util;

import java.sql.*;
import org.junit.Test;

public class DBHelp {
	
	public static Connection getConn(){
		String DBDirverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String DBUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=healthManage";
		String DBUser = "sa";
		String DBPwd = "leo123";
		Connection connection = null;
		try {
			Class.forName(DBDirverName);
			connection = DriverManager.getConnection(DBUrl, DBUser, DBPwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("SQLServerDriver没有找到，驱动包加载了吗");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接出现了问题");
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeDBResource(ResultSet rs, Statement stm, Connection con) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stm != null) {
				stm.close();
				stm = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("关闭数据库出现了问题");
			e.printStackTrace();
		}

	}
	@Test
    public  void printTableDataForTest(){
    	Connection conn=getConn();
    	String sql="select * from users";
    	PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
	    	ResultSet rs=ps.executeQuery();;
	    	while(rs.next()){
	    		int id=rs.getInt(1);
	    	    String tel=rs.getString("tel");
	    	    String username=rs.getString(3);
	    	    String idNumber=rs.getString(4);
	    	    String pwd=rs.getString(5);
	    	    String sex=rs.getString(6);
	    	    String address=rs.getString(7);


	    	    System.out.print(id+"\t");
	    	    System.out.print(tel+"\t");	
	    	    System.out.print(username+"\t");
	    	    System.out.print(idNumber+"\t");
	    	    System.out.print(pwd+"\t");
	    	    System.out.print(sex+"\t\n");
    	
	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	    	
    }
    public static void main(String args[]){
   	 
   	 new DBHelp().printTableDataForTest();
    }	
}
