<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >

<title>Insert title here</title>
</head>
<body>
<div class="container" style="margin-top: 30px">
	<form:form action="/addCourse" method="post" modelAttribute="course" >
  <div class="form-group row">
    <form:label path="courseName" for="courseName" class="col-sm-2 col-form-label">courseName</form:label>
    <div class="col-sm-10">
      <form:input path="courseName" type="text" class="form-control" id="courseName" name="courseName" placeholder="Ex: John Doe"/>
    </div>
  </div>
  <div class="form-group row">
    <form:label path="content" for="content" class="col-sm-2 col-form-label">content</form:label>
    <div class="col-sm-10">
      <form:input path="content" type="text" class="form-control" id="content" name="content" placeholder="content"/>
    </div>
  </div>
  <div class="form-group row">
    <form:label path="imageUrl" for="imageUrl" class="col-sm-2 col-form-label">imageUrl</form:label>
    <div class="col-sm-10">
      <form:input path="imageUrl" type="text" class="form-control" id="imageUrl" name="imageUrl" placeholder="imageUrl"/>
    </div>
  </div>
  <div class="form-group row">
    <form:label path="author" for="author" class="col-sm-2 col-form-label">author</form:label>
    <div class="col-sm-10">
      <form:input path="author" type="text" class="form-control" id="author" name="author" placeholder="author"/>
    </div>
  </div>
  <div class="form-group row">
    <div class="col-sm-10">
      <button style="margin: 0 50% 0 50%" type="submit" class="btn btn-primary">Regsiter</button>
    </div>
  </div>
</form:form>

  </div>
	
</body>
</html>