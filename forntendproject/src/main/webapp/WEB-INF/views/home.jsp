<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  </style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="home">SHOP WORLD</a>
    </div>
    <ul class="nav navbar-nav">
 
      <li><a href="product">product</a></li>
      <li><a href="contact">AboutUS</a></li>
      <li><a href="contact">ContactUs</a></li>
    </ul>  
     <ul class="nav navbar-nav navbar-right">
      <li><a href="registration"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
<h2>Welcome to ShopingCart</h2>
	<c:if test="${isAdmin=='true'}">
    	<jsp:include page="admin/adminhome.jsp"></jsp:include>
	</c:if>
	<c:if test="${isAdminClickedCategories=='true'}">
		<jsp:include page="admin/category.jsp"></jsp:include>  
	</c:if>
	<c:if test="${isAdminClickedSuppliers=='true'}">
		<jsp:include page="admin/supplier.jsp"></jsp:include> <br>
	</c:if>
	<c:if test="${isAdminClickedProducts=='true'}">
		<jsp:include page="admin/product.jsp"></jsp:include> <br>
	</c:if>
	<br>
	<c:if test="${isUserClickedLogin=='true'}">
		<jsp:include page="login.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedRegister=='true' }">
		<jsp:include page="registration.jsp"></jsp:include>
	</c:if>
<jsp:include page="carousel.jsp"></jsp:include>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>