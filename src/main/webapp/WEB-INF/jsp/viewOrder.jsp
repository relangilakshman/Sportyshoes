<html>
<h2>View Order</h2>
<body>
<form action="/"  >
<table border="1" style="background-color:DodgerBlue;">
<tr>
<td>Order Id: ${product.orderId}</td>
<td>Product Name: ${order.productName}</td>
</tr>
<tr>
<td>Model No: ${order.modelNo}</td>
<td>Order Cost: ${order.eachProdCost}</td>
</tr>
<tr>
<td>User Name : ${order.userName}</td>
<td>Address: ${order.dispatchAddress} </td>
</tr>
<tr>
<td>Phone No: ${order.userPhno} </td>
<td>Email : ${order.userEamil} </td>
</tr>
<tr>
<td><input type="submit" name="back" value="Back"/></td>
</tr>
</table>
</form>
</body>
</html>