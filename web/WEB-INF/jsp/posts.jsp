<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="${contextPath}/resources/css/posts.css" />
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <title>facebook</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp" />
        
        <br>
        <div class="container">
            <center>
                <div class="card" style="width:50%">
                    <br>
                    <h2>Share your thoughts</h2>
                    <h5>${msg}</h5>
                    <form class="form-horizontal" action="addpost.htm" method="POST" enctype="multipart/form-data">
                        <div class="form-group">
                            <div class="col-sm-10">
                                <textarea class="form-control" name="content" placeholder="What are you thinking ..."></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10"> 
                                <label for="file" class="filebtn"><span class="oi oi-image"></span> Attach something </label>
                                <input type="file" id="file" name="file" class="form-control inputfile">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10"> 
                                <input type="submit" value="Post" class="form-control btn btn-primary">
                            </div>
                        </div>
                </div>
                <c:forEach items="${posts}" var="post">
                    <br/>
                    <div class="card card-body" style="width:50%">
                        <div align="left">
                            <table><tr><td><img src="${post.author.imageLink}" style="width:50px; height:50px; border-radius:50%"></td>
                                    <td><h5>&nbsp;${post.author}</h5></td>
                                </tr></table>
                            <p>${post.content}</p>
                            <img class="card-img-top" src="<c:url value="${post.fileLink}" />" alt="Card image" style="width:100%">                       
                        </div>
                    </div>
                </c:forEach>
        </div>
    </center>

</body>
</html>
