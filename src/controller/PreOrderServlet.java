package controller;

import domain.Order;
import domain.OrderData;
import service.PreOrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet(urlPatterns = "/PreOrderServlet")
public class PreOrderServlet extends HttpServlet {
    PreOrderService preOrderService= new PreOrderService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderData time = preOrderService.getTime();
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        long hours = c.get(Calendar.HOUR_OF_DAY);
        long min = c.get(Calendar.MINUTE);
        long second = c.get(Calendar.SECOND);
        long temp = ( second + min * 60 + hours * 60 * 60 )*1000 + 1000;
        String s1 = df.format(date);
        try {
            long nowTime = df.parse(s1).getTime();
            Date start = time.getStart();
            String s2 = df.format(start);
            long time1 =start.getTime();
            long startTime = time1 - date.getTime() + temp;
            long endTime = time.getEnd().getTime();
            System.out.println(startTime);
            if(startTime >= 0 && date.getTime() < endTime){
                request.getSession().setAttribute("start", 1);
            }
            if(date.getTime() >= endTime){
                request.getSession().setAttribute("start", 0);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("order.jsp").forward(request,response);
    }
}
