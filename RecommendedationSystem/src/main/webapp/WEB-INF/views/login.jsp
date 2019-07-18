<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Sign in</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
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
        <a class="nav-link" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/aboutUs">About Us <span class="sr-only">(current)</span></a>
      </li>
    </ul>
    <a class="nav-item active" href="/register"><button class="btn btn-outline-success">Sign Up</button></a>
    
  </div>
</nav>
<div class="container" style="width: 40%; margin-top: 40px">
<form action="/login" method="post">
  
  <div class="form-group row">
    <label for="email" class="col-sm-2 col-form-label">Email</label>
    <div class="col-sm-10">
      <input  type="email" class="form-control" id="email" name="email" placeholder="Email"/>
    </div>
  </div>
  <div class="form-group row">
    <label  for="password" class="col-sm-2 col-form-label">Password</label>
    <div class="col-sm-10">
      <input  type="password" class="form-control" id="password" name="password" placeholder="Password"/>
    </div>
  </div>
  
<div class="form-group row">
    <div class="col-sm-10">
      <button style="margin-left: 50%" type="submit" class="btn btn-primary">Log In</button>
    </div>
  </div>
</form>
</div>
<p align="center"><c:if test="${errorMessage ne null}">
		<strong style="color: red;"><c:out
				value="${errorMessage}"></c:out></strong>
	</c:if>
	
</body>
</html>