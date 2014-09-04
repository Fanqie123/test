package action;

import form.SignUpForm;
import main.DAOProxy;
import org.apache.struts.action.*;
import vo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.security.MessageDigest;

/**注册
 * Created by test on 2014/9/2.
 */
public class SignUpAction extends Action{
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        SignUpForm signUpForm = (SignUpForm) form;
        User user = new User(signUpForm);
        try {
            if (! new DAOProxy<User>(user).find().isEmpty()) {
                request.setAttribute("error","exist_account");
                return mapping.findForward("signin");
            }

            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(user.getPassword().getBytes());
            user.setPassword(new BigInteger(md5.digest()).toString(16).substring(0,32));

            if (new DAOProxy<User>(user).create()) {
                request.setAttribute("info","注册成功，请登录");
                return mapping.findForward("signin");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("info","注册失败");
        return mapping.findForward("signin");

    }
}
