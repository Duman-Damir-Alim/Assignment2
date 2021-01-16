<%--
  Created by IntelliJ IDEA.
  User: rakhad
  Date: 1/16/21
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    <title>Start game</title>
    <style type="text/css">
        .form-container{
            margin: 200px 400px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="form-container">
        <form action="auth" method="post">
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Enter Username">
            </div>
            <div class="mb-3">
                <label for="side" class="form-label">Enter your side</label>
                <select class="form-select" id="side" name="side">
                    <option value="black">Black</option>
                    <option value="white">White</option>
                </select>
            </div>
            <%
                if (request.getAttribute("error") != null){
                    out.print("<div class=\"alert alert-danger\" role=\"alert\">");
                    out.print("Username cannot be empty");
                    out.print("</div>");
                }
            %>
            <button type="submit" class="btn btn-primary">Enter</button>
        </form>
    </div>
</div>
</body>
</html>