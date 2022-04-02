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
			System.out.println("MySQL Driver�����಻���ڣ���������jar���Ƿ��Ѿ���ȷ������lib��");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("���ݿ����ӳ���������");
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
			System.out.println("�ر����ݿ����������");
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
	    		// ��¼���
	    		int id=rs.getInt("id");
	    		//ѧ����
	    		String staffID = rs.getString("staffID");
	    	    // ����
	    	    String stuName=rs.getString("name");
	    		// �绰
	    	    String tel=rs.getString("telephone");
	    	    // ���֤
	    	    String idNumber=rs.getString("idcard");
	    	    // ����
	    	    String pwd=rs.getString("passwd");
	    	    // �Ա�
	    	    String sex=rs.getString("sex");
	    	    // סַ
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
