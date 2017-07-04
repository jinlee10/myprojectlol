package com.tacademy.data.udp.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.tacademy.data.udp.client.WeatherClient;

public class WeatherThread extends Thread{
	
	boolean onAir = false;
	WeatherServer server;
	WeatherClient packet;
	DatagramSocket s;
	
	public WeatherThread(WeatherServer server){
		this.server = server;
		try {
			s = new DatagramSocket();//클라이언트가 받을거라서 12345쓰면안된댜
		} catch (SocketException e) {
			server.appendLog("server 생성오류: " + e);
		}
		
	}
	
	public void stopServer(){
		onAir = false;
		server.appendLog("닫는다!");
		if(s != null){
			s.close();
			server.appendLog("닫았다!");
			
		}
	}
	
	public void run(){ //욘석이 병행되는것
		//혹시 위에서 에러가나서 null일수도잇는데?
		//error면 반복문 없에버리죠?
		
		if(s == null){
			return;
		}
		
		onAir = true;
		byte[] data = new byte[256];		//DatagramPacket 초기화를위한것
		DatagramPacket packet = new DatagramPacket(data, data.length);
		//InetAddress address = null;
		InetAddress address = null;
		try {
			//D클래스 영역의 ip를 사용한다!!! (첫째자리가 224~239까지)
			address = InetAddress.getByName("230.0.0.1"); //채널로 쏘죠?
		} catch (UnknownHostException e1) {  
			server.appendLog("아이피 get 에러: " + e1);
		} 
		String weather = "";
		
		// ==== 3교시BIP ====
		
		while(onAir){
			try {
				weather = WeatherUtil.getWeather();
				byte[] fByte = weather.getBytes();
				
				//보낼 패킷 만들죠? 글자가 data가들어가죠?
				packet = new DatagramPacket(fByte, fByte.length, address, 12345);
				s.send(packet);
				server.appendLog(String.format("sent data: %s", new String(fByte)));
				
				Thread.sleep(500);
			} catch (IOException e) {
				server.appendLog("패킷 받기 에러: " + e);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
					
		}
		
		
		// ===== 1, 2교시 ====
		
//		while(onAir){	//외부에서 제어하고싶어서 bool변수쓰는것
//			try {
//				//대기중 알럿
//				server.appendLog("한조 대기중....");
//				
//				s.receive(packet);
//				data = packet.getData();
//				port = packet.getPort();
//				address = packet.getAddress();
//				server.appendLog(String.format("보낸사람: %s, port: %d, 받은내용: %s )"
//						, address.getHostAddress(), port, new String(data)));
//				
//				fortune = TodaysFortune.getFortune();
//				//얘를 바이트배열로만들어보내야된다
//				byte[] fByte = fortune.getBytes();
//				
//				packet = new DatagramPacket(fByte, fByte.length, address, port);
//				s.send(packet);
//				server.appendLog("sent well!");
//				
//			} catch (IOException e) {
//				server.appendLog("패킷 받기 에러: " + e);
//			}//패킷있어야돼);
//					
//			//패킷에서많이쓰는메소드
//			//getData()
//			//getName;
//			//getInetadderss//ㄱ;ㅅ.//////////
//					
//					
//					
//		}
	}
}
