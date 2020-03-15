package service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class EndService extends HttpServlet {
    public void setEnd(HttpServletRequest request){
        request.getSession().setAttribute("appointmentStatus",false);
    }
}
