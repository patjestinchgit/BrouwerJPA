<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://brouwerijen.be/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Brouwer toevoegen' />
</head>
<body>
	<v:menu />
	<h1>Brouwer toevoegen</h1>
	Hier komen later de invoervelden van de brouwerij ...
	
	
	<c:url value='/brouwers' var='url' />
	<form:form action='${url}' commandName='brouwer' id='toevoegform'>
		<jsp:include page='brouwerformfields.jsp' />
		<input type='submit' value='Toevoegen' id='toevoegknop'>
		<form:errors cssClass='fout'/>
	</form:form>
	<script>
		document.getElementById('toevoegform').onsubmit = function() {
			document.getElementById('toevoegknop').disabled = true;
		};
	</script>

	<v:return />
</body>
</html>