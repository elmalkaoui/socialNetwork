<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${contextPath}/resources/font/css/open-iconic-bootstrap.css" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
    </head>
    <body>
        <nav class="navbar sticky-top navbar-expand-sm bg-primary navbar-dark">
            <h3 style="color:white" class="col-md-2">Bubbly</h3>
            
                <form class=" col-md-8" method="POST" action="search.htm">
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">@</span>
                    </div>
                      <input type="text" class="form-control col-md-8" placeholder="search" name="username">
                  </div>    
                </form>
                
                <ul class="navbar-nav col-md-2" >
                    
                  <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/setting.htm" style="color:white;font-weight: bold">${sessionScope.currentUser.username}</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/posts.htm"><span style="color:white;font-weight: bold" class="oi oi-home"></span></a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/friends.htm"><span style="color:white;font-weight: bold" class="oi oi-person"></span></a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/notifications.htm"><span style="color:white;font-weight: bold" class="oi oi-bell"></span></a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/chat.htm"><span style="color:white;font-weight: bold" class="oi oi-chat"></span></a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/logout.htm"><span style="color:white;font-weight: bold" class="oi oi-account-logout"></span></a>
                  </li>
                </ul>
            </nav>
    </body>
</html>