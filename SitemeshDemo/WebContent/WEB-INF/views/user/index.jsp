<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>Danh sách thành viên</title>
</head>

<body>
	<!-- CONTENT -->
	<section id="admin-content" class="p-3">
		<h3 class="mb-3">Danh sách thành viên</h3>
		<div class="row">
			<div class="col-md-8">
				<a href="/SitemeshDemo/user/add" class="btn btn-primary">Thêm mới</a>
			</div>
			<div class="col-md-4">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Tìm kiếm...">
					<div class="input-group-append">
						<span class="input-group-text" id="basic-addon2"><i
							class="fa fa-search"></i></span>
					</div>
				</div>
			</div>
		</div>
		<table class="table table-bordered table-hover mt-3">
			<thead>
				<tr>
					<th>STT</th>
					<th>Họ Tên</th>
					<th>Email</th>
					<th>Số ĐT</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Nguyễn Văn Tèo</td>
					<td>teonguyen@gmail.com</td>
					<td>098754636</td>
					<td><a href="user-edit.html" class="btn btn-sm btn-info">
							<i class="fa fa-pencil-square-o"></i>
					</a> <a href="#" class="btn btn-sm btn-danger"> <i
							class="fa fa-trash-o"></i>
					</a></td>
				</tr>
				<tr>
					<td>2</td>
					<td>Nguyễn Thùy Linh</td>
					<td>thuylinh@gmail.com</td>
					<td>0919255678</td>
					<td><a href="user-edit.html" class="btn btn-sm btn-info">
							<i class="fa fa-pencil-square-o"></i>
					</a> <a href="#" class="btn btn-sm btn-danger"> <i
							class="fa fa-trash-o"></i>
					</a></td>
				</tr>
			</tbody>
		</table>
	</section>
</body>

</html>