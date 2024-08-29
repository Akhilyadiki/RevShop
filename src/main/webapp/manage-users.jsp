<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .table-hover tbody tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center mb-4">Manage Users</h1>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.userId}</td>
                        <td>${user.fullName}</td>
                        <td>${user.email}</td>
                        <td>
                            <span style="{color:black}" class="badge badge-${user.isblocked ? 'danger' : 'success'}" id="status-${user.userId}">
                                ${user.isblocked ? 'Blocked' : 'Active'}
                            </span>
                        </td>
                        <td>
                            <button class="btn btn-${user.isblocked ? 'success' : 'danger'} btn-sm" id ="blockButton"
                                    onclick="toggleUserStatus(${user.userId}, ${user.isblocked})">
                                ${user.isblocked ? 'Unblock' : 'Block'}
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script>
    
        function toggleUserStatus(userId, isblocked) {
        	
            const action = isblocked ? 'unblock' : 'block';
            fetch("AdminActionServlet?userId="+userId+"&action="+action)
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    const statusElement = document.getElementById("status-"+userId);
                    const blockButtton = document.getElementById("blockButton");
                    statusElement.classList.toggle('badge-danger');
                    statusElement.classList.toggle('badge-success');
                    statusElement.textContent = isblocked ? 'Active' : 'Blocked';
                    blockButton.classList.toggle("btn-"+action);
                } else {
                    alert('Failed to update user status');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Error updating user status');
            });
        }
    </script>
</body>
</html>