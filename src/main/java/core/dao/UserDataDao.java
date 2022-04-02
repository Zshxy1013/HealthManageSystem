package core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import core.bean.UserDataBean;
import core.util.DBHelp;

public class UserDataDao {
	public void checkUserData(UserDataBean udata) {
		Connection conn = DBHelp.getConn();
		PreparedStatement ps;
		if (conn == null) {
			udata.setDbOperateStatusCode(503);
			return ;
		}
		String sql = "select name, passwd from users where staffID = ?";
	}
}
