package com.zzq.util;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

public class Util {
	
	//使用默认浏览器打开指定网页
	public static void browserUrl(String url){
		 
        //判断是否支持Desktop扩展,如果支持则进行下一步
        if (Desktop.isDesktopSupported()){
            try {
                URI uri = new URI(url);
                Desktop desktop = Desktop.getDesktop(); //创建desktop对象
                //调用默认浏览器打开指定URL
                desktop.browse(uri);
 
            } catch (URISyntaxException e) {
                e.printStackTrace();
 
            } catch (IOException e) {
                //如果没有默认浏览器时，将引发下列异常
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "没有默认浏览器");
            }
 
 
        }
    }
}
