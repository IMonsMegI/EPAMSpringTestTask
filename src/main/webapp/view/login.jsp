<%@ include file="/view/taglib.jspf" %>

<html>

<head>
    <title>Dynamusic</title>
</head>
<body>
<center><h1>Dynamusic</h1></center>
<form method="post" action="login" model-atribute="user">
    <label>Login</label>
    <input name="login" type="text" placeholder="login"/>

    <label>Password</label>
    <input name="password" type="password" placeholder="password"/>

    <input type="submit" value="Login">
</form>
</body>
</html>