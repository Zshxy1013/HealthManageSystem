package core.service;

import core.bean.LeaveBean;
import core.bean.LeaveListBean;
import core.bean.QRCodeData;
import core.bean.RecordListBean;
import core.bean.UserDataBean;
import core.dao.LeaveDataDao;
import core.util.PageUtils;

public class LeaveDataService {
	public static void leaveDataSave(LeaveBean leaveBean) {
		LeaveDataDao.saveLeaveData(leaveBean);
	}
	public static void leaveDataCheck(QRCodeData qRCodeData) {
		LeaveDataDao.checkLeaveData(qRCodeData);
	}
	
	public static void selectStuLeaveData(UserDataBean uDataBean,LeaveListBean leaveListBean, PageUtils pageUtils) {
		LeaveDataDao.selectStuLeaveData(uDataBean,leaveListBean,pageUtils);
	}
}
