package core.service;

import core.bean.RecordDataBean;
import core.dao.CommitDataDao;

public class CommitDataService {
	public static void UpdateCommitData(RecordDataBean recorddatabean) {
		CommitDataDao.InsertCommitData(recorddatabean);
	}
	

}
