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
    <title>RIS</title>
    <!-- links the jsp page to the corresponding css page -->
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<!-- creates a navigation element that holds links to other pages on the website -->
<nav class="flex-nowrap flex-row flex inset-x-0 top-0 z-50 justify-start fixed items-center py-2 px-4 bg-gray-100 ">

    <!-- link element that will redirect to the /admin path -->
    <a href="/admin" class="inline-block py-1 mr-4 text-xl whitespace-nowrap">
        Xamine-RIS
    </a>

    <!-- div element to hold the other two nav elements -->
    <div id="nav_elements" class="flex flex-grow items-center">
        <!-- Creates an unordered list to hold the link elements -->
        <ul id="pageLinks" class="flex-row flex mr-auto pl-0 my-0 list-none ">
            <li>
                <!-- link that redirects to path /admin -->
                <a href="/admin" id="adminLink" class="px-2 block text-gray-500">Admin</a>
            </li>
            <li>
                <!-- link that redirects to path /login -->
                <a id="logoutLink" href="/login" class="px-2 block text-gray-500">Logout</a>
            </li>
        </ul>

        <!-- display the currently logged in user -->
        <span id="loginAsUser" class="text-gray-500 inline-block py-2">Logged in as ${user}</span>
    </div>
</nav>

<div id="orderContainer" class=" ">
    <!-- creates a form that will send a post method to path /patient -->
    <form action="/patient" method="POST">
        <div class="opacity-0 fixed top-0 left-0 hidden w-full h-full overflow-hidden outline-none" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class=" max-w-screen-sm my-7 mx-auto relative w-auto pointer-events-none ">
                <div class=" relative flex w-full pointer-events-auto bg-white bg-clip-padding border border-gray-400 rounded ">
                    <div id="modalHeader" class=" flex items-start justify-between p-4 ">
                        <h5 class=" my-0 leading-6 text-xl">Create New Order</h5>
                        <button class=" p-4 -my-4 -mr-4 ml-auto cursor-pointer float-right text-2xl text-black" type="button">
                            <span aria-hidden="true">*</span>
                        </button>
                    </div>
                    <div id="modalBody" class="relative p-4 ">

                    </div>
                </div>
            </div>
        </div>
    </form>
    <!-- button type submit that will submit the form -->
    <div id="buttonContainer">
        <button type="submit">Create New Order</button>
    </div>
    <div id="orders">
        <div id="activeOrders">
            <p class="orderLabel">Active Orders</p>
            <!-- table that shows the headers for the table of Active Orders -->
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
            <p class="orderLabel">Completed Orders</p>
            <!-- table that shows the headers for the Completed orders tables -->
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
