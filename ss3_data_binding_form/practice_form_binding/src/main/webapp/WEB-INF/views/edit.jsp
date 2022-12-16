<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 16/12/2022
  Time: 11:48 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<%--@elvariable id="email" type=""--%>
<h1 class="m-2">Edit</h1>

<form:form method="post" action="/edit" modelAttribute="email">
    <form:hidden path="id"></form:hidden>
    <div class="row m-2">
        <form:label path="language" class="col-2">Languages: </form:label>
        <form:select path="language" items="${languageList}" class="col-3"></form:select>
    </div>
    <div class="row m-2">
        <form:label path="pageSize" class="col-2">Page Size: </form:label>
        <div class="col-3">
        <span >Show</span>
        <form:select path="pageSize" items="${pageSizeList}" ></form:select>
        <span>emails per page</span>
        </div>
    </div>
    <div class="row m-2">
        <form:label path="spamsFilter" class="col-2">Spams Filter: </form:label>
        <div class="col-3">
        <form:checkbox path="spamsFilter"></form:checkbox><span> Enable spams filter</span>
        </div>
    </div>
    <div class="row m-2">
        <form:label path="signature" class="col-2">Signature: </form:label>
        <form:textarea path="signature" class="col-3"></form:textarea>
    </div>
    <div class="row m-2">
        <span class="col-1"></span>
        <button type="submit" class="col-2 btn-warning">Update</button>
        <a href="/" class="col-2 btn btn-secondary">Cancel</a>
    </div>
</form:form>
</body>
</html>
