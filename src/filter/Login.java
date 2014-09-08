package filter;

import main.DAOProxy;
import vo.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Login implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        if (request.getSession().getAttribute("account") != null) {
            chain.doFilter(req, resp);
        }

        RequestDispatcher rd;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            Map<String, String> map = new HashMap<String, String>();
            for (Cookie cookie : cookies) {
                map.put(cookie.getName(), cookie.getValue());
            }

            if (map.containsKey("account")) {
                String cookieAccount = map.get("account");
                String cookiePassword = map.get("password");
                User user = new User();
                user.setAccount(cookieAccount);
                user.setPassword(cookiePassword);

                try {
                    if (!new DAOProxy<User>(user).find().isEmpty()) {
                        request.getSession().setAttribute("account", cookieAccount);
                        rd = request.getRequestDispatcher("main.jsp");
                        rd.forward(req, resp);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        rd = request.getRequestDispatcher("signin.jsp");
        rd.forward(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
