package domain;

import java.util.Date;

public class OrderData {
	private Date start;
	private Date end;
	private int sum;
	
	public OrderData() {
		// TODO Auto-generated constructor stub
	}
	public OrderData(Date start,Date end,int sum)
	{
		this.start=start;
		this.end=end;
		this.sum=sum;
	}
	
	public void setStart(Date start)
	{
		this.start=start;
	}
	public Date getStart()
	{
		return start;
	}
	
	public void setEnd(Date end) {
		this.end=end;
	}
	public Date getEnd() {
		return end;
	}
	
	public void setSum(int sum) {
		this.sum=sum;
	}
	public int getSum() {
		return sum;
	}

	@Override
	public String toString() {
		return "OrderData{" +
				"start=" + start +
				", end=" + end +
				", sum=" + sum +
				'}';
	}
}
