<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="top">
    <ul class="menu">
        <li><a href="<c:url value="/movies"/>">Movie List</a></li>
        <li><a href="<c:url value="/orders"/>">Orders</a></li>
        <li><a href="<c:url value="/order/search"/>">Search</a></li>
    </ul>
</div>