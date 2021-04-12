<%--
  Created by IntelliJ IDEA.
  User: cwimp
  Date: 4/7/2021
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <title>Referral Doctor Patient Page View</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div>
        <h1>Patient Information</h1>
        <h3>First Name: ${firstName}</h3>
        <h3>Middle Name: ${middleName}</h3>
        <h3>Last Name: ${lastName}</h3>
        <h3>Date of Birth: ${dob}</h3>
        <h3>Phone Number: ${phoneNumber}</h3>
        <h3>Email Address: ${email}</h3>
        <h3>X-Ray Dye Allergy: ${xraydye}</h3>
        <h3>MRI Dye Allergy: ${mridye}</h3>
        <h3>Latex Allergy: ${latex}</h3>
        <h3>Asthma: ${asthma}</h3>
        <h3>Notes: ${notes}</h3>
    </div>

    <div>
        <h1>Orders</h1>

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

    <div>
        <div class="container">
            <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#createOrder">Create New Order</button>
            <form method="POST" action="/createOrder">
                <div class="modal fade" id="createOrder" role="dialog">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Enter Order Information</h4>
                            </div>

                            <div class="modal-body">

                                <label class="block">
                                    <span class="text-gray-700">First Name: </span>
                                    <input type="text" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" name="firstName">
                                </label>

                                <label class="block">
                                    <span class="text-gray-700">Last Name: </span>
                                    <input type="text" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" name="middleName">
                                </label>

                                <label class="block">
                                    <span class="text-gray-700">Date of Birth: </span>
                                    <input type="date" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" name="dob">
                                </label>

                                <label class="block">
                                    <span class="text-gray-700">Reason for Visit:  </span>
                                    <input type="class" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" name="reason">
                                </label>

                                <label class="block">
                                    <span class="text-gray-700">Imaging Required: </span>
                                    <input type="text" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" name="imaging">
                                </label>

                                <label class="block">
                                    <span class="text-gray-700">Modality: </span> <br>
                                    <label for="xray">X-Ray</label>
                                    <input type="radio" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" id="xray" name="modality" value="xray">
                                    <label for="xray">CT Scan</label>
                                    <input type="radio" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" id="ctscan" name="modality" value="ctscan">
                                    <label for="xray">MRI</label>
                                    <input type="radio" class="mt-1 block w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0" id="mri" name="modality" value="mri">
                                </label>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Create Order</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
