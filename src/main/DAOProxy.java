package main;

import vo.OrderList;
import vo.Room;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * bli
 * Created by test on 2014/8/22.
 */
public class DAOProxy<E> {
    E e;
    private Conn conn = null;
    private DAOImpl dao = null;
    @SuppressWarnings("unchecked")
    public static ConcurrentHashMap<String, Lock> map = getMap();

    public DAOProxy(E e) throws SQLException, ClassNotFoundException {
        this.e = e;
        this.conn = new Conn();
        dao = new DAOImpl<E>(e, this.conn.getConnection());
    }

    @SuppressWarnings("unchecked")
    public static ConcurrentHashMap getMap() {
        ConcurrentHashMap<String, Lock> map = new ConcurrentHashMap<String, Lock>();
        DAOProxy<Room> daoProxy;
        try {
            daoProxy = new DAOProxy<Room>(new Room());
            List<Room> list = daoProxy.findAll();
            for (Room room : list) {
                ReentrantLock lock = new ReentrantLock();
                map.put(room.getRoom_no(), lock);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
        return map;
    }


    public List findAll() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        List list = dao.findAll();
        conn.close();
        return list;
    }

    public List find() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        List list = dao.find();
        conn.close();
        return list;
    }

    public boolean create() throws IllegalAccessException, SQLException, ClassNotFoundException {
        boolean bool = dao.create();
        conn.close();
        return bool;
    }

    public boolean remove() throws IllegalAccessException, SQLException, ClassNotFoundException {
        boolean bool = dao.remove();
        conn.close();
        return bool;
    }

    @SuppressWarnings("unchecked")
    public List<Room> findRoom(String start_date, String end_date) throws SQLException {
        List list;
        list = dao.findRoom(start_date, end_date);
        conn.close();
        return list;
    }

    public boolean createOrder() throws SQLException, IllegalAccessException, ClassNotFoundException {
        Lock lock = map.get(((OrderList) e).getRoom_no());
        if (lock == null) {
            return false;
        }
        boolean bool;
        lock.lock();
        try {
            if (dao.checkOrder())
                return false;
            bool = dao.create();
        } finally {
            lock.unlock();
            conn.close();
        }
        return bool;
    }

    public boolean updateUser() throws SQLException {
        boolean bool = dao.updateUser();
        conn.close();
        return bool;
    }

}
