<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://brouwerijen.be/tags'%>
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
			<!-- 			<form method='get'> -->
			<spring:url value="brouwersopalfabet/{letter}" var="letterURL">
				<spring:param name='letter' value='${letter}' />
			</spring:url>
			<%-- <form action='${letterURL}' method='get'> --%>
			<%-- <c:url value="/brouwersopalfabet" var="letterURL">
				<c:param name="letter" value="${letter}" />
			</c:url> --%>
			<!-- </form> -->
			<li><a href="${letterURL}">${letter}</a></li>
			<!-- </form> -->
		</c:forTokens>
	</ul>
<%-- 	<h2>Stap 1</h2>
	<form method='post' action="<c:url value='/brouwersopalfabet'/>">
		<div>Hier vraag je later de voornaam, familienaam en e-mail
			adres</div>
		<input type='submit' value='Volgende stap' name='volgende'>
	</form>
 --%>	<br>
</body>
</html>