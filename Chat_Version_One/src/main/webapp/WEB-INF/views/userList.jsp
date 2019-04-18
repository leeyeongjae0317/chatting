<%@page import="java.util.List"%>
<%@page import="com.happy.chat.dtos.ChatUser_Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 목록</title>
</head>
<%
	List<ChatUser_Dto> lists = (List<ChatUser_Dto>)request.getAttribute("lists");
	ChatUser_Dto loginDto = (ChatUser_Dto)session.getAttribute("loginDto"); 
%>
<script type="text/javascript">
	function openChat(userId) {
		confirm(userId+"님과 채팅을 시작하시겠습니까??");
		//window.open("");
		var sender = document.getElementById("sender").value;
		location.href="./insertRoom.do?sender="+sender+"&receiver="+userId;
	}
</script>
<body>
	<div>
		<table border="1">
			<%
				for(ChatUser_Dto dto : lists){
					if(!dto.getId().equals(loginDto.getId())){
						%>
						<tr>
							<th>아이디</th>
							<td><%=dto.getId()%></td>
							<td>
								<input type="hidden" id="sender" value="<%=loginDto.getId()%>">
								<input type="button" value="채팅시작" onclick="openChat('<%=dto.getId()%>')">
							</td>
						</tr>
						<%
					}
				}
			%>
		</table>
	</div>
</body>
</html>