package com.zzq.control;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.zzq.entity.Anime;
import com.zzq.entity.DrawList;
import com.zzq.frame.MyFrame;
import com.zzq.frame.MyPanel;
import com.zzq.util.Constant;
import com.zzq.util.GetAnime;

/**
 * �������������г�ʼ��Ҫʵ�������඼�ڴ�ʵ����
 * @author zzq
 *
 */
public class MainControl implements Constant{
	
	public static List<Anime> list = new ArrayList<Anime>();
	
	public MyPanel myPanel;
	public MyFrame myFrame;
	
	public TimerControl timerControl; 
	public GetAnime getAnime = new GetAnime(this);
	public DrawList drawList = new DrawList();
	
	
	public MainControl(){
		this.myPanel = new MyPanel(this);
		
		myFrame = new MyFrame(myPanel);
		myFrame.setVisible(true);
		myFrame.setIconImage(ICON);
		
		MouseControl mouseControl = new MouseControl(this);
		myFrame.addMouseListener(mouseControl);
		myFrame.addMouseMotionListener(mouseControl);
		
		
		
		timerControl = new TimerControl(this);
		timerControl.start();
		
		//list�г�ʼֵ
		list.add(new Anime(new Date().toString(),"�ȴ�����","","",""));
		
		if(SystemTray.isSupported()){
			SystemTray systemTray = SystemTray.getSystemTray();
			ActionListener listener1 = new ActionListener() {
				   public void actionPerformed(ActionEvent e) {
					   myFrame.setVisible(true);	
				   }	    
			   };
    		ActionListener listener2 = new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    	myFrame.setVisible(false);	
				    }	    
			   };	
			   
			   // ���������˵�
			PopupMenu popup = new PopupMenu();
			   
			   //������ѡ��
			MenuItem mainFrameItem = new MenuItem("������");
			mainFrameItem.addActionListener(listener1);
			   
			   //��С������
			MenuItem limitFrameItem = new MenuItem("��С��");
			limitFrameItem.addActionListener(listener2);
			   
			 //�˳�����ѡ��
			MenuItem exitItem = new MenuItem("�˳�����");
			exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     if (JOptionPane.showConfirmDialog(null, "ȷ���˳�ϵͳ", "��լ����", JOptionPane.YES_NO_OPTION) == 0) {
			      System.exit(0);
			     }
			    }
			});
			   
			popup.add(mainFrameItem);
			popup.add(limitFrameItem);
			popup.add(exitItem);
			   
			TrayIcon  trayIcon = new TrayIcon(ICON, "�����и���", popup);// ����trayIcon
			trayIcon.addActionListener(listener1);
			trayIcon.addActionListener(listener2);
			try {
			    systemTray.add(trayIcon);
			} catch (AWTException e1) {
			    e1.printStackTrace();
			}
		}
	}
}
