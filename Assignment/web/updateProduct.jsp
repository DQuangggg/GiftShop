<%-- 
    Document   : updateProduct
    Created on : Apr 19, 2023, 8:14:30 PM
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

                <form action="updateProductController" method="post" onsubmit="updateMessage()">
                    <div style="color: #db1d24; text-align: center; margin-bottom: 10px; font-size: 30px">PRODUCT INFORMATION</div>
                    <label>ID : </label>
                    <input type="text" value="${product.pid}" name="pid"  readonly />
                    
                    <label>Name :</label>
                    <input type="text" value="${product.productName}" name="productName" required/>
                    
                    <label>Image :</label>
                    <input type="url" value="${product.productImg}" name="productImg" required/>
                    
                    <label>Price :</label>
                    <input type="number" value="${product.productPrice}" name="productPrice" min="1" required/>
                    
                    <label>Note : </label>
                    <input type="text" value="${product.productNote}" name="productNote" required/>
                    
                    <label>Category: </label>
                    <select name="productCategory" id="sl_category" style="margin-bottom: 10px; font-size: 20px; width: 300px;" >
                       <c:forEach items="${listC}" var="c"> 
                            <option value="${c.cid}" ${product.cid == c.cid ? "selected":""}>${c.categoryName}</option>
                        </c:forEach>
                    </select><br/>
                   
                    
                    <button>Update</button>
                    <button type="reset">Reset</button>
                </form>
            </div>
        </div>
        <script>
            function updateMessage() {
                alert("Update product successful!");
            }
        </script>
    </body>
</html>