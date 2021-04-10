<%--
  Created by IntelliJ IDEA.
  User: Dillon
  Date: 4/7/2021
  Time: 12:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <title>Patient Search</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="flex-nowrap flex-row flex inset-x-0 top-0 z-50 justify-start fixed items-center py-2 px-4 bg-gray-100 ">

        <!-- link element that will redirect to the /admin path -->
        <a href="doctorPage.jsp" class="inline-block py-1 mr-4 text-xl whitespace-nowrap">
            Xamine-RIS
        </a>

        <!-- div element to hold the other two nav elements -->
        <div id="nav_elements" class="flex flex-grow items-center">
            <!-- Creates an unordered list to hold the link elements -->
            <ul id="pageLinks" class="flex-row flex mr-auto pl-0 my-0 list-none ">
                <li>
                    <!-- link that redirects to path /login -->
                    <a id="logoutLink" href="/login" class="px-2 block text-gray-500">Logout</a>
                </li>
            </ul>

            <!-- display the currently logged in user -->
            <span id="loginAsUser" class="text-gray-500 inline-block py-2">Logged in as <strong>${user}</strong></span>
        </div>
    </nav>

    <div>
        <form id="patientSearchForm" action="/receptionist" method="POST">
            <div class="py-8">
                <div class="mt-8 max-w-md">
                    <div class="grid grid-cols-1 gap-6">
                        <h4>${message}</h4>
<%--                        <label class="block">--%>
<%--                            <span class="text-gray-700">Patient first name</span>--%>
<%--                            <input--%>
<%--                                    type="text"--%>
<%--                                    class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0"--%>
<%--                                    name="firstName"--%>
<%--                                    placeholder=""--%>
<%--                            />--%>
<%--                        </label>--%>
<%--                        <label class="block">--%>
<%--                            <span class="text-gray-700">Patient last name</span>--%>
<%--                            <input--%>
<%--                                    type="text"--%>
<%--                                    class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0"--%>
<%--                                    name="lastName"--%>
<%--                                    placeholder=""--%>
<%--                            />--%>
<%--                        </label>--%>
                        <label class="block">
                            <span class="text-gray-700">Patient D.O.B.</span>
                            <input type="date" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" id="dob" name="dob" value="${current_dob}"/>
                        </label>
                    </div>
                </div>
            </div>
            <input type="submit" value="Submit"/>
        </form>

        <div>
            <div class="container">
                <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#createPatient">Create New Patient</button>
                <form method="POST" action="/patient/new">
                    <div class="modal fade" id="createPatient" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Enter New Patient Information</h4>
                                </div>

                                <div class="modal-body">

                                    <label class="block">
                                        <span class="text-gray-700">First Name: </span>
                                        <input type="text" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" name="firstName">
                                    </label>

                                    <label class="block">
                                        <span class="text-gray-700">Middle Name: </span>
                                        <input type="text" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" name="middleName">
                                    </label>

                                    <label class="block">
                                        <span class="text-gray-700">Last Name: </span>
                                        <input type="text" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" name="lastName">
                                    </label>

                                    <label class="block">
                                        <span class="text-gray-700">Email Info: </span>
                                        <input type="email" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" name="email">
                                    </label>

                                    <label class="block">
                                        <span class="text-gray-700">Birth Date: </span>
                                        <input type="date" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" name="birthDate">
                                    </label>

                                    <label class="block">
                                        <span class="text-gray-700">Phone Number: </span>
                                        <input type="number" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" name="phoneNumber">
                                    </label>

                                    <label class="block">
                                        <span class="text-gray-700">Allergy Asthma? </span>
                                        <input type="checkbox" value="true" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" name="asthmaAllergy">
                                    </label>

                                    <label class="block">
                                        <span class="text-gray-700">Allergy XRayDye: </span>
                                        <input type="checkbox" value="true" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" name="xraydyeAllergy">
                                    </label>

                                    <label class="block">
                                        <span class="text-gray-700">Allergy MRIDye? </span>
                                        <input type="checkbox" value="true" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" name="mriAllergy">
                                    </label>

                                    <label class="block">
                                        <span class="text-gray-700">Allergy Latex? </span>
                                        <input type="checkbox" value="true" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" name="latexAllergy">
                                    </label>

                                    <label class="block">
                                        <span class="text-gray-700">Notes: </span>
                                        <input type="text" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" name="notes">
                                    </label>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Save New Patient</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <ul>
                ${patient}
            </ul>
        </div>
    </div>
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
