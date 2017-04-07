package com.vbirds.web.servlet;

import com.vbirds.web.dao.ProductDao;
import com.vbirds.web.entity.Product;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vbirds on 17-4-6.
 */
@javax.servlet.annotation.WebServlet(name = "ProductServlet")
public class ProductServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        ProductDao dao = new ProductDao();
        HashMap<String, Product> products = dao.findAll();

        //组包
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<head>");
        builder.append("<link rel=\"stylesheet\" href=\"http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css\">");
        builder.append("<script src=\"http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js\"></script>");
        builder.append("<script src=\"http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
        builder.append("</head>");

        builder.append("<body>");
        builder.append("<table class=\"table table-hover\" width=\"300px\">");
        builder.append("<tr><th>编号</th><th>名称</th><th>类型</th><th>价格</th></tr>");
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            Product product = entry.getValue();
            builder.append("<tr>");
            builder.append("<td>" + product.getId() + "</td>");
            builder.append("<td><a href='/03-shop/DetailProduct?id=" + product.getId() +"'>"
                            + product.getName() + "</a>" + "</td>");
            builder.append("<td>" + product.getProType() + "</td>");
            builder.append("<td>" + product.getPrice() + "</td>");
            builder.append("</tr>");
        }
        builder.append("</table>");

        builder.append("</body>");
        builder.append("</html>");

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(builder.toString());
    }
}
