<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-md-5 m-auto mt-5">
				<h3 class="text-center">ĐĂNG NHẬP HỆ THỐNG</h3>
				<div class="p-4 border mt-4">
					<p style="color: red;">${ message }</p>
					<form action="<c:url value="/login"/>" method="POST">
						<div class="form-group">
							<label>Email</label> <input type="email" class="form-control"
								name="email">
						</div>
						<div class="form-group">
							<label>Mật khẩu</label> <input type="password"
								class="form-control" name="password">
						</div>
						<button type="submit" class="btn btn-primary">Đăng nhập</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>