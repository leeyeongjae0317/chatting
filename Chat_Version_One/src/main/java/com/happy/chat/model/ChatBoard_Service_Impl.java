package com.happy.chat.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.chat.dtos.ChatBoard_Dto;

@Service
public class ChatBoard_Service_Impl implements IChatBoard_Service {
	
	@Autowired
	private IChatBoard_Dao boardDao;
	
	private Logger logger = LoggerFactory.getLogger(ChatBoard_Service_Impl.class);
	
	@Override
	public ChatBoard_Dto selectBoard(String chatmember) {
		logger.info("selectBoard");
		return boardDao.selectBoard(chatmember);
	}

	@Override
	public boolean updateBoard(ChatBoard_Dto dto) {
		logger.info("updateBoard");
		return boardDao.updateBoard(dto);
	}

	@Override
	public List<ChatBoard_Dto> selectMyChatList(String id) {
		logger.info("selectMyChatList");
		return boardDao.selectMyChatList(id);
	}

	@Override
	public boolean insertChatRoom(ChatBoard_Dto dto) {
		logger.info("insertChatRoom");
		return boardDao.insertChatRoom(dto);
	}

}
