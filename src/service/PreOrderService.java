package service;

import util.MyTimerTask;

import javax.servlet.http.*;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.ScheduledExecutorService;

public class PreOrderService{

    public void setTimer(HttpServletRequest request,HttpServletResponse response,Long startTime,int endTime){
        MyTimerTask myTimerTask = new MyTimerTask();
        myTimerTask.setRequest(request);
        myTimerTask.setResponse(response);
        myTimerTask.setTime(endTime);
       Timer timer = new Timer();
       timer.schedule(myTimerTask,startTime);
    }

    public Long getStartTime(Date date){
        return date.getTime();
    }

    public Integer getEndTime(Date date){
        long time = date.getTime();
        return Integer.parseInt(String.valueOf(time));
    }



}

