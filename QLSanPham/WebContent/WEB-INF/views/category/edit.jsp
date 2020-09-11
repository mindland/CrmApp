<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cập nhật danh mục</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6 m-auto">
			
				<h5 class="text-center">CẬP NHẬT DANH MỤC</h5>
				
				<form action='<c:url value="/category/edit" />' method="POST">
				
				  <div class="form-group">
				    <input type="hidden" name="id" value="${ category.id }" class="form-control" />
				  </div>
				  
				  <div class="form-group">
				    <label>Tên danh mục</label>
				    <input type="text" name="name" value="${ category.name }" class="form-control" />
				  </div>
				  
				  <div class="form-group">
				    <label>Mô tả</label>
				    <input type="text" name="desc" value="${ category.desc }" class="form-control" />
				  </div>
				  
				  <button class="btn btn-primary">Lưu lại</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>