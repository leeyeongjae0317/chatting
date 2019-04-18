package com.happy.chat.socket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component(value="wsChat.do")
public class MySocketHandler extends TextWebSocketHandler {
	
	private ArrayList<WebSocketSession> list ; 
	private Map<WebSocketSession,String> map = 
			new HashMap<WebSocketSession,String>();
	
	
	public MySocketHandler() {
		list = new ArrayList<WebSocketSession>();
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) 
	throws Exception {
		System.out.println("afterConnectionEstablished()");
		super.afterConnectionEstablished(session);
		list.add(session) ;
		System.out.println("client session cnt : "+list.size()); 
		System.out.println("session connected : "+session.getId());
		map.put(session, "");
	}
	@Override
	public void handleTextMessage(WebSocketSession session,TextMessage message)
	throws Exception {
		System.out.println("handleTextMessage()");
		String msg = message.getPayload() ; 
		System.out.println("List 값 : "+list);
		System.out.println("Map 값 : "+map);
		System.out.println("메세지 : "+msg);
		if( msg != null && !msg.equals("") ) {
			if(msg.indexOf("#$nick_") > -1 ) {
				map.put(session, msg.replace("#$nick_", ""));
				//System.out.println(map);
				for(WebSocketSession s : list) {
					if( s!=session) {
						s.sendMessage(
						new TextMessage("<font color='red' size='2px'>"+map.get(session)+" 사용자가 입장하였습니다..</font>")
						);
					}
				}
			}else {
				for(WebSocketSession s : list) {
					String m = "<font color='blue' size='2px'>"+msg+"</font>" ;
					s.sendMessage(new TextMessage(m));
				}
			}
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session,CloseStatus status)
	throws Exception {
		System.out.println("afterConnectionClosed()");
		super.afterConnectionClosed(session, status);
		list.remove(session);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		String now = sdf.format(new Date());
		for(WebSocketSession a : list) {
			a.sendMessage(new TextMessage("<font color='blue' size='2px'>"+map.get(session)+"님이 퇴장하셨습니다. ("+now+")</font>"));
		}
		map.remove(session);
	}
	
}














