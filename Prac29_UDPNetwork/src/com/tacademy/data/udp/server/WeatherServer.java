package com.tacademy.data.udp.server;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WeatherServer {

	JFrame f; 
	JButton btnStart, btnStop;
	JTextArea taResult;
//	ServerThread thrd;
	WeatherThread wtrd;

	ActionListener al = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch(cmd){
			case "A":	//서버스레드 시작하는놈
				startServer();
				break;
			case "B":	//서버스레드 멈추는놈
				stopServer();
				break;
			}
		}
	};
	
	void appendLog(String msg){
		taResult.append(msg + "\n");
	}
	
	void stopServer(){
	}
	
	public void startServer(){
		wtrd = new WeatherThread(this);
		wtrd.start();
	}
	
	public WeatherServer(){
		
		setGUI();	
		//작업이 병행되어야하겠다..=======> 쓰레드만들자
		
	}
	

	void setGUI(){
		//ui만들어서 시작과 죠료 하기
		f = new JFrame("MultiCast Server");
		f.setBounds(new Rectangle(200, 200, 400, 400));

		JPanel nPanel = new JPanel(new GridLayout(1, 2));

		btnStart = new JButton("start");
		btnStart.setActionCommand("A");
		btnStart.addActionListener(al);
		nPanel.add(btnStart);

		btnStop = new JButton("stop");
		btnStop.setActionCommand("B");
		btnStop.addActionListener(al);
		nPanel.add(btnStop);

		taResult = new JTextArea();




		f.add(nPanel, BorderLayout.NORTH);
		f.add(new JScrollPane(taResult), BorderLayout.CENTER);


		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}


	public static void main(String[] args){
		new WeatherServer();
	}
}
