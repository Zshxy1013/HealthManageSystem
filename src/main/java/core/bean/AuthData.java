package core.bean;

public class AuthData {
	boolean success;
	String msg;
	
	
	
	public AuthData(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}	
	
	
}
