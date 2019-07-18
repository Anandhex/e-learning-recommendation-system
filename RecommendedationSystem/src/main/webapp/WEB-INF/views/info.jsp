<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/heart.scss"/>">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" >
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" >
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/modal.css"/>">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>SkillIdea</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/aboutUs"><img src="/resources/images/logo/logo.jpg" width="40" class="d-inline-block align-top" height="30" alt="">SkillIDea</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/aboutUs">About Us <span class="sr-only">(current)</span></a>
      </li>
    </ul>
    <c:if test="${userData ne null}">
     <span style="margin-right:20px">Hi! <c:out value="${userData.firstName}"></c:out></span>
    <a class="nav-item active" href="/logout"><button class="btn btn-outline-success">Log Out</button></a>
  </c:if>
  <c:if test="${userData.firstName eq null }">
  	 <a class="nav-item active" href="/login"><button class="btn btn-outline-success">Login</button></a>
	 <a style="margin-left: 10px" class="nav-item active" href="register.jsp"><button class="btn btn-outline-success">Register</button></a>  		
  </c:if>
  </div>
</nav>


</body>
</html>