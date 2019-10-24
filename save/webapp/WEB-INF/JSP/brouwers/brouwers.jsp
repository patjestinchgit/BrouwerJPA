<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://brouwerijen.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Brouwers' />
</head>
<body>
	<v:menu />
	<h1>Alle brouwers</h1>
	<br>
	
	
		<table>
			<tr>
				<th>Nummer</th>
				<th>Naam</th>
				<th>Straat</th>
				<th>HuisNr</th>
				<th>Postcode</th>
				<th>Omzet</th>
			</tr>
			<c:forEach items='${brouwers}' var='brouwer'>
			<tr>
				<td>${brouwer.brouwerNr}</td>
				<td>${brouwer.naam}</td>
				<td>${brouwer.omzet}</td>
				<td>${brouwer.adres.straat}</td>
				<td>${brouwer.adres.huisNr}</td>
				<td>${brouwer.adres.postcode}</td>
				
			</tr>
			</c:forEach>
		</table>
		<c:forEach items='${brouwers}' var='brouwer'>
		<h2>${brouwer.naam}</h2>
		<p>${brouwer.adres.straat}
			${brouwer.adres.huisNr}<br> ${brouwer.adres.postcode}
			${brouwer.adres.gemeente}
		</p>
		</c:forEach>
</body>
</html>