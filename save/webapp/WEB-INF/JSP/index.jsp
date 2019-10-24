<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://brouwerijen.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='/brouwers' />
</head>
<body>
	<v:menu />
	<h1>Brouwers</h1>
	<blockquote>Lorem Ipsum</blockquote>
	<img alt='Bierhuis'
		src='<c:url value="/images/bierhuis.jpg"/>' class='fullwidth'>
</body>
</html>