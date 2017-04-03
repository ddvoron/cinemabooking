<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="content">
    <div class="filmDetails">
        <div class="filmTitle">${movie.getFilm()}</div>
        <div>
            <div class="filmDate">Date: ${movie.getDate()}</div>
            <div class="seat">Number of seats available: ${freeSeats}</div>
        </div>
    </div>
    <div>
        <p>Choose seats you like and confirm your order!</p>
        <h3>Screen</h3>
    </div>
    <div id="schemaContainer">
        <form id="schema">
            <c:forEach var="ticket" items="${schema}" varStatus="status">
                <c:if test="${ticket.getBooked()==1}">
                    <div class="schemaBooked">
                        x
                    </div>
                </c:if>
                <c:if test="${ticket.getBooked()==0}">
                    <div class="schemaFree">
                        <input name="arr[]" type="checkbox" value="${ticket.getRow()}-${ticket.getSeat()}"/>
                    </div>
                </c:if>
            </c:forEach>
        </form>
    </div>
    <div id="button">
        <input class="btn_order" type="button"
               onclick="event.preventDefault();makeOrder(${movie.getIdFilm()});"
               value="Make order"/>
    </div>
</div>
