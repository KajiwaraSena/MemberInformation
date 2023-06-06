<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="jp.co.aforce.object.AccountInfo"%>

<%
ArrayList<AccountInfo> list = (ArrayList<AccountInfo>)request.getAttribute("list");
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
	 <h2 style="text-align:center">会員一覧</h2>
            <hr style="height:3; background-color:#0000FF" />
            <br>
             <%= error %>
             <table style="margin:0 auto">
				<tr>
				<th style="background-color:#6666FF; width:100">ID</th>
				<th style="background-color:#6666FF; width:100">名前</th>
				<th style="background-color:#6666FF; width:250">メールアドレス</th>
				</tr>
				<%
				if(list != null){
					for(int i = 0; i < list.size(); i++){
				%>
				
				<tr>
				<td style="text-align:center; width:100"><%= list.get(i).getAdmin_id() %></td>
				<td style="text-align:center; width:100"><%= list.get(i).getName() %></td>
				<td style="text-align:center; width:250"><%= list.get(i).getAddress() %></td>
				</tr>
				<%
					}
				}	
				%>
			</table>
			<p><a href="/MemberInformation/jsp/menu.jsp">TOP</a></p>
			</br>
		</div>	
</body>
</html>