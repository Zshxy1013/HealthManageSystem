package core.service;

import core.bean.RecordListBean;
import core.bean.UserDataBean;
import core.dao.RecordDataDao;
import core.util.PageUtils;

public class SelectRecordData {
	public static void selectRecordData(RecordListBean recordDataList, PageUtils pageUtils) {
		RecordDataDao.SelectRecordData(recordDataList, pageUtils);
	}
	
	public static void selectStuRecordData(UserDataBean uDataBean,RecordListBean recordDataList, PageUtils pageUtils) {
		RecordDataDao.SelectStuRecordData(uDataBean,recordDataList, pageUtils);
	}

}
