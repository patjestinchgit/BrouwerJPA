<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://brouwerijen.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method='get' name='nowmfmt' id="formattime">
		<c:set var="nowfmt" value="<%=new java.util.Date()%>" />
		<input type="hidden" value='${nowfmt}' name='nowfmt'>
	</form>

	<script>
			document.getElementById("formattime").submit();
		</script>


</body>
</html>