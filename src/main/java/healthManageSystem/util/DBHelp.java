package healthManageSystem.util;

import java.sql.*;
import org.junit.Test;

public class DBHelp {
	
	public static Connection getConn(){
		String DBDirverName = "com.mysql.jdbc.Driver";
		String DBUrl = "jdbc:mysql://193.123.249.239:3306/ihealthManage";
		String DBUser = "ihealthManage";
		String DBPwd = "fbkpBpPjnD7Gc5WT";
		Connection connection = null;
		try {
			Class.forName(DBDirverName);
			connection = DriverManager.getConnection(DBUrl, DBUser, DBPwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("MySQL Driver驱动类不存在，请检查驱动jar包是否已经正确放置在lib中");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("数据库连接出现了问题");
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
	    		// 记录编号
	    		int id=rs.getInt("id");
	    		//学工号
	    		String staffID = rs.getString("staffID");
	    	    // 姓名
	    	    String stuName=rs.getString("name");
	    		// 电话
	    	    String tel=rs.getString("telephone");
	    	    // 身份证
	    	    String idNumber=rs.getString("idcard");
	    	    // 密码
	    	    String pwd=rs.getString("passwd");
	    	    // 性别
	    	    String sex=rs.getString("sex");
	    	    // 住址
	    	    String address=rs.getString("address");


	    	    System.out.print(id+"\t");
	    	    System.out.print(staffID+"\t");
	    	    System.out.print(stuName+"\t");
	    	    System.out.print(pwd+"\t");
	    	    System.out.print(tel+"\t");	
	    	    System.out.print(idNumber+"\t");
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
