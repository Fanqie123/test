package form;

import main.DAOProxy;
import org.apache.struts.action.*;
import vo.Room;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by test on 2014/9/5.
 */
public class RoomOrderForm extends ActionForm {
    private String room_no;
    private String start_date;
    private String end_date;

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Room room = new Room();
        room.setRoom_no(room_no);
        try {
            if (room_no == null || "".equals(room_no)||new DAOProxy<Room>(room).find().size()==0) {
                errors.add("room_no_error",new ActionMessage("error.room_no"));
                return errors;
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
        if(start_date==null||end_date==null||"".equals(start_date)||"".equals(end_date)){
            errors.add("date_error",new ActionMessage("error.date"));
        }
        try {
            format.parse(start_date);
            format.parse(end_date);
        } catch (ParseException e) {
            errors.add("date_error",new ActionMessage("error.date"));
        }
        return errors;
    }
}
