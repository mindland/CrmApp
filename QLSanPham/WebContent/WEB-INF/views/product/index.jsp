<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Danh sách sản phẩm</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
			<h4 class="my-4">DANH SÁCH SẢN PHẨM</h4>
			<table class="table table-bordered">
			    <thead>
			      <tr>
			        <th>Mã SP</th>
			        <th>Tên Sản Phẩm</th>
			        <th>Số Lượng</th>
			        <th>Giá Bán</th>
			        <th>Danh mục</th>
			        <th>#</th>
			      </tr>
			    </thead>
			    <tbody>
			      <c:forEach items="${ products }" var="product">
			      	<tr>
				        <td>${ product.id }</td>
				        <td>${ product.name }</td>
				        <td>
				        	<c:choose>
				        		<c:when test="${ product.quantity > 0 }">
				        			${ product.quantity }
				        		</c:when>
				        		<c:otherwise>Hết hàng</c:otherwise>
				        	</c:choose>
				        </td>
				        <td>
				        	<fmt:formatNumber type="number" maxFractionDigits="3" value="${product.price}" /> đ
				        </td>
				        <td>${ product.cateId }</td>
				        <td>
				        	<a href='<c:url value="/product/edit?id=${ product.id }" />' class="btn btn-sm btn-info">Sửa</a>
				        	<a href="#" class="btn btn-sm btn-danger">Xóa</a>
				        </td>
				      </tr>
			      </c:forEach>
			      
			    </tbody>
			  </table>
			</div>
		</div>
	</div>
</body>
</html>