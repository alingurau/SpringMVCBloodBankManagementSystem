<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BLOOD BANK MANAGEMENT SYSTEM</title>
<style>
*{
    font-family: Arial, Helvetica, sans-serif;
}

.header h1 {
    font-size: 40px;
   
}
 
.header{    
    padding: 60px; /* some padding */
    text-align: center; /* center the text */
    background: grey;
    color: white; /* white text color */
}

/* Style the top navigation bar */
.navbar {
    overflow: hidden; /* Hide overflow */
    background-color: #333; /* Dark background color */
}

/* Style the navigation bar links */
.navbar a{
    float: left; /* Make sure that the links stay side-by-side */
    display: block; /* Change the display to block, for responsive reasons (see below) */
    color: white; /* White text color */
    text-align: center; /* Center the text */
    padding: 14px 20px; /* Add some padding */
    text-decoration: none; /* Remove underline */
}
/* Right-aligned link */
.navbar a.right {
    float: right; /* Float a link to the right */
}

/* Change color on hover/mouse-over */
.navbar a:hover {
    background-color: #ddd; /* Grey background color */
    color: black; /* Black text color */
}
.navbar input.right{
 	float: right;
    padding: 6px;
    border: none;
    margin-top: 8px;
    margin-right: 14px;
    font-size: 12px;
}


</style>
</head>
<body  background="https://images8.alphacoders.com/670/670007.jpg">
<div class="header">
	<h1 >BLOOD BANK MANAGEMENT SYSTEM</h1>
	<p>A website created by me</p>
</div>
<div class="navbar">
		<a href=" <c:url value="/bloodGroups.htm"/>">BLOOD GROUPS</a>
		<a href=" <c:url value="/clinics.htm"/>">CLINICS</a>
		<a href=" <c:url value="/donors.htm"/>">DONORS</a>
		<a href=" <c:url value="/receivers.htm"/>">RECEIVERS</a>
  		<a href="#" class="right">GO</a>
  		<input type="text" class="right" placeholder="Search..">
		<a href="#" class="right">LOGIN</a>
</div>


</body>
</html>