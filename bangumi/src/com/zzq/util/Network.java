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
		   oc.setConnectTimeout(3000); // ���ó�ʱʱ��
		   status = oc.getResponseCode();// ����״̬
		   if (200 == status) {
		    // 200�������ַ˳����ͨ����
			   System.out.println("���ӳɹ�");
			   return true;
		   }
		  } catch (Exception e) {
			  System.out.println("�Ͽ�����");
		  }
		  return false;
	}
	
	
}
