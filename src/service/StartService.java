package service;

import javax.servlet.http.*;
import java.util.HashMap;

public class StartService extends HttpServlet {

    public void setStart(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.setAttribute("start",1);
        session.setMaxInactiveInterval(-1);
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(2592000);
        response.addCookie(cookie);
    }
}
