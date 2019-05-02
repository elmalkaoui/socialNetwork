<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link href="${contextPath}/resources/css/chat.css" type="text/css" rel="stylesheet" />
        <title>facebook</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp" />
        <br/>
        <div class="container">
            <c:forEach items="${friends}" var="friend">  
                <div class="list-group">
                    <div class="list-group-item">
                        <table><tr><td><img src="${friend.imageLink}" style="width:50px; height:50px; border-radius:50%"></td>
                                <td><h5 class="list-group-item-heading">&nbsp;${friend}</h5></td>
                                <td>
                                    <form method="POST" action="messages.htm">
                                        <input type="hidden" name="receiver" value="${friend.id}" />
                                        <button type="submit" class="msg_send_btn" value="message" >
                                            <img src="${contextPath}/resources/img/chat.svg" width="30%"/>
                                        </button>
                                    </form>
                                </td>
                            </tr></table>

                    </div>
                </div>
            </c:forEach>               
        </div>
    </body>
</html>