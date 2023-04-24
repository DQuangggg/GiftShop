<%-- 
    Document   : aboutus
    Created on : Apr 18, 2023, 8:17:40 PM
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
        <link rel="stylesheet" href="css/aboutStyle.css" />
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
                                    <input id="search-field" name="q" type="search" placeholder="Search store..."/>
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
                        <li class=" firstItem">
                            <a  href="homePageController">Home</a>
                        </li>

                        <li class="has-dropdown">
                            <a  href="shopController">Shop</a>
                        </li>

                        <li class="active">
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
                <div class="pl-markup">
                    <div>
                        <p class="about_head" <b ><span >About Us</span></b></p>
                        <p class="MsoNormal" >
                            <a name="_Toc42700411">
                                <span >Our website
                                    is managed by Flawless (International) Ltd.</span>
                            </a>
                        </p>
                        <p class="MsoNormal" >
                            <span>
                                As the global leader in licensed sports
                                merchandise, Flawless delivers to over 180 countries, runs stores in over 
                                5 continents and supports multi-lingual call centres incorporating 11 languages.
                                Flawless extended the reach of its licensed sports merchandise business by
                                acquiring UK-based international sports e-commerce company, Kitbag on February
                                2<sup>nd</sup>, 2019. It now supports and compliments Flawless? successful VN.
                                operation by focusing on partnerships with the biggest sporting teams and
                                organisations around the world.
                            </span>
                        </p>

                        <p class="MsoNormal" >
                            <span >
                                Operating from its base in the UK?s sporting
                                stronghold of Manchester, the international business provides online, retail
                                and end-to-end event solutions for over 30 partners across various sports. Our shop will provide best product with high quality
                                and environmental friendliness.
                                Flawless has relationships with globally recognised English Premier League, La
                                Liga, Bundesliga and Ligue 1 clubs, along with representation across all major
                                US Sports Leagues, Golf, Rugby, F1, esports and Tennis.
                            </span>
                        </p>

                        <p class="MsoNormal" >
                            <span >
                                Internationally, Flawless also delivers specific
                                global leadership in event, city centre and in-venue retail; providing
                                expertise at leading soccer, rugby and golfing venues. Fulfilment and service
                                infrastructure has also expanded internationally, leveraging the historic
                                expertise of Kitbag in international markets and integrating with the marketing
                                and technology solutions traditionally used by Fanatics across its sites and
                                partners in the U.S.
                            </span>
                        </p>

                        <p class="MsoNormal" >
                            <span >
                                United Direct, the Official Online Store at shop.gift.com
                                is operated under licence by Flawless.
                            </span>
                        </p>

                        <p class="MsoNormal" >
                            <span >
                                <b>
                                    Contacting Us by Email
                                </b>
                            </span>
                        </p>

                        <p class="MsoNormal" >
                            <span >
                                We are happy to answer queries on products, orders
                                and anything else about the online store at the below address:</span>
                        </p>

                        <p class="MsoNormal" >
                            <a style="color: blue; text-decoration: underline;" href="https://mail.google.com/">
                                <span >
                                    <span style='font-family: "Times New Roman"; '>shopGift@gmail.com</span>
                                </span>
                            </a>
                        </p>

                        <p class="MsoNormal" >
                            <span >
                                We endeavour to respond to all emails within 24
                                hours.
                            </span>
                        </p>

                        <p class="MsoNormal" >
                            <span >
                                <b>
                                    Contacting Us by Phone
                                </b>
                            </span>
                        </p>

                        <p class="MsoNormal" ><span >
                                If you'd like to speak to one of our friendly
                                advisors, please contact us on +44 136-567-9842.
                            </span>
                        </p>

                        <p class="MsoNormal" >
                            <span >
                                Our opening times are 9:00am
                                to 5pm Sunday - Saturday and 7:30am
                                to 5pm in days of week.&nbsp;Outside of these hours, please send us an email and
                                we'll get back to you swiftly.
                            </span>
                        </p>

                        <p class="MsoNormal" >
                            <strong>
                                Please note:&nbsp;
                            </strong>
                            Times correspond to VN local time. &nbsp; Phone lines
                            are closed on VN Bank Holidays.
                        </p>

                        <p class="MsoNormal" >
                            <span >
                                <b>
                                    Contacting Us by Post
                                </b>
                            </span>
                        </p>

                        <p class="MsoNormal" >
                            <span >
                                You can of course write to our team at any time
                                using the address below:
                           </span>
                        </p>

                        <p class="MsoNormal" >
                            <span >
                                <a name="_Hlk44492046">
                                    Shop Gift, Official
                                    Online Store 
                                </a>
                            </span>
                        </p>

                        <p class="MsoNormal" >
                            <span >
                                <span >
                                    Flawless
                                </span>

                            </span>
                        </p>

                        <p class="MsoNormal" >
                            <span >
                                Greengate
                            </span>
                        </p>

                        <p class="MsoNormal" >
                            <span >
                                Manchester
                            </span>
                        </p>

                        <p class="MsoNormal" >
                            <span >
                                United Kingdom
                            </span>
                        </p>

                        <p class="MsoNormal" >
                            <span >
                                M24 1FD
                            </span>
                        </p>

                        <p class="normal_shop" style='font-family: "Times New Roman";'>
                            <span >
                                <b >Manchester United
                                    Enquiries &amp; Products
                                </b>
                            </span>
                        </p>

                        <p style='font-family: "Times New Roman", serif; font-size: 16px;'>
                            <span>For general enquiries and anything to do with
                                products details on the main </span>
                            <a style="color: blue; text-decoration: underline;" href="homePageController">
                                <span >https://www.giftShop.com/</span>
                            </a>
                            <span> site.</span>
                        </p>
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
</html>