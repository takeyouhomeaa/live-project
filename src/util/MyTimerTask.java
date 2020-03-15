package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private int time;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

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
        if (time != 0) {
            session.setAttribute("appointmentStatus", true);
            session.setMaxInactiveInterval(time);
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(2592000);
            response.addCookie(cookie);
        }

    }
}
