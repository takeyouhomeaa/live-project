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
        long time1 = time.getStart().getTime();
        long startTime = date.getTime() - time1;
        long  time2= time.getEnd().getTime();
        long endTime = startTime + time2 - time1;
        preOrderService.setStartTimer(request,response,startTime);
        preOrderService.setEndTimer(request,response,endTime);
        request.getRequestDispatcher("order.jsp").forward(request,response);
    }
}
