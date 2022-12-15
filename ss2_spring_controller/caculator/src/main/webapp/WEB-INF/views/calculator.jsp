<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 15/12/2022
  Time: 1:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<h1 class="text-center">Calculator</h1>
<form action="/calculator/save" method="post">
    <div class="row d-flex justify-content-center">
        <label for="number1"></label>
        <div class="col-md-3 m-2">
            <input type="text" class="form-control" id="number1" pattern="(-?)(\d*)((\.\d+)?)" name="number1"
                   required>
        </div>
    </div>
    <div class="row d-flex justify-content-center">
        <label class="col-md-3 m-2">
            <select name="calculate" class="form-select">
                <option value="+">Addition(+)</option>
                <option value="-">Subtraction(-)</option>
                <option value="*">Multiplication(x)</option>
                <option value="/">Division(/)</option>
            </select>
        </label>
    </div>
    <div class="row d-flex justify-content-center">
        <label for="number2"></label>
        <div class="col-md-3 m-2">
            <input type="text" class="form-control" id="number2" pattern="(-?)(\d*)((\.\d+)?)" name="number2" required>
        </div>
    </div>
    <div class="d-flex justify-content-center">
    <button type="submit" class="btn btn-danger">Result</button>
    </div>
</form>

<c:if test="${number2==0}">
    <marquee style="color: red">${errorMsg}</marquee>
</c:if>
<c:if test="${number2!=0}">
    <marquee style="color: green">${result}</marquee>
</c:if>
</body>
</html>
