package core.bean;

public class CookieBean {
	int statusCode;
	int cookieValidStatus;
	private String staffID;
	private String ssohqCookie;

	public CookieBean(String staffID) {
		super();
		this.staffID = staffID;
	}

	public CookieBean(String staffID, String ssohqCookie) {
		super();
		this.staffID = staffID;
		this.ssohqCookie = ssohqCookie;
	}

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public String getSsohqCookie() {
		return ssohqCookie;
	}

	public void setSsohqCookie(String ssohqCookie) {
		this.ssohqCookie = ssohqCookie;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getCookieValidStatus() {
		return cookieValidStatus;
	}

	public void setCookieValidStatus(int cookieValidStatus) {
		this.cookieValidStatus = cookieValidStatus;
	}

}
