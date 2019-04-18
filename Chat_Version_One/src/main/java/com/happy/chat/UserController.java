package com.happy.chat;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.happy.chat.dtos.ChatUser_Dto;
import com.happy.chat.model.IChatUser_Service;

@Controller
public class UserController {

	@Autowired
	private IChatUser_Service userService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(ChatUser_Dto dto, HttpSession session) {
		logger.info("UserController login");
		
		ChatUser_Dto loginDto = userService.login(dto);
		if(loginDto==null){
			return "redirect:/main.do";
		}else{
			System.out.println(loginDto+"---------------");
			session.setAttribute("loginDto", loginDto);
			//model.addAttribute("loginDto", loginDto);
			return "redirect:/completeLogin.do";
		}
	}
	
	@RequestMapping(value="/completeLogin.do", method=RequestMethod.GET)
	public String userList(Model model) {
		logger.info("UserController userList");
		
		List<ChatUser_Dto> lists = userService.selectAllUser();
		model.addAttribute("lists", lists);
		
		return "userList";
	}
}
