<%-- 
    Document   : checkout
    Created on : Apr 20, 2023, 10:11:41 AM
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
        <link rel="stylesheet" href="css/checkoutStyle.css" />
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
                                <a class="header_cart" href="showCartController" id="customer_cart_link"><b>Cart</b><span class="cart-items"></span></a>
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
                    <div id="main_content" >
                        <div class="col-sm-6">
                            <form action="checkOutController" method="post" onsubmit="checkOut()">
                                <div class="field__head">
                                    <h1>
                                        Shipping Address
                                    </h1>
                                </div>
                                <div class="field__Name">
                                    <input name="checkoutFName" class="field__input "
                                           id="checkout_shipping_firstname" type="text" placeholder="First Name" pattern="[a-zA-Z]{2,}" title="First name contains only letter and have at least 2 characters." required>
                                    <input name="checkoutLName" class="field__input "
                                           id="checkout_shipping_lastname" type="text" placeholder="Last Name" pattern="[a-zA-Z]{2,}" title="Last name contains only letter and have at least 2 characters." required>
                                    <div class="field__Address">
                                        <input name="checkoutAddress" class="field__input "
                                               id="checkout_shipping_address" type="text" placeholder="Address" pattern=".{5,}" title="Address must have at least 5 characters."  required>
                                    </div>
                                    <div class="field__City">

                                        <input name="checkoutCity" class="field__input "
                                               id="checkout_shipping_address_city" type="text" placeholder="City" pattern="[a-zA-Z\s]{3,}" title="City contains only letter and space. And must have at least 3 characters." required>
                                    </div>
                                    <div class="field__Phone">
                                        <input name="checkoutPhone" class="field__input "
                                               id="checkout_shipping_address_phone" type="text" placeholder="Phone" pattern="(09|03|07|08|05)([0-9]{8})" title="Phone number must start with 09 or 03 or 07 or 08 or 05. And must have exactly 10 characters." required>
                                    </div>
                                    <div class="submit_address">
                                        <button class="bt_send"  >Send</button>
                                    </div>
                            </form>
                        </div>
                    </div>

                    <div class="column_right column col-sm-6">
                        <div class="widget widget__best-sellers">
                            <h3 class="widget_header">Your Product</h3>
                            <div class="widget_content">
                                <div class="product-listing product-listing__bestsellers">
                                    <c:forEach items= "${listB}" var="b">
                                        <div class="product firstItem col-lg-12" >
                                           <div class="product_img">
                                                <a href="productController?pid=${b.product.pid}">
                                                    <img src="${b.product.productImg}">
                                                </a>
                                            </div>
                                            <div class="product_info">
                                                <div class="product_name">
                                                    <a href="productController?pid=${b.product.pid}">${b.product.productName}</a>
                                                </div>
                                                <div class="product_desc">Quantity: ${b.amount}
                                                </div>
                                            </div>
                                            <div class="product_pricecheckout">Price: ${b.product.productPrice}$</div>
                                            <div class="product_total">Total: ${b.product.productPrice *b.amount }$</div>
                                        </div>
                                    </c:forEach>
                                    <div class="payprice">
                                        <div class="disco"><h3>Discount: <span class="money" >${discount}</span></h3></div>

                                        <div class="subtt"><h3>SubTotal: <span class="money" >${subtotal}</span></h3></div>
                                    </div>
                                </div>
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
    <script>
        function checkOut() {
            alert("Check out successful!");
        }
    </script>

</body>

</html>