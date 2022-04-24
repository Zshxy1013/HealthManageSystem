package core.bean;

import java.sql.Timestamp;

public class LeaveBean {

	private long id;
	private long ticketid;
	private String userid;
	private String username;
	private String classid;
	private String classname;
	private String majorid;
	private String majorname;
	private String collegeid;
	private String collegename;
	private String teachername;
	private String teacherphone;
	private String linkname;
	private String linkphone;
	private Timestamp outtime;
	private Timestamp intime;
	private int typeid;
	private String typename;
	private String remarks;
	private String img;
	private int status;
	private int tstatus;
	private int cstatus;
	private int sstatus;
	private int jstatus;
	private Timestamp cdt;
	private Timestamp dt;
	private String routtime;
	private String rintime;
	private String fevernum;
	private String duration;
	private int del;
	private String teacherid;
	private int shanghai;
	private String slocationcode;
	private String slocation;
	private String locationcode;
	private String location;
	private int num;
	private int bid;

	public LeaveBean(long id,String userid, String username, String classid, String classname, String majorid,
			String majorname, String collegeid, String collegename, String teachername, String teacherphone,
			String linkname, String linkphone, Timestamp outtime, Timestamp intime, int typeid, String typename,
			String remarks, String img, int status, int tstatus, int cstatus, int sstatus, int jstatus, Timestamp cdt,
			Timestamp dt, String routtime, String rintime, String fevernum, String duration, int del, String teacherid,
			int shanghai, String slocationcode, String slocation, String locationcode, String location, int num,
			int bid) {
		this.ticketid = id;
		this.userid = userid;
		this.username = username;
		this.classid = classid;
		this.classname = classname;
		this.majorid = majorid;
		this.majorname = majorname;
		this.collegeid = collegeid;
		this.collegename = collegename;
		this.teachername = teachername;
		this.teacherphone = teacherphone;
		this.linkname = linkname;
		this.linkphone = linkphone;
		this.outtime = outtime;
		this.intime = intime;
		this.typeid = typeid;
		this.typename = typename;
		this.remarks = remarks;
		this.img = img;
		this.status = status;
		this.tstatus = tstatus;
		this.cstatus = cstatus;
		this.sstatus = sstatus;
		this.jstatus = jstatus;
		this.cdt = cdt;
		this.dt = dt;
		this.routtime = routtime;
		this.rintime = rintime;
		this.fevernum = fevernum;
		this.duration = duration;
		this.del = del;
		this.teacherid = teacherid;
		this.shanghai = shanghai;
		this.slocationcode = slocationcode;
		this.slocation = slocation;
		this.locationcode = locationcode;
		this.location = location;
		this.num = num;
		this.bid = bid;
	}

	public long getTicketid() {
		return ticketid;
	}

	public void setTicketid(long ticketid) {
		this.ticketid = ticketid;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getClassname() {
		return classname;
	}

	public void setMajorid(String majorid) {
		this.majorid = majorid;
	}

	public String getMajorid() {
		return majorid;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	public String getMajorname() {
		return majorname;
	}

	public void setCollegeid(String collegeid) {
		this.collegeid = collegeid;
	}

	public String getCollegeid() {
		return collegeid;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public String getCollegename() {
		return collegename;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeacherphone(String teacherphone) {
		this.teacherphone = teacherphone;
	}

	public String getTeacherphone() {
		return teacherphone;
	}

	public void setLinkname(String linkname) {
		this.linkname = linkname;
	}

	public String getLinkname() {
		return linkname;
	}

	public void setLinkphone(String linkphone) {
		this.linkphone = linkphone;
	}

	public String getLinkphone() {
		return linkphone;
	}

	public void setOuttime(Timestamp outtime) {
		this.outtime = outtime;
	}

	public Timestamp getOuttime() {
		return outtime;
	}

	public void setIntime(Timestamp intime) {
		this.intime = intime;
	}

	public Timestamp getIntime() {
		return intime;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getTypename() {
		return typename;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImg() {
		return img;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setTstatus(int tstatus) {
		this.tstatus = tstatus;
	}

	public int getTstatus() {
		return tstatus;
	}

	public void setCstatus(int cstatus) {
		this.cstatus = cstatus;
	}

	public int getCstatus() {
		return cstatus;
	}

	public void setSstatus(int sstatus) {
		this.sstatus = sstatus;
	}

	public int getSstatus() {
		return sstatus;
	}

	public void setJstatus(int jstatus) {
		this.jstatus = jstatus;
	}

	public int getJstatus() {
		return jstatus;
	}

	public void setCdt(Timestamp cdt) {
		this.cdt = cdt;
	}

	public Timestamp getCdt() {
		return cdt;
	}

	public void setDt(Timestamp dt) {
		this.dt = dt;
	}

	public Timestamp getDt() {
		return dt;
	}

	public void setRouttime(String routtime) {
		this.routtime = routtime;
	}

	public String getRouttime() {
		return routtime;
	}

	public void setRintime(String rintime) {
		this.rintime = rintime;
	}

	public String getRintime() {
		return rintime;
	}

	public void setFevernum(String fevernum) {
		this.fevernum = fevernum;
	}

	public String getFevernum() {
		return fevernum;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDuration() {
		return duration;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getDel() {
		return del;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

	public String getTeacherid() {
		return teacherid;
	}

	public void setShanghai(int shanghai) {
		this.shanghai = shanghai;
	}

	public int getShanghai() {
		return shanghai;
	}

	public void setSlocationcode(String slocationcode) {
		this.slocationcode = slocationcode;
	}

	public String getSlocationcode() {
		return slocationcode;
	}

	public void setSlocation(String slocation) {
		this.slocation = slocation;
	}

	public String getSlocation() {
		return slocation;
	}

	public void setLocationcode(String locationcode) {
		this.locationcode = locationcode;
	}

	public String getLocationcode() {
		return locationcode;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getBid() {
		return bid;
	}

	@Override
	public String toString() {
		return "LeaveBean [id=" + id + ", ticketid=" + ticketid + ", userid=" + userid + ", username=" + username
				+ ", classid=" + classid + ", classname=" + classname + ", majorid=" + majorid + ", majorname="
				+ majorname + ", collegeid=" + collegeid + ", collegename=" + collegename + ", teachername="
				+ teachername + ", teacherphone=" + teacherphone + ", linkname=" + linkname + ", linkphone=" + linkphone
				+ ", outtime=" + outtime + ", intime=" + intime + ", typeid=" + typeid + ", typename=" + typename
				+ ", remarks=" + remarks + ", img=" + img + ", status=" + status + ", tstatus=" + tstatus + ", cstatus="
				+ cstatus + ", sstatus=" + sstatus + ", jstatus=" + jstatus + ", cdt=" + cdt + ", dt=" + dt
				+ ", routtime=" + routtime + ", rintime=" + rintime + ", fevernum=" + fevernum + ", duration="
				+ duration + ", del=" + del + ", teacherid=" + teacherid + ", shanghai=" + shanghai + ", slocationcode="
				+ slocationcode + ", slocation=" + slocation + ", locationcode=" + locationcode + ", location="
				+ location + ", num=" + num + ", bid=" + bid + "]";
	}

}
