package com.zzq.control;

import com.zzq.util.Constant;
import com.zzq.util.GetAnime;
import com.zzq.util.Network;

public class TimerControl {

	MainControl mainControl;
	private Thread mainThread;//���ƴ���ˢ���ٶ�
	private Thread netThread;//������������Ƶ��
	
	public TimerControl(MainControl mainControl){
		this.mainControl = mainControl;
	}
	
	public void start(){
		mainThread = new Thread(){
			public void run(){
				while(true){
					mainControl.myPanel.repaint();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
//					System.out.println("mainThread runing");
				}
			}
		};
		
		netThread = new Thread(){
			public void run(){
				while(true){
					
					//������ͨʱ��������ץȡ������
					if(Network.isConnect(Constant.URL)){
						GetAnime.PostHtml(Constant.URL);
					}
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}; 
		
		mainThread.start();
		netThread.start();
	}
	
	
}
