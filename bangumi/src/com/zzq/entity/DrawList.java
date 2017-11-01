package com.zzq.entity;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.zzq.control.MainControl;
import com.zzq.control.MouseControl;
import com.zzq.util.Constant;

public class DrawList {
	
	
	public static int COUNT = 0;
	
	private int time_width = (int)(Constant.FRAME_WIDTH*0.2);
	private int name_width = (int)(Constant.FRAME_WIDTH*0.6);
	private int count_width = (int)(Constant.FRAME_WIDTH*0.2);
	public DrawList(){
	
	}
	
	public void draw(Graphics g){
		//������ ���ھ���
		FontMetrics fm = g.getFontMetrics();
		for(int i=0;i<MainControl.list.size();i++){
			//����ʱ��
			if(MainControl.list.get(i).isArrive())
				g.setColor(new Color(0,0,0,Constant.HOVER_OPACTIY));
			else
				g.setColor(Constant.BLACK);
			g.fillRect(0,i*25,time_width-5,20);
			g.setColor(Color.WHITE);
			g.drawString(MainControl.list.get(i).getTime(),(time_width-fm.stringWidth(MainControl.list.get(i).getTime()))>>1,15+i*25);
			
			//��������
			if(MainControl.list.get(i).isArrive())
				g.setColor(new Color(56,80,188,Constant.HOVER_OPACTIY));
			else
				g.setColor(Constant.BLUE);
			
			g.fillRect(time_width, i*25, name_width-5, 20);
			g.setColor(Color.WHITE);
			g.drawString(MainControl.list.get(i).getName(),time_width+(name_width-fm.stringWidth(MainControl.list.get(i).getName())>>1),15+i*25);

			
			//���Ƽ���
			if(MainControl.list.get(i).isArrive())
				g.setColor(new Color(185,21,26,Constant.HOVER_OPACTIY));
			else
				g.setColor(Constant.RED);
			
			g.fillRect(time_width+name_width, i*25, count_width, 20);
			g.setColor(Color.WHITE);
			g.drawString(MainControl.list.get(i).getCount(),time_width+name_width+(count_width-fm.stringWidth(MainControl.list.get(i).getCount())>>1),15+i*25);
			
		}
		
		//����ͼƬ ������һ��ѭ��������ᱻ��һ�и���
		
		BufferedImage c;
		ImageIcon imageIcon = null;
		
		for(int i=0;i<MainControl.list.size();i++){
			if(MainControl.list.get(i).isChecked()){
				try {
					//ֱ��ͨ��url��ַ�����ص��ڴ����
					c = ImageIO.read(new URL(MainControl.list.get(i).getImage()));
					imageIcon = new ImageIcon(c);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Image image = imageIcon.getImage();
				
				//����ͼƬ������������ƶ�
				g.drawImage(image,MouseControl.mouse_x, MouseControl.mouse_y,100,100,null);
				
			}
		}
	}
}
