package com.vbirds.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by vbirds on 17-4-8.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("uft-8");
        String name =  request.getParameter("userName");
        String password = request.getParameter("userPwd");

        if ("vbirds".equals(name) && ("123456".equals(password))) {
            /**
             * 一、登录成功后，把用户数据保存session对象中
             */
            //1.创建session对象
            HttpSession session = request.getSession();
            //2.把数据保存到session域中
            session.setAttribute("loginName", name);
            //3.跳转到用户主页
            response.sendRedirect(request.getContextPath()+"/05-login/IndexServlet");
        } else {
            response.sendRedirect("/fail.html");
        }
    }
}
