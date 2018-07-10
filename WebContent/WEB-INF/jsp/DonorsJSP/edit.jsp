<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EDITEAZA DONATOR</title>
<style>
table {
    font-family: verdana, sans-serif, bold;
    border-collapse: collapse;
    width: 50%;
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
color: 	black;
border: 1px solid white;
border-radius: 10px;
align:right;
}
input.MyButton:hover {
color: #ffff00;
background: #000;
border: 1px solid white;
}

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    border: 1px solid white;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: 	#C0C0C0;
    color: 	black;
    padding: 10px;
    margin: 8px 0;
    border: 1px solid white;
    border-radius: 10px;
    cursor: pointer;
    font-weight: bold;
	font-size: 100%;
}

input[type=submit]:hover {
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
<h4 style="color:black; font-size:320%; text-align:center; border:2px;">EDIT DONOR</h4>

<div>
	<form:form action="${pageContext.request.contextPath}/donors/save" method="post" commandName="donorForm">
	<td>ID:</td>
		<form:input path="id" readonly="true"/>
	<td>Nume:</td>
		<form:input path="nume"/>
	<td>Prenume:</td>
		<form:input path="prenume"/>
	<td>CNP:</td>
		<form:input path="cnp"/>
	<td>Adresa:</td>
		<form:input path="adresa"/>
	<td>Email:</td>
		<form:input path="email"/>
	<td>Numar telefon:</td>
		<form:input path="numarTelefon"/>
	<input type=submit value="Save"/>
	</form:form>
</div>
<br>
<input class="MyButton" type="button" value="Back to List" onclick="window.location.href='<c:url value="/donors.htm"/>'" />
</body>
</html>