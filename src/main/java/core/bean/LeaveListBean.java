package core.bean;

import java.util.List;

public class LeaveListBean {
	private int currentPage;
	private int total;
	private String stuSchoolID;
	private List<LeaveBean> records;

	public LeaveListBean(int total, List<LeaveBean> records) {
		this.total = total;
		this.records = records;
	}
	
	public LeaveListBean(String stuSchoolID) {
		this.stuSchoolID = stuSchoolID;
	}

	
	
	public String getStuSchoolID() {
		return stuSchoolID;
	}

	public void setStuSchoolID(String stuSchoolID) {
		this.stuSchoolID = stuSchoolID;
	}

	public LeaveListBean() {

	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal() {
		return total;
	}

	public void setRecords(List<LeaveBean> records) {
		this.records = records;
	}

	public List<LeaveBean> getRecords() {
		return records;
	}
	
	@Override
	public String toString() {
		return "LeaveListBean [currentPage=" + currentPage + ", total=" + total + ", records=" + records + "]";
	}

}