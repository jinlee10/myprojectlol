package com.tacademy.data.udp.client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WeatherClient {

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
	byte[] data;
	};
	
	
	public WeatherClient(){
		setGUI();
		
		//클라에서 먼저 보내고 서버서 클라로 보낸다.
		//클라는 단 한번 보낼거라 반복문 없지만
		//서버는 반복문 있따
		
	}
	
	//편하게 알아서 엔터쳐주는 줄바뀜문자 생략 메솓 쓰자!
	void appendLog(String msg){
		taResult.append(msg + "\n");
	}
	
	boolean onAir = false;
	///이너쓰레드만들장
	class ReceiverThread extends Thread{
		public void run(){	//오버라이딩:부모가갖고있는메소드재정의
			onAir = true;
			
			MulticastSocket ms = null;
			InetAddress addrs = null;
			try{
				ms = new MulticastSocket();
				addrs = InetAddress.getByAddress("23.0.0.1");
				ms.joinGroup(addrs);
			}catch(IOException e){
				ms.leaveGroup(addrs);
			}
			try{
				
				
			}catch(IOException e){
				packet = new DatagramPacket(data, data.leghW);
				while(onAr);
			}
			
		}
		
	
			
	}
	
	void receiveData(){
		//요서부터 ㄹㅇ udp하자!
		
		//UDP의 핵심클래서 1) 접속을 관리하는 DatagramSocket,
		//					2) DatagramPacket
		DatagramSocket s = null;	//얘도 걍 s라고함
		DatagramPacket packet = null;	//얘한테 쓰일 byte[] make!
		byte[] data = new byte[256];		//얘가 가는게아니고
											//얘가 함 가야 서버가 receive하여
							//상대방의 아이피와 port를 알아낼수있는것이다
		
		int port = 12345;
		InetAddress address = null;
		
		try{
			//상대방이볼수있도록 나(소켓)를열어놔야돼
			s = new DatagramSocket(12345);	//얘가받을거라 포트 12345로해놓음 [내 ip + bIP 는 요 포트로 받겠습니다.]
			for(int i = 0; i < 20; i++){
				data = new byte[256];
				packet = new DatagramPacket(data, data.length);	
				s.receive(packet);
				//클라이언트는 서버가 주면 받는거만 하는거야!
				data = packet.getData();
				port = packet.getPort();
				address = packet.getAddress();
				appendLog(String.format("보낸사람: %s, port: %d, 받은내용: %s )"
						, address.getHostAddress(), port, new String(data)));
				
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}catch(SocketException e){
			appendLog("소켓 익셉션! udp 에러: " + e);
		} catch (UnknownHostException e) {
			appendLog("Unknwon 호스트 익셉션! 에러정보: " + e);
		} catch (IOException e) {
			appendLog("소켓 send() 에러: " + e);
		} finally{	//예서 닫아주자
			if(s != null){
				s.close();//닫아준다
			}
		}
		
//		try{
//			address = InetAddress.getByName("192.168.205.159");
//			
//			data = "홍길동 보냄".getBytes();	//얘가 가는거다
//			
//			packet = new DatagramPacket(data, data.length, address, port);	//데이터 안에 있던없든 노상관
//			s = new DatagramSocket();	
//			s.send(packet);   //소켓을 통해 보낸다
////			s = new DatagramSocket(port, address); //얠 더 많이쓰긴 함
//			
//			data = new byte[256];
//			packet = new DatagramPacket(data, data.length);	//받을땐 바이트랑 크기만 있음 됨
//			s.receive(packet);//data가 256에서 홍길동 보냄이 되어버렸다. 데이타가 더 길어지면 안받아진다
//							//넓히고싶으면 byte배열을 두개 만들던지 새로 new해서 만들던지 해라
//			
//			//보여줘야지~
//			data = packet.getData();
//			port = packet.getPort();
//			address = packet.getAddress();
//			appendLog(String.format("보낸사람: %s, port: %d, 받은내용: %s )"
//					, address.getHostAddress(), port, new String(data)));
//			
//		}catch(SocketException e){
//			appendLog("소켓 익셉션! udp 에러: " + e);
//		} catch (UnknownHostException e) {
//			appendLog("Unknwon 호스트 익셉션! 에러정보: " + e);
//		} catch (IOException e) {
//			appendLog("소켓 send() 에러: " + e);
//		}
		
		//그담으로 실제적으로 서버의 주소와 port를 필요로하게되겠지?
		//인자가 ip, port
		//ip 문자열로 못쓰고)"192.168.0.0" 무적권 InetAdress로만들어줘야한다
		//127.0.0.1은 내아이피가 맞으나 공부하면서 계속 외부ip쓰는습관들이자
		//위에거 절대로 쓰지말자!!
		
		
		
		
	}
	
	void setGUI(){

		//ui만들어서 시작과 종료 하기
		f = new JFrame("UDP Client");
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
		new WeatherClient();
	}
}
