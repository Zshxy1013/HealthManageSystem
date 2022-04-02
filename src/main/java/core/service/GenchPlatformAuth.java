package core.service;

import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
		byte [] buffer;
		byte [] all;
		int length;
		ArrayList<byte []> byteList;
		ArrayList<Integer> byteLength;
		int totalLength = 0;
		String execution = null;
		try {
			// 初次请求，获得Cookie
			HttpURLConnection httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.connect();
			if(httpURLConnection.getResponseCode() == 200) {
				InputStream inputStream = httpURLConnection.getInputStream();
				buffer = new byte[1024];
				byteList = new ArrayList<>();
				byteLength = new ArrayList<>();
				while( (length = inputStream.read(buffer)) != -1 ) {
					byteList.add(buffer);
					byteLength.add(length);
		            totalLength += length;
		           	buffer = new byte[1024];
				}
				httpURLConnection.disconnect();
				all = new byte[totalLength];
				totalLength = 0;
				while(byteList.size() != 0) {
					System.arraycopy(byteList.get(0), 0, all, totalLength, byteLength.get(0));
					totalLength += byteLength.get(0);
					byteList.remove(0);
					byteLength.remove(0);
				}
				execution = new String(all, "UTF-8").split("name=\"execution\" value=\"")[1].split("\" />")[0];
				System.out.println("获取execution成功！execution=" + execution);
				formData = formData + "username=" + uDataBean.getStuSchoolID() + "&password=" + uDataBean.getStuPasswd() + "&execution=" + execution + "&encrypted=true&_eventId=submit&loginType=1";
				//printCookie(manager.getCookieStore());
				//System.out.print(formData);
				
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
				while( (length = inputStream.read(buffer)) != -1 ) {
					byteList.add(buffer);
					byteLength.add(length);
					totalLength += length;
					buffer = new byte[1024];
				}
				httpURLConnection.disconnect();
				all = new byte[totalLength];
				totalLength = 0;
				while(byteList.size() != 0) {
					System.arraycopy(byteList.get(0), 0, all, totalLength, byteLength.get(0));
					totalLength += byteLength.get(0);
					byteList.remove(0);
					byteLength.remove(0);
				}
				//System.out.print(new String(all, "UTF-8"));
				if(httpURLConnection.getResponseCode() != 302) {
					// 模拟登录失败
					return -1;
				}
				System.out.println(httpURLConnection.getHeaderField("Location"));
				
				// 第三次请求
				String url = httpURLConnection.getHeaderField("Location");
				httpURLConnection = (HttpURLConnection) (new URL(url).openConnection());
				httpURLConnection.setRequestMethod("GET");
				httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
				httpURLConnection.connect();
				
				if(httpURLConnection.getResponseCode() != 200) {
					return -2;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return -3;
		}
		return 1;
	}
	
	public void getHomePage() {
		String formData = "appName=pc.sudy.xgfytbxs&screenSize=1920*1080&clientVersion=MacIntel-Chrome-5.0";
		byte [] buffer;
		byte [] all;
		int length;
		ArrayList<byte []> byteList;
		ArrayList<Integer> byteLength;
		int totalLength = 0;
		try {
			/*
			HttpURLConnection httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
			httpURLConnection.setInstanceFollowRedirects(false);
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.connect();
			httpURLConnection.getOutputStream().write(formData.getBytes("UTF-8"));
			InputStream inputStream = httpURLConnection.getInputStream();
			buffer = new byte[1024];
			byteList = new ArrayList<>();
			byteLength = new ArrayList<>();
			totalLength = 0;
			while( (length = inputStream.read(buffer)) != -1 ) {
				byteList.add(buffer);
				byteLength.add(length);
				totalLength += length;
				buffer = new byte[1024];
			}
			httpURLConnection.disconnect();
			all = new byte[totalLength];
			totalLength = 0;
			while(byteList.size() != 0) {
				System.arraycopy(byteList.get(0), 0, all, totalLength, byteLength.get(0));
				totalLength += byteLength.get(0);
				byteList.remove(0);
				byteLength.remove(0);
			}
			System.out.println(new String(all, "utf-8"));
			*/
			
			String loginURL = "https://ssohq.gench.edu.cn/sso/step?url=https%3A%2F%2Fihealth.hq.gench.edu.cn%2Fmp%2Findex";
			HttpURLConnection httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
			httpURLConnection.setInstanceFollowRedirects(false);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.connect();
			httpURLConnection.disconnect();
			
			
			loginURL= "https://ssohq.gench.edu.cn/cas/login";
			httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
			httpURLConnection.setInstanceFollowRedirects(false);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.connect();			
			httpURLConnection.disconnect();
			System.out.println(httpURLConnection.getHeaderField("Location"));
			
			loginURL= httpURLConnection.getHeaderField("Location");
			httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
			httpURLConnection.setInstanceFollowRedirects(false);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.connect();
			httpURLConnection.disconnect();
			System.out.println(httpURLConnection.getHeaderField("Location"));
			
			loginURL= httpURLConnection.getHeaderField("Location");
			httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
			httpURLConnection.setInstanceFollowRedirects(false);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.connect();
			httpURLConnection.disconnect();
			System.out.println(httpURLConnection.getHeaderField("Location"));
			
			loginURL= httpURLConnection.getHeaderField("Location");
			httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
			httpURLConnection.setInstanceFollowRedirects(false);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.connect();
			httpURLConnection.disconnect();
			//httpURLConnection.getOutputStream().write(formData.getBytes("UTF-8"));
			if (checkCookie(manager.getCookieStore()))
				System.out.println("i健康系统登录成功！");
			else {
				System.out.println("i健康系统登录失败！");
				return;
			}
				

			loginURL= "http://ihealth.hq.gench.edu.cn/api/GDaily/pageusertoday";
			httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
			httpURLConnection.setInstanceFollowRedirects(false);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
			httpURLConnection.connect();
			httpURLConnection.disconnect();
			
			if(httpURLConnection.getResponseCode() == 200) {
				InputStream inputStream = httpURLConnection.getInputStream();
				buffer = new byte[1024];
				byteList = new ArrayList<>();
				byteLength = new ArrayList<>();
				while( (length = inputStream.read(buffer)) != -1 ) {
					byteList.add(buffer);
					byteLength.add(length);
		            totalLength += length;
		           	buffer = new byte[1024];
				}
				httpURLConnection.disconnect();
				all = new byte[totalLength];
				totalLength = 0;
				while(byteList.size() != 0) {
					System.arraycopy(byteList.get(0), 0, all, totalLength, byteLength.get(0));
					totalLength += byteLength.get(0);
					byteList.remove(0);
					byteLength.remove(0);
				}
				System.out.println(new String(all, "utf-8"));
				
				loginURL = "http://ihealth.hq.gench.edu.cn/api/GDaily/pageusertoday";
				httpURLConnection = (HttpURLConnection) (new URL(loginURL).openConnection());
				httpURLConnection.setInstanceFollowRedirects(false);
				httpURLConnection.setDoOutput(true);
				httpURLConnection.setRequestMethod("POST");
				httpURLConnection.setRequestProperty(headerAgent, headerAgentArg);
				httpURLConnection.connect();
				//httpURLConnection.getOutputStream().write(formData.getBytes("UTF-8"));
					inputStream = httpURLConnection.getInputStream();
					buffer = new byte[1024];
					byteList = new ArrayList<>();
					byteLength = new ArrayList<>();
					while( (length = inputStream.read(buffer)) != -1 ) {
						byteList.add(buffer);
						byteLength.add(length);
			            totalLength += length;
			           	buffer = new byte[1024];
					}
					httpURLConnection.disconnect();
					all = new byte[totalLength];
					totalLength = 0;
					while(byteList.size() != 0) {
						System.arraycopy(byteList.get(0), 0, all, totalLength, byteLength.get(0));
						totalLength += byteLength.get(0);
						byteList.remove(0);
						byteLength.remove(0);
					}
					//printCookie(manager.getCookieStore());
					System.out.println(new String(all, "utf-8"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	
    public static boolean checkCookie(CookieStore cookieStore){
        List<HttpCookie> listCookie = cookieStore.getCookies();
        for (HttpCookie httpCookie : listCookie) {
        	 //System.out.println("httpCookie : "+httpCookie);
        	 String cookieName = httpCookie.getName();
        	 if (cookieName == "ssohg_703") {
        		 return true; 
        	 }
		}
        return false;
    }
	
	public static void main(String args[]) {
		UserDataBean uDataBean = new UserDataBean(1922518, "leo$123456");
		GenchPlatformAuth auth = new GenchPlatformAuth(uDataBean);
		if(auth.webAuth() == 1) {
			System.out.println("建桥信息门户登录成功！");
			auth.getHomePage();
		}
	}
}
