package dao;

import java.awt.List;
import java.sql.Date;

import domain.OrderData;

public interface OrderDataDao {
	void add(Date start,Date end,int sum);
	void updateStart(Date startDate);
	void updateEnd(Date endDate);
	void updateSum(int sum);
	void updateAll(Date start,Date end,int sum);
	OrderData find();
}
