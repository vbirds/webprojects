package com.vbirds.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vbirds on 17-4-5.
 */
@WebServlet(name = "world")
public class world extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("world init 对象创建啦");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("world 对象调用 service方法");
    }

    @Override
    public void destroy() {
        System.out.println("world 对象被销毁啦");
    }

    @Override
    public String getServletInfo() {
        System.out.println("world getServletInfo");
        return "";
    }


}
