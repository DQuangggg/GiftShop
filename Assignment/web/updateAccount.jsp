<%-- 
    Document   : updateAccount
    Created on : Apr 19, 2023, 8:14:06 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product</title>
        <link rel="stylesheet" href="css/formStyle.css" />

    </head>
    <body>
        <div class="form_page">
            <div class="form">

                <form action="updateAccount" method="post" onsubmit="updateMessage()">
                    <div style="color: #db1d24; text-align: center; margin-bottom: 10px; font-size: 30px">ACCOUNT INFORMATION</div>
                    <label>ID :</label>
                    <input type="text" value="${account.aid}" name="aid"  readonly />
                    
                    
                    <label >User Name :</label>
                    <input type="text" value="${account.user}" name="userName" readonly/>
                    
                    <label>Password :</label>
                    <input type="text" value="${account.pass}" name="password" pattern=".{3,16}" title="Password must have at least 3 characters and max 16 characters." required/>

                     <label>Admin: </label><select name="isAdmin"  style="margin-bottom: 10px; font-size: 20px; width: 300px;">
                        <option value="true" ${account.isAdmin==true?"selected":""}>Is Admin</option>
                        <option value="false"${account.isAdmin==false?"selected":""}>Not Admin</option>

                     </select> <br/>
                    <button >Update</button>
                    <button type="reset">Reset</button>
                </form>
            </div>
        </div>
        <script>
            function updateMessage() {
                alert("Update account successful!");
            }
        </script>
    </body>
</html>