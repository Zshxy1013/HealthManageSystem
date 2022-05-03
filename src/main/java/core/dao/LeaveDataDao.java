package core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.bean.LeaveBean;
import core.bean.LeaveListBean;
import core.bean.QRCodeData;
import core.bean.RecordDataBean;
import core.bean.UserDataBean;
import core.util.DBHelp;
import core.util.PageUtils;

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
			return ;
		}
		String sql = "INSERT INTO `ihealthManage`.`leave` (`userid`, `username`, `classid`, `classname`, `majorid`, `majorname`, `collegeid`, `collegename`, `teachername`, `teacherphone`,`linkname`, `linkphone`, `outtime`, `intime`, `typeid`, `typename`, `remarks`, `img`, `teacherid`, `shanghai`, `slocationcode`, `slocation`, `locationcode`, `location`, `cdt`, `duration`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
			ps.setString(10, leaveBean.getTeacherphone());
			ps.setString(11, leaveBean.getLinkname());
			ps.setString(12, leaveBean.getLinkphone());
			ps.setTimestamp(13, leaveBean.getOuttime());
			ps.setTimestamp(14, leaveBean.getIntime());
			ps.setInt(15, leaveBean.getTypeid());
			ps.setString(16, leaveBean.getTypename());
			ps.setString(17, leaveBean.getRemarks());
			ps.setString(18, leaveBean.getImg());
			ps.setString(19, leaveBean.getTeacherid());
			ps.setInt(20, leaveBean.getShanghai());
			ps.setString(21, leaveBean.getSlocationcode());
			ps.setString(22, leaveBean.getSlocation());
			ps.setString(23, leaveBean.getLocationcode());
			ps.setString(24, leaveBean.getLocation());
			Date date = new Date();// 获得系统时间.
  			String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
  			Timestamp timestamp = Timestamp.valueOf(nowTime);
			ps.setTimestamp(25, timestamp);
			ps.setString(26, String.valueOf(Date2TimeStamp(leaveBean.getIntime().toString(), leaveBean.getOuttime().toString(), "yyyy-MM-dd HH:mm:ss") / 3600));
			ps.executeUpdate();
			ps.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void selectStuLeaveData(UserDataBean uDataBean,LeaveListBean LeaveListData, PageUtils pageUtils) {
		Connection conn = DBHelp.getConn();
		if (conn == null) {
			return;
		}

		String sql = "SELECT COUNT(*) FROM `ihealthManage`.`leave` WHERE `userid`=?";
		try {
			// 获取总共的记录
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uDataBean.getStuSchoolID());
			ResultSet rs = ps.executeQuery();
			int count = 0;
			List<LeaveBean> list = null;
			if (rs.next()) {
				count = rs.getInt(1);
			}
			pageUtils.setTotalCount(count);
			pageUtils.Init();

			ps.close();
			rs.close();
			if (pageUtils.getTotalCount() != 0) {
				// 将每一条详细数据添加到list中
				sql = "SELECT * FROM `ihealthManage`.`leave` WHERE `userid`=? order by `id` desc LIMIT ?,?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, uDataBean.getStuSchoolID());
				ps.setInt(2, pageUtils.getStartIndex());
				ps.setInt(3, pageUtils.getPageSize());
		
				
				rs = ps.executeQuery();
				list = new ArrayList<LeaveBean>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String userid=rs.getString("userid");
					String username=rs.getString("username");
					String classname=rs.getString("classname");
					String collegename=rs.getString("collegename");
					String teachername=rs.getString("teachername");
					String teacherphone=rs.getString("teacherphone");
					String linkname=rs.getString("linkname");
					String linkphone=rs.getString("linkphone");
					int shanghai=rs.getInt("shanghai");
					String slocation=rs.getString("slocation");
					String location=rs.getString("location");
					String typename=rs.getString("typename");
					Timestamp cdt=rs.getTimestamp("cdt");
					Timestamp outtime=rs.getTimestamp("outtime");
					Timestamp intime=rs.getTimestamp("intime");
					String duration=rs.getString("duration");
					String remarks=rs.getString("remarks");
					String img=rs.getString("img");
					int status=rs.getInt("status");
					int tstatus=rs.getInt("tstatus");
					LeaveBean leavebean = new LeaveBean(id, userid,username, classname, collegename, teachername, teacherphone, linkname, linkphone, outtime, intime, typename, remarks, img, status, tstatus, cdt, duration, shanghai, slocation, location);
					list.add(leavebean);
				}
			} else {
				list = null;
			}
			LeaveListData.setRecords(list);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    public static void checkLeaveData(QRCodeData qrcode) {

		Connection conn = DBHelp.getConn();
		if (conn == null) {
			return;
		}
		String sql = "SELECT * FROM `leave` WHERE UNIX_TIMESTAMP(DATE_FORMAT(outtime,'%Y-%m-%d %00:%00:%00'))  <= UNIX_TIMESTAMP() AND UNIX_TIMESTAMP(DATE_FORMAT(intime,'%Y-%m-%d %00:%00:%00')) + 86400 >= UNIX_TIMESTAMP() AND userid = ? ORDER BY ID DESC";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, qrcode.getStuID());
			ResultSet rs = ps.executeQuery();
			// 默认通行状态为禁止通行
			qrcode.setPassStatus(false);
			while(rs.next()) {
				// 判断剩余次数是否为0
				if (rs.getInt("leftTimes") != 0 && rs.getInt("tstatus") == 2) {
					// 不为0代表此条出行次数还未用完，依旧有效
					qrcode.setStuID(rs.getString("userid"));
					qrcode.setStuName(rs.getString("username"));
					qrcode.setPassStatus(true);
					qrcode.setLeftPassTimes(rs.getInt("leftTimes"));
					qrcode.setPassTimeStart(rs.getTimestamp("outtime"));
					qrcode.setPassTimeEnd(rs.getTimestamp("intime"));
					// 处理数据，生成当日出行简报
					qrcode.processTimeStatus();
					break;
				} else {
					continue;
				}
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
