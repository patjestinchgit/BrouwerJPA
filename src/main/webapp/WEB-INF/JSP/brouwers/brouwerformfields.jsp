<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://brouwerijen.be/tags'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:label path='naam'>Naam:<form:errors path='naam' />
	</form:label>
	<form:input path='naam' /> <%-- autofocus='autofocus'  required='required'
		maxlength='50' />  --%> 
	<form:label path='adres.straat'>Straat:
<form:errors path='adres.straat' delimiter=', ' />
	</form:label>
	<form:input path='adres.straat' /> <%-- required='required' maxlength='50' /> --%>  
	<form:label path='adres.huisNr'>Huisnr.:
<form:errors path='adres.huisNr' delimiter=', ' />
	</form:label>
	<form:input path='adres.huisNr' /> <%-- required='required' maxlength='7' /> --%> 
	<form:label path='adres.postcode'>Postcode:
<form:errors path='adres.postcode' delimiter=', ' />
	</form:label>
	<form:input path='adres.postcode' /> <%-- required='required' type='number'
		min='1000' max='9999' />  --%> 
	<form:label path='adres.gemeente'>Gemeente:
<form:errors path='adres.gemeente' delimiter=', ' />
	</form:label>
	<form:input path='adres.gemeente' />  <%-- required='required' maxlength='50' /> --%>  
	<form:label path='omzet'>Omzet:<form:errors path='omzet' />
	</form:label>
	<form:input path='omzet' autofocus='autofocus' />  <%-- required='required'
		type='number' min='0' />  --%> 
 </body>
</html>