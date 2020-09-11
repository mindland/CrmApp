
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="image/png" sizes="16x16"
	href="assets/plugins/images/favicon.png">
<title><dec:title /></title>
<!-- Bootstrap Core CSS -->
<link href="assets/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Menu CSS -->
<link
	href="assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css"
	rel="stylesheet">
<!-- animation CSS -->
<link href="/SERVLET-CRM/assets/css/animate.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="/SERVLET-CRM/assets/css/style.css" rel="stylesheet">
<!-- color CSS -->
<link href="/SERVLET-CRM/assets/css/colors/blue-dark.css" id="theme" rel="stylesheet">
</head>
<body>
	<div class="preloader">
		<div class="cssload-speeding-wheel"></div>
	</div>
	<div id="wrapper">
		<%-- HEADER --%>
		<jsp:include page="/views/layout/header.jsp" />

		<%-- SIDEBAR --%>
		<jsp:include page="/views/layout/sidebar.jsp" />

		<div id="page-wrapper">
			<dec:body />
		</div>


		<!-- FOOTER -->
		<jsp:include page="/views/layout/footer.jsp"></jsp:include>
	</div>


	<!-- Begin Script -->
	<!-- /#wrapper -->
	<!-- jQuery -->
	<script src="assets/plugins/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="assets/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- Menu Plugin JavaScript -->
	<script
		src="/SERVLET-CRM/assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
	<!--slimscroll JavaScript -->
	<script src="/SERVLET-CRM/assets/js/jquery.slimscroll.js"></script>
	<!--Wave Effects -->
	<script src="/SERVLET-CRM/assets/js/waves.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="/SERVLET-CRM/assets/js/custom.min.js"></script>
</body>
</html>