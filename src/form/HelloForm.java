package form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

/**`12
 * Created by test on 2014/8/16.
 */
public class HelloForm extends ActionForm {
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors=new ActionErrors();
        errors.add("info",new ActionMessage("error.info"));
        return errors;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {

    }
}
