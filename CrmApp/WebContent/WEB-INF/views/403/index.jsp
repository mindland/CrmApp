<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="image/png" sizes="16x16"
	href='<c:url value="/CrmApp/static//assets/plugins/images/favicon.png"></c:url>'>
<title>403 - Forbidden</title>
</head>

<body>
	<!-- Preloader -->
	<div class="preloader">
		<div class="cssload-speeding-wheel"></div>
	</div>
	<section id="wrapper" class="error-page">
		<div class="error-box">
			<div class="error-body text-center">
				<h1>403</h1>
				<h3 class="text-uppercase">Bạn không có quyền truy cập !</h3>
				<p class="text-muted m-t-30 m-b-30">YOU SEEM TO BE TRYING TO
					FIND HIS WAY HOME</p>
				<a href='<c:url value="/home" />'
					class="btn btn-info btn-rounded waves-effect waves-light m-b-40">Về
					trang chủ</a>
			</div>
			<footer class="footer text-center">2018 © Pixel Admin.</footer>
		</div>
	</section>
	<!-- jQuery -->
	<script src='/CrmApp/static/plugins/bower_components/jquery/dist/jquery.min.js'></script>
	<!-- Bootstrap Core JavaScript -->
	<script src='/CrmApp/static/bootstrap/dist/js/bootstrap.min.js'></script>
	<script type="text/javascript">
		$(function() {
			$(".preloader").fadeOut();
		});
	</script>
</body>

</html>