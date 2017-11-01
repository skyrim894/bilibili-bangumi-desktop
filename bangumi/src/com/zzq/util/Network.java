package com.zzq.util;

import java.net.HttpURLConnection;
import java.net.URL;

public class Network {
	
	
	
	public static boolean isConnect(String address){
		
		int status = 404;
		  try {
		   URL urlObj = new URL(address);
		   HttpURLConnection oc = (HttpURLConnection) urlObj.openConnection();
		   oc.setUseCaches(false);
		   oc.setConnectTimeout(3000); // 设置超时时间
		   status = oc.getResponseCode();// 请求状态
		   if (200 == status) {
		    // 200是请求地址顺利连通。。
			   System.out.println("链接成功");
			   return true;
		   }
		  } catch (Exception e) {
			  System.out.println("断开连接");
		  }
		  return false;
	}
	
	
}
