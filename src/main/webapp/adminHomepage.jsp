<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            display: flex;
            min-height: 100vh;
            flex-direction: column;
        }
        #sidebar {
            min-width: 250px;
            max-width: 250px;
            background-color: #343a40;
            color: white;
            padding-top: 20px;
            height: 100vh;
            position: fixed;
        }
        #sidebar a {
            color: white;
            text-decoration: none;
            padding: 10px;
            display: block;
        }
        #sidebar a:hover {
            background-color: #495057;
        }
        #content {
            margin-left: 250px;
            padding: 20px;
            flex-grow: 1;
        }
        @media (max-width: 768px) {
            body {
                flex-direction: column;
            }
            #sidebar {
                width: 100%;
                min-width: 100%;
                position: relative;
                height: auto;
            }
            #content {
                margin-left: 0;
                padding: 10px;
            }
        }
    </style>
</head>
<body>
    <div id="sidebar">
        <h3 class="text-center">Admin Panel</h3>
        <a href="#">Dashboard</a>
        <a href="ViewUsersServlet">View Users & Retailers</a>
        <a href="ManageUsersServlet">Manage Users</a>
        <a href="ViewComplaintsServlet">View Complaints</a>
        <a href="view-registration-requests.jsp">Registration Requests</a>
    </div>

    <div id="content">
        <h1 class="text-center mb-4">Admin Dashboard</h1>
        <div class="row">
            <div class="col-md-4 mb-4">
                <div class="card text-center">
                    <div class="card-body">
                        <h5 class="card-title">Total Users</h5>
                        <p id="userCount" class="card-text display-4">0</p>
                        <a href="ManageUsersServlet" class="btn btn-primary mt-2">Manage Users</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-4">
                <div class="card text-center">
                    <div class="card-body">
                        <h5 class="card-title">Total Complaints</h5>
                        <p id="complaintCount" class="card-text display-4">0</p>
                        <a href="view-complaints.jsp" class="btn btn-warning mt-2">View Complaints</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-4">
                <div class="card text-center">
                    <div class="card-body">
                        <h5 class="card-title">Registration Requests</h5>
                        <p id="requestCount" class="card-text display-4">0</p>
                        <a href="ViewComplaintsServlet" class="btn btn-success mt-2">Manage Requests</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        // Fetch data from the servlet and update the dashboard
        fetch('AdminServlet?taskType=dashboardData')
            .then(response => response.json())
            .then(data => {
                document.getElementById('userCount').innerText = data.userCount;
                document.getElementById('complaintCount').innerText = data.complaintCount;
                document.getElementById('requestCount').innerText = data.registrationRequestCount;
            })
            .catch(error => console.error('Error fetching data:', error));
    </script>
</body>
</html>
