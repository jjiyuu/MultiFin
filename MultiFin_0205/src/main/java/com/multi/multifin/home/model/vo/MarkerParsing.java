package com.multi.multifin.home.model.vo;


import java.util.Date;

public class MarkerParsing { 
	int rno;
	String text ;
	Object x;
	Object y;
	
	public MarkerParsing() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MarkerParsing(int rno, String text, Object x, Object y) {
		super();
		this.rno = rno;
		this.text = text;
		this.x = x;
		this.y = y;
	}
	
	public MarkerParsing(String text, Object x, Object y) {
		super();
		this.text = text;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Parsing [rno=" + rno + ", text=" + text + ", x=" + x + ", y=" + y + "]";
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Object getX() {
		return x;
	}
	public void setX(Object x) {
		this.x = x;
	}
	public Object getY() {
		return y;
	}
	public void setY(Object y) {
		this.y = y;
	}

	
}
