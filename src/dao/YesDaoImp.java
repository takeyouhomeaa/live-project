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

public class YesDaoImp implements YesDao{


    @Override
    public int getTotal(String table) {
        int count = -1;
        String sql = "SELECT COUNT(*) FROM `" + table +"`";
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
    public boolean add(String table, Yes yes) {
        int count = -1;
        String sql = "INSERT INTO `" + table + "`(orderid,id,name,num,comfired) VALUES(?,?,?,?,?);";
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,yes.getOrderid());
            preparedStatement.setString(2,yes.getId());
            preparedStatement.setString(3,yes.getName());
            preparedStatement.setInt(4,yes.getNum());
            preparedStatement.setInt(5,yes.getComfired());
            preparedStatement.execute();
            DBUtil.close(null,preparedStatement,connection);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void update(String table, Yes yes) {

    }

    @Override
    public void delete(String table, String id) {
        String sql = "DELETE FROM `"+ table+"` WHERE id = ?";
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
    public List<Yes> list(String table) {
        List<Yes> list = new ArrayList<>();
        String sql = "SELECT *  FROM `" + table+"`";
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String orderid = resultSet.getString("orderid");
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                Integer num = resultSet.getInt("num");
                Integer comfired = resultSet.getInt("comfired");
                list.add(new Yes(orderid,id,name,num,comfired));
            }
            DBUtil.close(null,preparedStatement,connection);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Yes get(String table, String id) {
        Yes yes = new Yes();
        String sql = "SELECT * FROM `" + table +"` WHERE id = ?";
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String orderid = resultSet.getString("orderid");
                String id1 = resultSet.getString("id");
                String name = resultSet.getString("name");
                Integer num = resultSet.getInt("num");
                Integer comfired = resultSet.getInt("comfired");
                yes.setName(name);
                yes.setNum(num);
                yes.setId(id1);
                yes.setOrderid(orderid);
                yes.setComfired(comfired);
            }
            DBUtil.close(null,preparedStatement,connection);
            return yes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Yes getByOrderId(String table, String orderId) {
        Yes yes = new Yes();
        String sql = "SELECT * FROM `" + table +"` WHERE orderid = ?";
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String orderid = resultSet.getString("orderid");
                String id1 = resultSet.getString("id");
                String name = resultSet.getString("name");
                Integer num = resultSet.getInt("num");
                Integer comfired = resultSet.getInt("comfired");
                yes.setName(name);
                yes.setNum(num);
                yes.setId(id1);
                yes.setOrderid(orderid);
                yes.setComfired(comfired);
            }
            DBUtil.close(null,preparedStatement,connection);
            return yes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

