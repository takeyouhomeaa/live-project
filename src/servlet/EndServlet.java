package servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dao.OrderDaoImp;
import domain.Order;

/**
 * Servlet implementation class EndServlet
 */
@WebServlet("/EndServlet")
public class EndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		OrderDao orderDao = new OrderDaoImp();
		List<Order> listsList = orderDao.list();
		savedTimes(request, response);
		Integer time = getTimes(request);
		switch (time) {
		case 1:
		{
			
			break;
		}
		case 2:
		{
			break;
		}
		case 3:
		{
			break;
		}
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void savedTimes(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        Object times = session.getAttribute("times");
        if(times == null){
            Integer times1 = 1;
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
