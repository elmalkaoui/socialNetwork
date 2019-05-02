<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
        <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/login.css"/>
        <title>Facebook</title>
    </head>
    <body style="padding: 0">
        <div class="main-container">
            <div id="signin-form">
                <form action="signin.htm" method="POST">
                    <div>
                        <label>Username</label>
                        <input type="text" name="username" placeholder="type your username" class="form form-control" required/>
                    </div>
                    <div>
                        <label>Password</label>
                        <input type="password" name="password" placeholder="********" class="form form-control" required/>    
                    </div>
                    <div>
                        <h1></h1><br>
                        <input type="submit" class="btn btn-dark" name="signin" value="Log in"/>
                    </div>
                </form>
                <br>
                <div class="col-md-3">
                    <c:if test="${message != null}" >
                    <div class="alert alert-warning">
                        <strong>${message}</strong>
                    </div>
                </c:if>
                </div>
            </div>
            <div>
                <div class="card signup-card col-md-3">
                    <div class="card-body">
                        <h2 class="card-title">Join the world</h2>
                        <div class="card-text">
                            <form action="signup.htm" method="POST">
                                <input type="text" name="username" placeholder="username" class="form form-control" required/><br>
                                <input type="text" name="firstname" placeholder="firstname" class="form form-control" required/><br>
                                <input type="text" name="lastname" placeholder="lastname" class="form form-control" required/><br>
                                <input type="password" name="password" placeholder="password" class="form form-control" required/><br>
                                <label>Birthdate</label>
                                <input type="date" name="birthdate" class="form form-control" required/><br>

                                <input type="submit" class="btn btn-outline-primary" name="signin" value="Sign up"/>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-1"></div>
                <div class="col-md-7 header">
                    <h1>Welcome to Bubbly</h1><br>
                    <p>Chat with friends</p>
                    <p>Play games</p>
                    <p>Watch movies</p>
                </div>
            </div>

        </div>    
    </body>
</html>
