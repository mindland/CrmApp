<%@page import="java.util.ArrayList"%>
<%@page import="com.myclass.entity.Products"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách sản phẩm</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12 m-auto">
				<h3 class="text-center my-4">DANH SÁCH SẢN PHẨM</h3>
				<table class="table table-bordered text-center">
					<thead>
						<tr>
							<th scope="col">Mã sản phẩm</th>
							<th scope="col">Tên sản phẩm</th>
							<th scope="col">Số lượng</th>
							<th scope="col">Giá bán</th>
							<th scope="col">Danh mục</th>
							<th scope="col">Thao tác</th>
						</tr>
					</thead>
					<tbody>
						<%-- <%
							List<Products> data = (ArrayList<Products>) request.getAttribute("products");
						for (Products p : data) {
						%>
						<tr>
							<td><%=p.getMaSanPham()%></td>
							<td><%=p.getTenSanPham()%></td>
							<td><%=p.getSoLuong()%></td>
							<td><%=p.getGiaBan()%>đ</td>
							<td><a href="/QLSP/product/edit?id=<%=p.getMaSanPham()%>"
								class="btn btn-info">Sửa</a> <a
								href="/QLSP/product/delete?id=<%=p.getMaSanPham()%>"
								class="btn btn-danger">xóa</a></td>
						</tr>
						<%
							}
						%> --%>
						
						<c:forEach var="product" items="${products}">    <!-- EL: expression language -->
							<tr>
								<td>${product.id}</td>
								<td>${product.name}</td>
								<td>
									<c:choose>
										<c:when test="${product.amount > 0}">${product.amount}</c:when>
										<c:otherwise>Hết hàng</c:otherwise>
									</c:choose>
								</td>
								<td>  
								<fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${product.price}"/> đ
								</td>
								<td>  
								${product.cateId} 
								</td>
								<td><a href='<c:url value="product/edit?id=${product.id}"/>'
									class="btn btn-info">Sửa</a> 
									<a href='<c:url value="product/delete?id=${product.id}"/>'
									class="btn btn-danger">xóa</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a class="btn btn-primary" href= '<c:url value="product/add"/>' role="button">Thêm
					sản phẩm</a>

			</div>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>
</html>