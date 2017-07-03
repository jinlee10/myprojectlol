package com.tacademy.data.udp.server;

public class TodaysFortune {
	
	static String[] fortune = {
			"존 씨나 운수대통", "존 씨나 운수 좋은 날", 
			"존 씨나 그럭저럭 괜찮음", "존 씨나 행복",
			"존 씨나 재수없음", "존 씨나 재수왕창없음",
			"존 씨나 개똥밟음", "존 씨나 유캔T씨미",
			"존 씨나 읍내에서 껌밟아", "존 씨나 탈모빔"};
	
	public static String getFortune(){
		int idx = (int) (Math.random() * fortune.length); //인덱스니까 0부터나와도ok!
				//다 얻어진걸 int로 cast해야된다!
		
		return fortune[idx];	//얘네먼저 완성하고 나머지 fill하는습관들이자
	}
}
