package core.service;

import core.bean.UserDataBean;
import core.dao.UserDataDao;

public class UserDataService {
	public static void updateUserData(UserDataBean uDataBean) {
		UserDataDao.checkUserData(uDataBean);
	}
}
