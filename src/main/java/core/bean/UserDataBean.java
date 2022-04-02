package core.bean;

public class UserDataBean {
	/***
	 * ���ݿ����
	 * dbIDCode ���ݿ����к�
	 * dbOperateStatusCode ��ѯ������
	 * - 200 �ɹ�
	 * - 400 �ظ�����
	 * - 404 δ�ҵ�����
	 ***/
	int dbIDCode;
	int dbOperateStatusCode;
	
	/***
	 * ѧ��������Ϣ���
	 * stuSchoolID ѧ��ѧ��
	 * stuName ѧ������
	 * stuPasswd ѧ������
	 * stuTelephone ѧ���ֻ�����
	 * stuSex ѧ���Ա�
	 * === ����Ϊ���ݿ���ʾ���ֲ���ȡ��ʹ��FakeData���ɵļ����� ===
	 * stuIDCard ѧ�����֤
	 * stuAddress ѧ����ͥסַ
	 * parentName �ҳ�����
	 * parentPhone �ҳ��绰
	 * counsellorID ����Ա����
	 * counsellorName ����Ա����
	 * counsellorPhone ����Ա�绰
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
		this.setStuName("�����");
		this.setStuSex("M");
		this.setStuTelephone("13918062552");
		// �������ݿ�����ȡ��Щ��Ϣ
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
				"���ݿ����״̬�룺"+ this.dbIDCode + "\n"+
				"������š���Select״̬����Ч����" + this.dbIDCode + "\n"+
				"��ѧ����Ϣ ��" + "\n"+
				"ѧ��ѧ�ţ�" + this.stuSchoolID + "\n"+
				"ѧ��������" + this.stuName + "\n"+
				"ѧ���Ա�" + this.stuSex + "\n" +
				"ѧ�����룺" + this.stuPasswd + "\n" +
				"ѧ���ֻ��ţ�" + this.stuTelephone + "\n"
				);
	}

	public static void main(String args[]) {
		UserDataBean userData = new UserDataBean(1922518, "leo123");
		userData.debugPrintObject();
	}
}
