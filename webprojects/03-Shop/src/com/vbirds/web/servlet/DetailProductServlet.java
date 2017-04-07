package com.vbirds.web.servlet;

import com.vbirds.web.dao.ProductDao;
import com.vbirds.web.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by vbirds on 17-4-6.
 */
@WebServlet(name = "DetailProduct")
public class DetailProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao dao = new ProductDao();

        String id = request.getParameter("id");
        if (id != null) {
            Product product = dao.findById(id);
            if (product == null) {
                return;
            }
            StringBuilder builder = new StringBuilder();
            builder.append("<html>");
            builder.append("<head>");
            builder.append("<link rel=\"stylesheet\" href=\"http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css\">");
            builder.append("<script src=\"http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js\"></script>");
            builder.append("<script src=\"http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
            builder.append("</head>");

            builder.append("<body>");
            builder.append("<table class=\"table table-hover\" width=\"300px\">");
                builder.append("<tr><th>编号</th><td>" + product.getId() + "</td></tr>");
                builder.append("<tr><th>名称</th><td>" + product.getName() + "</td></tr>");
                builder.append("<tr><th>类型</th><td>" + product.getProType() + "</td></tr>");
                builder.append("<tr><th>价格</th><td>" + product.getPrice() + "</td></tr>");
            builder.append("</table>");
            builder.append("<center><a href='"+ request.getContextPath() +
                "/03-shop/Product\'>返回列表</a></center>");

            /*
             * 显示浏览过的商品
             */
            builder.append("<br />最近浏览过的商品:<br />");
            Cookie[] cookies =  request.getCookies();
            if (cookies != null) {
                for (Cookie ck : cookies) {
                    if (ck.getName().equals("proHistry")) {
                        String productId = ck.getValue();
                        String[] ids = productId.split("#");
                        builder.append("<table class=\"table table-hover\" width=\"300px\">");
                        for (String pid : ids) {
                            Product pd = dao.findById(pid);
                            builder.append("<tr><th>编号</th><td>" + pd.getId() + "</td></tr>");
                            builder.append("<tr><th>名称</th><td>" + pd.getName() + "</td></tr>");
                            builder.append("<tr><th>类型</th><td>" + pd.getProType() + "</td></tr>");
                            builder.append("<tr><th>价格</th><td>" + pd.getPrice() + "</td></tr>");
                        }
                        builder.append("</table>");
                    }
                }
            }

            builder.append("</body>");
            builder.append("</html>");

            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(builder.toString());

            Cookie ck = new Cookie("proHistry", createIds(request, id));
            ck.setMaxAge(3600);
            response.addCookie(ck);

            builder = null;
            cookies = null;
            dao = null;
        }
    }

    private String createIds(HttpServletRequest request, String id) {
        Cookie[] cookies =  request.getCookies();
        String prodHist = null;
        if (cookies != null) {
            for (Cookie ck : cookies) {
                if (ck.getName().equals("proHistry")) {
                    prodHist = ck.getValue();
                    break;
                }
            }
        }
        // null or prodHist = null
        if (cookies == null || prodHist == null) {
            return id;
        }
        String[] ids = prodHist.split("#");
        Collection<String> collection = Arrays.asList(ids);
        LinkedList list = new LinkedList(collection);

        if (list.size() < 3) {
            if (list.contains(id)) {
                list.remove(id);
            }
            list.addFirst(id);
        } else {
            if (list.contains(id)) {
                list.remove(id);
            } else {
                list.removeLast();
            }
            list.addFirst(id);
        }

        StringBuffer buffer = new StringBuffer();
        for (Object object : list) {
            buffer.append(object+"#");
        }


        String result = buffer.toString();
        result = result.substring(0, result.length()-1);

        buffer      = null;
        collection  = null;
        cookies     = null;
        list        = null;
        ids         = null;
        System.out.println(result);
        return result;
    }
}
