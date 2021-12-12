<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
<title>Search Result</title>
</head>
<body>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<div align="center">
        <table border="1" cellpadding="5" style="background-color:DodgerBlue;">
            <caption><h2>List of Users</h2></caption>
       
            
            <tr>
                <th>User Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Eamil Id</th>
                <th>Phone No</th>
                
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td><c:out value="${user.userId}" /></td>
                    <td><c:out value="${user.firstName}" /></td>
                    <td><c:out value="${user.lastName}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.phNo}" /></td>                    
                    <td><a href="/admin/getUserOrders/${user.userId}">View Orders</a></td>  
                </tr>
            </c:forEach>
        </table>
        <a href="/admin/">Back</a> 
    </div>
</body>
</html>