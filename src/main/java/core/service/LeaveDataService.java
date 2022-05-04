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
	
	public static void selectStuLeaveDataByTicketID(int ticketID, LeaveBean leaveBean) {
		LeaveDataDao.selectStuLeaveDataByTicketID(ticketID, leaveBean);
	}
	
	public static void updateLeaveDataForLeftTime(int ticketID) {
		LeaveDataDao.updateLeaveDataForLeftTime(ticketID);
	}
	
	public static void selectStuLeaveData(UserDataBean uDataBean,LeaveListBean leaveListBean, PageUtils pageUtils) {
		LeaveDataDao.selectStuLeaveData(uDataBean,leaveListBean,pageUtils);
	}
	
	public static void selectStuLeaveDataForTeacher(LeaveListBean leaveListBean, PageUtils pageUtils) {
		// TODO Auto-generated method stub
		LeaveDataDao.selectStuLeaveDataForTeacher(leaveListBean,pageUtils);
	}
	
	public static void updateLeaveData(String ticketID, int updateID) {
		// TODO Auto-generated method stub
		// updateID 
		// 1 - 待审核
		// 2 - 审核通过
		// 3 - 审核拒绝
		LeaveDataDao.updateLeaveData(ticketID, updateID);
	}
}
