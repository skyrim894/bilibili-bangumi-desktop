package com.zzq.control;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.zzq.util.Constant;
import com.zzq.util.Util;

public class MouseControl extends MouseAdapter{
	
	MainControl mainControl;
	private Point origin = new Point();
	public static int mouse_x = 0; 
	public static int mouse_y = 0;
	
	public MouseControl(MainControl mainControl){
		this.mainControl = mainControl;
	}
	
	public void mousePressed(MouseEvent e) {
		origin.x = e.getX();
		origin.y = e.getY();
	}
	
	public void mouseDragged(MouseEvent e) {
		//�õ����ڵ�ǰλ��
		Point p = mainControl.myFrame.getLocation();
	    mainControl.myFrame.setLocation(
	        p.x + (e.getX() - origin.x), 
	        p.y + (e.getY() - origin.y));
	}
	
	
	public void mouseMoved(MouseEvent e) {
		//�����굱ǰλ��
		mouse_x = e.getX();
		mouse_y = e.getY(); 
		
		//�ж���굱ǰָ��λ��
		for(int i=0;i<MainControl.list.size();i++){
			if(e.getY()>(i*25)&&e.getY()<(i*25+20)){
				MainControl.list.get(i).setArrive(true);
			}else{
				MainControl.list.get(i).setArrive(false);
				MainControl.list.get(i).setChecked(false);
			}
		}
	}
	
	
	public void mouseClicked(MouseEvent e) {
		//��굥��ʱ��Amine�ĵ��״̬Ϊ�棬˫��ʱ����Ĭ���������ָ����ҳ
		for(int i=0;i<MainControl.list.size();i++){
			if(MainControl.list.get(i).isArrive()&&e.getClickCount()==1){
				MainControl.list.get(i).setChecked(true);
			}else if(MainControl.list.get(i).isArrive()&&e.getClickCount()==2){
				Util.browserUrl(Constant.SUB_URL+MainControl.list.get(i).getLink());
			}
		}
	}
}
