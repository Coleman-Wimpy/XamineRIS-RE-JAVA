<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Header that links the style sheet and assigns a title to the html page -->
    <link rel="stylesheet" href="index_style.css">
    <title>XamineRIS - Login</title>
</head>
<body class="text_center">
    <!-- Create a form that sends a http post request on the path /admin -->
    <form class="form_signIn" method="post" action="/admin">
        <h1>
            <!-- diplays a logo -->
            <img src="xamineLogo.png" alt="XamineRIS Logo" id="logoImg" width="60px" height="60px">
        </h1>
        <!-- Creates a Header element that will display in larger text than the rest of the elements -->
        <h1 id="titleHeader">Xamine RIS</h1>

        <!-- creats a div element to hold the username field of the login -->
        <div class="form_group" id="div_username">
            <!-- Label for the Username Input field so the user knows what to enter -->
            <label class="requiredField" for="username">
                Username
                <span class="asterik">*</span>
            </label>
            <!-- input element that allow the user to enter text(username) -->
            <div>
                <input class="textInput" id="username" type="text" name="username" maxlength="100" autofocus required>
            </div>
        </div>
        <!-- Div element to hold the password input field -->
        <div class="form_group" id="div_password">
            <!-- Label for the password input so the user know what to enter -->
            <label class="requiredField" for="password">
                Password
                <span class="asterik">*</span>
            </label>
            <!-- input field to allow the user to enter their password, type set to password so input is not displayed in plain text -->
            <div>
                <input class="textInput" id="password" type="password" name="password" maxlength="100" required>
            </div>
        </div>
        <!-- button with the type of submit that will send the post request when pressed -->
        <button type="submit" id="submit">Sign In</button>
    </form>
</body>
</html>