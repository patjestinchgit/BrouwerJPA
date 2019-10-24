<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://brouwerijen.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Brouwers op alfabet' />
</head>

<body>
	<v:menu />
	<h1>Brouwers op naam</h1>
	<c:url value='/brouwersopnaam' var='url' />
	<form:form action='${url}' commandName='brouwersOpNaam' method='get'>
		<form:label path='beginnaam'>Begin van de naam:
		<form:errors path='beginnaam' />
		</form:label>
		<form:input path='beginnaam' autofocus='autofocus' />
		<input type='submit' value='Zoeken'>
		<form:errors cssClass='fout' />
	</form:form>
	<ul class="zonderbolletjes">
		<li><c:forEach items='${brouwers}' var='brouwer'>
				<spring:url var='url' value='/brouwers/{id}'>
					<spring:param name='id' value='${brouwer.id}' />
				</spring:url>
				<h2>
					<a href='${url}'>${brouwer.naam}</a>
				</h2>
			</c:forEach></li>
	</ul>

</body>
</html>