package com.tacademy.data.udp.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WeatherUtil {
	
	
	public static String getWeather(){
		String str = "";
		BufferedReader br = null;
		//weather.txt파일에서 한 줄을 읽어 문자열로 보내기
		try {
			
			br = new BufferedReader(
					new FileReader(new File(".", "a.txt")));
			str = br.readLine();
			
		} catch (FileNotFoundException e) {
			//잘못읽었어! 멧지
		} catch (IOException e) {
		} finally{
			if(br != null){	//우에서 초기화할때 null이었는데, 만약에 catch에 걸리면 얘가 null인채로 내려오니깐 null인애를 .close()가되어버린다
				try {
					br.close();
				} catch (IOException e) {
				}
			}
		}
		
		return str;
	}
	
}
