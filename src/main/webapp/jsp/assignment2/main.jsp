<%--
  Created by IntelliJ IDEA.
  User: rakhad
  Date: 1/17/21
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Main</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</head>
<style type="text/css">
    .center {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }
</style>
<body>
<div class="container">
    <div class="center">
        <h3 class="text-center">Hello, Shyngys!</h3>
        <h3 class="text-center">Welcome to our Chess Club</h3><br>
        <div class="text-center">
            <a class="btn btn-primary" href="chat">Communicate with players</a><hr>
            <a class="btn btn-primary" href="chess" >Play Chess Online</a><hr>
            <form action="auth" method="post">
                <input type="hidden" value="logout" name="method">
                <button type="submit" class="btn btn-secondary">Log out</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>