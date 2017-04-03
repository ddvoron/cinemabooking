<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="content">
    <c:forEach var="movie" items="${movies}" varStatus="status">
        <a href="/web/movies/${movie.getIdFilm()}">
            <div class="film">
                <div class="filmTitle">${movie.getFilm()}</div>
                <div>
                    <div class="filmDate">Date: ${movie.getDate()}</div>
                </div>
            </div>
        </a>
    </c:forEach>
</div>
