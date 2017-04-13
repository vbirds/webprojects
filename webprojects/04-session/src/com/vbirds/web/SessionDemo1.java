package com.vbirds.web;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by vbirds on 17-4-8.
 */
@javax.servlet.annotation.WebServlet(name = "SessionDemo1")
public class SessionDemo1 extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("name", "rose");
    }
}
