package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LogOut extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("account");
        Cookie cookie1 = new Cookie("account", null);
        Cookie cookie2 = new Cookie("password", null);
        cookie1.setMaxAge(0);
        cookie2.setMaxAge(0);
        cookie1.setPath("/test");
        cookie2.setPath("/test");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        PrintWriter out = response.getWriter();
        response.setHeader("refresh", "3,/test/signin.jsp");
        out.print("<p>注销成功</p>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
