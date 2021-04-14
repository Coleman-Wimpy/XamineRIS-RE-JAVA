<%--
  Created by IntelliJ IDEA.
  User: cwimp
  Date: 4/13/2021
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Radiologist Patient View</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="flex-nowrap flex-row flex inset-x-0 top-0 z-50 justify-start fixed items-center py-2 px-4 bg-gray-100 ">

        <!-- link element that will redirect to the /admin path -->
        <a href="/radiologist/patientRadiologistSearch.jsp" class="inline-block py-1 mr-4 text-xl whitespace-nowrap">
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
            <span id="loginAsUser" class="text-gray-500 inline-block py-2">Logged in as <strong>${user} , ${role}</strong></span>
        </div>
    </nav><br>

    <div class="flexBox">
        <br>
        <h2>Patient Information</h2>
        <span>
                    <strong>First Name: </strong>
                    <p>${firstName}</p>
                </span>

        <span>
                    <strong>Middle Name: </strong>
                    <p>${middleName}</p>
                </span>

        <span>
                    <strong>Last Name: </strong>
                    <p>${lastName}</p>
                </span>

        <span>
                    <strong>Date of Birth: </strong>
                    <p>${dob}</p>
                </span>

        <span>
                    <strong>Phone Number: </strong>
                    <p>${phoneNumber}</p>
                </span>

        <span>
                    <strong>Email Address: </strong>
                    <p>${email}</p>
                </span>

        <span>
                    <strong>X-Ray Dye Allergy: </strong>
                    <p>${xraydye}</p>
                </span>

        <span>
                    <strong>MRI Dye Allergy: </strong>
                    <p>${mridye}</p>
                </span>

        <span>
                    <strong>Latex Allergy: </strong>
                    <p>${latex}</p>
                </span>

        <span>
                    <strong>Asthma: </strong>
                    <p>${asthma}</p>
                </span>

        <span>
                    <strong>Notes: </strong>
                    <p>${notes}</p>
                </span>
    </div>

    <div>
        <h3>Orders</h3>

        <h4>${message}</h4>

        <div id="orderTable">
            <table>
                <tr>
                    <th>Order #</th>
                    <th>Status</th>
                </tr>

                ${order}
            </table>
        </div>
    </div>

</body>
</html>
