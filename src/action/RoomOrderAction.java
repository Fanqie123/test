package action;

import form.RoomOrderForm;
import main.DAOProxy;
import org.apache.struts.action.*;
import vo.OrderList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**预定房间action
 * Created by test on 2014/9/5.
 */
public class RoomOrderAction extends Action{
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        RoomOrderForm roomOrderForm = (RoomOrderForm) form;
        String room_no = roomOrderForm.getRoom_no();
        String account = (String) request.getSession().getAttribute("account");
        String start_date = roomOrderForm.getStart_date();
        String end_date = roomOrderForm.getEnd_date();
        String order_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        OrderList order = new OrderList(room_no, account, start_date, end_date, order_date);
        try {
            if (new DAOProxy<OrderList>(order).createOrder()) {
                request.setAttribute("info","预定成功");
                System.out.print("预定成功");
            } else {
                request.setAttribute("info","预定失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mapping.findForward("main");
    }
}
