package com.zzq.util;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

public class Util {
	
	//ʹ��Ĭ���������ָ����ҳ
	public static void browserUrl(String url){
		 
        //�ж��Ƿ�֧��Desktop��չ,���֧���������һ��
        if (Desktop.isDesktopSupported()){
            try {
                URI uri = new URI(url);
                Desktop desktop = Desktop.getDesktop(); //����desktop����
                //����Ĭ���������ָ��URL
                desktop.browse(uri);
 
            } catch (URISyntaxException e) {
                e.printStackTrace();
 
            } catch (IOException e) {
                //���û��Ĭ�������ʱ�������������쳣
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "û��Ĭ�������");
            }
 
 
        }
    }
}
