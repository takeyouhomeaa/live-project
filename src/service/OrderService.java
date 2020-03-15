package service;

import dao.OrderDaoImp;
import dao.OrderDataDaoImp;
import domain.Order;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderService {

        OrderDaoImp orderDaoImp = new OrderDaoImp();
        public boolean determineIfIdentityIsDuplicated(String id,String phone){
            Order order = orderDaoImp.get(id);
            Order byPhone = orderDaoImp.getByPhone(phone);
            if(order.getId() == null && byPhone.getPhone() == null){
                return true;
            }
            return false;
        }
}
