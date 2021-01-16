<%--
  Created by IntelliJ IDEA.
  User: rakhad
  Date: 1/4/21
  Time: 09:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    <title>Demo</title>
</head>
<body>
<div class="container pb-5">
    <h3 class="text-center mt-5 mb-5">This is the title</h3>
    <div style="padding: 0px 200px;">
        <form action="main" method="post">
            <div class="input-group mb-3">
                <input type="hidden" name="action" value="load"/>
                <input type="text" class="form-control" name="path" placeholder="Enter a directory" aria-label="directory" aria-describedby="btn-load">
                <button class="btn btn-outline-secondary" type="submit" id="btn-load">Load</button>
            </div>
        </form>
        <%
            if (request.getAttribute("value") != null){
                String value = (String) request.getAttribute("value");
                out.print("<p>" + value + "</p>");
            }
        %>

        <c:forEach var="book" items="${files}">
            <ul class="list-group">
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    ${book}
<%--                    <div class="spinner-border text-primary spinner-border-sm" role="status">--%>
<%--                        <span class="visually-hidden">Loading...</span>--%>
<%--                    </div>--%>
                </li>
<%--                <li class="list-group-item d-flex justify-content-between align-items-center">--%>
<%--                    Dapibus ac facilisis in--%>
<%--                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red" class="bi bi-x-circle-fill" viewBox="0 0 16 16">--%>
<%--                        <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>--%>
<%--                    </svg>--%>
<%--                </li>--%>
<%--                <li class="list-group-item d-flex justify-content-between align-items-center">--%>
<%--                    Morbi leo risus--%>
<%--                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green" class="bi bi-check-circle-fill" viewBox="0 0 16 16">--%>
<%--                        <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>--%>
<%--                    </svg>--%>
<%--                </li>--%>
            </ul>
        </c:forEach>
        <div class="d-flex flex-row-reverse mt-4">
            <form action="main" method="post">
                <input type="hidden" name="action" value="clear"/>
                <button class="btn btn-secondary" type="submit" style="margin-left: 10px;">
                    Clear
                </button>
            </form>
            <form action="main" method="post">
                <input type="hidden" name="action" value="revert"/>
                <button class="btn btn-primary" style="margin-left: 10px;">
                    Revert
                </button>
            </form>
            <form action="main" method="post">
                <input type="hidden" name="action" value="rename"/>
                <button class="btn btn-primary" style="margin-left: 10px;">
                    Rename
                </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
