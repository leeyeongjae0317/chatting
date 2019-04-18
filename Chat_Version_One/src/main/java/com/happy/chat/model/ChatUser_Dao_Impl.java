package com.happy.chat.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happy.chat.dtos.ChatUser_Dto;

@Repository
public class ChatUser_Dao_Impl implements IChatUser_Dao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.happy.chat.user."; 
	
	@Override
	public ChatUser_Dto login(ChatUser_Dto dto) {
		ChatUser_Dto udto = sqlSession.selectOne(NS+"login", dto);
		return udto;
	}

	@Override
	public List<ChatUser_Dto> selectAllUser() {
		List<ChatUser_Dto> lists = sqlSession.selectList(NS+"selectAllUser");
		return lists;
	}

}
