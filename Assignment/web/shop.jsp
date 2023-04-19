<%-- 
    Document   : shop
    Created on : Apr 18, 2023, 10:05:00 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gift Shop</title>
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/stylepage.css" />
        <link rel="stylesheet" href="css/dropdownstyle.css" />
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
                            <form action="searchProductController" method="post" >
                                <div class="col-xs-9  col-lg-8 ">
                                    <input id="search-field" name="q" type="search" placeholder="Search in store..." value="${textsearch}"/>
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
                    <c:choose>
                        <c:when test="${sessionScope.acc==null}">
                            <ul class="sf-menu">
                                <li class="first ${cid==null?"active":""} firstItem">
                                    <a  href="shopController">Shop</a>
                                </li>
                                <li class="has-dropdown">
                                    <a title="" class="${cid!=null?"active":""}">Catalog</a>
                                    <ul class="sub-menu" style="width: 235px; ">
                                        <c:forEach items="${listC}" var="c">
                                            <li style="width: 100%; float: none;"><a class="${cid==c.cid?"active":""}"
                                                                                     style="width: auto; float: none;" href="categoryController?cid=${c.cid}">${c.categoryName}</a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </li>
                                <li>
                                    <a  href="aboutusController">About Us</a>
                                </li>
                                <li class="last lastItem">
                                    <a  href="contactusController">Contact us</a>
                                </li>
                            </ul>
                        </c:when>

                        <c:when test="${sessionScope.acc!=null && sessionScope.acc.isAdmin!=true }">
                            <ul class="sf-menu">
                                <li class="first ${cid==null?"active":""} firstItem">
                                    <a  href="shopController">Shop</a>
                                </li>
                                <li class="has-dropdown">
                                    <a title="" class="${cid!=null?"active":""}">Catalog</a>
                                    <ul class="sub-menu" style="width: 235px; ">
                                        <c:forEach items="${listC}" var="c">
                                            <li style="width: 100%; float: none;"><a class="${cid==c.cid?"active":""}"
                                                                                     style="width: auto; float: none;" href="categoryController?cid=${c.cid}">${c.categoryName}</a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </li>
                                <li>
                                    <a  href="aboutusController">About Us</a>
                                </li>
                                <li class="last lastItem">
                                    <a  href="contactusController">Contact us</a>
                                </li>
                            </ul>
                        </c:when>

                        <c:when test="${sessionScope.acc!=null && sessionScope.acc.isAdmin==true }">
                            <ul class="sf-menu">
                                <li class="first ${cid==null?"active":""} firstItem">
                                    <a  href="shopController">Shop</a>
                                </li>
                                <li class="has-dropdown">
                                    <a title="" class="${cid!=null?"active":""}">Catalog</a>
                                    <ul class="sub-menu" style="width: 235px; ">
                                        <c:forEach items="${listC}" var="c">
                                            <li style="width: 100%; float: none;"><a class="${cid==c.cid?"active":""}"
                                                                                     style="width: auto; float: none;" href="categoryController?cid=${c.cid}">${c.categoryName}</a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </li>
                            </ul>
                        </c:when>
                    </c:choose>

                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-12 text-center">
                    <h2 class="title">THE PRODUCT IN STORE</h2>
                    <p class="combo-header-des">
                        Quality belong with time!
                    </p>
                </div>
            </div>

            <div class="row">
                <c:choose>
                    <c:when test="${sessionScope.acc==null}">
                        <c:forEach items="${listP}" var="p">
                            <div class="col-md-3">
                                <div>
                                    <a href="productController?pid=${p.pid}" > 
                                        <img src="${p.productImg}" class="img-responsive" />
                                    </a>
                                    <div class="item">
                                        <p class="item-title">${p.productName}</p>
                                        <p>
                                            Price: 
                                            <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${p.productPrice} $ </span>
                                            <a href="cartController?pid=${p.pid}" id="add_cart">Add to cart </a>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:when>

                    <c:when test="${sessionScope.acc!=null && sessionScope.acc.isAdmin!=true }">
                        <c:forEach items="${listP}" var="p">
                            <div class="col-md-3">
                                <div>
                                    <a href="productController?pid=${p.pid}" > 
                                        <img src="${p.productImg}" class="img-responsive" />
                                    </a>
                                    <div class="item">
                                        <p class="item-title">${p.productName}</p>
                                        <p>
                                            Price: 
                                            <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${p.productPrice} $ </span>
                                            <a href="cartController?pid=${p.pid}" id="add_cart">Add to cart </a>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:when>

                    <c:when test="${sessionScope.acc!=null && sessionScope.acc.isAdmin==true }">
                        <c:forEach items="${listP}" var="p">
                            <div class="col-md-3">
                                <div>
                                    <a href="productController?pid=${p.pid}" > 
                                        <img src="${p.productImg}" class="img-responsive" />
                                    </a>
                                    <div class="item">
                                        <p class="item-title">${p.productName}</p>
                                        <p>
                                            Price: 
                                            <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${p.productPrice} $ </span>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:when>
                </c:choose>
            </div>

            <div class="row">
                <c:choose>
                    <c:when test="${issearch==true}">
                        <c:if test="${totalpage!=null}">
                            <div id="pagination">
                                <span class="prev"><a title="" href="searchProductController?q=${textsearch}&page=${pageCurrent-1>0?pageCurrent-1:"1"}">«
                                        Previous</a></span>
                                        <c:if test="${pageCurrent-1>0}">
                                    <span class=""><a title="" href="searchProductController?q=${textsearch}&page=${pageCurrent-1}">${pageCurrent-1}</a></span>
                                    </c:if>      

                                <c:forEach begin="${pageCurrent}" end="${pageCurrent+2<=totalpage?pageCurrent+2:totalpage}" var="pg">
                                    <span class=" ${pg==pageCurrent?"current":""}"><a title="" href="searchProductController?q=${textsearch}&page=${pg}">${pg}</a></span>
                                    </c:forEach>
                                <span class="next"><a title="" href="searchProductController?q=${textsearch}&page=${pageCurrent+1>totalpage?totalpage:pageCurrent+1}">Next »</a></span>
                            </div>
                        </c:if>
                    </c:when>

                    <c:when test="${iscategory==true }">
                        <div id="pagination">

                            <span class="prev"><a title="" href="categoryController?cid=${cid}&page=${pageCurrent-1>0?pageCurrent-1:"1"}">«
                                    Previous</a></span>
                                    <c:if test="${pageCurrent-1>0}">
                                <span class=""><a title="" href="categoryController?cid=${cid}&page=${pageCurrent-1}">${pageCurrent-1}</a></span>
                                </c:if>        
                                <c:forEach begin="${pageCurrent}" end="${pageCurrent+2<=totalpage?pageCurrent+2:totalpage}" var="pg">
                                <span class=" ${pg==pageCurrent?"current":""}"><a title="" href="categoryController?cid=${cid}&page=${pg}">${pg}</a></span>
                                </c:forEach>

                            <span class="next"><a title="" href="categoryController?cid=${cid}&page=${pageCurrent+1>totalpage?totalpage:pageCurrent+1}">Next
                                    »</a></span>
                        </div>
                    </c:when>

                    <c:otherwise>
                        <div id="pagination">
                            <span class="prev"><a title="" href="shopController?page=${pageCurrent-1>0?pageCurrent-1:"1"}">« Previous</a>
                            </span>
                            <c:if test="${pageCurrent-1>0}">
                                <span class=""><a title="" href="shopController?page=${pageCurrent-1}">${pageCurrent-1}</a></span>
                                </c:if>

                            <c:forEach begin="${pageCurrent}" end="${pageCurrent+2<=totalpage?pageCurrent+2:totalpage}" var="pg"> 
                                <span class=" ${pg==pageCurrent?"current":""}"><a title="" href="shopController?page=${pg}">${pg}</a></span>
                                </c:forEach>

                            <span class="next"><a title="" href="shopController?page=${pageCurrent+4>totalpage?totalpage:pageCurrent+4}">Next »</a></span>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
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
</html>