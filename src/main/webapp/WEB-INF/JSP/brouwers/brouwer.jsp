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
	<h1>Brouwer</h1>
</head>
<c:choose>
	<c:when test="${not empty brouwer}">
		<h1>${brouwer.naam}</h1>
		<h2>${brouwer.omzet}</h2>
		<br>
		<h3>Adres:</h3>
		<dl>
			<dt>Straat</dt>
			<dd>${brouwer.adres.straat}</dd>
			<dt>Huisnr.</dt>
			<dd>${brouwer.adres.huisNr}</dd>
			<dt>Postcode</dt>
			<dd>${brouwer.adres.postcode}</dd>
			<dt>Gemeente</dt>
			<dd>${brouwer.adres.gemeente}</dd>
		</dl>
		<spring:url value='{id}/wijzigen' var='wijzigURL'>
			<spring:param name='id' value='${brouwer.id}' />
		</spring:url>
		<form action='${wijzigURL}'>
			<input type='submit' value='Wijzigen'>
		</form>
		<spring:url value='{id}/verwijderen' var='verwijderURL'>
			<spring:param name='id' value='${brouwer.id}' />
		</spring:url>
		<form action='${verwijderURL}' method='post'>
			<input type='submit' value='Verwijderen'>
		</form>
	</c:when>

	<c:otherwise>
		<div class='fout'>brouwer niet gevonden</div>
	</c:otherwise>
</c:choose>

<br>

<c:if test='${not empty param.fout}'>
	<div class='fout'>${param.fout}</div>
</c:if>



<body>

</body>
</html>