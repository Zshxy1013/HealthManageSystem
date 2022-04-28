package core.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import core.bean.CookieBean;
import core.bean.LeaveListBean;
import core.bean.UserDataBean;
import core.dao.CookieCacheDao;

public class GenchPlatformAuth {
	final String headerAgent = "User-Agent";
	final String headerAgentArg = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:98.0) Gecko/20100101 Firefox/98.0";
	String ssohqCookie = null;
	String genchInformationSystemUrl = null;
	UserDataBean uDataBean = null;
	CookieManager manager = new CookieManager();
	CookieBean cookieBean = null;

	public GenchPlatformAuth(UserDataBean uDataBean) {
		super();
		this.uDataBean = uDataBean;
		this.cookieBean = new CookieBean(uDataBean.getStuSchoolID());
		manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
		CookieHandler.setDefault(manager);
	}

	public int webAuth() {
		String loginURL = "https://cas.gench.edu.cn/cas/login?service=http%3A%2F%2Fi1.gench.edu.cn%2F_web%2Ffusionportal%2Fwelcome.jsp%3F_p%3DYXM9MSZwPTEmbT1OJg__0";
		String formData = "";
		byte[] buffer;
		byte[] all;
		int length;
		ArrayList<byte[]> byteList;
		ArrayList<Integer> byteLength;
		int totalLength = 0;
		String execution = null;
		try {
			// 初次GET请求CAS平台，获得Cookie和登录时表单所需的execution参数，execution默认隐藏，主要用于简单的防止模拟登录
			HttpURLConnection httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.connect();
			if (httpURLConnection.getResponseCode() == 200) {
				InputStream inputStream = httpURLConnection.getInputStream();
				buffer = new byte[1024];
				byteList = new ArrayList<>();
				byteLength = new ArrayList<>();
				while ((length = inputStream.read(buffer)) != -1) {
					byteList.add(buffer);
					byteLength.add(length);
					totalLength += length;
					buffer = new byte[1024];
				}
				httpURLConnection.disconnect();
				all = new byte[totalLength];
				totalLength = 0;
				while (byteList.size() != 0) {
					System.arraycopy(byteList.get(0), 0, all, totalLength, byteLength.get(0));
					totalLength += byteLength.get(0);
					byteList.remove(0);
					byteLength.remove(0);
				}
				execution = new String(all, "UTF-8").split("name=\"execution\" value=\"")[1].split("\" />")[0];
				System.out.println("[Log] Auth.casAuthInterface->getExecution Success");
				formData = formData + "username=" + uDataBean.getStuSchoolID() + "&password=" + uDataBean.getStuPasswd()
						+ "&execution=" + execution + "&encrypted=true&_eventId=submit&loginType=1";
				// printCookie(manager.getCookieStore());
				// System.out.print(formData);

				// 第二次POST请求登录接口，传入execution和账号密码等信息
				httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
				httpURLConnection.setInstanceFollowRedirects(false);
				httpURLConnection.setRequestMethod("POST");
				httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
				httpURLConnection.setDoOutput(true);
				httpURLConnection.connect();
				httpURLConnection.getOutputStream().write(formData.getBytes("UTF-8"));
				inputStream = httpURLConnection.getInputStream();
				buffer = new byte[1024];
				byteList = new ArrayList<>();
				byteLength = new ArrayList<>();
				totalLength = 0;
				while ((length = inputStream.read(buffer)) != -1) {
					byteList.add(buffer);
					byteLength.add(length);
					totalLength += length;
					buffer = new byte[1024];
				}
				httpURLConnection.disconnect();
				all = new byte[totalLength];
				totalLength = 0;
				while (byteList.size() != 0) {
					System.arraycopy(byteList.get(0), 0, all, totalLength, byteLength.get(0));
					totalLength += byteLength.get(0);
					byteList.remove(0);
					byteLength.remove(0);
				}
				if (httpURLConnection.getResponseCode() != 302) {
					// 模拟登录失败
					return -1;
				}
				System.out.println("[Log] Auth.casAuthInterface->cookieTry Success");
				this.genchInformationSystemUrl = httpURLConnection.getHeaderField("Location");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return -3;
		}
		return 1;
	}

	public void genchInformationLogin() {
		this.getApiResponse(this.genchInformationSystemUrl);
		System.out.println("[Log] Auth.genchInfoLoginInterface->cookieTry Success");
	}

	public void checkiHealthCookieAvailable() {
		String url = "http://ihealth.hq.gench.edu.cn/api/login/clearSession";
		// 查找是否存在Cookie缓存
		CookieCacheDao.findCookie(cookieBean);
		// 如果存在Cookie缓存，那么直接试图使用Cookie获取请求
		if (cookieBean.getStatusCode() == 200) {
			String res = getApiResponse(url, cookieBean.getSsohqCookie());
			//
			if (res.indexOf("\"suc\":false") != -1) {
				// Cookie已经失效
				cookieBean.setCookieValidStatus(-1);
			}

			// 建桥i健康防爬虫及DDOS检测，一般会在晚上8点左右启用，8点10分左右结束，只对ssohq来访的用户起效
			// 这种防爬策略的启用也和页面访问压力有关系，在服务器后端压力很大的时候也会不定期启用，具体的页面样式可以参考下面
			// <meta http-equiv="refresh"
			// content="0;url=http://ihealth.hq.gench.edu.cn/api/login/clearSession?cbaimohdjmglfkng">
			if (res.indexOf("0;url=") != -1) {
				// 提取跳转的URL
				url = res.split("0;url=")[1].split("\">")[0];
				System.out.println("检测到反爬虫页面，302跳转的URL=" + url);
				// 对特殊的302跳转页面请求一次，让系统误以为你是真的浏览器客户端，对你的IP加白，有效期24小时
				// 需要注意的是，判断你是否应该跳转不是通过Cookie，而是仅根据IP，如果同一IP之前已经加白过，后续换其他账号的Cookie也不会再遇到跳转
				this.getApiResponse(url, ssohqCookie);
			}
		} else {
			// 没有找到缓存
			cookieBean.setCookieValidStatus(-2);
		}
	}

	public int iHealthLogin() {
		checkiHealthCookieAvailable();
		if (cookieBean.getCookieValidStatus() == 0) {
			// Cookie缓存命中且有效，跳过登录
			ssohqCookie = cookieBean.getSsohqCookie();
			System.out.println("[Log] ssohq_703 Cache Cookie is Available. Nothing to do.");
			return 0;
		}

		System.out.println("[Log] ssohq_703 Cache Cookie is Unavailable. Try to Get A New One.");
		// 调用信息门户的登录模块，登录cas，准备工作
		if (this.webAuth() == -1) {
			System.out.println("[Log] msg=信息门户登录失败，用户名或密码不正确");
			return -1;
		}
		// 开始登录建桥后勤系统（i健康PC入口都是通过建桥后勤系统登录的）
		try {
			// 访问跳转接口，后勤系统收到i健康的登录请求后会Set-Cookie
			// ssohq_jump_703，这个Cookie在统一身份认证cas平台通过后会被ssohq_703正式替代
			String loginURL = "https://ssohq.gench.edu.cn/sso/step?url=https%3A%2F%2Fihealth.hq.gench.edu.cn%2Fmp%2Findex";
			HttpURLConnection httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
			httpURLConnection.setRequestProperty("Host", "ssohq.gench.edu.cn");
			httpURLConnection.setUseCaches(false);
			httpURLConnection.setInstanceFollowRedirects(true);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.connect();
			httpURLConnection.getInputStream();
			System.out.println("[Log] Auth.ssohq->getCookie(ssohq_jump_703) Success");

			String cookieVal = httpURLConnection.getHeaderField("Set-Cookie");

			// 后勤登录接口，申请要登录后勤系统的Ticket，并302跳转到统一身份认证cas平台
			loginURL = "https://ssohq.gench.edu.cn/cas/login";
			httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
			httpURLConnection.setInstanceFollowRedirects(false);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestProperty("Cookie", cookieVal);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.connect();
			httpURLConnection.disconnect();

			// 统一身份认证cas平台验证通过后，批准ticket，跳转回后勤系统接口
			loginURL = httpURLConnection.getHeaderField("Location");
			httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
			httpURLConnection.setInstanceFollowRedirects(false);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestProperty("Cookie", cookieVal);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.connect();
			httpURLConnection.disconnect();

			// 后勤系统登录成功，并且根据已经被cas平台认证的ssohq_jump_703，赋予正式的ssohq_703
			// Cookie，后续iHealth系统只需要ssohq_703
			loginURL = httpURLConnection.getHeaderField("Location");
			httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
			httpURLConnection.setInstanceFollowRedirects(false);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestProperty("Cookie", cookieVal);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.connect();
			httpURLConnection.disconnect();

			loginURL = httpURLConnection.getHeaderField("Location");
			httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
			httpURLConnection.setInstanceFollowRedirects(false);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.connect();
			cookieVal = httpURLConnection.getHeaderField("Set-Cookie");
			System.out.println("[Log] Auth.ssohq->getCookie(ssohq_703) Success");
			System.out.println("[Log] Auth.iHealth->cookieTry Success");
			httpURLConnection.disconnect();

			// 将cookie缓存
			cookieBean.setSsohqCookie(cookieVal);
			CookieCacheDao.setCookie(cookieBean);
			return 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return -1;
		}
	}

	private String getApiResponse(String apiUrl, String cookieVal) {
		byte[] buffer;
		byte[] all;
		String res = null;
		int length;
		ArrayList<byte[]> byteList;
		ArrayList<Integer> byteLength;
		int totalLength = 0;
		HttpURLConnection httpURLConnection;

		try {
			httpURLConnection = (HttpURLConnection) (new URL(apiUrl).openConnection());
			httpURLConnection.setInstanceFollowRedirects(false);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty("Cookie", cookieVal);
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.connect();
			httpURLConnection.disconnect();

			if (httpURLConnection.getResponseCode() == 200) {
				InputStream inputStream = httpURLConnection.getInputStream();
				buffer = new byte[1024];
				byteList = new ArrayList<>();
				byteLength = new ArrayList<>();
				while ((length = inputStream.read(buffer)) != -1) {
					byteList.add(buffer);
					byteLength.add(length);
					totalLength += length;
					buffer = new byte[1024];
				}
				httpURLConnection.disconnect();
				all = new byte[totalLength];
				totalLength = 0;
				while (byteList.size() != 0) {
					System.arraycopy(byteList.get(0), 0, all, totalLength, byteLength.get(0));
					totalLength += byteLength.get(0);
					byteList.remove(0);
					byteLength.remove(0);
				}
				res = new String(all, "utf-8");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	private String getApiResponse(String apiUrl) {
		byte[] buffer;
		byte[] all;
		String res = null;
		int length;
		ArrayList<byte[]> byteList;
		ArrayList<Integer> byteLength;
		int totalLength = 0;
		HttpURLConnection httpURLConnection;

		try {
			httpURLConnection = (HttpURLConnection) (new URL(apiUrl).openConnection());
			httpURLConnection.setInstanceFollowRedirects(false);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty("Cookie", ssohqCookie);
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.connect();
			httpURLConnection.disconnect();

			if (httpURLConnection.getResponseCode() == 200) {
				InputStream inputStream = httpURLConnection.getInputStream();
				buffer = new byte[1024];
				byteList = new ArrayList<>();
				byteLength = new ArrayList<>();
				while ((length = inputStream.read(buffer)) != -1) {
					byteList.add(buffer);
					byteLength.add(length);
					totalLength += length;
					buffer = new byte[1024];
				}
				httpURLConnection.disconnect();
				all = new byte[totalLength];
				totalLength = 0;
				while (byteList.size() != 0) {
					System.arraycopy(byteList.get(0), 0, all, totalLength, byteLength.get(0));
					totalLength += byteLength.get(0);
					byteList.remove(0);
					byteLength.remove(0);
				}
				res = new String(all, "utf-8");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	/**
	 *
	 * @param httpUrl 请求的url
	 * @param param   form表单的参数（key,value形式）
	 * @return
	 */
	public static String doPostForm(String httpUrl, Map<String, String> param) {

		HttpURLConnection connection = null;
		InputStream is = null;
		OutputStream os = null;
		BufferedReader br = null;
		String result = null;
		try {
			URL url = new URL(httpUrl);
			// 通过远程url连接对象打开连接
			connection = (HttpURLConnection) url.openConnection();
			// 设置连接请求方式
			connection.setRequestMethod("POST");
			// 设置连接主机服务器超时时间：15000毫秒
			connection.setConnectTimeout(15000);
			// 设置读取主机服务器返回数据超时时间：60000毫秒
			connection.setReadTimeout(60000);

			// 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
			connection.setDoOutput(true);
			// 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
			connection.setDoInput(true);
			// 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			// 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
			// connection.setRequestProperty("Authorization", "Bearer
			// da3efcbf-0845-4fe3-8aba-ee040be542c0");
			// 通过连接对象获取一个输出流
			os = connection.getOutputStream();

			// 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的(form表单形式的参数实质也是key,value值的拼接，类似于get请求参数的拼接)
			os.write(createLinkString(param).getBytes("UTF-8"));

			// 通过连接对象获取一个输入流，向远程读取
			if (connection.getResponseCode() == 200) {

				is = connection.getInputStream();
				// 对输入流对象进行包装:charset根据工作项目组的要求来设置
				br = new BufferedReader(new InputStreamReader(is, "utf-8"));

				StringBuffer sbf = new StringBuffer();
				String temp = null;
				// 循环遍历一行一行读取数据
				while ((temp = br.readLine()) != null) {
					sbf.append(temp);
					sbf.append("\r\n");
				}
				result = sbf.toString();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != os) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// 断开与远程地址url的连接
			connection.disconnect();
		}
		return result;
	}

	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * @param params 需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public static String createLinkString(Map<String, String> params) {

		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);

		StringBuilder prestr = new StringBuilder();
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);
			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				prestr.append(key).append("=").append(value);
			} else {
				prestr.append(key).append("=").append(value).append("&");
			}
		}

		return prestr.toString();
	}

	public void getStuData() {
		String url = "http://ihealth.hq.gench.edu.cn/api/login/clearSession";
		JSONObject jsonObject = JSONObject.parseObject(this.getApiResponse(url));
		jsonObject = jsonObject.getJSONObject("data").getJSONObject("userInfo");
		// uuid
		uDataBean.setStuUuid(jsonObject.getString("uuid"));
		// 学生姓名
		uDataBean.setStuName(jsonObject.getString("username"));
		// 学生住址
		uDataBean.setStuAddress(jsonObject.getString("address"));
		// 学生电话
		uDataBean.setStuTelephone(jsonObject.getString("phone"));
		// 学生身份证
		uDataBean.setStuIDCard(jsonObject.getString("idcard"));
		// 学生性别
		uDataBean.setStuSex(jsonObject.getString("gender"));
		// 学生班级
		uDataBean.setStuClass(jsonObject.getString("classname"));
		// 学生专业
		uDataBean.setStuMajor(jsonObject.getString("majorname"));
		// 辅导员工号
		uDataBean.setCounsellorID(jsonObject.getString("teacherid"));
		// 辅导员姓名
		uDataBean.setCounsellorName(jsonObject.getString("teachername"));
		// 辅导员手机
		uDataBean.setCounsellorPhone(jsonObject.getString("teacherphone"));
		// 学生学院id
		uDataBean.setStuCollegeid(jsonObject.getString("collegeid"));
		// 学生专业id
		uDataBean.setStuMajorid(jsonObject.getString("majorid"));
		// 学生学院
		uDataBean.setStuCollege(jsonObject.getString("collegename"));
		// 学生班级id
		uDataBean.setStuClassid(jsonObject.getString("classid"));
		System.out.println("[Log] Auth.iHealth->getStudentInformation Success");
	}

	// 从学校请假接口获取数据
	public LeaveListBean getLeaveData(String i) {
		String url = "http://ihealth.hq.gench.edu.cn/api/LAskleaveAp/pagebyme";
		Map<String, String> map = new HashMap<>();
		map.put("page", i);
		map.put("size", "3");

		String formResult = GenchPlatformAuth.doPostForm(url, map);
		return (JSON.parseObject(formResult, LeaveListBean.class));
	}

	public static void main(String args[]) {
		UserDataBean uDataBean = new UserDataBean("1922538", "Zs165301");

		GenchPlatformAuth auth = new GenchPlatformAuth(uDataBean);

		auth.iHealthLogin();
		System.out.println(auth.getLeaveData("1"));

	}
}
