<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.0.min.js" integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <title>facebook</title>
        <style>
            #imageUpload
            {
                display: none;
            }

            #profileImage
            {
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <jsp:include page="navbar.jsp" />
        <br>
        <div class="container">
            <div class="row" >
                <div class="col-md-4" align="center">
                    <div class="card card-body">
                        <form method="POST" action="updateProfil.htm" enctype="multipart/form-data" accept="image/*">
                            <div class="form-group">                
                                <img id="profileImage" class="card-img-top" src="<c:url value="${account.user.imageLink}" />" style="width:150px; height:150px; border-radius:50%"></br></br>
                                <input id="imageUpload" type="file" name="profilimage" />
                            </div>
                            <div class="form-group">
                                <label>firstname</label><br>
                                <input type="text" name="firstname" class="form-control" value="${account.user.firstname}" />
                            </div>
                            <div class="form-group">
                                <label>lastname</label><br>
                                <input type="text" name="lastname" class="form-control" value="${account.user.lastname}" />
                            </div>
                            <div class="form-group">
                                <label>birth date</label><br>
                                <input type="date" name="birthdate" class="form-control" value="${account.user.birthdate}" />
                            </div>
                            <div class="form-group">
                                <label>password</label><br>
                                <input type="password" name="password" class="form-control" value="${account.password}"/>
                            </div>
                            <div class="form-group">                    
                                <input type="submit" name="update"  value="update" class="btn btn-primary form-control"/>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-8">
                    <c:forEach items="${account.user.posts}" var="post">
                        <div class="card card-body" style="width:80%">
                            <div align="left">
                                <table>
                                    <tr>
                                        <td><img src="${post.author.imageLink}" style="width:50px; height:50px; border-radius:50%"></td>
                                        <td><h5>&nbsp;${post.author}</h5></td>
                                        <td><form method="POST" action="removePost.htm"><input type="submit" class="btn btn-danger" value="delete" /></form></td>
                                    </tr>
                                </table>
                                <p>${post.content}</p>
                                <c:if test = "${post.fileLink != ''}">
                                    <c:if test = "${fn:startsWith(post.fileType, 'image')}">
                                        <img class="card-img-top" src="<c:url value="${post.fileLink}" />" alt="Card image" style="width:100%">                       
                                    </c:if>
                                    <c:if test = "${fn:startsWith(post.fileType, 'video')}">
                                        <video style="width:100%" controls>
                                            <source src="<c:url value="${post.fileLink}" />" type="<c:url value="${post.fileType}" />"/>
                                            <source src="<c:url value="${post.fileLink}" />" type="<c:url value="${post.fileType}" />"/>
                                        </video>
                                    </c:if>
                                    <c:if test = "${fn:startsWith(post.fileType, 'application')}">
                                        <a href="<c:url value="${post.fileLink}" />"><c:url value="${post.fileLink}" /></a>                       
                                    </c:if>
                                </c:if>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>    
    </body>
    <script>
        $("#profileImage").click(function (e) {
            $("#imageUpload").click();
        });
    </script>
</html>

