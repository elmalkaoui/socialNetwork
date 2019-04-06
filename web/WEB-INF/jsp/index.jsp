<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <title>facebook</title>
</head>
    <body>
        <div class="container">
        <h1>${message}</h1>
            <h2>Sign up</h2>
                <form action="signin.htm" method="POST">

                    <label>username</label><br>
                    <input type="text" name="username"/><br>

                    <label>Password</label><br>
                    <input type="password" name="password"/><br><br>

                    <input type="submit" name="signin" value="Sign in"/>
                </form>
        <h2 color="red">Sign up</h2>
            <form action="signup.htm" method="POST">

                <label>username</label><br>
                <input type="text" name="username"/><br>

                <label>firstname</label><br>
                <input type="text" name="firstname"/><br>

                <label>lastname</label><br>
                <input type="text" name="lastname"/><br>

                <label>birthday date</label><br>
                <input type="date" name="birthdate"/><br>

                <label>Password</label><br>
                <input type="password" name="password"/><br><br>

                <input type="submit" name="signin" value="Sign in"/>
            </form>
        </div>    
</body>
</html>
