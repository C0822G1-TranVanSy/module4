<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 14/12/2022
  Time: 2:53 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  </head>
  <body>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  <h1 class="d-flex justify-content-center m-2">Từ điển hoa quả sơn</h1>
  <form class="d-flex justify-content-center" action="/dictionary" method="get">
    <div class="row">
      <div class="col-9">
    <input class="form-control m-2" type="search" placeholder="Search" aria-label="Search" name="text">
      </div>
      <div class="col-3">
    <button class="btn btn-outline-success m-2" type="submit">Translate</button>
      </div>
    </div>
  </form>
  </body>
</html>