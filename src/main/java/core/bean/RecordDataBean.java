package core.bean;

public class RecordDataBean {
	private String type;
	private String uuid;
	private String userid;
	private String username;
	private String collegename;
	private String classname;
	private String phone;
	private String slocationcode;
	private String slocation;
	private String xlocationcode;
	private String locationcode;
	private String location;
	private String fever;
	private String symptomids;
	private String diagnosis;
	private String touchquezhen;
	private String inschool;
	
	
	
	public RecordDataBean(String type, String uuid, String userid, String username, String collegename,
			String classname, String phone, String slocationcode, String slocation, String xlocationcode,
			String locationcode, String location, String fever, String symptomids, String diagnosis,
			String touchquezhen, String inschool) {
		super();
		this.type = type;
		this.uuid = uuid;
		this.userid = userid;
		this.username = username;
		this.collegename = collegename;
		this.classname = classname;
		this.phone = phone;
		this.slocationcode = slocationcode;
		this.slocation = slocation;
		this.xlocationcode = xlocationcode;
		this.locationcode = locationcode;
		this.location = location;
		this.fever = fever;
		this.symptomids = symptomids;
		this.diagnosis = diagnosis;
		this.touchquezhen = touchquezhen;
		this.inschool = inschool;
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
	public String getXlocationcode() {
		return xlocationcode;
	}
	public void setXlocationcode(String xlocationcode) {
		this.xlocationcode = xlocationcode;
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

	@Override
	public String toString() {
		return "RecordDataBean [type=" + type + ", uuid=" + uuid + ", userid=" + userid + ", username=" + username
				+ ", collegename=" + collegename + ", classname=" + classname + ", phone=" + phone + ", slocationcode="
				+ slocationcode + ", slocation=" + slocation + ", xlocationcode=" + xlocationcode + ", locationcode="
				+ locationcode + ", location=" + location + ", fever=" + fever + ", symptomids=" + symptomids
				+ ", diagnosis=" + diagnosis + ", touchquezhen=" + touchquezhen + ", inschool=" + inschool + "]";
	}
	
	
}
