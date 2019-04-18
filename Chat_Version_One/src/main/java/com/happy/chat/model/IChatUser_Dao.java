package com.happy.chat.model;

import java.util.List;

import com.happy.chat.dtos.ChatUser_Dto;

public interface IChatUser_Dao {
	// 로그인
		public ChatUser_Dto login(ChatUser_Dto dto);
		
		// 회원리스트
		public List<ChatUser_Dto> selectAllUser();
}
