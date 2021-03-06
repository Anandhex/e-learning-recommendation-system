<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/css/progress.css">
<script type="text/javascript" src="/resources/js/pace.js"></script>

<title>Your Recommendation!</title>
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
			<div class="form-row">	
			<c:set var="count" value="1" scope="page"></c:set>	
							<c:forEach items="${courses}" var="course">
								<form:form action="/addRecommended" method="GET">
							 	<div class="col-3">
							 		<div class="card" style="width: 18rem;">
							  		<img src="${course.imageUrl}" class="card-img-top" data-toggle="popover" title="Popover title" data-content="And here's some amazing content. It's very engaging. Right?" alt="...">
											  			<div class="card-body">
											    		<h5 class="card-title">${course.courseName}</h5>
											    		<p class="card-text" style="text-overflow: ellipsis; width: 200px; overflow: hidden;white-space: nowrap">${course.content}</p>
											    		<input type="hidden" name="courseName" value="${course.courseName }">
											    		<button class="btn btn-info btn-sm" id="none" onclick="changeText">Opted:<c:out value="${course.number }"></c:out></button>
											    		<input type="hidden" name="email" value="${userData.email}">
											    						<button class="btn btn-info btn-sm" id="addCourse" onclick="changeText">Add course</button>
																		<!-- Trigger the modal with a button -->
																		<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal${count}">More Info</button>
															
																				<!-- Modal -->
																				<div id="myModal${count}" class="modal fade" role="dialog">
																				  <div class="modal-dialog">
																				
																				    <!-- Modal content-->
																				    <div class="modal-content">
																				      <div class="modal-header">
																				        <button type="button" class="close" data-dismiss="modal">&times;</button>
																				        <h4 class="modal-title">Course Name:${course.courseName}</h4>
																				      </div>
																				      <div class="modal-body">
																				      	<p>Course Author:${course.author}</p>
																				        <p>Course Content:${course.content}</p>
																				      </div>
																				      <div class="modal-footer">
																				        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
																				      </div>
																				    </div>
																				  </div>
																				</div>
											              </div>  
									</div>
							<c:set var="count" value="${count+1}" scope="page"></c:set>
								</div>
								</form:form>
							<c:if test="${count}%4==0">
							</div>
							<div class="form-row">
							</c:if>	
							</c:forEach>
				</div>
					  
			</div>
	  <form action="/save" method="get">
	  	<button style="margin-left: 50%;margin-top: 10%;" class="btn btn-primary ">save</button>
	  </form>
    </div>
<script type="text/javascript">
	function changeText() {
		var k = document.getElementById("addCourse");
		k.innerText="Course Added";
	}
</script>

</body>
</html>