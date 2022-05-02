package core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import core.bean.LeaveBean;
import core.util.DBHelp;

public class LeaveDataDao {
	/**
     * 日期格式字符串转换成时间戳
     *
     * @param dateStr 字符串日期
     * @param format   如：yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static long Date2TimeStamp(String dateStrBegin, String dateStrEnd, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return (sdf.parse(dateStrBegin).getTime() / 1000 - sdf.parse(dateStrEnd).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

	public static void saveLeaveData(LeaveBean leaveBean) {
		Connection conn = DBHelp.getConn();
		if (conn == null) {
			return;
		}
		String sql = "INSERT INTO `ihealthManage`.`leave` (`userid`, `username`, `classid`, `classname`, `majorid`, `majorname`, `collegeid`, `collegename`, `teachername`, `linkname`, `linkphone`, `outtime`, `intime`, `typeid`, `typename`, `remarks`, `img`, `teacherid`, `shanghai`, `slocationcode`, `slocation`, `locationcode`, `location`, `cdt`, `duration`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, leaveBean.getUserid());
			ps.setString(2, leaveBean.getUsername());
			ps.setString(3, leaveBean.getClassid());
			ps.setString(4, leaveBean.getClassname());
			ps.setString(5, leaveBean.getMajorid());
			ps.setString(6, leaveBean.getMajorname());
			ps.setString(7, leaveBean.getCollegeid());
			ps.setString(8, leaveBean.getCollegename());
			ps.setString(9, leaveBean.getTeachername());
			ps.setString(10, leaveBean.getLinkname());
			ps.setString(11, leaveBean.getLinkphone());
			ps.setTimestamp(12, leaveBean.getOuttime());
			ps.setTimestamp(13, leaveBean.getIntime());
			ps.setInt(14, leaveBean.getTypeid());
			ps.setString(15, leaveBean.getTypename());
			ps.setString(16, leaveBean.getRemarks());
			ps.setString(17, leaveBean.getImg());
			ps.setString(18, leaveBean.getTeacherid());
			ps.setInt(19, leaveBean.getShanghai());
			ps.setString(20, leaveBean.getSlocationcode());
			ps.setString(21, leaveBean.getSlocation());
			ps.setString(22, leaveBean.getLocationcode());
			ps.setString(23, leaveBean.getLocation());
			Date date = new Date();// 获得系统时间.
  			String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
  			Timestamp timestamp = Timestamp.valueOf(nowTime);
			ps.setTimestamp(24, timestamp);
			ps.setString(25, String.valueOf(Date2TimeStamp(leaveBean.getIntime().toString(), leaveBean.getOuttime().toString(), "yyyy-MM-dd HH:mm:ss") / 3600));
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
