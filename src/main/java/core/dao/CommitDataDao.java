package core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import core.bean.RecordDataBean;
import core.util.DBHelp;

public class CommitDataDao {
	public static void InsertCommitData(RecordDataBean recorddatabean) {
		Connection conn = DBHelp.getConn();
		if (conn == null) {
			recorddatabean.setDbIDCode(503);
			return ;
		}
		String sql = "INSERT INTO `ihealthManage`.`record` (`type`, `uuid`, `userid`, `username`, `collegename`, `classname`, `phone`, `slocationcode`, `slocation`, `locationcode`, `location`, `xlocationcode`, `xlocation`, `fever`, `symptomids`, `diagnosis`, `touchquezhen`, `inschool`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, recorddatabean.getType());
			ps.setString(2, recorddatabean.getUuid());
			ps.setString(3, recorddatabean.getUserid());
			ps.setString(4, recorddatabean.getUsername());
			ps.setString(5, recorddatabean.getCollegename());
			ps.setString(6, recorddatabean.getClassname());
			ps.setString(7, recorddatabean.getPhone());
			ps.setString(8, recorddatabean.getSlocationcode());
			ps.setString(9, recorddatabean.getSlocation());
			ps.setString(10, recorddatabean.getLocationcode());
			ps.setString(11, recorddatabean.getLocation());
			ps.setString(12, recorddatabean.getXlocationcode());
			ps.setString(13, recorddatabean.getXlocation());
			ps.setString(14, recorddatabean.getFever());
			ps.setString(15, recorddatabean.getSymptomids());
			ps.setString(16, recorddatabean.getDiagnosis());
			ps.setString(17, recorddatabean.getTouchquezhen());
			ps.setString(18, recorddatabean.getInschool());
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (SQLException e) {
			recorddatabean.setDbIDCode(503);
			return ;
		}
	}
}
