package com.vbirds.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by vbirds on 17-4-4.
 */
public class hello extends javax.servlet.http.HttpServlet {


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");
        out.println("<h3>当前时间为:"+new Date() +"</h3>");
        out.println("</body>");
        out.println("</html>");

        this.getServletContext().setAttribute("name", "hello");
    }
}
