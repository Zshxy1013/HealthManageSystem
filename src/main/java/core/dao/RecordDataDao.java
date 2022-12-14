package core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import core.bean.RecordDataBean;
import core.bean.RecordListBean;
import core.bean.UserDataBean;
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
			// ?????????????????????
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			ArrayList<RecordDataBean> list = null;
			if (rs.next()) {
				count = rs.getInt(1);
			}
			pageUtils.setTotalCount(count);
			pageUtils.Init();

			ps.close();
			rs.close();
			if (pageUtils.getTotalCount() != 0) {
				// ?????????????????????????????????list???
				sql = "SELECT * FROM `ihealthManage`.`record` order by `id` desc LIMIT ?,?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, pageUtils.getStartIndex());
				ps.setInt(2, pageUtils.getPageSize());
				rs = ps.executeQuery();
				list = new ArrayList<RecordDataBean>();
				while (rs.next()) {
					int id = rs.getInt("id");
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
						inschool = "??????";
					} else {
						inschool = "?????????";
					}
					RecordDataBean databean = new RecordDataBean(id, type, userid, username, collegename, classname,
							phone, slocation, location, xlocation, inschool, timestamp);
					list.add(databean);
				}
			} else {
				list = null;
			}
			recordDataList.setRecordDataList(list);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void DeleteRecordData(RecordDataBean recordDataBean) {
		Connection conn = DBHelp.getConn();
		if (conn == null) {
			recordDataBean.setDbIDCode(503);
			return;
		}
		String sql = "DELETE FROM `ihealthManage`.`record` WHERE  `id`=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, recordDataBean.getId());
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (SQLException e) {
			recordDataBean.setDbIDCode(503);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void SelectStuRecordData(UserDataBean uDataBean,RecordListBean recordDataList, PageUtils pageUtils) {
		Connection conn = DBHelp.getConn();
		if (conn == null) {
			return;
		}

		String sql = "SELECT COUNT(*) FROM `ihealthManage`.`record` WHERE `userid`=?";
		try {
			// ?????????????????????
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uDataBean.getStuSchoolID());
			ResultSet rs = ps.executeQuery();
			int count = 0;
			ArrayList<RecordDataBean> list = null;
			if (rs.next()) {
				count = rs.getInt(1);
			}
			pageUtils.setTotalCount(count);
			pageUtils.Init();

			ps.close();
			rs.close();
			if (pageUtils.getTotalCount() != 0) {
				// ?????????????????????????????????list???
				sql = "SELECT * FROM `ihealthManage`.`record` WHERE `userid`=? order by `id` desc LIMIT ?,?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, uDataBean.getStuSchoolID());
				ps.setInt(2, pageUtils.getStartIndex());
				ps.setInt(3, pageUtils.getPageSize());
				
				rs = ps.executeQuery();
				list = new ArrayList<RecordDataBean>();
				while (rs.next()) {
					int id = rs.getInt("id");
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
						inschool = "??????";
					} else {
						inschool = "?????????";
					}
					RecordDataBean databean = new RecordDataBean(id, type, userid, username, collegename, classname,
							phone, slocation, location, xlocation, inschool, timestamp);
					list.add(databean);
				}
			} else {
				list = null;
			}
			recordDataList.setRecordDataList(list);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
