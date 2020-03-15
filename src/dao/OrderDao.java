package dao;

import domain.Order;
import domain.Yes;

import java.util.List;

public interface OrderDao {
    int getTotal();
    void add(Order order);
    void update(Order order);
    void delete(String id) ;
    List<Order> list();
    Order get(String id);
}
