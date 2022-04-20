package core.bean;

import java.sql.Timestamp;
import java.util.ArrayList;



public class RecordDataBean {
	int dbIDCode;
	private String type;
	private String uuid;
	private String userid;
	private String username;
	private String collegename;
	private String classname;
	private String phone;
	private String slocationcode;
	private String slocation;
	private String locationcode;
	private String location;
	private String xlocationcode;
	private String xlocation;
	private String fever;
	private String symptomids;
	private String diagnosis;
	private String touchquezhen;
	private String inschool;
	private Timestamp timestamp ;
		
	public RecordDataBean() {
		
	}
	
	public RecordDataBean(String type, String uuid, String userid, String username, String collegename,
			String classname, String phone, String slocationcode, String slocation, String locationcode,
			String location, String xlocationcode, String xlocation, String fever, String symptomids, String diagnosis,
			String touchquezhen, String inschool, Timestamp timestamp) {
		this.type = type;
		this.uuid = uuid;
		this.userid = userid;
		this.username = username;
		this.collegename = collegename;
		this.classname = classname;
		this.phone = phone;
		this.slocationcode = slocationcode;
		this.slocation = slocation;
		this.locationcode = locationcode;
		this.location = location;
		this.xlocationcode = xlocationcode;
		this.xlocation = xlocation;
		this.fever = fever;
		this.symptomids = symptomids;
		this.diagnosis = diagnosis;
		this.touchquezhen = touchquezhen;
		this.inschool = inschool;
		this.timestamp = timestamp;
	}
	
	public RecordDataBean(String type, String userid, String username, String collegename,
			String classname, String phone,  String slocation, 
			String location,  String xlocation,String inschool, Timestamp timestamp) {
		super();
		this.type = type;
	
		this.userid = userid;
		this.username = username;
		this.collegename = collegename;
		this.classname = classname;
		this.phone = phone;
	
		this.slocation = slocation;
	
		this.location = location;

		this.xlocation = xlocation;
		this.inschool = inschool;
		this.timestamp = timestamp;
	}
	
	public int getDbIDCode() {
		return dbIDCode;
	}
	public void setDbIDCode(int dbIDCode) {
		this.dbIDCode = dbIDCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCollegename() {
		return collegename;
	}
	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSlocationcode() {
		return slocationcode;
	}
	public void setSlocationcode(String slocationcode) {
		this.slocationcode = slocationcode;
	}
	public String getSlocation() {
		return slocation;
	}
	public void setSlocation(String slocation) {
		this.slocation = slocation;
	}
	public String getLocationcode() {
		return locationcode;
	}
	public void setLocationcode(String locationcode) {
		this.locationcode = locationcode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getXlocationcode() {
		return xlocationcode;
	}
	public void setXlocationcode(String xlocationcode) {
		this.xlocationcode = xlocationcode;
	}
	public String getXlocation() {
		return xlocation;
	}
	public void setXlocation(String xlocation) {
		this.xlocation = xlocation;
	}
	public String getFever() {
		return fever;
	}
	public void setFever(String fever) {
		this.fever = fever;
	}
	public String getSymptomids() {
		return symptomids;
	}
	public void setSymptomids(String symptomids) {
		this.symptomids = symptomids;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getTouchquezhen() {
		return touchquezhen;
	}
	public void setTouchquezhen(String touchquezhen) {
		this.touchquezhen = touchquezhen;
	}
	public String getInschool() {
		return inschool;
	}
	public void setInschool(String inschool) {
		this.inschool = inschool;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "RecordDataBean [dbIDCode=" + dbIDCode + ", type=" + type + ", uuid=" + uuid + ", userid=" + userid
				+ ", username=" + username + ", collegename=" + collegename + ", classname=" + classname + ", phone="
				+ phone + ", slocationcode=" + slocationcode + ", slocation=" + slocation + ", locationcode="
				+ locationcode + ", location=" + location + ", xlocationcode=" + xlocationcode + ", xlocation="
				+ xlocation + ", fever=" + fever + ", symptomids=" + symptomids + ", diagnosis=" + diagnosis
				+ ", touchquezhen=" + touchquezhen + ", inschool=" + inschool + ", timestamp=" + timestamp + "]";
	}


}