<%-- 
    Document   : login
    Created on : 03-Sept-2023, 9:53:16?am
    Author     : Rohit
--%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="hello-box">
        <h2>Login</h2>

        <p align="center">
            <%-- Display error messages if there are any --%>
            <c:if test="${param.error ne null}">
                <span style="color: red">${param.error}</span>
            </c:if>
        </p>

        <form method="post" action="LoginServlet">
            <div class="user-box">
                <input type="text" name="username" id="userinput" required>
                <label >Username</label>
            </div>
            <div class="user-box">
                <input type="text" name="password" id="userinput" required>
                <label >Password</label>
            </div>
            <div name="btn">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <button type="Submit" name="submit">Submit</button>
            </div>
            <p align="center"><a href="index.jsp">New User?</a></p>
        </form>
    </div>
</body>
</html>