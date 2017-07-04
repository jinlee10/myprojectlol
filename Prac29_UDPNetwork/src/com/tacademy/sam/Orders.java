package com.tacademy.sam;

//import java.sql.Date;

public class Orders {
	
	private int orderid;
	private int dustid;
	private int bookid;
	private int salerprice;
	private String orderdate;
	//private Date orderdate;
	
	//=======================================================
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getDustid() {
		return dustid;
	}
	public void setDustid(int dustid) {
		this.dustid = dustid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getSalerprice() {
		return salerprice;
	}
	public void setSalerprice(int salerprice) {
		this.salerprice = salerprice;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	
	//-----------------------------------------------------------
	
	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", dustid=" + dustid + ", bookid=" + bookid + ", salerprice=" + salerprice
				+ ", orderdate=" + orderdate + "]";
	}
	
}
