package core.service;

import core.bean.UserDataBean;
import core.dao.UserDataDao;

public class UserDataService {
	public static void updateUserData(GenchPlatformAuth genchPlatformAuth, UserDataBean uDataBean) {
		UserDataDao.checkUserData(genchPlatformAuth, uDataBean);
	}
}
