<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='v' uri='http://brouwerijen.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Brouwer ${brouwer.naam}' />
</head>
<body>
	<v:menu />
	<h1>brouwer ${brouwer.id}</h1>
	<%-- <spring:url value='/brouwers/{id}/wijzigen' var='url'> --%>
	<spring:url value='/brouwers/{id}/wijzigen' var='url'>
		<spring:param name='id' value='${brouwer.id}' />
	</spring:url>
	<h1>'${url}' </h1>
	<form:form action='${url}' commandName='brouwer'>
		<jsp:include page='brouwerformfields.jsp' />
		<input type='submit' value='Wijzigen'>
	</form:form>
</body>
</html>