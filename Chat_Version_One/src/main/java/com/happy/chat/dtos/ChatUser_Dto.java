package com.happy.chat.dtos;

public class ChatUser_Dto {
	
	private int seq;
	private String id;
	private String pw;
	
	
	public ChatUser_Dto() {
	}


	public ChatUser_Dto(int seq, String id, String pw) {
		super();
		this.seq = seq;
		this.id = id;
		this.pw = pw;
	}


	@Override
	public String toString() {
		return "ChatUser_Dto [seq=" + seq + ", id=" + id + ", pw=" + pw + "]";
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	
	
}
