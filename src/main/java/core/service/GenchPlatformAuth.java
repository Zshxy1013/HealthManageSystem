package core.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.alibaba.fastjson.JSONObject;

import core.bean.UserDataBean;

public class GenchPlatformAuth {
	final String headerAgent = "User-Agent";
	final String headerAgentArg = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:98.0) Gecko/20100101 Firefox/98.0";
	UserDataBean uDataBean = null;
	CookieManager manager = new CookieManager();

	public GenchPlatformAuth(UserDataBean uDataBean) {
		super();
		this.uDataBean = uDataBean;
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
			// 初次请求，获得Cookie
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
				System.out.println("获取execution成功！execution=" + execution);
				formData = formData + "username=" + uDataBean.getStuSchoolID() + "&password=" + uDataBean.getStuPasswd()
						+ "&execution=" + execution + "&encrypted=true&_eventId=submit&loginType=1";
				// printCookie(manager.getCookieStore());
				// System.out.print(formData);

				// 第二次Post请求，传入登录信息
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
				// System.out.print(new String(all, "UTF-8"));
				if (httpURLConnection.getResponseCode() != 302) {
					// 模拟登录失败
					return -1;
				} 
				/*
				System.out.println(httpURLConnection.getHeaderField("Location"));

				// 第三次请求
				String url = httpURLConnection.getHeaderField("Location");
				httpURLConnection = (HttpURLConnection) (new URL(url).openConnection());
				httpURLConnection.setRequestMethod("GET");
				httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
				httpURLConnection.connect();
			*/
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return -3;
		}
		return 1;
	}

	public void iHealthLogin() {
		try {
			// 访问跳转接口
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
			
			String cookieVal = httpURLConnection.getHeaderField("Set-Cookie");

			loginURL = "https://ssohq.gench.edu.cn/cas/login";
			httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
			httpURLConnection.setInstanceFollowRedirects(false);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestProperty("Cookie", cookieVal);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.connect();
			httpURLConnection.disconnect();
			System.out.println(httpURLConnection.getHeaderField("Location"));

			loginURL = httpURLConnection.getHeaderField("Location");
			httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
			httpURLConnection.setInstanceFollowRedirects(false);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestProperty("Cookie", cookieVal);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.connect();
			httpURLConnection.disconnect();
			System.out.println(httpURLConnection.getHeaderField("Location"));

			loginURL = httpURLConnection.getHeaderField("Location");
			httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
			httpURLConnection.setInstanceFollowRedirects(false);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestProperty("Cookie", cookieVal);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.connect();
			httpURLConnection.disconnect();
			System.out.println(httpURLConnection.getHeaderField("Location"));

			loginURL = httpURLConnection.getHeaderField("Location");
			httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
			httpURLConnection.setInstanceFollowRedirects(false);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.connect();
			cookieVal = httpURLConnection.getHeaderField("Set-Cookie");
			System.out.println("Cookie：" + cookieVal);
			System.out.println("建桥i健康登录成功！");
			// httpURLConnection.getOutputStream().write(formData.getBytes("UTF-8"));
			httpURLConnection.disconnect();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	private String getApiResponse(String apiUrl){
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

	public void getStuData(){
		String url = "http://ihealth.hq.gench.edu.cn/api/login/clearSession";
		JSONObject jsonObject = JSONObject.parseObject(this.getApiResponse(url));
		jsonObject = jsonObject.getJSONObject("data").getJSONObject("userInfo");
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
	}

	public static void main(String args[]) {
		UserDataBean uDataBean = new UserDataBean("1922518", "leo$123456");
		GenchPlatformAuth auth = new GenchPlatformAuth(uDataBean);
		if (auth.webAuth() == 1) {
			System.out.println("建桥信息门户登录成功！");
			auth.iHealthLogin();
			auth.getStuData();
			uDataBean.debugPrintObject();
		}
	}
}
