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
        <center>
        <div class="card card-body" style="width:400px">
               <form method="POST" action="updateProfil.htm" enctype="multipart/form-data">
                <div class="form-group">                
                    <img id="profileImage" class="card-img-top" src="<c:url value="${account.user.imageLink}" />" style="width:150px; height:150px; border-radius:50%"></br></br>
                    <input id="imageUpload" type="file" name="profilimage" />
                </div>
                <div class="form-group">
                    <label>firstname</label><br>
                    <input type="text" name="firstname" value="${account.user.firstname}" />
                </div>
                <div class="form-group">
                    <label>lastname</label><br>
                    <input type="text" name="lastname" value="${account.user.lastname}" /><br>
                </div>
                <div class="form-group">
                    <label>birth date</label><br>
                    <input type="date" name="birthdate" value="${account.user.birthdate}" /><br>
                </div>
                <div class="form-group">
                    <label>password</label><br>
                    <input type="password" name="password" value="${account.password}"/><br>
                </div>
                <div class="form-group">                    
                    <input type="submit" name="update" value="update" class="btn btn-defaul"/>
                </div>
                </form>
        </div>
        </center>
        </div>    
</body>
        <script>
            $("#profileImage").click(function(e) {
                $("#imageUpload").click();
            });
        </script>
</html>

