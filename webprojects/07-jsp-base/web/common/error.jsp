<%--
  Created by IntelliJ IDEA.
  User: vbirds
  Date: 17-4-13
  Time: 上午9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8"
         isErrorPage="true"
%>
<html>
<head>
    <title>错误处理页面</title>
</head>
<body>
    亲，系统发生小小错误: <%=exception.getMessage()%>
</body>
</html>
