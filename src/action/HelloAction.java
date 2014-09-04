package action;

import form.HelloForm;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**123123
 * Created by test on 2014/8/16.
 */
public class HelloAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        HelloForm helloForm = (HelloForm) form;
        String info = helloForm.getInfo();
        request.setAttribute("msg", info);
        return mapping.findForward("show");
    }
}
