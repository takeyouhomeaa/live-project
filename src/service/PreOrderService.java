package service;

import dao.OrderDataDaoImp;
import domain.OrderData;
import util.MyTimerTask2;
import util.MyTimerTask;

import javax.servlet.http.*;
import java.util.Timer;

public class PreOrderService{
    OrderDataDaoImp orderDataDaoImp = new OrderDataDaoImp();

    public void setStartTimer(HttpServletRequest request,HttpServletResponse response,Long startTime){
        MyTimerTask myTimerTask = new MyTimerTask();
        myTimerTask.setRequest(request);
        myTimerTask.setResponse(response);
        Timer timer = new Timer();
        timer.schedule(myTimerTask, startTime);
    }

    public void setEndTimer(HttpServletRequest request,HttpServletResponse response,Long endTime){
        MyTimerTask2 myTimerTask = new MyTimerTask2();
        myTimerTask.setRequest(request);
        myTimerTask.setResponse(response);
        Timer timer = new Timer();
        timer.schedule(myTimerTask, endTime);
    }

    public OrderData getTime(){
        OrderData orderData = orderDataDaoImp.find();
        return orderData;
    }



}

