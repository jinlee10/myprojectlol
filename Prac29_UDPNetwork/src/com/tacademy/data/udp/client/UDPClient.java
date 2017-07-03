package com.tacademy.data.udp.client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UDPClient {

	JFrame f; 
	JButton btnReceive;//, btnStop;
	JTextArea taResult;

	ActionListener al = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch(cmd){
			case "A":
				new ReceiverThread().start();
				break;
			}
		}
	};
	
	public UDPClient(){
		setGUI();
		
		//클라에서 먼저 보내고 서버서 클라로 보낸다.
		//클라는 단 한번 보낼거라 반복문 없지만
		//서버는 반복문 있따
		
	}
	
	//편하게 알아서 엔터쳐주는 줄바뀜문자 생략 메솓 쓰자!
	void appendLog(String msg){
		taResult.append(msg + "\n");
	}
	
	///이너쓰레드만들장
	class ReceiverThread extends Thread{
		public void run(){	//오버라이딩:부모가갖고있는메소드재정의
			receiveData();	//run에있으므로쓰레드안에서동작하는거지?
		}
	}
	
	void receiveData(){
		//멀티캐스트소켓^^!
		
		
	}
	
	void setGUI(){

		//ui만들어서 시작과 종료 하기
		f = new JFrame("Weather Client");
		f.setBounds(new Rectangle(700, 200, 400, 400));
		
		JPanel nPanel = new JPanel(new GridLayout(1, 1));
		
		btnReceive = new JButton("Receive");
		btnReceive.setActionCommand("A");
		btnReceive.addActionListener(al);
		nPanel.add(btnReceive);
		
		taResult = new JTextArea();
		
		f.add(nPanel, BorderLayout.NORTH);
		f.add(new JScrollPane(taResult), BorderLayout.CENTER);
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	public static void main(String[] args){
		new UDPClient();
	}
}
