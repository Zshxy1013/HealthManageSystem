package core.bean;

public class UserDataBean {
	/***
	 * 数据库相关
	 * dbIDCode 数据库序列号
	 * dbOperateStatusCode 查询定义码
	 * - 200 成功
	 * - 400 重复插入
	 * - 403 无权限
	 * - 404 未找到数据
	 * - 503 数据库连接异常
	 ***/
	int dbIDCode;
	int dbOperateStatusCode;
	
	/***
	 * 学生数据信息相关
	 * stuSchoolID 学生学号
	 * stuName 学生姓名
	 * stuPasswd 学生密码
	 * stuTelephone 学生手机号码
	 * stuSex 学生性别
	 * === 以下为数据库演示部分不获取，使用FakeData生成的假数据 ===
	 * stuIDCard 学生身份证
	 * stuAddress 学生家庭住址
	 * parentName 家长姓名
	 * parentPhone 家长电话
	 * counsellorID 辅导员工号
	 * counsellorName 辅导员姓名
	 * counsellorPhone 辅导员电话
	 ***/
	private String stuSchoolID;
	private String stuName;
	private String stuPasswd;
	private String stuTelephone;
	private String stuSex;
	private String stuIDCard;
	private String stuAddress;
	private String parentName;
	private String parentPhone;
	private String counsellorID;
	private String counsellorName;
	private String counsellorPhone;
	
	public UserDataBean(int stuSchoolID, String stuPasswd) {
		super();
		this.stuSchoolID = Integer.toString(stuSchoolID);
		this.stuPasswd = stuPasswd;
		this.updateData();
	}
	
	private void updateData() {
		// Demo
		this.setStuName("沈嘉乐");
		this.setStuSex("M");
		this.setStuTelephone("13918062552");
		// 请在数据库里拿取这些信息
	}
	
	public int getDbIDCode() {
		return dbIDCode;
	}
	public void setDbIDCode(int dbIDCode) {
		this.dbIDCode = dbIDCode;
	}
	public int getDbOperateStatusCode() {
		return dbOperateStatusCode;
	}
	public void setDbOperateStatusCode(int dbOperateStatusCode) {
		this.dbOperateStatusCode = dbOperateStatusCode;
	}
	public String getStuSchoolID() {
		return stuSchoolID;
	}
	public void setStuSchoolID(String stuSchoolID) {
		this.stuSchoolID = stuSchoolID;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuPasswd() {
		return stuPasswd;
	}
	public void setStuPasswd(String stuPasswd) {
		this.stuPasswd = stuPasswd;
	}
	public String getStuTelephone() {
		return stuTelephone;
	}
	public void setStuTelephone(String stuTelephone) {
		this.stuTelephone = stuTelephone;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public String getStuIDCard() {
		return stuIDCard;
	}
	public void setStuIDCard(String stuIDCard) {
		this.stuIDCard = stuIDCard;
	}
	public String getStuAddress() {
		return stuAddress;
	}
	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getParentPhone() {
		return parentPhone;
	}
	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
	}
	public String getCounsellorID() {
		return counsellorID;
	}
	public void setCounsellorID(String counsellorID) {
		this.counsellorID = counsellorID;
	}
	public String getCounsellorName() {
		return counsellorName;
	}
	public void setCounsellorName(String counsellorName) {
		this.counsellorName = counsellorName;
	}
	public String getCounsellorPhone() {
		return counsellorPhone;
	}
	public void setCounsellorPhone(String counsellorPhone) {
		this.counsellorPhone = counsellorPhone;
	}
	
	public void debugPrintObject() {
		System.out.println(
				"数据库操作状态码："+ this.dbIDCode + "\n"+
				"数据序号「仅Select状态下有效」：" + this.dbIDCode + "\n"+
				"『学生信息 』" + "\n"+
				"学生学号：" + this.stuSchoolID + "\n"+
				"学生姓名：" + this.stuName + "\n"+
				"学生性别：" + this.stuSex + "\n" +
				"学生密码：" + this.stuPasswd + "\n" +
				"学生手机号：" + this.stuTelephone + "\n"
				);
	}

	public static void main(String args[]) {
		UserDataBean userData = new UserDataBean(1922518, "leo123");
		userData.debugPrintObject();
	}
}
