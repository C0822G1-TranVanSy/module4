<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 14/12/2022
  Time: 11:29 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <form action="/convert" method="post">
    <fieldset style="display: inline">
      <legend>Chuyển đổi tiền tệ</legend>
    <select name="type1">
      <option value="USD">USD</option>
      <option value="VND">VND</option>
    </select>
    <input type="number" name="number" value="0">
    <select name="type2">
      <option value="USD">USD</option>
      <option value="VND">VND</option>
    </select>
    <button type="submit">Nhấn</button>
    </fieldset>
  </form>
  </body>
</html>
