package com.happy.chat;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.happy.chat.dtos.ChatBoard_Dto;
import com.happy.chat.model.IChatBoard_Service;

@Controller
public class BoardController {

	@Autowired
	private IChatBoard_Service boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	   @RequestMapping(value="/selectChatRoom.do", method=RequestMethod.GET)
	   public String selectChatRoom() {
	      String chatmember = "lee,kim";
	      ChatBoard_Dto boardDto = boardService.selectBoard(chatmember);
	      logger.info("selectChatRoom + {}",boardDto);
	      return null;
	   }
	   
	   @RequestMapping(value="/updateChat.do", method=RequestMethod.GET)
	   public String updateChat(String chatmember, String content) {
	      ChatBoard_Dto dto = new ChatBoard_Dto();
	      String[] newChat = chatmember.split(",");
	      System.out.println("받은 문자를 자름 : "+Arrays.toString(newChat));
	      Arrays.sort(newChat);
	      System.out.println("정렬된 문자 : " + Arrays.toString(newChat));
	      
	      String finalChat = newChat[0]+","+newChat[1];
	      System.out.println("최종 이름 : "+finalChat);
	      dto.setChatmember(finalChat);
	      dto.setContent(content);
	      
	      System.out.println(content);
	      
	      boolean isc = boardService.updateBoard(dto);
	      System.out.println(isc);
	      return "redirect:/completeLogin.do";
	   }
	   
	   @RequestMapping(value="/insertRoom.do", method=RequestMethod.GET)
	   public String insertRoom(Model model,String sender, String receiver) {
		  String chatmember = sender + "," + receiver;
		  ChatBoard_Dto dto = new ChatBoard_Dto();
	      String[] newChat = chatmember.split(",");
	      
	      System.out.println("받은 문자를 자름 : "+Arrays.toString(newChat));
	      Arrays.sort(newChat);
	      System.out.println("정렬된 문자 : " + Arrays.toString(newChat));
	      
	      String finalChat = newChat[0]+","+newChat[1];
	      System.out.println("최종 이름 : "+finalChat);
	      dto.setChatmember(finalChat);
	      dto.setContent("");
	      
	      model.addAttribute("sender", sender);
	      model.addAttribute("receiver", receiver);
	      
	      boolean isc = boardService.insertChatRoom(dto);
	      System.out.println(isc);
	      return "chatPage";
	   }
	   
	  /* 
	   @RequestMapping(value="/myChatList.do", method=RequestMethod.GET)
	   public String myChatList(String id) {
	      List<ChatBoard_Dto> lists = boardService.selectMyChatList(id);
	      System.out.println(lists);
	      return null;
	   }
	   */
	   @RequestMapping(value="/chatStart.do", method=RequestMethod.GET)
	   public String creatChatRoom(Model model, String sender, String receiver) {
		   
		   
		   return "chatPage";
	   }
	   
}
