<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align:center">
	<h2 style="text-align:center">会員登録</h2>
	<hr style="height:3; background-color:#000ff" />
	<br>
	登録する情報を入力してください。
	<form action="<%= request.getContextPath() %>/servlet/InsertServlet">
	<table style="margin:0 auto">
		<tr>
			<td style="width:60">ID</td>
			<td><input type=text size="30" name="admin_id"></input></td>
		</tr>	
		<tr>
			<td style="width:60">名前</td>
			<td><input type=text size="30" name="name"></input></td>
		</tr>
		<tr>
			<td style="width:60">メールアドレス</td>
			<td><input type=text size="30" name="address"></input></td>
		</tr>
		<tr>
			<td colsapan=2 style="text-align:center">
				<input type="submit" value="登録">
			</td>
		</tr>
	</table>
	</form>
	</div>					
</body>
</html>