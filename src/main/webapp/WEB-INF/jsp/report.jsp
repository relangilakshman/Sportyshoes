<html>
<body>
<header>

</header>
<script type="text/javascript">
</script>
<span>Report Creation</span>
<table border="2" style="background-color:Crimson;" >
<form action="/admin/showReport">
<tr><td>Date of Purchase<input type="date" name="creationDt" value =${order.creationDt} ></td></tr>
<tr><td>Date of Dispatch<input type="date" name="dispatchDt" value =${order.dispatchDt} ></td></tr>
<tr><td>Order Status<input type="text"   name="ordertStatus" value=${order.ordertStatus} ></td></tr>
<tr><td>Order Type <input type="text" name="orderType" value=${order.orderType} ></td></tr>
<tr><td><input type="submit" name="Submit"/><td></tr>
</form>

</table>
</body>
</html>