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
        <style>
            td {padding:0 10px 0 0;}
        </style>
    </head>
    <body>
        <jsp:include page="navbar.jsp" />
        <br/>
        <div class="container">
            <table>
                <tbody>
                    <tr>
                        <c:forEach items="${friends}" var="item">                 
                            <td>
                                <div class="card card-body" align="center">
                                    <img class="card-img-top" src="<c:url value="${item.imageLink}" />" style="width:130px; height:130px; border-radius:50%" />
                                    <div class="card-body">
                                        <h4 class="card-title">${item.firstname}</h4>
                                        <p class="card-text">Hi i am using Bubbly</p>
                                        <table>
                                            <tbody>
                                                <tr>
                                                    <td>
                                                        <form method="POST" action="removefriend.htm">
                                                            <input type="hidden" name="userID" value="${item.id}"/>
                                                            <input type="submit" class="btn btn-primary" value="unfollow"/>
                                                        </form>
                                                    </td>
                                                    <td>
                                                        <form method="POST" action="messages.htm">
                                                            <input type="hidden" name="receiver" value="${item.id}"/>
                                                            <input type="submit" class="btn btn-primary" value="Message"/>
                                                        </form>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </td>
                        </c:forEach></tr>
                </tbody>
            </table>
        </div>    
    </body>
</html>
