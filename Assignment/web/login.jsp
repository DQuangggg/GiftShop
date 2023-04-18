<%-- 
    Document   : login
    Created on : Apr 18, 2023, 7:57:04 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                <link rel="stylesheet" href="css/loginandsingup.css" />
    </head>
    <body>
        <div class="login_signup">
            <div class="form">
                <form class="login-form" action="login" method="post">
                    <h1>Login Form</h1>
                    <input type="text" placeholder="Username" name="username" required/>
                    <br><input type="password" placeholder="Password" name="password" required/>
                    <p class="text-danger" >${alertMess}</p>
                    <br><button>login</button>
                    <h1 class="message">Don't have account ?<a href="signup.jsp"> Create an account</a></h1>
                </form>
            </div>
        </div>
    </body>
</html>
