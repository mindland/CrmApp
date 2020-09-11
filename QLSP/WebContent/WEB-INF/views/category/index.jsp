<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách danh mục</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12 m-auto">
				<h3 class="text-center my-4">DANH SÁCH DANH MỤC</h3>
				<table class="table table-bordered text-center">
					<thead>
						<tr>
							<th scope="col">Mã danh mục</th>
							<th scope="col">Tên danh mục</th>
							<th scope="col">Mô tả</th>
							<th scope="col">Thao tác</th>
						</tr>
					</thead>
					<tbody>				
						<c:forEach var="cat" items="${categories}"> 
							<tr>
								<td>${cat.id}</td>
								<td>${cat.name}</td>
								<td>${cat.description}</td>
								<td><a href='<c:url value="category/edit?id=${cat.id}"/>'
									class="btn btn-info">Sửa</a> 
									 <a href='<c:url value="category/delete?id=${cat.id}"/>'
									class="btn btn-danger">xóa</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a class="btn btn-primary" href= '<c:url value="category/add"/>' role="button">Thêm
					danh mục</a>
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