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
		String sql = "select name, passwd from users where staffID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, udata.getStuSchoolID());
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				// 存在
				if (udata.getStuPasswd().equals(rs.getString("passwd")))
					System.out.println("密码已经是最新");
				
				else {
					System.out.println("密码需要更新"+ udata.getStuPasswd());
					 sql = "update users set passwd=? where staffID=?";
					 ps = conn.prepareStatement(sql);
					 ps.setString(1, udata.getStuPasswd());
					 ps.setString(2, udata.getStuSchoolID());
					 ps.executeUpdate();
				}
				ps.close();
			} else {
				//插入学生的信息
				sql="INSERT INTO `ihealthManage`.`users` (`staffID`, `name`, `passwd`, `sex`, `majorName`, `className`, `telephone`, `idcard`, `address`, `counsellorID`, `counsellorName`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				//登陆i健康
				genchPlatformAuth.iHealthLogin();
				//取用户数据都封装在这个方法中了
				genchPlatformAuth.getStuData();
				
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, udata.getStuSchoolID());
				ps.setString(2, udata.getStuName());
				ps.setString(3, udata.getStuPasswd());
				ps.setString(4, udata.getStuSex());
				ps.setString(5, udata.getStuMajor());
				ps.setString(6, udata.getStuClass());
				ps.setString(7, udata.getStuTelephone());
				ps.setString(8, udata.getStuIDCard());
				ps.setString(9, udata.getStuAddress());
				ps.setString(10, udata.getCounsellorID());
				ps.setString(11, udata.getCounsellorName());
				ps.executeUpdate();
				System.out.println("插入成功");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
