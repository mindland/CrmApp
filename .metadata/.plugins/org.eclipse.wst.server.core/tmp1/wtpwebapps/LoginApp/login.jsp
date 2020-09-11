<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Log in</title>
</head>
<body>	
	<form action=" ${appName}" method="POST">
		<label>Username:</label><br>
		<input type="text" name="usrName"><br>
		<label>Password: </label><br>
		<input type="password" name="passWord"><br><br>
		<input type="submit" value="Log in">
	</form> 
</body>
</html>