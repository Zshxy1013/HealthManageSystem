package core.bean;

public class UserDataBean {
	/***
	 * 数据库相关 dbIDCode 数据库序列号 dbOperateStatusCode 查询定义码 - 200 成功 - 400 重复插入 - 403 无权限
	 * - 404 未找到数据 - 503 数据库连接异常
	 ***/
	int dbIDCode;
	int dbOperateStatusCode;

	/***
	 * 学生数据信息相关 stuSchoolID 学生学号 stuName 学生姓名 stuPasswd 学生密码 stuTelephone 学生手机号码
	 * stuSex 学生性别 === 以下为数据库演示部分不获取，使用FakeData生成的假数据 === stuIDCard 学生身份证 stuAddress
	 * 学生家庭住址 parentName 家长姓名 parentPhone 家长电话 counsellorID 辅导员工号 counsellorName
	 * 辅导员姓名 counsellorPhone 辅导员电话
	 ***/
	private String stuSchoolID;
	private String stuUuid;
	private String stuName;
	private String stuPasswd;
	private String stuClass;
	private String stuMajor;
	private String stuTelephone;
	private String stuSex;
	private String stuIDCard;
	private String stuAddress;
	private String counsellorID;
	private String counsellorName;
	private String counsellorPhone;

	public UserDataBean(String stuSchoolID, String stuPasswd) {
		this.stuSchoolID = stuSchoolID;
		this.stuPasswd = stuPasswd;
	}


	public int getDbIDCode() {
		return dbIDCode;
	}

	public String getStuUuid() {
		return stuUuid;
	}

	public void setStuUuid(String stuUuid) {
		this.stuUuid = stuUuid;
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

	public String getStuClass() {
		return stuClass;
	}

	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}

	public String getStuMajor() {
		return stuMajor;
	}

	public void setStuMajor(String stuMajor) {
		this.stuMajor = stuMajor;
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

}
