<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: frankstar
  Date: 2017/6/11
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach items="${earthQuakeList}" var="earthQuake">
        <tr>
            <td><c:out value="${earthQuake.title}" /></td>
            <td><c:out value="${earthQuake.deepth}" /></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
