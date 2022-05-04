package core.bean;

import java.sql.Timestamp;

public class QRCodeData {
	private String stuID;
	private String stuName;
	private Boolean passStatus;
	private Timestamp passTimeStart;
	private Timestamp passTimeEnd;
	private String todayPassTime;
	private int leftPassTimes;
	private int id;
	
	public QRCodeData(String stuID) {
		this.stuID = stuID;
	}

	@SuppressWarnings("deprecation")
	public void processTimeStatus() {
		if (passTimeStart.getDay() == passTimeEnd.getDay() && passTimeStart.getMonth() == passTimeEnd.getMonth() && passTimeStart.getYear() == passTimeEnd.getYear())
			todayPassTime = String.format("%02d:%02d至%02d:%02d", passTimeStart.getHours(), passTimeStart.getMinutes(), passTimeEnd.getHours(), passTimeEnd.getMinutes());
			//todayPassTime = passTimeStart.getHours() + ":" + passTimeStart.getMinutes() + "至" + passTimeEnd.getHours() + ":" + passTimeEnd.getMinutes();
		else todayPassTime = "全天";
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStuID() {
		return stuID;
	}

	public void setStuID(String stuID) {
		this.stuID = stuID;
	}

	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Boolean getPassStatus() {
		return passStatus;
	}
	public void setPassStatus(Boolean passStatus) {
		this.passStatus = passStatus;
	}
	public Timestamp getPassTimeStart() {
		return passTimeStart;
	}
	public void setPassTimeStart(Timestamp passTimeStart) {
		this.passTimeStart = passTimeStart;
	}
	public Timestamp getPassTimeEnd() {
		return passTimeEnd;
	}
	public void setPassTimeEnd(Timestamp passTimeEnd) {
		this.passTimeEnd = passTimeEnd;
	}
	public String getTodayPassTime() {
		return todayPassTime;
	}
	public void setTodayPassTime(String todayPassTime) {
		this.todayPassTime = todayPassTime;
	}
	public int getLeftPassTimes() {
		return leftPassTimes;
	}
	public void setLeftPassTimes(int leftPassTimes) {
		this.leftPassTimes = leftPassTimes;
	}
	
	
}
