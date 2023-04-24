<%-- 
    Document   : cart
    Created on : Apr 20, 2023, 10:11:04 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Gift Shop</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/stylepage.css" />
        <link rel="stylesheet" href="css/dropdownstyle.css" />
        <link rel="stylesheet" href="css/bestSellerStyle.css" />
        <link rel="stylesheet" href="css/cartStyle.css" />
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
                                    <input id="search-field" name="q" type="search" placeholder="Search in store..."/>
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
                                <a class="header_cart" href="showCartController" id="customer_cart_link"><b>Cart (${numProducts})</b><span class="cart-items"></span></a>
                            </c:when>
                                
                            <c:when test="${sessionScope.acc!=null && sessionScope.acc.isAdmin!=true }">
                                <a href="login" id="customer_login_link">Log out</a>
                                <a href="homePageController" id="customer_register_link">Hello: ${sessionScope.acc.user}</a>
                                <a class="header_cart" href="showCartController" id="customer_cart_link"><b>Cart (${numProducts})</b><span class="cart-items"></span></a>
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
                            <a  href="shopController">Shop</a>
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
            <div class="row  ">
                <div class="column_center">
                    <div id="main_content" class="col-sm-9">
                        <div class="cart-scope">
                            <div class="page_header">
                                <h1 class="page_heading">Shopping Cart</h1>
                            </div>
                            <div class="page_content">
                                <div class="cart-list">
                                    <c:forEach items="${listcart}" var="c">
                                        <div class="row cart-item">
                                           <div class="col-md-3">
                                                <div class="item_image">
                                                    <img src="${c.product.productImg}"
                                                         alt="${cart.product.productName}">
                                                </div>
                                            </div>
                                            <div class="col-md-9">
                                                <div class="item_remove pull-right">
                                                    <a href="deleteCartController?pid=${c.product.pid}"><img
                                                            style="width:30px;"
                                                            src="images/deleteCartIcon.png" /></i></a>
                                                </div>
                                                <div class="product_name">
                                                    <a href="productController?pid=${c.product.pid}">
                                                        ${c.product.productName}
                                                    </a>
                                                </div>
                                                <h3 class="item_vendor">${c.product.productNote}</h3>
                                                <div class="item_price">
                                                    <div class="row">
                                                        <div class="col-sm-4">
                                                            <div class="price"><span class="money" >Price : ${c.product.productPrice}$</span></div>
                                                        </div>
                                                        <div class="col-sm-8">
                                                            <div class="qty"><label>Quantity: <input type="number"
                                                                                                name="updates" id="updates_cart${c.product.pid}" value="${c.amount}" onchange="changeAmount(${c.product.pid})"
                                                                                                class="input-small form-control"></label></div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="total col-sm-12">
                                                            <h3>Total: <span class="money"
                                                                             >${c.product.productPrice * c.amount}$</span></h3>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                   <div class="cart_subtotal">
                                        <h3>${discountMess} <span class="money" >${discount}</span>
                                        </h3>
                                    </div>
                                    <div class="cart_subtotal">
                                        <h3>${subtotalMess} <span class="money" >${subtotal}</span>
                                        </h3>
                                    </div>
                                    <div class="cart_buttons">
                                        <button><a href="shopController">Continue shopping</a></button>
                                        <span class="or">or</span>
                                        <button><a href="checkOutController">Check out</a></button>
                                    </div>
                                    <div class="cart_instructions">
                                        <label>Special instructions for seller</label>
                                        <textarea class="form-control" name="note"  style="height: 100px;"></textarea>
                                    </div>
                                </div>

                                <div id="payment-methods">
                                    <ul>
                                        <li class="firstItem"> <img
                                                src="images/Payment1.png"
                                                alt=""> </li>
                                        <li> <img
                                                src="images/Payment2.png"
                                                alt=""> </li>
                                        <li> <img
                                                src="images/Payment3.png"
                                                alt=""> </li>
                                        <li> <img
                                                src="images/Payment4.png"
                                                alt=""> </li>
                                        <li> <img
                                                src="images/Payment5.png"
                                                alt=""> </li>
                                        <li> <img
                                                src="images/Payment6.png"
                                                alt=""> </li>
                                        <li> <img
                                                src="images/Payment7.png"
                                                alt=""> </li>
                                        <li class="lastItem"> <img
                                                src="images/Payment8.png"
                                                alt=""> </li>
                                    </ul>
                               </div>
                            </div>
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
        function changeAmount(pid) {
            var amount = document.getElementById("updates_cart" + pid).value;
            window.location.href = 'updateCartController?pid=' + pid + '&amount=' + amount;
        }
    </script>
</html>
