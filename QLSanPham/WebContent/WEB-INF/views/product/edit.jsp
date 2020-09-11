<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.myclass.entity.Product" %>

<%
	Product product = (Product)request.getAttribute("product");
%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cập nhật sản phẩm</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6 m-auto">
				<h5 class="text-center">CẬP NHẬT SẢN PHẨM</h5>
				<form action="/QLSanPham/product/edit" method="POST">
				
				  <div class="form-group">
				    <input type="hidden" name="id" value="<%= product.getId() %>" class="form-control" />
				  </div>
				  
				  <div class="form-group">
				    <label>Tên sản phẩm</label>
				    <input type="text" name="name" value="<%= product.getName() %>" class="form-control" />
				  </div>
				  
				  <div class="form-group">
				    <label>Số lượng</label>
				    <input type="text" name="quantity" value="<%= product.getQuantity() %>" class="form-control" />
				  </div>
				  
				  <div class="form-group">
				    <label>Giá bán</label>
				    <input type="text" name="price" value="<%= product.getPrice() %>" class="form-control" />
				  </div>
				  
				  <button class="btn btn-primary">Lưu lại</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>