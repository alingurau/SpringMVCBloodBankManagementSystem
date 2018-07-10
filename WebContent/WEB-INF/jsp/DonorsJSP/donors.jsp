<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DONATORI</title>
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

.action{
	float:left;
	width: 100px;
	background:lightgrey;
	display: block; /* Change the display to block, for responsive reasons (see below) */
    color: black; /* White text color */
    text-align: center; /* Center the text */
    padding: 5px ; /* Add some padding */
    text-decoration: none; /* Remove underline */
    border-radius: 10px;
	
}

.action:hover{
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
<h4 style="color:black; font-size:320%; text-align:center; border:2px;">DONORS</h4>

<table>
	<tr>
		<th>ID</th>
		<th>Nume</th>
		<th>Prenume</th>
		<th>Action</th>
	</tr>

	<c:forEach var="donor" items="${donorsList }">
	<tr>
		<td><c:out value="${donor.id }"/></td>
		<td><c:out value="${donor.nume}"/></td>
		<td><c:out value="${donor.prenume }"/></td>
		<td><a class="action" href=" <c:url value="/donors/detalii/${donor.id}"/>">Detalii</a> 
			<a class="action" href=" <c:url value="/donors/${donor.id }"/>">Delete</a>
			<a class="action" href=" <c:url value="/donors/adauga/${donor.id }"/>">Adauga</a>
			<a class="action" href=" <c:url value="/donors/editeaza/${donor.id }"/>">Edit</a>
		</td>
	</tr>
	<br/>
	</c:forEach>
</table>
</body>
</html>