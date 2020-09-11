<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Thêm sản phẩm</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6 m-auto">
			
				<h5 class="text-center">THÊM MỚI SẢN PHẨM</h5>
				
				<form action="/QLSanPham/product/add" method="POST">
				
				  <div class="form-group">
				    <label>Mã sản phẩm</label>
				    <input type="text" name="id" class="form-control" />
				  </div>
				  
				  <div class="form-group">
				    <label>Loại sản phẩm</label>
				    <select name="cateId" class="form-control" >
				    	<c:forEach items="${ categories }" var="item">
				    		<option value="${ item.id }">${ item.name }</option>
				    	</c:forEach>
				    </select>
				  </div>
				  
				  <div class="form-group">
				    <label>Tên sản phẩm</label>
				    <input type="text" name="name" class="form-control" />
				  </div>
				  
				  <div class="form-group">
				    <label>Số lượng</label>
				    <input type="text" name="quantity" class="form-control" />
				  </div>
				  
				  <div class="form-group">
				    <label>Giá bán</label>
				    <input type="text" name="price" class="form-control" />
				  </div>
				  
				  <button class="btn btn-primary">Lưu lại</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>