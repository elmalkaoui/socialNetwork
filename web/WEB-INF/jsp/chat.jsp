<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.0.min.js" integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <link href="${contextPath}/resources/css/chat.css" type="text/css" rel="stylesheet" />
        <title>facebook</title>
        <style>
            #fileUpload
            {
                display: none;
            }

            #filepj
            {
                cursor: pointer;
            }
        </style>
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
                                                <p>${message.message}</p><br/>
                                                <c:if test="${message.fileLink != ''}" >
                                                    <c:if test = "${fn:startsWith(message.fileType, 'image')}">
                                                        <img class="card-img-top" src="<c:url value="${message.fileLink}" />" alt="Card image" style="width:50%">                       
                                                    </c:if>
                                                    <c:if test = "${fn:startsWith(message.fileType, 'video')}">
                                                        <video style="width:50%" controls>
                                                            <source src="<c:url value="${message.fileLink}" />" type="<c:url value="${message.fileType}" />"/>
                                                            <source src="<c:url value="${message.fileLink}" />" type="<c:url value="${message.fileType}" />"/>
                                                        </video>
                                                    </c:if>
                                                    <c:if test = "${fn:startsWith(message.fileType, 'application')}">
                                                        <a href="<c:url value="${message.fileLink}" />"><c:url value="${message.fileLink}" /></a>                       
                                                    </c:if>
                                                </c:if>
                                                <span class="time_date"> ${message.date}</span>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${message.sender.id == account.user.id}">
                                    <div class="outgoing_msg">
                                        <div class="sent_msg">
                                            <p>${message.message}</p><br/>
                                            <c:if test="${message.fileLink != ''}" >
                                                <c:if test = "${fn:startsWith(message.fileType, 'image')}">
                                                    <img class="card-img-top" src="<c:url value="${message.fileLink}" />" alt="Card image" style="width:50%">                       
                                                </c:if>
                                                <c:if test = "${fn:startsWith(message.fileType, 'video')}">
                                                    <video style="width:50%" controls>
                                                        <source src="<c:url value="${message.fileLink}" />" type="<c:url value="${message.fileType}" />"/>
                                                        <source src="<c:url value="${message.fileLink}" />" type="<c:url value="${message.fileType}" />"/>
                                                    </video>
                                                </c:if>
                                                <c:if test = "${fn:startsWith(message.fileType, 'application')}">
                                                    <a href="<c:url value="${message.fileLink}" />"><c:url value="${post.fileLink}" /></a>                       
                                                </c:if>
                                            </c:if>
                                            <span class="time_date">${message.date}</span> </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                            <div class="type_msg">
                                <div class="input_msg_write msg_input" >
                                    <form method="POST" action="sendMessage.htm" enctype="multipart/form-data">
                                        <input type="text" class="write_msg" name="message" placeholder="Type a message" required/>
                                        <input type="hidden" name="receiver" value="${receiver}"/>
                                        <button class="msg_send_btn" type="submit"><img src="${contextPath}/resources/img/send.svg" width="30%" style="color:white"/></button>
                                        <img id="filepj" class="" src="${contextPath}/resources/img/upload.svg" style="width:30px"></br></br>
                                        <input id="fileUpload" type="file" name="file" />
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div></div>
        </div>
    </body>
    <script>
        $("#filepj").click(function (e) {
            $("#fileUpload").click();
        });
    </script>
</html>