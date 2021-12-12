<html>
<h2>Oder Creation</h2>
<body>
<form action="/order"  method="POST"  >
<table border="1" style="background-color:DodgerBlue;">
<tr>
<td>Product No<input type="text" name="productId" value="${product.productId}" readonly/></td>
<td>Product Name<input type="text" name="productName" value="${order.productName}" readonly/></td>
</tr>
<tr>
<td>Model No<input type="text" name="modelNo" value="${order.modelNo}" readonly></td>
<td>Order Cost<input type="text" name="eachProdCost" value="${order.eachProdCost}" readonly="readonly"></td>
</tr>
<tr>
<td>User Name<input type="text" name="userName" value=${order.userName} ></td>
<td>Address<input type="text" name="dispatchAddress" value=${order.dispatchAddress} ></td>
</tr>
<tr>
<td>Phone No<input type="text" name="userPhno" value=${order.userPhno} ></td>
<td>Email<input type="text" name="userEamil" value=${order.userEamil} ></td>
</tr>
<tr>
<td><input type="submit" name="Payment"/></td>
</tr>
</table>
</form>
</body>
</html>