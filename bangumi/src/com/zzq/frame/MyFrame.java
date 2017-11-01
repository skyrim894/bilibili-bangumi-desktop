package com.zzq.frame;

import java.awt.Color;
import javax.swing.JFrame;
import com.zzq.util.Constant;

public class MyFrame extends JFrame implements Constant{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyFrame(MyPanel myPanel){
		this.setUndecorated(true);//²»×°ÊÎ
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLocation(FRAME_X, FRAME_Y);
		this.setBackground(new Color(0,250,0,0));
		
		this.setContentPane(myPanel);
		
		
	}
	
}
