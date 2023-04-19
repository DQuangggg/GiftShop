<%-- 
    Document   : managerContactDetails
    Created on : Apr 19, 2023, 8:07:18 AM
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
                    </ul>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="managet_contact">
                <c:forEach items="${contact}" var="c">
                    <form action="contactDetails" method="post" onsubmit="updateMessage()">
                        <div style="color: #db1d24; text-align: left; margin-bottom: 10px; font-size: 30px">CONTACT INFORMATION</div>

                        <label>ID : </label>
                        <input style =" border-top-style: hidden; border-right-style: hidden;
                               border-left-style: hidden;
                               border-bottom-style: hidden; font-size: 20px" 
                               type="text" value="${c.contactid}" name="contactid"  readonly />
                        <br/>

                        <label>First Name :</label>
                        <input style =" border-top-style: hidden; border-right-style: hidden;
                               border-left-style: hidden;
                               border-bottom-style: hidden; font-size: 20px"  
                               type="text" value="${c.firstName}" name="firstName" readonly/>
                        <br/>

                        <label>Last Name :</label>
                        <input style =" border-top-style: hidden; border-right-style: hidden;
                               border-left-style: hidden;
                               border-bottom-style: hidden; font-size: 20px"  
                               type="text" value="${c.lastName}" name="lastName" readonly/>
                        <br/>

                        <label>Email :</label>
                        <input style =" border-top-style: hidden; border-right-style: hidden;
                               border-left-style: hidden;
                               border-bottom-style: hidden; font-size: 20px"  
                               type="text" value="${c.email}" name="email"  readonly/>
                        <br/>

                        <label>Phone :</label>
                        <input style =" border-top-style: hidden; border-right-style: hidden;
                               border-left-style: hidden;
                               border-bottom-style: hidden; font-size: 20px"  
                               type="number" value="${c.phone}" name="phone"  readonly/>
                        <br/>

                        <label>Message :</label>
                        <input style =" border-top-style: hidden; border-right-style: hidden;
                               border-left-style: hidden;
                               border-bottom-style: hidden; font-size: 20px" 
                               type="text"  value="${c.message}" name="message"  readonly/>
                        <br/>

                        <label>Date : </label>
                        <input style =" border-top-style: hidden; border-right-style: hidden;
                               border-left-style: hidden;
                               border-bottom-style: hidden; font-size: 20px"  
                               type="text" value="${c.contactDate}" name="contactDate" readonly/>
                        <br/>

                        <label>Category: </label>
                        <input type="radio" name="status"  value="1" ${c.status == 1 ? "checked" : "" }> Readed
                        <input type="radio" name="status"  value="0" ${c.status == 0 ? "checked" : "" }> Unread
                        <br/>

                        <button>Update</button>

                    </form>   
                </c:forEach>
            </div>                                                         
        </div>
        <div class="container-fluid ">
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
        <script>
            function updateMessage() {
                alert("Update contact successful!");
            }
        </script>
    </body>
</html>