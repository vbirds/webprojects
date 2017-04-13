package com.vbirds.web;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by vbirds on 17-4-8.
 */
@WebServlet(name = "SessionDemo2")
public class SessionDemo2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("name");
        response.getWriter().write("name:" + name);
        Cookie cookie = new Cookie("JSESSIONID", "E9839CC8134E91AEC898F3D82FA9DA23");
        response.addCookie(cookie);
    }
}
