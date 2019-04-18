package com.happy.chat.model;

import java.util.List;

import com.happy.chat.dtos.ChatBoard_Dto;

public interface IChatBoard_Service {
	
	public ChatBoard_Dto selectBoard(String chatmember);
	
	public boolean updateBoard(ChatBoard_Dto dto);
	
	public List<ChatBoard_Dto> selectMyChatList(String id);
	
	public boolean insertChatRoom(ChatBoard_Dto dto);
}
