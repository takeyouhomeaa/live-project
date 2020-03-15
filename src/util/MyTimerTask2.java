package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.TimerTask;

public class MyTimerTask2 extends TimerTask {

    private HttpServletRequest request;
    private HttpServletResponse response;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }


    @Override
    public void run() {
        HttpSession session = request.getSession();
        session.setAttribute("start", 0);
        session.setMaxInactiveInterval(-1);
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(2592000);
        response.addCookie(cookie);
    }
}
