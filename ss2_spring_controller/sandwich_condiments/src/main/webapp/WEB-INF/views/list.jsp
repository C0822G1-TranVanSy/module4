<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 15/12/2022
  Time: 11:09 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách gia vị đã chọn</h1>
<table>
<c:forEach var="c" items="${condiments}">
    <tr>
<td>${c}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
