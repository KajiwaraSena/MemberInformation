<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Integer count = (Integer)request.getAttribute("count");
String error = (String)request.getAttribute("error");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align:center">
		<h2 style="text-align:center">登録完了</h2>
		<hr style="heght:3; background-color:#0000ff" />
		<br>
		<%= error %>
		<% if(count != null){ %>
			<%= count %>件のデータを登録しました
		<% } %>
		</br>
		<p><a href="/MemberInformation/jsp/menu.jsp">TOP</a></p>
	</div>	
</body>
</html>