package core.service;

import core.bean.LeaveBean;
import core.dao.LeaveDataDao;

public class LeaveDataService {
	public static void leaveDataSave(LeaveBean leaveBean) {
		LeaveDataDao.saveLeaveData(leaveBean);
	}
}
