package core.service;

import core.bean.AdminBean;
import core.bean.UserDataBean;
import core.dao.UserDataDao;

public class UserDataService {
	public static void updateUserData(GenchPlatformAuth genchPlatformAuth, UserDataBean uDataBean) {
		UserDataDao.checkUserData(genchPlatformAuth, uDataBean);
	}

	public static void checkAdminData(AdminBean aDataBean) {
		UserDataDao.checkAdminData(aDataBean);
	}
}
