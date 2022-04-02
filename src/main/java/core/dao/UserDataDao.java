package core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.bean.UserDataBean;
import core.util.DBHelp;

public class UserDataDao {
	public void checkUserData(UserDataBean udata) throws SQLException {
		Connection conn = DBHelp.getConn();
		PreparedStatement ps;
		if (conn == null) {
			udata.setDbOperateStatusCode(503);
			return ;
		}
		String sql = "select name, passwd from users where staffID = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, udata.getStuSchoolID());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			// 存在
			if (udata.getStuPasswd() != rs.getString("passwd"))
				System.out.println("密码需要更新");
		}
	}
}
