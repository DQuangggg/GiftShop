<%-- 
    Document   : addProduct
    Created on : Apr 19, 2023, 8:10:13 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
        <link rel="stylesheet" href="css/formStyle.css" />

    </head>
    <body>
        <div class="form_page">
            <div class="form" >

                <form action="addProductController" method="post" onsubmit="addProductMessage()">
                    <div style="color: #db1d24; text-align: center; margin-bottom: 10px;font-size: 30px">PRODUCT INFORMATION</div>
                    <label>Name :</label>
                    <input type="text" placeholder="Enter product name"  name="productName" required/>

                    <label>Image :</label>
                    <input type="url" placeholder="Enter product image link" name="productImg" required/>

                    <label>Price :</label>
                    <input type="number" placeholder="Enter product price" name="productPrice" min="1" required/>

                    <label>Note : </label>
                    <input type="text" placeholder="Note" name="productNote" required/>
                    
                    <label>Category: </label>
                    <select name="productCategory" id="sl_category" style="margin-bottom: 10px; font-size: 20px; width: 300px;">
                        <c:forEach items="${listC}" var="c"> 
                            <option value="${c.cid}">${c.categoryName}</option>
                        </c:forEach>
                    </select>
                    
                    <button>Add</button>
                    <button type="reset">Reset</button>
                </form>
            </div>
        </div>
        <script>
            function addProductMessage() {
                alert("Add product successful!");
            }
        </script>
    </body>
</html>
