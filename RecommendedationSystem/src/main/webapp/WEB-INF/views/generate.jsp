<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<link rel="stylesheet" href="/resources/css/progress.css">
<script type="text/javascript" src="/resources/js/pace.js"></script>
<title>Generate Recommendation!</title>
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
<div class="container">
<div class="jumbotron">
  <h1 class="display-4">Hello,<c:out value="${userData.firstName}"></c:out></h1>
  <p class="lead">Get the best recommendation.</p>
  <hr class="my-4">
  <p>It Uses the collaborative filtering to generate a set of recommendation to the user based on his tastes and likings   .</p>
  <p class="lead" style="margin-left: 35%">
    <a class="btn btn-primary btn-lg" href="/getReco" role="button">Get Recommendation</a>
  </p>
</div>
</div>

</body>
</html>