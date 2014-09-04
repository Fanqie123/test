package main;

import vo.OrderList;
import vo.Room;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;


public class test {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException {



     try {
            int i=0;
            List<Room> list = new DAOProxy<Room>(new Room()).findAll();
            for (Room room : list) {
                i++;
                DAOProxy.map.put(room.getRoom_no(), new ReentrantLock());
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        OrderList orderList = new OrderList();
        orderList.setRoom_no("0001");
        orderList.setAccount("admin3");
        orderList.setStart_date("2014-8-26");
        orderList.setEnd_date("2014-8-26");
        orderList.setOrder_date("2014-8-26");
        ExecutorService service= Executors.newCachedThreadPool();
        for (int i=0; i < 10; i++) {
            service.execute(new Demo(orderList));
        }
        service.shutdown();

    }


}
class Demo extends Thread{
    private OrderList orderList;
    public Demo(OrderList orderList) {
        this.orderList = orderList;
    }
    public void run(){
        try {
            new DAOProxy<OrderList>(orderList).createOrder();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}


