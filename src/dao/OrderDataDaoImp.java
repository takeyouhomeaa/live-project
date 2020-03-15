package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import util.DBUtil;
import domain.OrderData;;

public class OrderDataDaoImp implements OrderDataDao{

	@Override
	public void add(Date start, Date end, int sum) {
		// TODO Auto-generated method stub
		String sql = "insert into `orderdata` (start,end,sum) values ("+start+","+end+","+sum+")";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			DBUtil.close(null,stmt,conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateStart(Date startDate) {
		// TODO Auto-generated method stub
		String sql = "update `orderdata` set start="+startDate+"where id=1";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			DBUtil.close(null,stmt,conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateEnd(Date endDate) {
		// TODO Auto-generated method stub
		String sql = "update `orderdata` set end="+endDate+"where id=1";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			DBUtil.close(null,stmt,conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateSum(int sum) {
		// TODO Auto-generated method stub
		String sql = "update `orderdata` set sum="+sum+"where id=1";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			DBUtil.close(null,stmt,conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateAll(Date start, Date end, int sum) {
		// TODO Auto-generated method stub
		String sql = "update `orderdata` set start="+start+",end="+end+",sum="+sum+"where id=1";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			DBUtil.close(null,stmt,conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public OrderData find() {
		// TODO Auto-generated method stub
		String sql = "select * from orderdata";
		OrderData orderdata = new OrderData() ;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
	            ResultSet resultSet = stmt.executeQuery();
	            while (resultSet.next()){
	                String start = resultSet.getString("start");
	                String end = resultSet.getString("end");
	                Integer sum = resultSet.getInt("sum");
	                
	                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	                Date startTime = null;
	                Date endTimeDate = null;
	                try {
	                    startTime = (Date) simpleDateFormat.parse(start);
	                    endTimeDate =(Date) simpleDateFormat.parse(end);
	                } catch (ParseException e) {
	                    e.printStackTrace();
	                }
	                orderdata.setStart(startTime);
	                orderdata.setEnd(startTime);
	                orderdata.setSum(sum);
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderdata;
	}

}
