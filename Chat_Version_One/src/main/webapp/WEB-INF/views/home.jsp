<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	
	<form action="./login.do" method="post">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id" required="required">
				</td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="text" name="pw" required="required">
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
