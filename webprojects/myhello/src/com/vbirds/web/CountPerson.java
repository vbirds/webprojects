package com.vbirds.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Integer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by vbirds on 17-4-5.
 */
@WebServlet(name = "CountPerson")
public class CountPerson extends HttpServlet {

    static final AtomicInteger count = new AtomicInteger(0);
    static ConcurrentHashMap hostMap = new ConcurrentHashMap<String , Integer>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String host = request.getRemoteHost();
        Integer num = null;
        synchronized (this) {
            num = (Integer) hostMap.get(host);
        }
        if (num == null) {
            hostMap.put(host, 1);
            count.addAndGet(1);
        } else {
            hostMap.put(host, num.intValue() + 1);
        }

        response.getWriter().write("你现在是第" + count.get() + "访客");

        String filePath = request.getParameter("file");
        System.out.println("RemoteHost:" + request.getRemoteHost());

        // read
        File file = new File(filePath);
        if (!file.isFile()) {
            response.getWriter().write("请输入合法的路径:" + filePath);
            return;
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str = null;
        while ((str = br.readLine()) != null ) {
            response.getWriter().write("<pre>" + str +"</pre>");
        }

        ServletConfig config = getServletConfig();
        response.getWriter().write(config.getInitParameter("path"));

        String name = (String)this.getServletContext().getAttribute("name");
        response.getWriter().write("<br />" + name + "<br />");

        host = null;
        num  = null;
    }
}
