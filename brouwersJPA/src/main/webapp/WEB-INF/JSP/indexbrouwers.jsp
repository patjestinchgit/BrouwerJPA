<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://brouwerijen.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!doctype html>
<html lang='nl'>
<head>
<v:head title='/brouwers' />
</head>
<body>
	<v:menu />
	<h2>Date Format:</h2>


	<%-- <form method="post" id="tzForm" action="">
      <input id="tzInput" type="hidden" name="timeZoneOffset"><br>
      <input type="hidden" name="requestedUrl" value="${requestedUrl}" >
    </form>

    <script>
        var date = new Date()
        var offSet = date.getTimezoneOffset()
        document.getElementById("tzInput").value = offSet;
        document.getElementById("tzForm").submit();
    </script>
 --%>
	<%-- <c:set var="nowfmt" value="<%=new java.util.Date()%>" /> --%>

	<script>
		document.getElementById("formattime").submit();
	</script>

	<h2>
		<%-- <fmt:message key="${indexlanguagetime}" >
		</fmt:message>

		<script>
			document.getElementById("formattime").submit();
		</script>
 --%>
	</h2>

	<h1>


		<spring:message code="${indexlanguagetime}" text="Hello">
			<%-- <spring:url value="brouwersopalfabet/{nowfmt}" var="<%=new java.util.Date()%>">
				<spring:param name="nowfmt" />
			</spring:url> --%>
		</spring:message>
		<%-- <spring:message code="${indexlanguagetime}"> var="${nowfmt}"
			<c:set var="nowfmt" value="<%=new java.util.Date()%>" />
		</spring:message> --%>
	</h1>


	<%-- 	<spring:param value="${now}" name="nowfmt">
		<c:set var="now" value="<%=new java.util.Date()%>" />
	</spring:param> --%>



	goodnight goodmorning goodafternoon goodevening

	<blockquote>Lorem Ipsum</blockquote>
	<%-- <img alt='Bierhuis' src='<c:url value="/images/bierhuis.jpg"/>'
		class='fullwidth'> --%>
	<c:set var='foto' value='${empty foto ? "ochtend" : foto}' />
	<img alt='Bierhuis${foto}'
		src='<c:url value="/images/bierhuis${foto}.jpg"/>' class='fullwidth'>

	<c:url var='ochtendURL' value=''>
		<c:param name='foto' value='ochtend' />
	</c:url>
	<c:url var='avondURL' value=''>
		<c:param name='foto' value='avond' />
	</c:url>
	<a href='${ochtendURL}'>Ochtend</a>
	<a href='${avondURL}'>Avond</a>
</body>
</html>