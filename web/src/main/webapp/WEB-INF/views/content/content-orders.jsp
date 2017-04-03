<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="content">
    <c:forEach var="order" items="${orders}" varStatus="status">
        <div class="item" id="order${order.getIdOrder()}">
            <div class="item1">
                <div class="item2">ID: ${order.getIdOrder()}</div>
                <div class="item2">Film: ${order.getFilm()}</div>
                <div class="item3">
                    Display date: ${order.getDate()}</div>
                <div class="item4">
                    Number of tickets: ${order.getTickets().getTickets().size()}</div>
            </div>
            <div class="item2">
                <div class="item5" onclick="deleteOrder(${order.getIdOrder()});">
                    Cancel reservation
                </div>
            </div>
        </div>
    </c:forEach>
</div>
