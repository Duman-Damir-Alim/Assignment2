<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>
    <title>Start game</title>
    <style type="text/css">
        .form-container {
            margin: 100px 300px;
        }
    </style>
</head>
<body>

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