<%--
  Created by IntelliJ IDEA.
  User: vbirds
  Date: 17-4-13
  Time: 下午2:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="简写" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
    <c:set var="name" value="rose" scope="page"></c:set>

    <c:out value="${name}"></c:out>

    <c:if test="${10>5}">
        <h1>Hello if</h1>
    </c:if>

    <c:choose>
        <c:when test="${name=='rose'}">
            <h1>Hello Rose</h1>
        </c:when>
        <c:otherwise>
            <h1>Hello otherwise</h1>
        </c:otherwise>
    </c:choose>


</body>
</html>
