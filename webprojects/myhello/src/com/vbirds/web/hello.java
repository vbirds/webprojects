package com.vbirds.web;

import com.vbirds.web.entity.Contact;
import com.vbirds.web.util.XMLUtil;
import org.dom4j.Document;
import org.dom4j.Element;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

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

    public static void main(String[] args) {
        Document doc = XMLUtil.getDocument("/home/vbirds/contact.xml");
        if (doc != null) {
            List<Element> conList = (List<Element>) doc.selectNodes("//contact");
            for (Element elem : conList) {
                Contact c = new Contact();
                c.setId(elem.attributeValue("id"));
                c.setName(elem.elementText("name"));
                c.setGender(elem.elementText("gender"));
                c.setAge(elem.elementText("age"));
                c.setQq(elem.elementText("qq"));
                c.setEmail(elem.elementText("email"));
                c.setPhone(elem.elementText("phone"));
                System.out.println("contact:" + c.toString());
            }
        }
    }
}
