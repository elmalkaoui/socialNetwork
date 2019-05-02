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
        <div class="chat-container">
            <div class="messaging">
                <div class="inbox_msg">  
                    <div class="mesgs">
                        <div class="msg_history">
                            <c:forEach items="${messages}" var="message">
                                <c:if test="${message.sender.id != account.user.id}">
                                    <div class="incoming_msg">
                                        <div class="incoming_msg_img"> <img src="<c:url value="${message.sender.imageLink}" />"> </div>
                                        <div class="received_msg">
                                            <div class="received_withd_msg">
                                                <p>${message.message}</p>
                                                <span class="time_date"> ${message.date}</span></div>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${message.sender.id == account.user.id}">
                                    <div class="outgoing_msg">
                                        <div class="sent_msg">
                                            <p>${message.message}</p>
                                            <span class="time_date">${message.date}</span> </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                            <div class="type_msg">
                                <div class="input_msg_write msg_input" >
                                    <form method="POST" action="sendMessage.htm">
                                        <input type="text" class="write_msg" name="message" placeholder="Type a message" required/>
                                        <input type="hidden" name="receiver" value="${receiver}"/>
                                        <button class="msg_send_btn" type="submit"><img src="${contextPath}/resources/img/send.svg" width="30%" style="color:white"/></button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div></div>
        </div>
    </body>
</html>