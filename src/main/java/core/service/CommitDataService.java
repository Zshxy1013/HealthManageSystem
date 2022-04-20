package core.service;

import core.bean.RecordDataBean;
import core.dao.RecordDataDao;

public class CommitDataService {
	public static void UpdateCommitData(RecordDataBean recorddatabean) {
		RecordDataDao.InsertCommitData(recorddatabean);
	}

}
