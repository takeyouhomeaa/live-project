//查询用户是否中签，方法输入为预约编号，返回一个购买凭证类buyProve无则null

package domain;

import dao.YesDao;
import dao.YesDaoImp;
import model.buyProve;

public class serchOrder {
	public serchOrder(){
		
	}
	public static Yes serch_(String orderId) {
		//连接数据库查询，返回buyProve
		YesDao yesDao=new YesDaoImp();
		Yes buy1=yesDao.getByOrderId("Yes1", orderId);
		Yes buy2=yesDao.getByOrderId("Yes2", orderId);
		Yes buy3=yesDao.getByOrderId("Yes3", orderId);
		if(buy1==null)
		buy1=buy2;
		if(buy1==null)
		buy1=buy3;
		return buy3;
	}

}
