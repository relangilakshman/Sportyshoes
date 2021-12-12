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
            <caption><h2>View Report</h2></caption>
       
            
            <tr>
                <th>Order Id</th>
                <th>Order Type</th>
                <th>productName Name</th>
                <th>Model No</th>
                <th>Creation Date</th>
                <th>Dispatch Date</th>
                <th>Order Status</th>
                
            </tr>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td><c:out value="${order.orderId}" /></td>
                    <td><c:out value="${order.orderType}" /></td>
                    <td><c:out value="${order.productName}" /></td>
                    <td><c:out value="${order.modelNo}" /></td>
                    <td><c:out value="${order.creationDt}" /></td>                    
                    <td><c:out value="${order.dispatchDt}" /></td>
                    <td><c:out value="${order.ordertStatus}" /></td>
                    
                </tr>
            </c:forEach>
        </table>
         <a href="/admin">Back</a> 
    </div>
</body>
</html>