<%-- 
    Document   : product
    Created on : Apr 18, 2023, 8:36:31 PM
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
        <link rel="stylesheet" href="css/productStyle.css" />
        <link rel="stylesheet" href="css/bestSellerStyle.css" />
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
                                    <input id="search-field" name="q" type="search" placeholder="Search in store..." value="${textsearch}" />
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
                                        <c:forEach items="${listC}" var="c" >
                                            <li style="width: 100%; float: none; "><a class="${cid==c.cid?"active":""}"
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
                                        <c:forEach items="${listC}" var="c" >
                                            <li style="width: 100%; float: none; "><a class="${cid==c.cid?"active":""}"
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
                                        <c:forEach items="${listC}" var="c" >
                                            <li style="width: 100%; float: none; "><a class="${cid==c.cid?"active":""}"
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
            <div class="column_midle">
                <div class="row col-md-9" >
                    <div class="row">
                        <div class="col-md-12 ">
                            <h2 class="title_p">PRODUCT</h2>
                        </div>
                    </div>

                    <div class="row">
                        <div id="product_image-container" class="col-sm-5">
                            <div class="product_image">
                                <img style="width: 420px;"
                                     src="${product.productImg}"
                                     class="img-responsive" />
                            </div>

                        </div><!-- #product-photos -->
                        <div class="col-sm-7">
                            <div  class="product_name">${product.productName}</div>
                            <form action="cartController" method="post" class="form-horizontal"
                                  id="product-actions">
                                <div class="options clearfix">
                                    <div id="product_price">
                                        <label >Price:</label>  <span class="money_single" >${product.productPrice}$</span>
                                    </div>
                                    <input type="hidden"
                                           name="pid" value="${product.pid}" class="form-control input-small" >
                                    <c:choose>
                                        <c:when test="${sessionScope.acc==null}">
                                            <div id="purchase">
                                                <label >Quantity: </label><input min="1" type="number" id="quantity"
                                                                                 name="quantity" value="1" class="form-control input-small">
                                                <button id="add_cartProduct">Add to cart </button>
                                            </div>
                                        </div><!-- /.options -->
                                    </c:when>

                                    <c:when test="${sessionScope.acc!=null && sessionScope.acc.isAdmin!=true }">
                                        <div id="purchase">
                                            <label >Quantity: </label><input min="1" type="number" id="quantity"
                                                                             name="quantity" value="1" class="form-control input-small">
                                            <button id="add_cartProduct">Add to cart </button>
                                        </div>
                                </div><!-- /.options -->
                            </c:when>

                            <c:when test="${sessionScope.acc!=null && sessionScope.acc.isAdmin==true }">
                                <div id="purchase">

                                </div>
                            </c:when>
                        </c:choose>
                        </form>

                        <div class="product_details">
                            <div class="product_type"> <label >Type: </label>
                                <c:forEach items="${listC}" var="c"> 
                                    <c:if test="${product.cid == c.cid}"> <a href="categoryController?cid=${product.cid}"
                                       title="Equipment">${c.categoryName}</a></c:if>
                                </c:forEach>
                            </div>
                        </div>
                        <div id="product_description" class="rte" >
                            <h4>Description:</h4>
                            <p>${product.productNote}</p>
                        </div>
                    </div>
                </div>
                <div class="column_center">
                    <h3>Other fine products</h3>
                </div>

                <div class="row">
                    <c:forEach items= "${listP}" var="p">
                        <div class="col-md-3">
                            <div>
                                <a href="productController?pid=${p.pid}" > 
                                    <img src="${p.productImg}" class="img-responsive" />
                                </a>
                                <div class="item">
                                    <p class="item-title">${p.productName}</p>

                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

            </div>
            <div class="column_right column col-md-3">
                <div class="widget widget__best-sellers">
                    <h3 class="widget_header">Best Sellers</h3>
                    <div class="widget_content">
                        <div class="product-listing product-listing__bestsellers">
                            <c:forEach items= "${listB}" var="b">
                                <div class="product firstItem">
                                    <div class="product_img">
                                        <a href="productController?pid=${b.pid}">
                                            <img src="${b.productImg}">
                                        </a>
                                    </div>
                                    <div class="product_info">
                                        <div class="product_name">
                                            <a href="productController?pid=${b.pid}">${b.productName}</a>
                                        </div>
                                        <div class="product_desc">${b.productNote}
                                        </div>
                                        <div class="product_price">
                                            <span class="money">${b.productPrice} $</span>

                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
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

                    <li class="firstItem"><a title="" href="showCartController">Home</a></li>

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
