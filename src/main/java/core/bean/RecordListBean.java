package core.bean;

import java.util.ArrayList;

public class RecordListBean {

	private ArrayList<RecordDataBean> recordDataList;

	public RecordListBean(ArrayList<RecordDataBean> recordDataList) {
		this.recordDataList = recordDataList;
	}

	public RecordListBean() {

	}

	public ArrayList<RecordDataBean> getRecordDataList() {
		return recordDataList;
	}

	public void setRecordDataList(ArrayList<RecordDataBean> recordDataList) {
		this.recordDataList = recordDataList;
	}

	@Override
	public String toString() {
		return "RecordListBean [recordDataList=" + recordDataList + "]";
	}

}
