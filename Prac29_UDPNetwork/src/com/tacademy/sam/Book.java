package com.tacademy.sam;

public class Book {
	
	// 0704. sql 연습 1
	// 2. book 테이블 구조에 맞는 자바 클래스를 만드시오
	
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
	
	
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	//----------------------------------------------------
	
	
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookname + ", publisher=" + publisher + ", price=" + price
				+ "]";
	}
	
	
	
}
