package com.happy.chat.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.chat.dtos.ChatUser_Dto;

@Service
public class ChatUser_Service_Impl implements IChatUser_Service {

	@Autowired
	private IChatUser_Dao userDao;
	
	private Logger logger = LoggerFactory.getLogger(ChatBoard_Service_Impl.class);
	
	@Override
	public ChatUser_Dto login(ChatUser_Dto dto) {
		logger.info("login");
		return userDao.login(dto);
	}

	@Override
	public List<ChatUser_Dto> selectAllUser() {
		logger.info("selectAllUser");
		return userDao.selectAllUser();
	}

}
