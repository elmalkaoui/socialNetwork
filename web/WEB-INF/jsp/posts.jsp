<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <title>facebook</title>
</head>
    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <form class="form-inline" method="POST" action="search.htm">
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">@</span>
                    </div>
                      <input type="text" class="form-control" placeholder="Username" name="username">
                  </div>    
                </form>
                <ul class="navbar-nav">
                  <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/posts.htm" >Posts</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/friends.htm">Friends</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/logout.htm">Logout</a>
                  </li>
                </ul>
            </nav>
            <br>
            <div class="container">
            <center>
            <div class="card" style="width:50%">
                <br>
                <h2>${msg}</h2>
            <form class="form-horizontal" action="addpost.htm" method="POST" enctype="multipart/form-data">
                <div class="form-group">
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="content" placeholder="What do you think ...">
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-sm-10"> 
                    <input type="file" name="file" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-sm-10"> 
                    <input type="submit" value="Add" class="form-control btn btn-primary">
                  </div>
                </div>
            </div>
            
            <c:forEach items="${posts}" var="post">
                <br/>
               <div class="card" style="width:50%">
                   <h3>${post.content}</h3>
                   <br/>
                   <img class="card-img-top" src="<c:url value="${post.fileLink}" />" alt="Card image" style="width:100%">                       
                </div>
            </c:forEach>
            </center>
            </div>
</body>
</html>
