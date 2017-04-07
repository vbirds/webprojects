package com.vbirds.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vbirds on 17-4-6.
 */
@WebServlet(name = "GetLatsTime")
public class GetLatsTime extends HttpServlet {

    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        Cookie   lastTimeCookie = null;

        // first time
        if (cookies == null) {
            lastTimeCookie = new Cookie("lasttime", getStringDate());
            response.addCookie(lastTimeCookie);
            return;
        }

        for (Cookie ck : cookies) {
            if (ck.getName().equals("lasttime")) {
                lastTimeCookie = ck;
                break;
            }
        }

        // first time
        if (lastTimeCookie == null) {
            lastTimeCookie = new Cookie("lasttime", getStringDate());
            response.addCookie(lastTimeCookie);
            return;
        }

        String currdate = getStringDate();
        response.getWriter().write("您上次访问的时间:" + lastTimeCookie.getValue() +
                                        "<br />这次的时间为:" + currdate);
        lastTimeCookie.setValue(currdate);
        response.addCookie(lastTimeCookie);

        cookies         = null;
        lastTimeCookie  = null;
        currdate        = null;
    }
}
