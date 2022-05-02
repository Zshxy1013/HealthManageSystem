package core.bean;

import java.sql.Timestamp;

public class QRCodeData {
	private String stuName;
	private Boolean passStatus;
	private Timestamp passTimeStart;
	private Timestamp passTimeEnd;
	private String todayPassTime;
	private int leftPassTimes;
	
	public QRCodeData(String stuName, Boolean passStatus, Timestamp passTimeStart, Timestamp passTimeEnd,
			int leftPassTimes) {
		super();
		this.stuName = stuName;
		this.passStatus = passStatus;
		this.passTimeStart = passTimeStart;
		this.passTimeEnd = passTimeEnd;
		this.todayPassTime = processTimeStatus(passTimeStart, passTimeEnd);
		this.leftPassTimes = leftPassTimes;
	}
	
	@SuppressWarnings("deprecation")
	public String processTimeStatus(Timestamp passTimeStart, Timestamp passTimeEnd) {
		if (passTimeStart.getDay() == passTimeEnd.getDate() && passTimeStart.getMonth() == passTimeEnd.getMonth() && passTimeStart.getYear() == passTimeEnd.getYear())
			return passTimeStart.getHours() + ":" + passTimeStart.getMinutes() + ":" + passTimeEnd.getHours() + ":" + passTimeEnd.getMinutes();
		else return "全天";
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
