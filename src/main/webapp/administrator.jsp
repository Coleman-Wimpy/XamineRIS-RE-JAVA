<%--
  Created by IntelliJ IDEA.
  User: cwimp
  Date: 2/24/2021
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="admin_style.css">
    <title>RIS</title>
</head>
<body>
    <nav id="nav_bar">
        <a href="/admin" id="titleLink">
            <img src="xamineLogo.png" alt="logo image" width="40" height="40">
            Xamine-RIS
        </a>
        <div id="nav_elements">
            <ul id="pageLinks">
                <li class="navLink">
                    <a href="/admin" id="adminLink">Admin</a>
                </li>
                <li class="navLink">
                    <a id="logoutLink" href="/login">Logout</a>
                </li>
            </ul>

            <span id="loginAsUser">Logged in as admin</span>
        </div>
    </nav>

    <div id="orderContainer">
        <div id="buttonContainer">
            <button type="submit">Create New Order</button>
        </div>
        <div id="orders">
            <div id="activeOrders">
                <p class="orderLabel">Active Orders</p>
                <table id="activeOrderTable">
                    <thead>
                        <tr>
                            <th>Order #</th>
                            <th>Patient</th>
                            <th>Stage</th>
                        </tr>
                    </thead>
                </table>
            </div>
            <div id="completeOrders">
                <p class="orderLabel">Active Orders</p>
                <table id="completeOrderTable">
                    <thead>
                    <tr>
                        <th>Order #</th>
                        <th>Patient</th>
                        <th>Completed</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>

</body>
</html>
