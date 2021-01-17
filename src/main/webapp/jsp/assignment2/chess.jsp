<%@ page import="assignment2.model.Spot" %>
<%@ page import="assignment2.model.Board" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
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

    <%
        Board board = new Board();
        board = (Board) request.getAttribute("board");
    %>

    <div class="chessboard">
        <!-- 1st -->
        <div class="white">&#9820;</div>
        <div class="black">&#9822;</div>
        <div class="white">&#9821;</div>
        <div class="black">&#9819;</div>
        <div class="white">&#9818;</div>
        <div class="black">&#9821;</div>
        <div class="white">&#9822;</div>
        <div class="black">&#9820;</div>
        <!-- 2nd -->
        <div class="black">&#9821;</div>
        <div class="white">&#9821;</div>
        <div class="black">&#9821;</div>
        <div class="white">&#9821;</div>
        <div class="black">&#9821;</div>
        <div class="white">&#9821;</div>
        <div class="black">&#9821;</div>
        <div class="white">&#9821;</div>
        <!-- 3th -->
        <div class="white"></div>
        <div class="black"></div>
        <div class="white"></div>
        <div class="black"></div>
        <div class="white"></div>
        <div class="black"></div>
        <div class="white"></div>
        <div class="black"></div>
        <!-- 4st -->
        <div class="black"></div>
        <div class="white"></div>
        <div class="black"></div>
        <div class="white"></div>
        <div class="black"></div>
        <div class="white"></div>
        <div class="black"></div>
        <div class="white"></div>
        <!-- 5th -->
        <div class="white"></div>
        <div class="black"></div>
        <div class="white"></div>
        <div class="black"></div>
        <div class="white"></div>
        <div class="black"></div>
        <div class="white"></div>
        <div class="black"></div>
        <!-- 6th -->
        <div class="black"></div>
        <div class="white"></div>
        <div class="black"></div>
        <div class="white"></div>
        <div class="black"></div>
        <div class="white"></div>
        <div class="black"></div>
        <div class="white"></div>
        <!-- 7th -->
        <div class="white">&#9817;</div>
        <div class="black">&#9817;</div>
        <div class="white">&#9817;</div>
        <div class="black">&#9817;</div>
        <div class="white">&#9817;</div>
        <div class="black">&#9817;</div>
        <div class="white">&#9817;</div>
        <div class="black">&#9817;</div>
        <!-- 8th -->
        <div class="black">&#9814;</div>
        <div class="white">&#9816;</div>
        <div class="black">&#9815;</div>
        <div class="white">&#9813;</div>
        <div class="black">&#9812;</div>
        <div class="white">&#9815;</div>
        <div class="black">&#9816;</div>
        <div class="white">&#9814;</div>
    </div>
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