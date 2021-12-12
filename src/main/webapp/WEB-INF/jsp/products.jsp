<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
<title>Sporty Shoes</title>
</head>
<body>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<div align="left">
        <table border="2">
           
            <c:forEach var="product" items="${products}" varStatus="rowCounter">
               <c:if test="${rowCounter.count % 5 == 1}">
      <tr>
    </c:if>
                	<td ><img src="data:image/jpg;base64,${product.encodeImage}" width="100" height="100"></br>
                    Product Id: <c:out value="${product.productId}" /></br>
                     <!--<c:out value="${product.productType}" />-->
                    Product Name: <c:out value="${product.productName}" /></br>
                    <c:out value="${product.modelNo}" /></br>
                    <!--<c:out value="${product.creationDt}" />-->
                    Price: <span class="WebRupee">Rs.</span><c:out value="${product.eachProdCost}" />
                    <a href="/buyProduct/${product.productId}">Buy</a>
                    </td>  
               <c:if test="${rowCounter.count % 5 == 0}">
      </tr>
    </c:if>
            </c:forEach>
        </table>
    </div>
</body>
</html>