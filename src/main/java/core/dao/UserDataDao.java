package core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.bean.UserDataBean;
import core.service.GenchPlatformAuth;
import core.util.DBHelp;

public class UserDataDao {
	
	public static void checkUserData(GenchPlatformAuth genchPlatformAuth, UserDataBean udata) {

		Connection conn = DBHelp.getConn();
		if (conn == null) {
			udata.setDbOperateStatusCode(503);
			return ;
		}
		String sql = "select * from users where stuSchoolID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, udata.getStuSchoolID());
			ResultSet rs = ps.executeQuery();
			// 如果存在用户名，即数据已经入库
			if (rs.next()) {
				// 查询用户是否有更新过信息门户的密码
				if (udata.getStuPasswd().equals(rs.getString("stuPasswd"))) {
					// 与数据库的匹配，不需要做什么事情
					System.out.println("密码已经是最新");
					getUserData(udata, rs);
				}
				else {
					// 与数据库不匹配，更新数据库的密码
					System.out.println("密码需要更新"+ udata.getStuPasswd());
					 sql = "update users set stuPasswd=? where stuSchoolID=?";
					 ps = conn.prepareStatement(sql);
					 ps.setString(1, udata.getStuPasswd());
					 ps.setString(2, udata.getStuSchoolID());
					 ps.executeUpdate();
				}
			} else {
				// 关闭之前的查询，防止内存泄漏
				ps.close();
				
				//插入学生的信息
				sql="INSERT INTO `ihealthManage`.`users` (`stuSchoolID`, `stuName`, `stuPasswd`, `stuSex`, `stuMajor`, `stuClass`, `stuTelephone`, `stuIDCard`, `stuAddress`, `counsellorID`, `counsellorName`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				//登陆i健康
				genchPlatformAuth.iHealthLogin();
				//取用户数据都封装在这个方法中了
				genchPlatformAuth.getStuData();
				
				// 新建一个新的ps查询
				ps = conn.prepareStatement(sql);
				
				// 学生学号
				ps.setString(1, udata.getStuSchoolID());
				// 学生姓名
				ps.setString(2, udata.getStuName());
				// 学生密码
				ps.setString(3, udata.getStuPasswd());
				// 学生性别
				ps.setString(4, udata.getStuSex());
				// 学生专业
				ps.setString(5, udata.getStuMajor());
				// 学生班级
				ps.setString(6, udata.getStuClass());
				// 学生电话
				ps.setString(7, udata.getStuTelephone());
				// 学生身份证
				ps.setString(8, udata.getStuIDCard());
				// 学生家庭住址
				ps.setString(9, udata.getStuAddress());
				// 辅导员工号
				ps.setString(10, udata.getCounsellorID());
				// 辅导员姓名
				ps.setString(11, udata.getCounsellorName());
				ps.executeUpdate();
				System.out.println("插入成功");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void getUserData(UserDataBean udata,ResultSet rs) {
		
		try {
			udata.setStuSchoolID(rs.getString(2));
			udata.setStuName(rs.getString(3));
			udata.setStuPasswd(rs.getString(4));
			udata.setStuSex(rs.getString(5));
			udata.setStuMajor(rs.getString(6));
			udata.setStuClass(rs.getString(7));
			udata.setStuTelephone(rs.getString(8));
			udata.setStuIDCard(rs.getString(9));
			udata.setStuAddress(rs.getString(10));
			udata.setCounsellorID(rs.getString(11));
			udata.setCounsellorName(rs.getString(12));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]) {
		UserDataBean uData = new UserDataBean("1922557", "wyw20082009");
		GenchPlatformAuth genchPlatformAuth = new GenchPlatformAuth(uData);
		checkUserData(genchPlatformAuth, uData);
	}
}


