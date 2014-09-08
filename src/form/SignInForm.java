package form;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**登录actionForm
 * Created by test on 2014/8/31.
 */
public class SignInForm extends ActionForm{
    private String account;
    private String password;
    private String[] rememberMe;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(String[] rememberMe) {
        this.rememberMe = rememberMe;
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        Pattern pat = Pattern.compile("^[a-zA-Z0-9-_]{5,9}$");
        ActionErrors errors = new ActionErrors();
        if(this.account==null||"".equals(this.account)||!pat.matcher(account).find()){
            errors.add("account_error",new ActionMessage("error.account"));
        }
        if(this.password==null||"".equals(this.password)||!pat.matcher(password).find()){
            errors.add("password_error",new ActionMessage("error.password"));
        }
        return errors;
    }
}
