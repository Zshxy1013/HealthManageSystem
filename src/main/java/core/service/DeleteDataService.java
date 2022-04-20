package core.service;

import core.bean.RecordDataBean;
import core.dao.RecordDataDao;

public class DeleteDataService {
	public static void DeleteRecordData(RecordDataBean recordDataBean) {
		RecordDataDao.DeleteRecordData(recordDataBean);
	}
}
