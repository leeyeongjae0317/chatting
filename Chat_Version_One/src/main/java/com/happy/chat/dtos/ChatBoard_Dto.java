package com.happy.chat.dtos;

public class ChatBoard_Dto {
	private int seq;
	private String chatmember;
	private String content;
	private String recentdate;
	
	public ChatBoard_Dto() {
	}

	public ChatBoard_Dto(int seq, String chatmember, String content, String recentdate) {
		super();
		this.seq = seq;
		this.chatmember = chatmember;
		this.content = content;
		this.recentdate = recentdate;
	}

	@Override
	public String toString() {
		return "ChatBoard_Dto [seq=" + seq + ", chatmember=" + chatmember + ", content=" + content + ", recentdate="
				+ recentdate + "]";
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getChatmember() {
		return chatmember;
	}

	public void setChatmember(String chatmember) {
		this.chatmember = chatmember;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRecentdate() {
		return recentdate;
	}

	public void setRecentdate(String recentdate) {
		this.recentdate = recentdate;
	}
	
	
	
}
