package com.tacademy.sam;

import java.sql.Date;

public class Sample21 {			// 테이블
	private int no;		//SQL의 61쪽 type int(11)와 매핑
	private String name;//varChar는 String으로 매킹
	private String date;//java.sql.Date보단 String으로많이잡는다
	private String address;	//varChar
	
	
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "Sample21 [no=" + no + ", name=" + name + ", date=" + date + ", address=" + address + "]";
	}
	
}
