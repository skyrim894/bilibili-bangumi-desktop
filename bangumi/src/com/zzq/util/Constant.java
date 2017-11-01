package com.zzq.util;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public interface Constant {
	//��ʼ���
	int FRAME_WIDTH=300;
	int FRAME_HEIGHT=300;
	//��Ļ���
	int SCREEN_WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	int SCREEN_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	//��ʼλ��
	int FRAME_X=SCREEN_WIDTH-FRAME_WIDTH;
	int FRAME_Y=SCREEN_HEIGHT-FRAME_HEIGHT;
	
	//����ͼ��
	Image ICON = new ImageIcon("image/icon.png").getImage();
	
	//��ȡĿ����ַ
	String URL = "https://bangumi.bilibili.com/web_api/timeline_global";
	//�������ӵ�ƴ��
	String SUB_URL = "https://bangumi.bilibili.com/anime/";
	
	Color RED = new Color(224,41,46,200);
	Color BLUE = new Color(72,79,193,200);
	Color WHITE = new Color(200,200,200,200);
	Color BLACK = new Color(0,0,0,200);
	
	//hoverʱ͸����
	int HOVER_OPACTIY = 250;
	
}
