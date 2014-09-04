package vo;

/**
 * 123
 * Created by test on 2014/7/26.
 */
public class Room {
    private String room_no;
    private String room_type;
    private Integer room_price;
    private String room_info;

    public Room(){}

    public Room(String room_no, String room_type, Integer room_price, String room_info) {
        this.room_no = room_no;
        this.room_type = room_type;
        this.room_price = room_price;
        this.room_info = room_info;
    }

    public String getRoom_info() {
        return room_info;
    }

    public void setRoom_info(String room_info) {
        this.room_info = room_info;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public int getRoom_price() {
        return room_price;
    }

    public void setRoom_price(int room_price) {
        this.room_price = room_price;
    }
}
