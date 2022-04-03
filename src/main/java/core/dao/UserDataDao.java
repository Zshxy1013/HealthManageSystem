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
		PreparedStatement ps;
		if (conn == null) {
			udata.setDbOperateStatusCode(503);
			return ;
		}
		String sql = "select name, passwd from users where staffID = ?";
		try {
			ps = conn.prepareStatement(sql);
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
			} else {
				sql = "select name, passwd from users where staffID = ?";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
