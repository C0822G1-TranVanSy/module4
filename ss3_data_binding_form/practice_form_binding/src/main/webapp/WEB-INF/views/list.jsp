<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 16/12/2022
  Time: 10:50 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<h1 class="m-2 text-center">Settings</h1>
<marquee class="text-success">${mess}</marquee>
<table class="table table-striped">
    <tr>
        <th>Language</th>
        <th>Page Size</th>
        <th>Spams Filter</th>
        <th>Signature</th>
        <th>Update</th>
    </tr>
    <c:forEach var="e" items="${emailList}">
        <tr>
            <td>${e.language}</td>
            <td>${e.pageSize}</td>
            <c:if test="${e.spamsFilter}">
                <td>Enable spams filter</td>
            </c:if>
            <c:if test="${!e.spamsFilter}">
                <td>No enable spams filter</td>
            </c:if>
            <td>${e.signature}</td>
            <td><a class="btn btn-danger" href="/edit/${e.id}">Update</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
