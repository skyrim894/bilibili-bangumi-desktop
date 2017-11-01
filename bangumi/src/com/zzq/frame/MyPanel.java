package com.zzq.frame;

import java.awt.Graphics;
import javax.swing.JPanel;
import com.zzq.control.MainControl;

public class MyPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainControl mainControl;
	
	public MyPanel(MainControl mainControl){
		this.mainControl = mainControl;
		this.setOpaque(false);
	}
	
	//用于线程中重绘
	public void paintComponent(Graphics g){
		mainControl.drawList.draw(g);
	}
}
