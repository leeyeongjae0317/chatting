<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅방</title>
<script type="text/javascript" 
			src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		var ws = null ; // WebSocket 객체 변수
		var url = null ; // WebSocket 생성자의 ip주소 변수
		var nick = null ; // 채팅방 입장시 입력하는 nickname 변수
		
		$(document).ready(function() {
			
		
				nick = $("#nickName").val();
				$("#receive_msg").html('');
				$("#chat_div").show();
				$("#chat").focus();
				
				//WebSocket 서버 생성
				ws = new WebSocket("ws://192.168.4.3:8091/chat/wsChat.do");
				//ws.onopen은 afterConnectionEstablished()를 실행함
				ws.onopen = function() {
					//ws.send(value)는 handleTextMessage()를 실행하고 value를 전송
					ws.send("#$nick_"+nick);
				};
				//handleTextMessage()에서 보낸 값을 event로 받아옴, sendMessage()를 통해 보낸 값을 event.data로 받아옴 
				ws.onmessage = function(event) {
					$("#receive_msg").append(event.data+"<br/>");
				}
				ws.onclose = function(event) {
					alert("서버와의 연결이 종료되었습니다."); 
				}
		
			
			$("#chat_btn").bind("click",function() {
				if($("#chat").val() == '' ) {
					alert("내용을 입력하세요");
					return ;
				}else {
					ws.send(nick+" : "+$("#chat").val());
					$("#chat").val('');
					$("#chat").focus();
				}
			});
		});
		
		// 뒤로가기가 되었을 때 WebSocket을 종료함
		window.onbeforeunload = function() {
			ws.close();
			ws = null ;
		}
		
		// WebSocket를 종료함
		function disconnect() {
			var content = document.getElementById("receive_msg").innerHTML;
			alert(content);
			location.href="./updateChat.do?content="+content;
			ws.close();
			ws = null ;
		} 
		
	</script>
</head>
<body>

	<table border="1">
		<tr>
			<td width="500px" height="500px" align="center">
			<div id="receive_msg" style="border:1px"> 
				   
			</div>
			</td>
		</tr>	
	</table>
	<br/><br/><br/>
	
	<input type="hidden" id="nickName" value="${sender}">
	<div id="chat_div" style="display:none">
		<input type="text" id="chat" style="width:460px" 
		       onKeypress="if(event.keyCode==13) $('#chat_btn').click();" />
		<input type="button" id="chat_btn" value="입력" />    	
	    <input type="button" id="chat_close" value="나가기" onclick="disconnect()">
	</div>
	
	<div>
		${sender}
		${receiver}
	</div>
</body>
</html>