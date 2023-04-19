<%-- 
    Document   : managerOrder
    Created on : Apr 19, 2023, 7:43:57 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/stylepage.css" />
        <link rel="stylesheet" href="css/dropdownstyle.css" />

        <link rel="stylesheet" href="css/managerStyle.css" />
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12 col-lg-3 logo_wrap">
                    <a id="logo" href="homePageController">
                        <b>Gift Shop</b>
                        <span>Gift & Accessories</span>
                    </a>
                </div>
                <div class="col-sm-6 col-lg-5">
                    <div class="header_row-12"></div>
                    <div class="header_row-2-search">
                        <!-- HEADER SEARCH -->
                        <div class="header_search">
                            <form action="searchProductController" method="post"  >
                                <div class="col-xs-9  col-lg-8 ">
                                    <input id="search-field" name="q" type="search" placeholder="Search in store..." />
                                </div>
                                <div class="col-xs-3 col-lg-4 ">
                                    <button type="submit" class="btn btn-default">                                       
                                        Search
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-lg-4 header_row-both">
                    <div class="header_user">
                        <!-- USER MENU -->
                        <c:choose>
                            <c:when test="${sessionScope.acc==null}">
                                <a href="login.jsp" id="customer_login_link">Log in</a>
                                <a href="signup.jsp" id="customer_register_link">SIGN UP & SAVE 10%</a>
                                <a class="header_cart" href="showCartController" id="customer_cart_link"><b>Cart</b><span class="cart-items"></span></a>
                                </c:when>

                            <c:when test="${sessionScope.acc!=null && sessionScope.acc.isAdmin!=true }">
                                <a href="login" id="customer_login_link">Log out</a>
                                <a href="homePageController" id="customer_register_link">Hello: ${sessionScope.acc.user}</a>
                                <a class="header_cart" href="showCartController" id="customer_cart_link"><b>Cart</b><span class="cart-items"></span></a>
                                </c:when>

                            <c:when test="${sessionScope.acc!=null && sessionScope.acc.isAdmin==true }">
                                <a href="login" id="customer_login_link">Log out</a>
                                <a href="homePageController" id="customer_register_link">Hello: ${sessionScope.acc.user}</a>
                                <a href="managerController" id="customer_manager_link">Manager</a>
                            </c:when>
                        </c:choose>
                    </div>
                </div>
            </div>

            <div class="row-Menu">
                <div class="clearfix" id="navigation">
                    <ul class="sf-menu">
                        <li class="firstItem">
                            <a  href="homePageController">Home</a>
                        </li>
                        <li class="has-dropdown">
                            <a title="" class="active" >Manager</a>
                            <ul class="sub-menu" style="width: 235px; ">
                                <li style="width: 100%; float: none; "><a style="width: auto; float: none;" href="managerController">Manager Product</a>
                                </li>
                                <li style="width: 100%; float: none; "><a style="width: auto; float: none;" href="managerAccount">Manager Account</a>
                                </li>
                                <li style="width: 100%; float: none; "><a style="width: auto; float: none;" href="managerOrder">Manager Order</a>
                                </li>
                                <li style="width: 100%; float: none; "><a style="width: auto; float: none;" href="managerContact">Manager Contact</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a  href="aboutusController">About Us</a>
                        </li>
                        <li class="last lastItem">
                            <a  href="contactusController">Contact us</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="manager_bannerSet">
                <div class="manager_left">
                    <b>Manager System</b> 
                    <div class="manager_search">
                        <form action="managerOrder" method="post">
                                <div class="">
                                <input id="search-byid" name="status" type="search" placeholder="Search order by id..." value="${searchByStatus}" />
                                <button type="submit" class="button_searchbyid">
                                    Search
                                </button>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
            <div class="managet_product">
                <table class="table table table-striped  ">
                    <thead >
                        <tr>
                            <td><b>Order ID</b></td>
                            <td><b>Customer Name</b></td>
                            <td><b>Order Date</b></td>
                            <td><b>Status</b></td>
                            <td><b>More Details</b></td>
                        </tr>
                    </thead>
                    <c:forEach items="${listO}" var="o">
                        <tr>
                            <th  scope="row" style="text-align: center">${o.orderid}</th>
                     <c:forEach items="${listCU}" var="c">
                        <c:if test="${o.custid == c.custid }">
                            <td>${c.firstname} ${c.lastname}</td>
                        </c:if>
                     </c:forEach>
                            <td>${o.orderDate}</td>
                            <c:if test="${o.status == 0}">
                                <td>Wait</td>
                            </c:if>
                            <c:if test="${o.status == 1}">
                                <td>Process</td>
                            </c:if>
                            <c:if test="${o.status == 2}">
                                <td>Done</td>
                            </c:if>    
                            <td><a href="cartDetails?cartid=${o.orderid}">Details</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <c:if test="${totalpage!=null}">                   
                <div class="row">
                    <div id="pagination">
                        <span class="prev"><a title="" href="managerOrder?page=${pageCurrent-1>0?pageCurrent-1:"1"}">«
                                Previous</a></span>
                                <c:if test="${pageCurrent-1>0}">
                            <span class=""><a title="" href="managerOrder?page=${pageCurrent-1}">${pageCurrent-1}</a></span>
                            </c:if>
                            <c:forEach begin="${pageCurrent}" end="${pageCurrent+2<=totalpage?pageCurrent+2:totalpage}" var="pg">
                            <span class=" ${pg==pageCurrent?"current":""}"><a title="" href="managerOrder?page=${pg}">${pg}</a></span>
                            </c:forEach>

                        <span class="next"><a title="" href="managerOrder?page=${pageCurrent+1>totalpage?totalpage:pageCurrent+1}">Next
                                »</a></span>
                    </div>
                </div>
            </c:if>                                                          
        </div>
        <div class="container-fluid ">
            <div class="row">
            </div>
            <div class="row_footer1">
                <div class="col-md-3  custom_footer custom_footer1">
                    <h3>Menu</h3>
                    <ul class="list">

                        <li class="firstItem"><a title="" href="homePageController">Home</a></li>

                        <li><a title="" href="shopController">Shop</a></li>

                        <li><a title="" href="aboutusController">About Us</a></li>

                        <li class="lastItem"><a title="" href="contactusController">Contact us</a></li>

                    </ul>
                </div>
                <div class="col-md-3  custom_footer custom_footer2">
                    <h3>Collections</h3>
                    <ul class="list">
                        <c:forEach items="${listC}" var="c" >
                            <li> <a title="" href="categoryController?cid=${c.cid}">${c.categoryName}</a></li>
                            </c:forEach>
                    </ul>
                </div>

                <div class="col-md-3  custom_footer custom_footer3">
                    <h3>Information</h3>
                    <ul class="list">
                        <li class="lastItem"><a title="" href="showCartController">My cart</a></li>
                            <c:if test="${sessionScope.acc!=null}">
                            <li class=""><a title="" href="changePassword">Change Password</a></li>
                            </c:if>
                    </ul>
                </div>

                <div class="col-md-3  custom_footer custom_footer4">
                    <h3>Contacts</h3>
                    <ul>
                        <li class="firstItem">0210 Ram Road,  Royal Crescent Tel 136-567-9842
                        </li>
                        <li class="lastItem">Email: <a href="https://mail.google.com/">shopGift@gmail.com</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </body>
    <script>
        function confirmDelete(id) {
            if (confirm('Are you want to delete order have Id: ' + id + '?')) {
                window.location.href = 'deleteOrder?orderid=' + id;
                window.alert('Delete successfully!');
            }
        }
    </script>
</html>
