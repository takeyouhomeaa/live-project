package servlet;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dao.OrderDao;
import dao.OrderDaoImp;
import dao.YesDao;
import dao.YesDaoImp;
import domain.Order;
import domain.Yes;
import util.*;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name =request.getParameter("name");
		String ID =request.getParameter("ID");
		String phone = request.getParameter("phone");
		String number = request.getParameter("number");
		String uuid = UUID.randomUUID().toString().replaceAll("-","");
		OrderDao orderDao = new OrderDaoImp();
		YesDao yesDao = new YesDaoImp();
		List<Yes> lists= new ArrayList<Yes>();
		lists.add(yesDao.get("yes1", ID));
		lists.add(yesDao.get("yes1", ID));
		lists.add(yesDao.get("yes3", ID));
		try {
			if(IDCardValidate(ID))
			{
				if(phoneValidate(phone))
				{
					if(isWin(lists))
					{

						Order order = new Order();
						order.setName(name);
						order.setId(ID);
						order.setPhone(phone);
						order.setNum(Integer.parseInt(number));
						order.setOrderid(uuid);
						if(orderDao.add(order))
						{
							//预定成功
						}
						else {
							//预定失败，主键：身份证号码跟电话号码，插入失败着证明预约过了
						}
					}
					else {
						//前三次预约抽取成功
					}
				}
				else {
					//电话号码错误
				}
			}
			else {
				//身份证错误
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public boolean phoneValidate(String phone) {
		if(phone.length()!=11)
		{
			return false;
		}
		return true;
		
	}
	public boolean isWin(List<Yes> lists)
	{
		for(Yes yes:lists)
		{
			if(yes.getComfired()==1)
			{
				return false;
			}
		}
		return true;
	}
	public static boolean IDCardValidate(String IDStr) throws ParseException {          
        String Ai = "";  
        // 判断号码的长度 15位或18位  
        if (IDStr.length() != 15 && IDStr.length() != 18) {  
            return false;  
        }  
          
  
        // 18位身份证前17位位数字，如果是15位的身份证则所有号码都为数字  
        if (IDStr.length() == 18) {  
            Ai = IDStr.substring(0, 17);  
        } else if (IDStr.length() == 15) {  
            Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);  
        }  
        if (isNumeric(Ai) == false) {  
            return false;  
        }  
          
  
        // 判断出生年月是否有效   
        String strYear = Ai.substring(6, 10);// 年份  
        String strMonth = Ai.substring(10, 12);// 月份  
        String strDay = Ai.substring(12, 14);// 日期  
        if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {  
            return false;  
        }  
        GregorianCalendar gc = new GregorianCalendar();  
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");  
        try {  
            if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150  
                    || (gc.getTime().getTime() - s.parse(  
                            strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {  
                return false;  
            }  
        } catch (NumberFormatException e) {  
            e.printStackTrace();  
        } catch (java.text.ParseException e) {  
            e.printStackTrace();  
        }  
        if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {  
            return false;  
        }  
        if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {  
            return false;  
        }  
          
  
        // 判断地区码是否有效   
        Hashtable areacode = GetAreaCode();  
        //如果身份证前两位的地区码不在Hashtable，则地区码有误  
        if (areacode.get(Ai.substring(0, 2)) == null) {  
            return false;  
        }  
          
        if(isVarifyCode(Ai,IDStr)==false){  
            return false;  
        }  
         
          
        return true;  
    }  
      
      
     /* 
      * 判断第18位校验码是否正确 
     * 第18位校验码的计算方式：  
        　　1. 对前17位数字本体码加权求和  
        　　公式为：S = Sum(Ai * Wi), i = 0, ... , 16  
        　　其中Ai表示第i个位置上的身份证号码数字值，Wi表示第i位置上的加权因子，其各位对应的值依次为： 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2  
        　　2. 用11对计算结果取模  
        　　Y = mod(S, 11)  
        　　3. 根据模的值得到对应的校验码  
        　　对应关系为：  
        　　 Y值：     0  1  2  3  4  5  6  7  8  9  10  
        　　校验码： 1  0  X  9  8  7  6  5  4  3   2 
     */  
    private static boolean isVarifyCode(String Ai,String IDStr) {  
         String[] VarifyCode = { "1", "0", "X", "9", "8", "7", "6", "5", "4","3", "2" };  
         String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7","9", "10", "5", "8", "4", "2" };  
         int sum = 0;  
         for (int i = 0; i < 17; i++) {  
            sum = sum + Integer.parseInt(String.valueOf(Ai.charAt(i))) * Integer.parseInt(Wi[i]);  
         }  
         int modValue = sum % 11;  
         String strVerifyCode = VarifyCode[modValue];  
         Ai = Ai + strVerifyCode;  
         if (IDStr.length() == 18) {  
             if (Ai.equals(IDStr) == false) {  
                 return false;  
                  
             }  
         }   
         return true;  
    }  
      
  
    /** 
     * 将所有地址编码保存在一个Hashtable中     
     * @return Hashtable 对象 
     */  
     
    private static Hashtable<String, String> GetAreaCode() {  
        Hashtable<String, String> hashtable = new Hashtable<String, String>();  
        hashtable.put("11", "北京");  
        hashtable.put("12", "天津");  
        hashtable.put("13", "河北");  
        hashtable.put("14", "山西");  
        hashtable.put("15", "内蒙古");  
        hashtable.put("21", "辽宁");  
        hashtable.put("22", "吉林");  
        hashtable.put("23", "黑龙江");  
        hashtable.put("31", "上海");  
        hashtable.put("32", "江苏");  
        hashtable.put("33", "浙江");  
        hashtable.put("34", "安徽");  
        hashtable.put("35", "福建");  
        hashtable.put("36", "江西");  
        hashtable.put("37", "山东");  
        hashtable.put("41", "河南");  
        hashtable.put("42", "湖北");  
        hashtable.put("43", "湖南");  
        hashtable.put("44", "广东");  
        hashtable.put("45", "广西");  
        hashtable.put("46", "海南");  
        hashtable.put("50", "重庆");  
        hashtable.put("51", "四川");  
        hashtable.put("52", "贵州");  
        hashtable.put("53", "云南");  
        hashtable.put("54", "西藏");  
        hashtable.put("61", "陕西");  
        hashtable.put("62", "甘肃");  
        hashtable.put("63", "青海");  
        hashtable.put("64", "宁夏");  
        hashtable.put("65", "新疆");  
        hashtable.put("71", "台湾");  
        hashtable.put("81", "香港");  
        hashtable.put("82", "澳门");  
        hashtable.put("91", "国外");  
        return hashtable;  
    }  
  
    /** 
     * 判断字符串是否为数字,0-9重复0次或者多次    
     * @param strnum 
     * @return 
     */  
    private static boolean isNumeric(String strnum) {  
        Pattern pattern = Pattern.compile("[0-9]*");  
        Matcher isNum = pattern.matcher(strnum);  
        if (isNum.matches()) {  
            return true;  
        } else {  
            return false;  
        }  
    }  
  
    /** 
     * 功能：判断字符串出生日期是否符合正则表达式：包括年月日，闰年、平年和每月31天、30天和闰月的28天或者29天 
     *  
     * @param string 
     * @return 
     */  
    public static boolean isDate(String strDate) {  
      
        Pattern pattern = Pattern  
                .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))?$");  
        Matcher m = pattern.matcher(strDate);  
        if (m.matches()) {  
            return true;  
        } else {  
            return false;  
        }  
    }

}
