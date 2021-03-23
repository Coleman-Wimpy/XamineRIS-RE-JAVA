<%--
  Created by IntelliJ IDEA.
  User: Dillon
  Date: 3/17/2021
  Time: 12:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <title>Patient Search</title>
</head>
<body>
    <nav class="flex-nowrap flex-row flex inset-x-0 top-0 z-50 justify-start fixed items-center py-2 px-4 bg-gray-100 ">

        <!-- link element that will redirect to the /admin path -->
        <a href="patientSearch.jsp" class="inline-block py-1 mr-4 text-xl whitespace-nowrap">
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
        <form id="patientSearchForm" action="patientSearch.jsp" method="POST">
            <div class="py-8">
                <div class="mt-8 max-w-md">
                    <div class="grid grid-cols-1 gap-6">
                        <label class="block">
                            <span class="text-gray-700">Patient name</span>
                            <input
                                    type="text"
                                    class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0"
                                    placeholder=""
                            />
                        </label>
                    </div>
                </div>
            </div>
            <input type="submit" value="Submit"/>
        </form>
    </div>
</body>
</html>
