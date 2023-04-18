<%-- 
    Document   : homePage
    Created on : Apr 18, 2023, 7:53:36 AM
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
                <div class="col-sm-6 col-lg-6">
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
                <div class="col-sm-6 col-lg-3 header_row-both">
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

                        <li class="active firstItem">
                            <a href="homePageController">Home</a>
                        </li>

                        <li class="has-dropdown">
                            <a href="shopController">Shop</a>
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
            <div class="rowBanner">
                <div class="col-md-12 banner123">
                    <img style="height: 600px; width: 100%;" class="img-responsive"
                         src="images/ManUnitedbanner.jpg" />
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-12 text-left">
                    <h2 style="color: #f72b2f; text-transform:uppercase;"  >New Product</h2>
                    <p class="combo-header-des">
                        Hot new arrivals !
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <div>
                        <a href="productController?pid=${listPNew[0].pid}" > 
                            <img src="${listPNew[0].productImg}" class="img-responsive" />
                        </a>
                        <div class="item">
                            <p class="item-title">${listPNew[0].productName}</p>
                            <p>
                                Price: 
                                <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${listPNew[0].productPrice} $ </span> </a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div>
                        <a href="productController?pid=${listPNew[1].pid}" > 
                            <img src="${listPNew[1].productImg}" class="img-responsive" />
                        </a>
                        <div class="item">
                            <p class="item-title">${listPNew[1].productName}</p>
                            <p>
                                Price: 
                                <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${listPNew[1].productPrice} $ </span></a>
                            </p>
                        </div>
                    </div>
                </div>    
                <div class="col-md-3">
                    <div>
                        <a href="productController?pid=${listPNew[2].pid}" > 
                            <img src="${listPNew[2].productImg}" class="img-responsive" />
                        </a>
                        <div class="item">
                            <p class="item-title">${listPNew[2].productName}</p>
                            <p>
                                Price: 
                                <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${listPNew[2].productPrice} $ </span></a>
                            </p>
                        </div>
                    </div>
                </div>  
                <div class="col-md-3">
                    <div>
                        <a href="productController?pid=${listPNew[3].pid}" > 
                            <img src="${listPNew[3].productImg}" class="img-responsive" />
                        </a>
                        <div class="item">
                            <p class="item-title">${listPNew[3].productName}</p>
                            <p>
                                Price: 
                                <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${listPNew[3].productPrice} $ </span></a>
                            </p>
                        </div>
                    </div>
                </div>  
                <div class="row">
                    <div class="col-md-12 text-center">
                    </div>
                </div>
                <div class="col-md-3">
                    <div>
                        <a href="productController?pid=${listPNew[4].pid}" > 
                            <img src="${listPNew[4].productImg}" class="img-responsive" />
                        </a>
                        <div class="item">
                            <p class="item-title">${listPNew[4].productName}</p>
                            <p>
                                Price: 
                                <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${listPNew[4].productPrice} $ </span></a>
                            </p>
                        </div>
                    </div>
                </div>  
                <div class="col-md-3">
                    <div>
                        <a href="productController?pid=${listPNew[5].pid}" > 
                            <img src="${listPNew[5].productImg}" class="img-responsive" />
                        </a>
                        <div class="item">
                            <p class="item-title">${listPNew[5].productName}</p>
                            <p>
                                Price: 
                                <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${listPNew[5].productPrice} $ </span></a>
                            </p>
                        </div>
                    </div>
                </div> 
                <div class="col-md-3">
                    <div>
                        <a href="productController?pid=${listPNew[6].pid}" > 
                            <img src="${listPNew[6].productImg}" class="img-responsive" />
                        </a>
                        <div class="item">
                            <p class="item-title">${listPNew[6].productName}</p>
                            <p>
                                Price: 
                                <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${listPNew[6].productPrice} $ </span></a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div>
                        <a href="productController?pid=${listPNew[7].pid}" > 
                            <img src="${listPNew[7].productImg}" class="img-responsive" />
                        </a>
                        <div class="item">
                            <p class="item-title">${listPNew[7].productName}</p>
                            <p>
                                Price: 
                                <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${listPNew[7].productPrice} $ </span></a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="rowBanner">
            <div class="col-md-12 banner123">
                <img src="images/cec5f9a7-2a6c-4bf4-a070-a95e2f52df2a__3200X1224.png" style="height: 500px; width: 100%;" class="img-responsive"/>
            </div>
        </div>    
        <div class="rowBanner">
            <div class="col-md-6 banner123">
                <img src="images/a5a24537-ea8f-43e5-9292-328ae7ac3f41__1600X1224.png" style="height: 500px; width: 100%;" class="img-responsive"/>
            </div>
        </div> 
        <div class="rowBanner">
            <div class="col-md-6 banner123">
                <img src="images/f5d0f347-3ec0-49ac-aaaa-78457674ff7d__800X612.png" style="height: 500px; width: 100%;" class="img-responsive"/>
            </div>
        </div> 

        <div class="container">
            <div class="row">
                <div class="col-md-12 text-left">
                    <h2 style="color: #f72b2f; text-transform:uppercase;" >Top Selling</h2>
                    <p class="combo-header-des">
                        Buy the best, and forget the rest!
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <div>
                        <a href="productController?pid=${listPBest[0].pid}" > 
                            <img src="${listPBest[0].productImg}" class="img-responsive" />
                        </a>
                        <div class="item">
                            <p class="item-title">${listPBest[0].productName}</p>
                            <p>
                                Price: 
                                <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${listPBest[0].productPrice} $ </span></a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div>
                        <a href="productController?pid=${listPBest[1].pid}" > 
                            <img src="${listPBest[1].productImg}" class="img-responsive" />
                        </a>
                        <div class="item">
                            <p class="item-title">${listPBest[1].productName}</p>
                            <p>
                                Price: 
                                <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${listPBest[1].productPrice} $ </span></a>
                            </p>
                        </div>
                    </div>
                </div>    
                <div class="col-md-3">
                    <div>
                        <a href="productController?pid=${listPBest[2].pid}" > 
                            <img src="${listPBest[2].productImg}" class="img-responsive" />
                        </a>
                        <div class="item">
                            <p class="item-title">${listPBest[2].productName}</p>
                            <p>
                                Price: 
                                <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${listPBest[2].productPrice} $ </span></a>
                            </p>
                        </div>
                    </div>
                </div>  
                <div class="col-md-3">
                    <div>
                        <a href="productController?pid=${listPBest[3].pid}" > 
                            <img src="${listPBest[3].productImg}" class="img-responsive" />
                        </a>
                        <div class="item">
                            <p class="item-title">${listPBest[3].productName}</p>
                            <p>
                                Price: 
                                <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${listPBest[3].productPrice} $ </span></a>
                            </p>
                        </div>
                    </div>
                </div>  
                <div class="row">
                    <div class="col-md-12 text-center">
                    </div>
                </div>
                <div class="col-md-3">
                    <div>
                        <a href="productController?pid=${listPBest[4].pid}" > 
                            <img src="${listPBest[4].productImg}" class="img-responsive" />
                        </a>
                        <div class="item">
                            <p class="item-title">${listPBest[4].productName}</p>
                            <p>
                                Price: 
                                <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${listPBest[4].productPrice} $ </span></a>
                            </p>
                        </div>
                    </div>
                </div>  
                <div class="col-md-3">
                    <div>
                        <a href="productController?pid=${listPBest[5].pid}" > 
                            <img src="${listPBest[5].productImg}" class="img-responsive" />
                        </a>
                        <div class="item">
                            <p class="item-title">${listPBest[5].productName}</p>
                            <p>
                                Price: 
                                <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${listPBest[5].productPrice} $ </span></a>
                            </p>
                        </div>
                    </div>
                </div> 
                <div class="col-md-3">
                    <div>
                        <a href="productController?pid=${listPBest[6].pid}" > 
                            <img src="${listPBest[6].productImg}" class="img-responsive" />
                        </a>
                        <div class="item">
                            <p class="item-title">${listPBest[6].productName}</p>
                            <p>
                                Price: 
                                <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${listPBest[6].productPrice} $ </span></a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div>
                        <a href="productController?pid=${listPBest[7].pid}" > 
                            <img src="${listPBest[7].productImg}" class="img-responsive" />
                        </a>
                        <div class="item">
                            <p class="item-title">${listPBest[7].productName}</p>
                            <p>
                                Price: 
                                <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${listPBest[7].productPrice} $ </span></a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>                   

        <div class="rowBanner">
            <div class="col-md-3 banner123">
                <img src="images/Adidas.png" style="height: 300px; width: 100%;" class="img-responsive"/>
            </div>
        </div> 
        <div class="rowBanner">
            <div class="col-md-3 banner123">
                <img src="images/Mainnn.png" style="height: 300px; width: 100%;" class="img-responsive"/>
            </div>
        </div> 
        <div class="rowBanner">
            <div class="col-md-3 banner123">
                <img src="images/Mre.png" style="height: 300px; width: 100%;" class="img-responsive"/>
            </div>
        </div> 
        <div class="rowBanner">
            <div class="col-md-3 banner123">
                <img src="images/NE.png" style="height: 300px; width: 100%;" class="img-responsive"/>
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
    </body>
</html>