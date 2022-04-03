package core.bean;

public class AdminBean {
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
	
	private String adminID;
	private String adminPasswd;
	
	public AdminBean(String adminID, String adminPasswd) {
		this.adminID = adminID;
		this.adminPasswd = adminPasswd;
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

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getAdminPasswd() {
		return adminPasswd;
	}

	public void setAdminPasswd(String adminPasswd) {
		this.adminPasswd = adminPasswd;
	}
	
}
