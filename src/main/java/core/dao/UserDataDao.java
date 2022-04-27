package core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.bean.AdminBean;
import core.bean.UserDataBean;
import core.service.GenchPlatformAuth;
import core.util.DBHelp;

public class UserDataDao {

	public static void checkUserData(GenchPlatformAuth genchPlatformAuth, UserDataBean udata) {

		Connection conn = DBHelp.getConn();
		if (conn == null) {
			udata.setDbOperateStatusCode(503);
			return;
		}
		String sql = "select * from users where stuSchoolID = ?";
		try {
			genchPlatformAuth.iHealthLogin();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, udata.getStuSchoolID());
			ResultSet rs = ps.executeQuery();
			// 如果存在用户名，即数据已经入库
			if (rs.next()) {
				// 查询用户是否有更新过信息门户的密码
				if (udata.getStuPasswd().equals(rs.getString("stuPasswd"))) {
					// 与数据库的匹配，不需要做什么事情
					System.out.println("密码已经是最新");
					//为了使session成功添加到页面
					getUserData(udata, rs);
				} else {
					// 与数据库不匹配，更新数据库的密码
					System.out.println("密码需要更新" + udata.getStuPasswd());
					sql = "update users set stuPasswd=? where stuSchoolID=?";
					ps = conn.prepareStatement(sql);
					ps.setString(1, udata.getStuPasswd());
					ps.setString(2, udata.getStuSchoolID());
					ps.executeUpdate();
				}
			} else {
				// 关闭之前的查询，防止内存泄漏
				ps.close();
				rs.close();

				// 插入学生的信息
				sql = "INSERT INTO `ihealthManage`.`users` (`stuSchoolID`, `stuUuid`, `stuName`, `stuPasswd`, `stuSex`, `stuCollege`, `stuCollegeid`, `stuMajorid`, `stuMajor`, `stuClassid`, `stuClass`, `stuTelephone`, `stuIDCard`, `stuAddress`, `counsellorID`, `counsellorName`,`counsellorPhone`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				// 取用户数据都封装在这个方法中了
				genchPlatformAuth.getStuData();

				// 新建一个新的ps查询
				ps = conn.prepareStatement(sql);

				// 学生学号
				ps.setString(1, udata.getStuSchoolID());
				// 学生uid
				ps.setString(2, udata.getStuUuid());
				// 学生姓名
				ps.setString(3, udata.getStuName());
				// 学生密码
				ps.setString(4, udata.getStuPasswd());
				// 学生性别
				ps.setString(5, udata.getStuSex());
				// 学生学院
				ps.setString(6, udata.getStuCollege());
				// 学生学院id
				ps.setString(7, udata.getStuCollegeid());
				// 学生专业id
				ps.setString(8, udata.getStuMajorid());
				// 学生专业
				ps.setString(9, udata.getStuMajor());
				// 学生班级id
				ps.setString(10, udata.getStuClassid());
				// 学生班级
				ps.setString(11, udata.getStuClass());
				// 学生电话
				ps.setString(12, udata.getStuTelephone());
				// 学生身份证
				ps.setString(13, udata.getStuIDCard());
				// 学生家庭住址
				ps.setString(14, udata.getStuAddress());
				// 辅导员工号
				ps.setString(15, udata.getCounsellorID());
				// 辅导员姓名
				ps.setString(16, udata.getCounsellorName());
				// 辅导员手机
				ps.setString(17, udata.getCounsellorPhone());
				ps.executeUpdate();
				System.out.println("插入成功");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void getUserData(UserDataBean udata, ResultSet rs) {

		try {
			udata.setStuSchoolID(rs.getString(2));
			udata.setStuUuid(rs.getString(3));
			udata.setStuName(rs.getString(4));
			udata.setStuPasswd(rs.getString(5));
			udata.setStuSex(rs.getString(6));
			udata.setStuCollege(rs.getString(7));
			udata.setStuCollegeid(rs.getString(8));
			udata.setStuMajorid(rs.getString(9));
			udata.setStuMajor(rs.getString(10));
			udata.setStuClassid(rs.getString(11));
			udata.setStuClass(rs.getString(12));
			udata.setStuTelephone(rs.getString(13));
			udata.setStuIDCard(rs.getString(14));
			udata.setStuAddress(rs.getString(15));
			udata.setCounsellorID(rs.getString(16));
			udata.setCounsellorName(rs.getString(17));
			udata.setCounsellorPhone(rs.getString(18));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void checkAdminData(AdminBean aDataBean) {
		// TODO Auto-generated method stub
		Connection conn = DBHelp.getConn();
		if (conn == null) {
			aDataBean.setDbIDCode(503);
			return;
		}
		String sql = "SELECT * FROM `ihealthManage`.`admin` WHERE staffID=? and passwd=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, aDataBean.getAdminID());
			ps.setString(2, aDataBean.getAdminPasswd());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {// 登陆信息正确
				aDataBean.setDbIDCode(200);
		} 
			else {
				aDataBean.setDbIDCode(404);
			}

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			aDataBean.setDbIDCode(503);
			e.printStackTrace();
		}
	}
}
