<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật sản phẩm</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-6 m-auto">
        <h3 class="text-center my-4">CẬP NHẬT SẢN PHẨM</h3>
			<form action='<%=request.getContextPath()%>/product/edit' method="POST">
			  <div class="form-group">
			    <label>Mã sản phẩm</label>
			    <input type="text" readonly class="form-control" name="maSanPham" value="${sanPham.id}"/>
			  </div>
			  <div class="form-group">
			    <label>Loại sản phẩm</label>
			    <select name="cateId" class="form-control">
				    <c:forEach var="item" items="${categories}">
				    	<option value="${item.id}">${item.name}</option>
				    </c:forEach>
			    </select>
			  </div>
			  <div class="form-group">
			    <label>Tên sản phẩm</label>
			    <input type="text" class="form-control"  name="tenSanPham" value="${sanPham.name}"/>
			  </div>
			  <div class="form-group">
			    <label>Số lượng</label>
			    <input type="text" class="form-control"  name="soLuong" value="${sanPham.amount}"/>
			  </div>
			  <div class="form-group">
			    <label>Giá bán</label>
			    <input type="text" class="form-control"  name="giaBan" value="${sanPham.price}"/>
			  </div>
			  <button class="btn btn-primary">Lưu lại</button>
			</form>
        </div>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>