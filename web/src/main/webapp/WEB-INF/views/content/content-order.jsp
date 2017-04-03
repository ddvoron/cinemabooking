<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="content">

    <form action="<c:url value="/order/search/order"/>"/>
        Input orders ID
        <input type="text" name="id"/>
        <button type="submit">Search</button>
    Функция поиска работает в тестовом режиме, вводите натуральные числа, не больше максимального Integer
    </form>
    <c:if test="${order!=null}">
        Film: ${order.getFilm()}<br>
        Date: ${order.getDate()}<br>
        Tickets: ${order.getTickets()}
    </c:if>
</div>
