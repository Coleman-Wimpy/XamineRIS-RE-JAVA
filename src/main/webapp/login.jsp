<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="index_style.css">
    <title>XamineRIS - Login</title>
</head>
<body class="text_center">
    <form class="form_signIn" method="post" action="/admin">
        <h1>
            <img src="xamineLogo.png" alt="XamineRIS Logo" id="logoImg" width="60px" height="60px">
        </h1>
        <h1 id="titleHeader">Xamine RIS</h1>
        <div class="form_group" id="div_username">
            <label class="requiredField" for="username">
                Username
                <span class="asterik">*</span>
            </label>
            <div>
                <input class="textInput" id="username" type="text" name="username" maxlength="100" autofocus required>
            </div>
        </div>
        <div class="form_group" id="div_password">
            <label class="requiredField" for="password">
                Password
                <span class="asterik">*</span>
            </label>
            <div>
                <input class="textInput" id="password" type="password" name="password" maxlength="100" required>
            </div>
        </div>
        <button type="submit" id="submit">Sign In</button>
    </form>
</body>
</html>