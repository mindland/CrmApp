<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action=' <%=request.getContextPath()%>/login' method="POST">
		<label>Username:</label><br>
		<input type="text" name="usrName"><br>
		<label>Password: </label><br>
		<input type="password" name="passWord"><br><br>
		<input type="submit" value="Log in">
	</form> 
</body>
</html>