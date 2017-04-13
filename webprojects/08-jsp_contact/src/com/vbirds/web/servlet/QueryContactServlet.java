package com.vbirds.web.servlet;

import com.vbirds.web.dao.ContactDao;
import com.vbirds.web.dao.impl.ContactDaoImpl;
import com.vbirds.web.entity.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vbirds on 17-4-12.
 */
@WebServlet(name = "QueryContactServlet")
public class QueryContactServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null) {
            return;
        }

        ContactDao dao = new ContactDaoImpl();
        Contact contact = dao.findById(id);
        StringBuilder builder = new StringBuilder();

        builder.append("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>");
        builder.append("<html xmlns='http://www.w3.org/1999/xhtml'>");
        builder.append("<head>");
        builder.append("<meta charset=\"UTF-8\">\n" +
                "    <title>修改联系人</title>");

        builder.append("</head>");
        builder.append("<body>");
        builder.append("<form action=\"" + request.getContextPath() + "/08-jsp_contact/UpdateContactServlet\">");
        builder.append("<table align=\"center\" border=\"1\" width=\"300px\">");
        builder.append("<tr>\n" +
                "        <th>编号</th>\n" +
                "        <td><input type=\"text\" name=\"id\" value=\"" +contact.getId()+ "\"/></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <th>姓名</th>\n" +
                "        <td><input type=\"text\" name=\"name\" value=\"" + contact.getName() + "\"/></td>\n" +
                "    </tr>\n");

        if (contact.getGender().equals("男")) {
            builder.append("    <tr>\n" +
            "        <th>性别</th>\n" +
            "        <td>\n" +
            "            <input type=\"radio\" name=\"gender\" value=\"男\" checked=\"checked\"/>男\n" +
            "            <input type=\"radio\" name=\"gender\" value=\"女\"/>女\n" +
            "        </td>\n" +
            "    </tr>\n" +
            "    <tr>\n");
        } else {
            builder.append("    <tr>\n" +
                    "        <th>性别</th>\n" +
                    "        <td>\n" +
                    "            <input type=\"radio\" name=\"gender\" value=\"男\" />男\n" +
                    "            <input type=\"radio\" name=\"gender\" value=\"女\" checked=\"checked\"/>女\n" +
                    "        </td>\n" +
                    "    </tr>\n" +
                    "    <tr>\n");
        }

        builder.append("        <th>年龄</th>\n" +
                "        <td><input type=\"text\" name=\"age\" value=\"" + contact.getAge() + "\"/></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <th>QQ</th>\n" +
                "        <td><input type=\"text\" name=\"qq\" value=\"" + contact.getQq() + "\" ></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <th>邮箱</th>\n" +
                "        <td><input type=\"text\" name=\"email\" value=\"" + contact.getEmail() + "\" /></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <th>手机</th>\n" +
                "        <td><input type=\"text\" name=\"phone\" value=\"" + contact.getPhone() + "\" /></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td colspan=\"2\" align=\"center\">\n" +
                "            <input type=\"submit\" value=\"保存\"/>&nbsp;\n" +
                "            <input type=\"reset\" value=\"重置\"/>\n" +
                "        </td>\n" +
                "    </tr>");
        builder.append("</form>\n" +
                "</body>\n" +
                "</html>");

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(builder.toString());
    }
}
