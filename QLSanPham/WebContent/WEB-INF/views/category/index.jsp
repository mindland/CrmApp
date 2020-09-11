<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Danh sách danh mục</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
			<h4 class="my-4">DANH SÁCH DANH MỤC</h4>
			<a href='<c:url value="/category/add" /> ' class="btn btn-primary mb-3">Thêm mới</a>
			<table class="table table-bordered">
			    <thead>
			      <tr>
			        <th>Mã Danh Mục</th>
			        <th>Tên Danh Mục</th>
			        <th>Mô Tả</th>
			        <th>#</th>
			      </tr>
			    </thead>
			    <tbody>
			      <c:forEach items="${ categories }" var="item">
			      	<tr>
				        <td>${ item.id }</td>
				        <td>${ item.name }</td>
				        <td>${ item.desc }</td>
				        <td>
				        	<a href='<c:url value="/category/edit?id=${ item.id }" />' class="btn btn-sm btn-info">Sửa</a>
				        	<a href='<c:url value="/category/delete?id=${ item.id }" />' class="btn btn-sm btn-danger">Xóa</a>
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