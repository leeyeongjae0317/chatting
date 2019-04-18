package com.happy.chat.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happy.chat.dtos.ChatBoard_Dto;

@Repository
public class ChatBoard_Dao_Impl implements IChatBoard_Dao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.happy.chat.board."; 
	 
	@Override
	public ChatBoard_Dto selectBoard(String chatmember) {
		ChatBoard_Dto dto = sqlSession.selectOne(NS+"selectBoard", chatmember);
		return dto;
	}

	@Override
	public boolean updateBoard(ChatBoard_Dto dto) {
		int n = sqlSession.update(NS+"updateBoard", dto);
		return n > 0 ? true : false;
	}

	@Override
	public List<ChatBoard_Dto> selectMyChatList(String id) {
		List<ChatBoard_Dto> lists = sqlSession.selectList(NS+"selectMyChatList", id);
		return lists;
	}

	@Override
	public boolean insertChatRoom(ChatBoard_Dto dto) {
		int n = sqlSession.insert(NS+"insertChatRoom", dto);
		return n > 0 ? true : false;
	}

}
