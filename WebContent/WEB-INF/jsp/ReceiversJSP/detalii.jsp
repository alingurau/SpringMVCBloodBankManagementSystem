<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DETALII PRIMITOR</title>
   <style>
table {
    font-family: verdana, sans-serif, bold;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: center;
    padding: 8px;
}

th {
	background-color: #b4b4b4;
	color:black;
}

tr{
    background-color: white;
    color: green;
}

input.MyButton {
width: 150px;
padding: 10px;
cursor: pointer;
font-weight: bold;
font-size: 100%;
background: 	#C0C0C0;
color: black;
border: 1px solid white;
border-radius: 10px;
}
input.MyButton:hover {
color: #ffff00;
background: #000;
border: 1px solid white;
}
</style>
</head>
<body background="https://brookline.com/wp-content/uploads/2017/08/blood.png">
<form>
	<input class="MyButton" type="button" value="Home" onclick="window.location.href='<c:url value="/frontPage.htm"/>'" />
</form>
<h4 style="color:black; font-size:320%; text-align:center; border:2px;">DETAILS</h4>

<table>
	<tr>
		<th>ID</th>
		<th>Nume</th>
		<th>Prenume</th>
		<th>Gen</th>
		<th>CNP</th>
		<th>Adresa</th>
		<th>Email</th>
		<th>Telefon</th>
	</tr>
	<tr>
		<td><c:out value="${receiver.id }"/></td>
		<td><c:out value="${receiver.nume }"/></td>
		<td><c:out value="${receiver.prenume }"/></td>
		<td><c:out value="${receiver.gen }"/></td>
		<td><c:out value="${receiver.cnp }"/></td>
		<td><c:out value="${receiver.adresa }"/></td>
		<td><c:out value="${receiver.email }"/></td>
		<td><c:out value="${receiver.numarTelefon }"/></td>
	</tr>
</table>
<br>
<input class="MyButton" type="button" value="Back" onclick="window.location.href=' <c:url value="/receivers.htm"/>'"/>
</body>
</html>