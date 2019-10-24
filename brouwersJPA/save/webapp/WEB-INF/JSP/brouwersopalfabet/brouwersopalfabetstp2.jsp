<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://brouwerijen.be/tags'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Brouwers op alfabet' />
</head>
<body>
	<v:menu />
	<h1>Brouwers op alfabet</h1>

	<ul class="zonderbolletjes">
		<c:set var="alphabet">A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z</c:set>
		<c:forTokens var='letter' items="${alphabet}" delims=",">

			<%-- <c:url value="/brouwersopalfabetstp2" var="letterURL"> --%>
			<spring:url value="/brouwersopalfabet/{letter}" var="letterURL"> 
				<%-- <c:param name="letter" value="${letter}" /> --%>
				<spring:param name='letter' value='${letter}'/>
			</spring:url>

			<li><a href="${letterURL}">${letter}</a></li>
		</c:forTokens>

	</ul>


	<c:if test="${not empty brouwers}" />
	<ul>
		<c:forEach items='${brouwers}' var='brouwer'>
			<%-- <c:if test="${not empty brouwers }"> --%>
			<li>${brouwer.naam}( ${brouwer.adres.gemeente} )</li>
			<%-- </c:if> --%>
		
		</c:forEach>
	</ul>	

			<c:if test="${empty brouwers }">
				<h3>Geen brouwer gevonden met dit startletter</h3>

			</c:if>




			<br>

			<form method='post'>
				<input type='submit' value='Terug naar overzicht' name='vorige'>
			</form>
</body>

</html>