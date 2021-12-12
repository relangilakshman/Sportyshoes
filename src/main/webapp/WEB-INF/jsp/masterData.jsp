<html>
<h2>Add Product</h2>
<body>
<form action="/admin/addProduct" method="POST" enctype="multipart/form-data">
<table border="1" style="background-color:DodgerBlue;">
<tr>
<td>Product Type<input type="text" name="productType" value=${product.productType} ></td>
<td>Product Name<input type="text" name="productName" value=${product.productName} ></td>
</tr>
<tr>
<td>Model No<input type="text" name="modelNo" value=${product.modelNo} ></td>
<td>No Of Products<input type="text" name="noOfProducts"value=${product.noOfProducts} ></td>
</tr>
<tr>
<td>Creation Date<input type="text" name="creationDt" value=${product.creationDt} > </td>
<td>Each Product Cost<input type="text" name="eachProdCost" value=${product.eachProdCost} ></td>
</tr>
<tr>
<td>Product Status<input type="text" name="productStatus" value=${product.productStatus} ></td>
<td>Image 
<% if(request.getAttribute("filename") !=null){ %>
<input type="text" name="filename" value="<%= request.getAttribute("filename")%>" >
   
     <% }else { %>         
          <input type="file" name="file"  value=${product.image} required >
      <% } %>
</td>
</tr>
<tr>
<td>
<% if(request.getAttribute("filename") !=null){ %>
    <a  href="/admin/login">Click here Add More Product</a>
   
     <% }else { %>         
          <input type="submit" name="AddProduct" value="AddProduct"/>
      <% } %>
</td>

</tr>
</table>
</form>
</body>
</html>