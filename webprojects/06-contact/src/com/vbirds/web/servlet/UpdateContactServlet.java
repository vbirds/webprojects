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
@WebServlet(name = "UpdateContactServlet")
public class UpdateContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactDao dao = new ContactDaoImpl();
        Contact contact = dao.findById(request.getParameter("id"));
        if (contact != null) {

            dao.modify(new Contact(request.getParameter("id"),
                    request.getParameter("name"),
                    request.getParameter("gender"),
                    request.getParameter("age"),
                    request.getParameter("qq"),
                    request.getParameter("phone"),
                    request.getParameter("email")));
            dao.updateContact();
        }

        response.sendRedirect(request.getContextPath() + "/06-contact/ListContactServlet");
    }
}
