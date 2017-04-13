package com.vbirds.web.servlet;

import com.vbirds.web.dao.ContactDao;
import com.vbirds.web.entity.Contact;
import com.vbirds.web.dao.impl.ContactDaoImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by vbirds on 17-4-12.
 */
@javax.servlet.annotation.WebServlet(name = "ListContactServlet")
public class ListContactServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        ContactDao dao = new ContactDaoImpl();
        List<Contact> list = dao.findAll();

        //保存到域对象
        request.setAttribute("contactList", list);
        System.out.println("list_size:" + list.size());
        //
        request.getRequestDispatcher("/listcontact.jsp").forward(request, response);
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter writer = response.getWriter();
//
//        StringBuilder builder = new StringBuilder();
//        builder.append("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>");
//        builder.append("<html xmlns='http://www.w3.org/1999/xhtml'>");
//        builder.append("<head>");
//        builder.append("<meta charset=\"UTF-8\">\n" +
//                "    <title>查询所有联系人</title>");
//        builder.append("    <link rel=\"stylesheet\" href=\"http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css\">\n" +
//                "    <script src=\"http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js\"></script>\n" +
//                "    <script src=\"http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
//        builder.append("</head>");
//        builder.append("<body>");
//        builder.append("<table  class=\"table table-hover\">");
//        builder.append(" <tr>\n" +
//                "            <th>编号</th>\n" +
//                "            <th>姓名</th>\n" +
//                "            <th>性别</th>\n" +
//                "            <th>年龄</th>\n" +
//                "            <th>电话</th>\n" +
//                "            <th>邮箱</th>\n" +
//                "            <th>QQ</th>\n" +
//                "            <th>操作</th>\n" +
//                "        </tr>");
//        for (Contact contact : list) {
//            builder.append(" <tr>\n" +
//                    "            <td>" + contact.getId()    + "</td>\n" +
//                    "            <td>" + contact.getName()  + "</td>\n" +
//                    "            <td>" + contact.getGender()+ "</td>\n" +
//                    "            <td>" + contact.getAge()   + "</td>\n" +
//                    "            <td>" + contact.getPhone() + "</td>\n" +
//                    "            <td>" + contact.getEmail() + "</td>\n" +
//                    "            <td>" + contact.getQq()    + "</td>\n" +
//                    "            <td><a href='"+ request.getContextPath()+ "/06-contact/QueryContactServlet?id="+contact.getId()+"'>修改</a>&nbsp;<a href='" + request.getContextPath()+ "/06-contact/DeleteContactServlet?id=" + contact.getId()+ "'>删除</a></td>\n" +
//                    "        </tr>");
//        }
//        builder.append("</body>\n" +
//                "</html>");
//
//        writer.write(builder.toString());

    }
}

