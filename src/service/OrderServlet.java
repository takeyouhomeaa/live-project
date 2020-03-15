package service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderServlet {

    public void savedTimes(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Object times = session.getAttribute("times");
        if(times == null){
            Integer times1 = 0;
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

    public Integer getTimes(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object times = session.getAttribute("times");
        Integer rs = (Integer)times;
        return rs;
    }
}
