package form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**注册表单
 * Created by test on 2014/9/2.
 */
public class SignUpForm extends ActionForm{
    private String account;
    private String id;
    private String password;
    private String name;
    private String sex;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        Pattern pat = Pattern.compile("^[a-zA-Z0-9-_]{5,9}$");
        ActionErrors errors = new ActionErrors();
        if(this.account==null||"".equals(this.account)||!pat.matcher(this.account).find()){
            errors.add("account_error",new ActionMessage("error.account"));
        }
        if(this.password==null||"".equals(this.password)||!pat.matcher(this.password).find()){
            errors.add("password_error",new ActionMessage("error.password"));
        }
        pat=Pattern.compile("^[\\u4e00-\\u9fa5]{2,5}$");
        if (this.name == null || "".equals(this.name) || !pat.matcher(this.name).find()) {
            errors.add("name_error",new ActionMessage("error.name"));
        }
        pat=Pattern.compile("^[0-9]{17}[X0-9]$");
        if (this.id == null || "".equals((this.id)) || !pat.matcher(this.id).find()) {
            errors.add("id_error",new ActionMessage("error.id"));
        }
        pat = Pattern.compile("^[男女]$");
        if (this.sex == null || "".equals(this.sex) || !pat.matcher(this.sex).find()) {
            errors.add("sex_error", new ActionMessage("error.sex"));
        }
        return errors;
    }
}
