<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%--        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"--%>
    <%--              integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">--%>
    <%--        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"--%>
    <%--                integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"--%>
    <%--                crossorigin="anonymous"></script>--%>
    <title>Start game</title>
    <style type="text/css">

        .chessboard {
            width: 640px;
            height: 640px;
            margin: 20px;
            border: 25px solid #333;
        }

        .black {
            float: left;
            width: 80px;
            height: 80px;
            background-color: #999;
            font-size: 50px;
            text-align: center;
            display: table-cell;
            vertical-align: middle;
        }

        .white {
            float: left;
            width: 80px;
            height: 80px;
            background-color: #fff;
            font-size: 50px;
            text-align: center;
            display: table-cell;
            vertical-align: middle;
        }
    </style>
</head>
<body>
<div class="chessboard">
    <c:forEach items="${board}" var="myboard">
        <div class="white"><c:out value="${myboard.getPiece()}"/> &#9820;</div>
        <div class="black">&#9822;</div>
        <div class="white">&#9821;</div>
        <div class="black">&#9819;</div>
        <div class="white">&#9818;</div>
        <div class="black">&#9821;</div>
        <div class="white">&#9822;</div>
        <div class="black">&#9820;</div>

    </c:forEach>
</div>
<%--Chess Board... TODO--%>


<div class="container">
    <div class="form-container">
        <form action="client" method="post">
            <div class="mb-3">
                <label for="startX" class="form-label">StartX</label>
                <input type="number" class="form-control" id="startX" name="startX" placeholder="Enter StartX">
            </div>
            <div class="mb-3">
                <label for="startY" class="form-label">StartY</label>
                <input type="number" class="form-control" id="startY" name="startY" placeholder="Enter StartY">
            </div>
            <div class="mb-3">
                <label for="endX" class="form-label">EndX</label>
                <input type="number" class="form-control" id="endX" name="endX" placeholder="Enter endX">
            </div>
            <div class="mb-3">
                <label for="endY" class="form-label">EndY</label>
                <input type="number" class="form-control" id="endY" name="endY" placeholder="Enter endY">
            </div>
            <button type="submit" class="btn btn-primary">Enter</button>
        </form>
    </div>
</div>
</body>
</html>