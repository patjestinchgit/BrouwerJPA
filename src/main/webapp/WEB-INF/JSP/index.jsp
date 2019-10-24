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

	<div class="popup" onclick="myFunction()">
		<span class="popuptext" id="myPopup">Popup text...</span>
	</div>

	<script>
		// When the user clicks on <div>, open the popup
		function myFunction() {
			var popup = document.getElementById("myPopup");
			popup.classList.toggle("show");
		}
	</script>

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

	<form method='get' name='nowmfmt' id="formattime">
		<c:set var="nowfmt" value="<%=new java.util.Date()%>" />
		<input type="hidden" value='${nowfmt}' name='nowfmt'>
		<spring:url value="/{nowfmt}" var="nowmfmt">
			<spring:param name='nowmfmt' value='${nowfmt }' />
		</spring:url>
	</form>

	<spring:url value="/{nowmfmt}" var="nowmfmt">
		<spring:param name='nowfmt' value='nowfmt' />
	</spring:url>


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
	<img alt='Bierhuis' src='<c:url value="/images/bierhuis.jpg"/>'
		class='fullwidth'>
</body>
</html>