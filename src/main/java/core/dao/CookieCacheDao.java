package core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import core.bean.CookieBean;
import core.util.DBHelp;

public class CookieCacheDao {
	public static void findCookie(CookieBean cookieBean) {
		String sql = "select * from cookies  where staffID = ?";
		Connection conn = DBHelp.getConn();
		if (conn == null) {
			cookieBean.setStatusCode(503);
			return;
		}
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cookieBean.getStaffID());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cookieBean.setStatusCode(200);
				cookieBean.setSsohqCookie(rs.getString("ssohq_703"));
				// System.out.println(rs.getString("ssohq_703"));
			}
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			cookieBean.setStatusCode(500);
		}
	}

	public static void setCookie(CookieBean cookieBean) {
		if (cookieBean.getStatusCode() != 200) {
			String sql = "INSERT INTO `ihealthManage`.`cookies` (`staffID`, `ssohq_703`) VALUES (?, ?)";
			Connection conn = DBHelp.getConn();
			if (conn == null) {
				cookieBean.setStatusCode(503);
				return;
			}
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, cookieBean.getStaffID());
				ps.setString(2, cookieBean.getSsohqCookie());
				ps.executeUpdate();
				cookieBean.setStatusCode(200);
				ps.close();
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				cookieBean.setStatusCode(500);
			}
		} else {
			String sql = "update cookies set ssohq_703=? where staffID=?";
			try {
				Connection conn = DBHelp.getConn();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, cookieBean.getSsohqCookie());
				ps.setString(2, cookieBean.getStaffID());
				ps.executeUpdate();
				cookieBean.setStatusCode(200);
				ps.close();
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
	}

	public static void main(String args[]) {
		CookieBean cookieBean = new CookieBean("1922557");
		findCookie(cookieBean);
	}

}
