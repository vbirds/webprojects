package com.vbirds.web;

import javax.servlet.http.Cookie;
import java.io.File;
import java.io.IOException;

/**
 * Created by vbirds on 17-4-6.
 */
@javax.servlet.annotation.WebServlet(name = "CookieDemo1")
public class CookieDemo1 extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //1. create
        Cookie cookie = new Cookie("eamil", "841952496@qq.com");
        // 3. set path
        cookie.setPath("/03-cookie");
        //2. send
        response.addCookie(cookie);

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie ck : cookies) {
                response.getWriter().write("name:" + ck.getName() + " value:" + ck.getValue());
            }
        }

        response.getWriter().write(new File("/02-Cookie").getAbsolutePath());
    }
}
