<%@ page import="com.vbirds.web.entity.Contact" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: vbirds
  Date: 17-4-13
  Time: 上午10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>查询所有联系人</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<table  class="table table-hover">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>电话</th>
        <th>邮箱</th>
        <th>QQ</th>
        <th>操作</th>
    </tr>
    <%--<%--%>
        <%--List<Contact> list = (List<Contact>)request.getAttribute("contactList");--%>
        <%--for (Contact c : list) {--%>
    <%--%>--%>
    <%--<tr>--%>
        <%--<td><%=c.getId()%></td>--%>
        <%--<td><%=c.getName()%></td>--%>
        <%--<td><%=c.getGender()%></td>--%>
        <%--<td><%=c.getAge()%></td>--%>
        <%--<td><%=c.getPhone()%></td>--%>
        <%--<td><%=c.getEmail()%></td>--%>
        <%--<td><%=c.getQq()%></td>--%>
        <%--<td><a href="/08-jsp_contact/QueryContactServlet?id=<%=c.getId()%>">修改</a>&nbsp;<a href="contacts.html">删除</a></td>--%>
    <%--</tr>--%>
    <%--<%--%>
        <%--}--%>
    <%--%>--%>
    <c:forEach begin="0"
               step="1"
               items="${requestScope.contactList}" var="contact" varStatus="varSta">
        <tr>
        <td>${contact.id}</td>
        <td>${contact.name}</td>
        <td>${contact.gender}</td>
        <td>${contact.age}</td>
        <td>${contact.phone}</td>
        <td>${contact.email}</td>
        <td>${contact.qq}</td>
        <td><a href="/08-jsp_contact/QueryContactServlet?id=${contact.id}">修改</a>&nbsp;<a href="contacts.html">删除</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="8" align="center">
            <a  href="addcontact.html">添加联系人</a>
        </td>
    </tr>
</table>

</body>
</html>
