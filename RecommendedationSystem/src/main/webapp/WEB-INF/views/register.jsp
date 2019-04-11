<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title></title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/aboutUs"><img src="D:\HTML files\res\logo\Si_Logo_orange.jpg" width="40" class="d-inline-block align-top" height="30" alt="">SkillIDea</a>
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
    <a class="nav-item active" href="/login"><button class="btn btn-outline-success">Login</button></a>
	    
  </div>
</nav>
<div class="container" style="width: 40%; margin-top: 40px">
<form:form action="/register" method="post" modelAttribute="user" >
  <div class="form-group row">
    <form:label path="firstName" for="fullName" class="col-sm-2 col-form-label">Full Name</form:label>
    <div class="col-sm-10">
      <form:input path="firstName" type="text" class="form-control" id="fullName" name="fullName" placeholder="Ex: John Doe"/>
    </div>
  </div>
  <div class="form-group row">
    <form:label path="email" for="inputEmail" class="col-sm-2 col-form-label">Email</form:label>
    <div class="col-sm-10">
      <form:input path="email" type="email" class="form-control" id="inputEmail" name="inputEmail" placeholder="Email"/>
    </div>
  </div>
  <div class="form-group row">
    <form:label path="password" for="inputPassword" class="col-sm-2 col-form-label">Password</form:label>
    <div class="col-sm-10">
      <form:input path="password" type="password" class="form-control" id="inputPassword" name="inputPassword" placeholder="Password"/>
    </div>
  </div>
  
<div class="form-group row">
    <div class="col-sm-10">
      <button style="margin: 0 50% 0 50%" type="submit" class="btn btn-primary">Regsiter</button>
    </div>
  </div>
</form:form>
</div>
<p align="center"><c:if test="${requestScope.error ne null}">
		<strong style="color: red;"><c:out
				value="${requestScope.error}"></c:out></strong>
	</c:if>
	<c:if test="${requestScope.success ne null}">
		<strong style="color: green;"><c:out
				value="${requestScope.success}"></c:out></strong>
	</c:if></p>
</body>
</html>