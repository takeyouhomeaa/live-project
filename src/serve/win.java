package serve;


import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import domain.Order;
import domain.OrderData;
import domain.Yes;
import dao.*;

public class win {
	
	//只抽取预约口罩数量的三分之一的人数（无论这三分之一人是否把口罩均分配光，剩余的可下次抽取)
	//如果预约人数少于口罩数量的三分之一则每个人都可以分配到口罩
	public static void getRandom(HttpServletRequest request,HttpServletResponse response) {
		OrderDataDao orderData = new OrderDataDaoImp();
		OrderData data = orderData.find();
		int sum = data.getSum();//获取设置的口罩个数
		int count = sum/3;//每个人都购买三个，且预约人数超过设定口罩个数的三倍
		HashSet<Order> set = new HashSet<Order>();
		OrderDao orderDao = new OrderDaoImp();
		List<Order> list = orderDao.list();

		if(list.size()<count)//如果预约人数少于口罩数量的三分之一则每个人都可以分配到购买资格
		{
			count=list.size();
			for(int j=0;j<count;j++)
			{
				//int n =(int)(Math.random())*list.size();
				set.add(list.get(j));
			}
		}
		else {
			for(int j=0;j<count;j++)
			{
				int n =(int)(Math.random())*list.size();
				set.add(list.get(n));
			}
		}
		savedTimes(request, response);
		int time = getTimes(request);//获取第几次预约
		Iterator<Order> it = set.iterator();
		switch (time) {
			case 1:
			{
				String tableName = "Yes1";
				for(;it.hasNext();)
				{
					Order order = it.next();
					String id=order.getId();
					String orderid = order.getOrderid();
					String name = order.getName();
					Integer num = order.getNum();
					YesDao yesDao = new YesDaoImp();
					Yes yes = new Yes();
					yes.setId(id);
					yes.setName(name);
					yes.setNum(num);
					yes.setComfired(1);
					yes.setOrderid(orderid);
					yesDao.add(tableName, yes);
				}
				break;
			}
			case 2:
			{
				String tableName = "Yes2";
				for(;it.hasNext();)
				{
					Order order = it.next();
					String id=order.getId();
					String orderid = order.getOrderid();
					String name = order.getName();
					Integer num = order.getNum();
					YesDao yesDao = new YesDaoImp();
					Yes yes = new Yes();
					yes.setId(id);
					yes.setName(name);
					yes.setNum(num);
					yes.setComfired(1);
					yes.setOrderid(orderid);
					yesDao.add(tableName, yes);
				}
				break;
			}
			case 3:
			{
				String tableName = "Yes3";
				for(;it.hasNext();)
				{
					Order order = it.next();
					String id=order.getId();
					String orderid = order.getOrderid();
					String name = order.getName();
					Integer num = order.getNum();
					YesDao yesDao = new YesDaoImp();
					Yes yes = new Yes();
					yes.setId(id);
					yes.setName(name);
					yes.setNum(num);
					yes.setComfired(1);
					yes.setOrderid(orderid);
					yesDao.add(tableName, yes);
				}
				break;
			}
			default://超过第三次开启预约活动，则将抽到的人存入 第：次数%3张 yes表
			{
				int i =time%3;
				String tableName = "Yes"+String.valueOf(i);
				YesDao yesDao = new YesDaoImp();
				yesDao.deleteTable(tableName);//清空某张yes表格
				for(;it.hasNext();)
				{
					Order order = it.next();
					String id=order.getId();
					String orderid = order.getOrderid();
					String name = order.getName();
					Integer num = order.getNum();
					YesDao yesDao1 = new YesDaoImp();
					Yes yes = new Yes();
					yes.setId(id);
					yes.setName(name);
					yes.setNum(num);
					yes.setComfired(1);
					yes.setOrderid(orderid);
					yesDao1.add(tableName, yes);
				}
				break;
			}
		}
	}
	
	public static void savedTimes(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        Object times = session.getAttribute("times");
        if(times == null){
            Integer times1 = 1;
            session.setAttribute("times",times1);
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(2592000);
            response.addCookie(cookie);
            session.setMaxInactiveInterval(-1);
        }else {
            Integer times1 = (Integer) times + 1;
            session.setAttribute("times",times1);
        }
    }
    public static  Integer getTimes(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object times = session.getAttribute("times");
        Integer rs = (Integer)times;
        return rs;
    }
}
