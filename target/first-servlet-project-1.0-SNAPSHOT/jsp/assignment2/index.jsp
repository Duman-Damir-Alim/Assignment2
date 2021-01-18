<%@ page import="assignment2.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Chess</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <p>User: <%=((User)session.getAttribute("user")).getUsername()%></p>
    <div id="table-area"></div>
    <div id="errors"></div>
    <div id="moves"></div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/chess_table.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>