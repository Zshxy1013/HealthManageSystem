package core.dao;

import static org.hamcrest.CoreMatchers.equalTo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import core.bean.CookieBean;
import core.bean.RecordDataBean;
import core.bean.RecordListBean;
import core.util.DBHelp;
import core.util.PageUtils;

public class RecordDataDao {
	public static void InsertCommitData(RecordDataBean recordDataBean) {
		Connection conn = DBHelp.getConn();
		if (conn == null) {
			recordDataBean.setDbIDCode(503);
			return;
		}
		String sql = "INSERT INTO `ihealthManage`.`record` (`type`, `uuid`, `userid`, `username`, `collegename`, `classname`, `phone`, `slocationcode`, `slocation`, `locationcode`, `location`, `xlocationcode`, `xlocation`, `fever`, `symptomids`, `diagnosis`, `touchquezhen`, `inschool`,`timestamp`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, recordDataBean.getType());
			ps.setString(2, recordDataBean.getUuid());
			ps.setString(3, recordDataBean.getUserid());
			ps.setString(4, recordDataBean.getUsername());
			ps.setString(5, recordDataBean.getCollegename());
			ps.setString(6, recordDataBean.getClassname());
			ps.setString(7, recordDataBean.getPhone());
			ps.setString(8, recordDataBean.getSlocationcode());
			ps.setString(9, recordDataBean.getSlocation());
			ps.setString(10, recordDataBean.getLocationcode());
			ps.setString(11, recordDataBean.getLocation());
			ps.setString(12, recordDataBean.getXlocationcode());
			ps.setString(13, recordDataBean.getXlocation());
			ps.setString(14, recordDataBean.getFever());
			ps.setString(15, recordDataBean.getSymptomids());
			ps.setString(16, recordDataBean.getDiagnosis());
			ps.setString(17, recordDataBean.getTouchquezhen());
			ps.setString(18, recordDataBean.getInschool());
			ps.setTimestamp(19, recordDataBean.getTimestamp());
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (SQLException e) {
			recordDataBean.setDbIDCode(503);
			return;
		}
	}

	public static void SelectRecordData(RecordListBean recordDataList, PageUtils pageUtils) {
		Connection conn = DBHelp.getConn();
		if (conn == null) {
			return;
		}
		
		String sql = "SELECT COUNT(*) FROM `ihealthManage`.`record`";
		try {
			//获取总共的记录
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
			}
			pageUtils.setTotalCount(count);
			
			ps.close();
			rs.close();

			//将每一条详细数据添加到list中
			sql = "SELECT * FROM `ihealthManage`.`record` LIMIT ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pageUtils.getStartIndex());
			ps.setInt(2, pageUtils.getPageSize());
			rs = ps.executeQuery();
			ArrayList<RecordDataBean> list = new ArrayList<RecordDataBean>();
			while (rs.next()) {
				String type = rs.getString("type");
				String userid = rs.getString("userid");
				String username = rs.getString("username");
				String collegename = rs.getString("collegename");
				String classname = rs.getString("classname");
				String phone = rs.getString("collegename");
				String slocation = rs.getString("slocation");
				String location = rs.getString("location");
				String xlocation = rs.getString("xlocation");
				String _inschool = rs.getString("inschool");
				String inschool = null;
				Timestamp timestamp = rs.getTimestamp("timestamp");
				if (("1").equals(_inschool)) {
					inschool = "在校";
				} else {
					inschool = "不在校";
				}
				RecordDataBean databean = new RecordDataBean(type, userid, username, collegename, classname, phone,
						slocation, location, xlocation, inschool, timestamp);
				list.add(databean);
			}
			
			System.out.println(list + "---" + pageUtils.getTotalCount());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		SelectRecordData(new RecordListBean(),new PageUtils(5,null));
	}

}
