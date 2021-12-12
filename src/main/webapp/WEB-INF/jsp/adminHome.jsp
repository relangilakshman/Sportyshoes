<html>



   <body>
      <table width = "100%" border = "0">
         
         <tr>
            <td colspan = "2" bgcolor = "#b5dcb3">
               <a class="logo" href="http://localhost:8080/" title="Sporty Shoes Online" >
        <img src="/images/sportyshoes9.jpg"
             alt="Liberty Shoes Online"
                                  />
    </a>
   
    <% if(request.getAttribute("message")==null){ %>
    <p> <h1>Welcome to Admin</h1></p>
     <% } else { %>
         <p> <h1><%= request.getAttribute("message")%></h1></p>
      <% } %>   
    
    
            </td>
         </tr>
         <tr valign = "top">
            <td bgcolor = "#aaa" width = "50">
               <b>Manage Products</b><br />
               <a  href="../admin/report">Purchase Reports </a><br />
                <a  href="../admin/getUsers">Search Users</a><br />
               <a  href="../admin/changePassword">Change Password</a><br />              
            </td>
            
            <td bgcolor = "#eee" width = "100" height = "200">
               <jsp:include page="masterData.jsp"></jsp:include>
            </td>
         </tr>
         <tr>
            <td colspan = "2" bgcolor = "#b5dcb3">
               <center>
                  Copyright © 2007 sportyshoes.com
               </center>
            </td>
         </tr>
         
      </table>
   </body>

</html>