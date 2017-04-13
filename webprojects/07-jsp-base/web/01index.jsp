<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.omg.Messaging.SYNC_WITH_TRANSPORT" %><%--
  Created by IntelliJ IDEA.
  User: vbirds
  Date: 17-4-12
  Time: 下午9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title></title>
  </head>
  <body>
      <%
          SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
          String curDate = df.format(new Date());
      %>
      <%
          for (int i=0; i < 5; ++i) {
      %>
      <h<%=i+1%>><%="当前时间3为:" + curDate%></h<%=i+1%>>
      <%
          }
      %>
  <%@include file="common/header.jsp"%>
  </body>
</html>
