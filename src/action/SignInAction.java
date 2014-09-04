package action;

import form.SignInForm;
import main.DAOProxy;
import org.apache.struts.action.*;
import vo.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
/**1
 * Created by test on 2014/8/31.
 */
public class SignInAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        SignInForm signInForm=(SignInForm)form;
        User user = new User();
        String account = signInForm.getAccount();
        String password = signInForm.getPassword();
        String[] rememberMe = signInForm.getRememberMe();

        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return mapping.findForward("signin");
        }
        md5.reset();
        md5.update(password.getBytes());
        String md5Password = new BigInteger(md5.digest()).toString(16);
        user.setAccount(account);
        user.setPassword(md5Password);

        try {
            if (!new DAOProxy<User>(user).find().isEmpty()) {
                if (rememberMe != null) {
                    Cookie cookie1 = new Cookie("account", account);
                    Cookie cookie2 = new Cookie("password", md5Password);
                    cookie1.setMaxAge(600);
                    cookie2.setMaxAge(600);
                    cookie1.setHttpOnly(true);
                    cookie2.setHttpOnly(true);
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);
                }
                request.getSession().setAttribute("account", account);
                return mapping.findForward("main");
            } else {
                request.setAttribute("info","账号密码错误");
                return mapping.findForward("signin");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return mapping.findForward("signin");
    }
}
