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
 * 主控制器，所有初始需要实例化的类都在此实例化
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
		
		//list中初始值
		list.add(new Anime(new Date().toString(),"等待网络","","",""));
		
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
			   
			   // 创建弹出菜单
			PopupMenu popup = new PopupMenu();
			   
			   //主界面选项
			MenuItem mainFrameItem = new MenuItem("主界面");
			mainFrameItem.addActionListener(listener1);
			   
			   //最小化界面
			MenuItem limitFrameItem = new MenuItem("最小化");
			limitFrameItem.addActionListener(listener2);
			   
			 //退出程序选项
			MenuItem exitItem = new MenuItem("退出程序");
			exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     if (JOptionPane.showConfirmDialog(null, "确定退出系统", "漫宅助手", JOptionPane.YES_NO_OPTION) == 0) {
			      System.exit(0);
			     }
			    }
			});
			   
			popup.add(mainFrameItem);
			popup.add(limitFrameItem);
			popup.add(exitItem);
			   
			TrayIcon  trayIcon = new TrayIcon(ICON, "可能有更新", popup);// 创建trayIcon
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
