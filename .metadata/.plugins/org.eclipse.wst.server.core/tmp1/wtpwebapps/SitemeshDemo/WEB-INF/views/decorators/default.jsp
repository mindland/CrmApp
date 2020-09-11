<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title><dec:title /></title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/SitemeshDemo/static/css/bootstrap.min.css">
    <link rel="stylesheet" href='/SitemeshDemo/static/css/style.css'>
</head>

<body>

    <div class="d-flex justify-content-between">
        <!-- SIDE BAR -->
        <jsp:include page="/WEB-INF/views/layout/sidebar.jsp"></jsp:include>

        <div id="admin-wrapper">
        
            <!-- HEADER -->
            <jsp:include page="/WEB-INF/views/layout/navbar.jsp"></jsp:include>

            <!-- CONTENT -->
            <dec:body></dec:body>
           
        </div>
    </div>
    
    <script src="/SitemeshDemo/static/js/jquery.slim.min.js"></script>
    <script src="/SitemeshDemo/static/js/popper.min.js"></script>
    <script src="/SitemeshDemo/static/js/bootstrap.min.js"></script>
    <script src='/SitemeshDemo/static/js/chart.min.js'></script>
    <script src='/SitemeshDemo/static/js/custom-chart.js'></script>
</body>

</html>