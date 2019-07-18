<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Welcome!</title>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/homepage.css"/>">
</head>
<body style="background-image:url('/resources/images/bg/bghome.jpg');">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/aboutUs"><img src="/resources/images/logo/logo.jpg" width="40" class="d-inline-block align-top" height="30" alt="">SkillIDea</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="#">About Us <span class="sr-only">(current)</span></a>
      </li>
    </ul>
    <a class="nav-item active" href="/login"><button class="btn btn-outline-success">Login</button></a>
    <a style="margin-left: 10px" class="nav-item active" href="/register"><button class="btn btn-outline-success">Register</button></a>
  </div>
</nav>
<div class="container">
	<div class="center-div">
	<div class="card" style="width: 18rem; border-color: ; opacity: 0.8">
  <div class="card-body">
    <h5 class="card-title" style="margin-left: 35%">Skill Idea</h5>
    <p class="card-text">The best E-Learning Recommendation site.</p>
    
  </div>
</div>

</div>
</div>
</body>
</html>