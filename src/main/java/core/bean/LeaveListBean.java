package core.bean;

import java.util.List;


public class LeaveListBean {
	
   private int total;
   private List<LeaveBean> records;
   
   
   public LeaveListBean(int total, List<LeaveBean> records) {
	this.total = total;
	this.records = records;
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
		return "LeaveListBean [total=" + total + ", records=" + records + "]";
	}

}