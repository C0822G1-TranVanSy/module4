<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 15/12/2022
  Time: 10:58 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>
  <form action="/sandwich/save" method="post">
  <label>
    <input type="checkbox" name="condiment" value="lettuce">Lettuce
  </label>
  <label>
    <input type="checkbox" name="condiment" value="tomato">Tomato
  </label>
  <label>
    <input type="checkbox" name="condiment" value="mustard">Mustard
  </label>
  <label>
    <input type="checkbox" name="condiment" value="sprouts">Sprouts
  </label>
    <button type="submit">Save</button>
  </form>
  </body>
</html>
