package dao;

import domain.Order;
import domain.Yes;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImp implements OrderDao {
    @Override
    public int getTotal() {
        int count = -1;
        String sql = "SELECT COUNT(*) FROM `order`";
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                count = resultSet.getInt(1);
            }
            DBUtil.close(resultSet,preparedStatement,connection);
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public boolean add(Order order) {
        //int count = -1;
        boolean flat=false;
        String sql = "INSERT INTO `order`(name,num,id,phone,orderid) VALUES(?,?,?,?,?);";
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,order.getName());
            preparedStatement.setInt(2,order.getNum());
            preparedStatement.setString(3,order.getId());
            preparedStatement.setString(4,order.getPhone());
            preparedStatement.setString(5,order.getOrderid());
            System.out.println(sql);
            flat=preparedStatement.execute();
            DBUtil.close(null,preparedStatement,connection);
            return flat;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void update(Order order) {
        Connection connection = null;
        String sql = "";
        if(order.getId() != null && order.getPhone() == null){
            sql = "UPDATE `order` SET name = ? WHERE id = ?";
            try {
                connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,order.getName());
                preparedStatement.setString(2,order.getId());
                preparedStatement.execute();
                DBUtil.close(null,preparedStatement,connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(order.getPhone() != null && order.getId() == null) {
            sql = "UPDATE `order` SET name = ? WHERE phone = ?";
            try {
                connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,order.getName());
                preparedStatement.setString(2,order.getPhone());
                preparedStatement.execute();
                DBUtil.close(null,preparedStatement,connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM `order` WHERE id = ?";
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.execute();
            DBUtil.close(null,preparedStatement,connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> list() {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM `order`";
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                Integer num = resultSet.getInt("num");
                String id = resultSet.getString("id");
                String phone = resultSet.getString("phone");
                String orderid = resultSet.getString("orderid");
                list.add(new Order(name,num,id,phone,orderid));
            }
            DBUtil.close(null,preparedStatement,connection);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Order get(String id) {
        Order order = new Order();
        String sql = "SELECT * FROM `order` WHERE id = ?";
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                Integer num = resultSet.getInt("num");
                String id1 = resultSet.getString("id");
                String phone = resultSet.getString("phone");
                order.setName(name);
                order.setNum(num);
                order.setId(id1);
                order.setPhone(phone);
            }
            DBUtil.close(null,preparedStatement,connection);
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Order getByPhone(String phone) {
        Order order = new Order();
        String sql = "SELECT * FROM `order` WHERE phone = ?";
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                Integer num = resultSet.getInt("num");
                String id1 = resultSet.getString("id");
                String phone1 = resultSet.getString("phone");
                order.setName(name);
                order.setNum(num);
                order.setId(id1);
                order.setPhone(phone1);
            }
            DBUtil.close(null,preparedStatement,connection);
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
