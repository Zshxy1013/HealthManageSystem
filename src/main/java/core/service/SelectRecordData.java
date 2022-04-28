package core.service;

import core.bean.RecordListBean;
import core.dao.RecordDataDao;
import core.util.PageUtils;

public class SelectRecordData {
	public static void selectRecordData(RecordListBean recordDataList, PageUtils pageUtils) {
		RecordDataDao.SelectRecordData(recordDataList, pageUtils);
	}

}
